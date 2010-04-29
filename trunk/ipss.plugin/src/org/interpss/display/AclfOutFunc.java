/*
 * @(#)AclfOutFunc.java   
 *
 * Copyright (C) 2006 www.interpss.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @Author Mike Zhou
 * @Version 1.0
 * @Date 11/27/2007
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.display;

import org.apache.commons.math.complex.Complex;
import org.interpss.display.impl.AclfOut_BusStyle;
import org.interpss.display.impl.AclfOut_PSSE;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.Number2String;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.CapacitorBusAdapter;
import com.interpss.core.aclf.GenBusAdapter;
import com.interpss.core.aclf.PSXfrAdapter;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.AdjControlType;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.aclfadj.XfrTapControlType;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.loss.ActivePowerWalkDirection;
import com.interpss.core.algorithm.sec.BranchRatingAdapter;
import com.interpss.core.algorithm.sec.ViolationType;
import com.interpss.core.datatype.Mismatch;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.OriginalDataFormat;

public class AclfOutFunc {
	public static String getBusId(AclfBus bus, OriginalDataFormat fmt) {
		if (fmt == OriginalDataFormat.CIM)
			return "Bus" + bus.getNumber();
		return bus.getId();
	}  
	
	public static String formatKV(double kv) {
		if (kv > 1000.0)
			return String.format("%6.1f ", kv);
		else if (kv > 100.0)
			return String.format("%6.2f ", kv);
		else	
			return String.format("%6.3f ", kv);
	}
  
	public static String lf4Google(AclfAdjNetwork net) {
		if (net.getOriginalDataFormat() == OriginalDataFormat.CIM)
			return loadFlowSummary(net);
		return lfResultsBusStyle(net);
	}
	
	/*
	 *   PSS/E output
	 *   ============
	 */
	public static String lfResultsPsseStyle(AclfNetwork net, AclfOut_PSSE.Format format) {
		return AclfOut_PSSE.lfResults(net, format);
	}

	
	/*
	 *   Bus Style output
	 *   ================
	 */
	public static String lfResultsBusStyle(AclfNetwork net) {
		return AclfOut_BusStyle.lfResultsBusStyle(net);
	}

	/*
	 *   Summary output
	 *   ==============
	 */
	public static String loadFlowSummary(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		try {
			double baseKVA = net.getBaseKva();

			str.append("\n                          Load Flow Summary\n");
			str.append(AclfOutFunc.maxMismatchToString(net, "") + "\n");
			if (net.getOriginalDataFormat() == OriginalDataFormat.CIM) {
				str.append("     BusID          Code             Volt(pu)   Angle(deg)     P(pu)     Q(pu)                RdfId\n");
				str.append("  ------------------------------------------------------------------------------------------------------------------\n");
			}
			else {
				str.append("     BusID          Code             Volt(pu)   Angle(deg)     P(pu)     Q(pu)\n");
				str.append("  ----------------------------------------------------------------------------\n");
			}
				 

			for (Bus b : net.getBusList()) {
				AclfBus bus = (AclfBus) b;
				if (bus.isActive()) {
					GenBusAdapter genBus = (GenBusAdapter) bus
							.getAdapter(GenBusAdapter.class);
					Complex busPQ = genBus.getGenResults(UnitType.PU, baseKVA);
					busPQ = busPQ.subtract(genBus.getLoadResults(UnitType.PU,
							baseKVA));
					if (bus.isCapacitor()) {
						CapacitorBusAdapter cap = (CapacitorBusAdapter) bus
								.getAdapter(CapacitorBusAdapter.class);
						busPQ = busPQ.add(new Complex(0.0, cap.getQResults(bus
								.getVoltageMag(), UnitType.PU, baseKVA)));
					}
					str.append("  ");
					str.append(String.format("%-12s  ", getBusId(bus, net.getOriginalDataFormat())));
					str.append(String.format("%-17s ", bus.code2String()));
					str.append(String.format("%10.5f   ", bus.getVoltageMag(UnitType.PU)));
					str.append(String.format("%9.1f   ", bus.getVoltageAng(UnitType.Deg)));
					str.append(String.format("%10.4f", busPQ.getReal()));
					str.append(String.format("%10.4f", busPQ.getImaginary()));
					if (net.getOriginalDataFormat() == OriginalDataFormat.CIM) 
						str.append(String.format("   %s", bus.getId()));
					str.append("\n");
				}
			}
		} catch (Exception emsg) {
			str.append(emsg.toString());
		}

		str.append(branchMvaRatingViolationList(net));

		return str.toString();
	}

	public static String loadLossAllocation(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		double lossMW = net.totalLoss(UnitType.mVA).getReal();
		double lossPU = net.totalLoss(UnitType.PU).getReal();

		str.append("\n                          Load Loss Allocation\n");
		str.append("\n                       Total Loss = " + Number2String.toStr("####0.00", lossMW) + " MW\n\n");
		str.append("            BusID          LossAllocFactor         Allocated Loss(MW)\n");
		str.append("  ------------------------------------------------------------------------\n");
		for (Bus bus : net.getBusList()) {
			AclfBus aclfBus = (AclfBus)bus;
			if ( aclfBus.getLossPFactor(ActivePowerWalkDirection.SOURC2_LOAD, lossPU) > 0.0 && 
					(aclfBus.isLoad() || aclfBus.isSwing())) { 
				str.append(lossString(aclfBus, ActivePowerWalkDirection.SOURC2_LOAD, lossMW, lossPU));
			}
  		}		
		return str.toString();
	}
	
	public static String genLossAllocation(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		double lossMW = net.totalLoss(UnitType.mVA).getReal();
		double lossPU = net.totalLoss(UnitType.PU).getReal();

		str.append("\n                          Gen Loss Allocation\n");
		str.append("\n                       Total Loss = " + Number2String.toStr("####0.00", lossMW) + " MW\n\n");
		str.append("            BusID          LossAllocFactor         Allocated Loss(MW)\n");
		str.append("  ------------------------------------------------------------------------\n");
		for (Bus bus : net.getBusList()) {
			AclfBus aclfBus = (AclfBus)bus;
			if (aclfBus.isGen() && aclfBus.getLossPFactor(ActivePowerWalkDirection.LOAD2_SOURCE, lossPU) > 0.0) { 
				str.append(lossString(aclfBus, ActivePowerWalkDirection.LOAD2_SOURCE, lossMW, lossPU));
			}
  		}		
		
		return str.toString();
	}
	
	private static String lossString(AclfBus aclfBus, ActivePowerWalkDirection direction, double lossMW, double lossPU) {
		StringBuffer str = new StringBuffer("");
		str.append(Number2String.toStr(12, " "));
		str.append(Number2String.toStr(-12, aclfBus.getId()) + "  ");
		str.append(Number2String.toStr(2, " "));
		str.append(Number2String.toStr("####0.000", aclfBus.getLossPFactor(direction, lossPU)));
		str.append(Number2String.toStr(17, " "));
		str.append(Number2String.toStr("####0.00", aclfBus.getLossPFactor(direction, lossPU)*lossMW));
		str.append("\n");
		return str.toString();
	}

	public static String loadFlowSummary(AclfAdjNetwork net) {
		StringBuffer str = new StringBuffer(loadFlowSummary((AclfNetwork) net));
		try {
			if (net.getPvBusLimitList().size() > 0)
				str.append(pvBusLimitToString(net));

			if (net.getPqBusLimitList().size() > 0)
				str.append(pqBusLimitToString(net));

			if (net.getRemoteQBusList().size() > 0)
				str.append(remoteQBusToString(net));

			if (net.getFunctionLoadList().size() > 0)
				str.append(aclfFuncLoadToString(net));

			if (net.getTapControlList().size() > 0)
				str.append(tapVControlToString(net));

			if (net.getPsXfrPControlList().size() > 0)
				str.append(psXfrPControlToString(net));
		} catch (Exception emsg) {
			str.append(emsg.toString());
		}
		return str.toString();
	}

	public static String maxMismatchToString(AclfNetwork net, String prefix) {
		try {
			double baseKVA = net.getBaseKva();
			String str = "\n"+prefix+"                         Max Power Mismatches\n"
					+ prefix+"             Bus              dPmax       Bus              dQmax\n"
					+ prefix+"            -------------------------------------------------------\n";
			Mismatch mis = net.maxMismatch(AclfMethod.NR);
			str += prefix+Number2String.toStr(12, " ");
			str += String.format("%-12s ", getBusId(mis.maxPBus, net.getOriginalDataFormat()));
			str += String.format("%12.6f  ", mis.maxMis.getReal());
			str += String.format("%-12s ", getBusId(mis.maxQBus, net.getOriginalDataFormat()));
			str += String.format("%12.6f (pu)\n", mis.maxMis.getImaginary());
			str += prefix+String.format("%24s", " ");
			str += String.format("%12.6f0 ", baseKVA* mis.maxMis.getReal());
			str += String.format("%14s", " ");
			str += String.format("%12.6f (kva)\n", baseKVA * mis.maxMis.getImaginary());
			return str;
		} catch (Exception emsg) {
			return emsg.toString();
		}
	}

	public static String branchMvaRatingViolationList(AclfNetwork net) {
		StringBuffer str = new StringBuffer("");
		if (net.hasBranchMavRatingViolation()) {
			str.append("\n\n");
			str
					.append("                        Branch MvaRating Violation List\n\n");
			str
					.append("         BranchID        MvaFlow      Side    MvaRating1   MvaRating2   MvaRating3\n");
			str
					.append("     ----------------- ------------ -------- ------------ ------------ ------------\n");
			for (Branch b : net.getBranchList()) {
				AclfBranch bra = (AclfBranch) b;
				if (bra.isActive()) {
					BranchRatingAdapter adapter = (BranchRatingAdapter)b.getAdapter(BranchRatingAdapter.class);
					if (adapter.isRatingViolated(ViolationType.BRANCH_THERMAL_MVA_RATING, net.getBaseKva())) {
						str.append(Number2String.toStr(5, " "));
						str.append(Number2String.toStr(-16, bra.getId()));
						double mva = bra.powerFrom2To(UnitType.mVA,
								net.getBaseKva()).abs();
						String side = "From";
						if (bra.powerFrom2To(UnitType.mVA, net.getBaseKva()).abs() < bra
								.powerTo2From(UnitType.mVA, net.getBaseKva()).abs()) {
							mva = bra.powerTo2From(UnitType.mVA, net.getBaseKva())
									.abs();
							side = "To";
						}

						str.append("     " + Number2String.toStr("####0.0", mva));
						str.append("     " + Number2String.toStr(-4, side));
						str.append("      "
								+ Number2String.toStr("####0.0", bra
										.getRatingMva1()));
						str.append("      "
								+ Number2String.toStr("####0.0", bra
										.getRatingMva2()));
						str.append("      "
								+ Number2String.toStr("####0.0", bra
										.getRatingMva3()));
						str.append("\n");
					}
				}
			}
		}
		return str.toString();
	}

	public static String pvBusLimitToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  PV Bus Limit Adjustment/Control\n\n");
		str
				.append("      BusID     Vact     Vspec      Q      Qmax     Qmin   Status\n");
		str
				.append("     -------- -------- -------- -------- -------- -------- ------\n");

		for (PVBusLimit pv : net.getPvBusLimitList()) {
			GenBusAdapter genBus = (GenBusAdapter) pv.getAclfBus().getAdapter(
					GenBusAdapter.class);
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-8, getBusId(pv.getAclfBus(), net.getOriginalDataFormat())));
			str.append(Number2String.toStr("###0.0000", pv.getAclfBus()
					.getVoltageMag(UnitType.PU)));
			str.append(Number2String.toStr("###0.0000", pv
					.getVSpecified(UnitType.PU)));
			str.append(Number2String.toStr("#####0.00", genBus.getGenResults(
					UnitType.PU, baseKVA).getImaginary()));
			str.append(Number2String.toStr("#####0.00", pv.getQLimit(
					UnitType.PU, baseKVA).getMax()));
			str.append(Number2String.toStr("#####0.00", pv.getQLimit(
					UnitType.PU, baseKVA).getMin()));
			str.append(Number2String.toStr(6, pv.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String pqBusLimitToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  PQ Bus Limit Adjustment/Control\n\n");
		str
				.append("      BusID     Qact     Qspec      V      Vmax     Vmin   Status\n");
		str
				.append("     -------- -------- -------- -------- -------- -------- ------\n");

		for (PQBusLimit pq : net.getPqBusLimitList()) {
			GenBusAdapter genBus = (GenBusAdapter) pq.getAclfBus().getAdapter(
					GenBusAdapter.class);
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-8, getBusId(pq.getAclfBus(), net.getOriginalDataFormat())) + " ");
			str.append(Number2String.toStr("####0.00", genBus.getGenResults(
					UnitType.PU, baseKVA).getImaginary())
					+ " ");
			str.append(Number2String.toStr("####0.00", pq.getQSpecified(
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", pq.getAclfBus()
					.getVoltageMag(UnitType.PU))
					+ " ");
			str.append(Number2String.toStr("##0.0000", pq
					.getVLimit(UnitType.PU).getMax())
					+ " ");
			str.append(Number2String.toStr("##0.0000", pq
					.getVLimit(UnitType.PU).getMin())
					+ " ");
			str.append(Number2String.toStr(5, pq.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String remoteQBusToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                Remote Q Voltage Adjustment/Control\n\n");
		str
				.append("       VcBus    Type    ReQBus/Branch   Actual    Spec       Q      Qmax     Qmin   Status\n");
		str
				.append("     -------- -------- --------------- -------- -------- -------- -------- -------- ------\n");

		for (RemoteQBus re : net.getRemoteQBusList()) {
			GenBusAdapter genBus = (GenBusAdapter) re.getAclfBus().getAdapter(
					GenBusAdapter.class);
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-9, getBusId(re.getAclfBus(), net.getOriginalDataFormat())));
			str.append(Number2String.toStr(-9,
									(re.getControlType() == RemoteQControlType.BUS_VOLTAGE ? " Voltage"
											: "MvarFlow")));
			str.append(Number2String.toStr(15,
					re.getControlType() == RemoteQControlType.BUS_VOLTAGE ? re
							.getRemoteBus().getId() : re.getRemoteBranch()
							.getId()));
			str.append(Number2String.toStr("###0.0000",
					re.getControlType() == RemoteQControlType.BUS_VOLTAGE ? re
							.getRemoteBus().getVoltageMag(UnitType.PU) : re
							.getMvarFlowCalculated(re.getRemoteBranch(),
									UnitType.PU, baseKVA)));
			str.append(Number2String.toStr("###0.0000", re
					.getVSpecified(UnitType.PU)));
			str.append(Number2String.toStr("#####0.00", genBus.getGenResults(
					UnitType.PU, baseKVA).getImaginary()));
			str.append(Number2String.toStr("#####0.00", re.getQLimit(
					UnitType.PU, baseKVA).getMax()));
			str.append(Number2String.toStr("#####0.00", re.getQLimit(
					UnitType.PU, baseKVA).getMin()));
			str.append(Number2String.toStr(6, re.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String aclfFuncLoadToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  Aclf FuncLoad Adjustment/Control\n\n");
		str
				.append("      BusID     Pact     Qact       V      P(0)     Q(0)   Status\n");
		str
				.append("     -------- -------- -------- -------- -------- -------- ------\n");

		for (FunctionLoad x : net.getFunctionLoadList()) {
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-8, x.getAclfBus().getId()) + " ");
			double vpu = x.getAclfBus().getVoltage().abs();
			str.append(Number2String.toStr("##0.0000", x.getP().getLoad(vpu,
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getQ().getLoad(vpu,
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getAclfBus()
					.getVoltageMag(UnitType.PU))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getP().getLoad0(
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr("##0.0000", x.getQ().getLoad0(
					UnitType.PU, baseKVA))
					+ " ");
			str.append(Number2String.toStr(5, x.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String tapVControlToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKva = net.getBaseKva();

		str.append("\n\n");
		str
				.append("                          Tap Voltage Adjustment/Control\n\n");
		str
				.append("          BranchID     VC BusID  Actual   Spec/Range     Tap  Tmax  Tmin  StepSize Status\n");
		str
				.append("     ----------------- -------- -------- -------------- ----- ----- -----   -----  ------\n");

		for (TapControl x : net.getTapControlList()) {
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-17, x.getAclfBranch().getId())
					+ " ");

			if (x.getControlType() == XfrTapControlType.BUS_VOLTAGE) {
				str.append(Number2String.toStr(-8, x.getVcBus().getId()) + " ");
				str.append(Number2String.toStr("##0.0000", x.getVcBus()
						.getVoltageMag(UnitType.PU))
						+ " ");
				if (x.getFlowControlType() == AdjControlType.POINT_CONTROL)
					str.append(Number2String.toStr("##0.0000", x
							.getVSpecified(UnitType.PU))
							+ " ");
				else
					str.append(x.getControlRange() + " ");
			} else {
				str.append(Number2String.toStr(-8, " "));
				str.append(Number2String.toStr("##0.0000", x
						.getMvarFlowCalculated(UnitType.PU, baseKva))
						+ " ");
				if (x.getFlowControlType() == AdjControlType.POINT_CONTROL)
					str.append("   "
							+ Number2String.toStr("##0.0000", x
									.getMvarSpecified(UnitType.PU, baseKva))
							+ "    ");
				else
					str.append(x.getControlRange() + " ");
			}

			str.append(Number2String.toStr("0.000",
					(x.isControlOnFromSide() ? x.getAclfBranch()
							.getFromTurnRatio() : x.getAclfBranch()
							.getToTurnRatio()))
					+ " ");
			str.append(Number2String.toStr("0.000", x.getTurnRatioLimit().getMax())
					+ " ");
			str.append(Number2String.toStr("0.000", x.getTurnRatioLimit().getMin())
					+ "   ");
			str.append(Number2String.toStr("####0", x.getTapStepSize()) + "  ");
			str.append(Number2String.toStr(6, x.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String psXfrPControlToString(AclfAdjNetwork net)
			throws Exception {
		StringBuffer str = new StringBuffer("");

		double baseKVA = net.getBaseKva();

		str.append("\n\n");
		str.append("                  PSXfr Power Adjustment/Control\n\n");
		str
				.append("          BranchID       Pact     Spec/Range    Ang   Max   Min  Status\n");
		str
				.append("     ----------------- -------- -------------- ----- ----- ----- ------\n");

		for (PSXfrPControl x : net.getPsXfrPControlList()) {
			str.append(Number2String.toStr(5, " "));
			str.append(Number2String.toStr(-17, x.getAclfBranch().getId())
					+ " ");
			str.append(Number2String.toStr("##0.0000",
					(x.isControlOnFromSide() ? x.getAclfBranch().powerFrom2To(
							UnitType.PU, baseKVA).getReal() : x.getAclfBranch()
							.powerTo2From(UnitType.PU, baseKVA).getReal()))
					+ " ");

			if (x.getFlowControlType() == AdjControlType.POINT_CONTROL)
				str.append(Number2String.toStr("   " + "##0.0000", x
						.getPSpecified(UnitType.PU, baseKVA))
						+ "    ");
			else
				str.append(x.getControlRange() + " ");

			PSXfrAdapter psXfr = (PSXfrAdapter) x.getAclfBranch().getAdapter(
					PSXfrAdapter.class);
			str.append(Number2String.toStr("#0.00", psXfr
					.getFromAngle(UnitType.Deg))
					+ " ");
			str.append(Number2String.toStr("#0.00", x.getAngLimit(UnitType.Deg)
					.getMax())
					+ " ");
			str.append(Number2String.toStr("#0.00", x.getAngLimit(UnitType.Deg)
					.getMin())
					+ " ");
			str.append(Number2String.toStr(6, x.isActive() ? "on" : "off")
					+ "\n");
		}
		return str.toString();
	}

	public static String yMatrixToString(AclfNetwork net) {
		String str = "\n        Y-matrix\n";

		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			if (bus.isActive()) {
				str += "bus: " + bus.getId() + "    " + "yii: "
						+ bus.yii().toString() + "\n";
				for (Branch br : bus.getBranchList()) {
					AclfBranch bra = (AclfBranch) br;
					if (bra.isActive()) {
						str += "          "
								+ bra.getId()
								+ "   "
								+
								// " yff:" + Num2Str.toStr(bra.yff()) +
								// " ytt:" + Num2Str.toStr(bra.ytt()) +
								"  yft:" + Number2String.toStr(bra.ytf())
								+ "  ytf:" + Number2String.toStr(bra.yft())
								+ "\n";
					}
				}
			}
		}
		return str + "\n";
	}

	public static String b11MatrixToString(AclfNetwork net) {
		try {
			String str = "\n        B11-matrix\n";

			for (Bus b : net.getBusList()) {
				AclfBus bus = (AclfBus) b;
				if (bus.isActive()) {
					str += "bus: " + bus.getId() + "    " + "bii: "
							+ Number2String.toStr(bus.b11ii()) + "\n";
					for (Object br : bus.getBranchList()) {
						AclfBranch bra = (AclfBranch) br;
						if (bra.isActive())
							str += "          " + bra.getId() + "   " + "bij: "
								+ Number2String.toStr(bra.b11ft()) + "\n";
					}
				}
			}
			return str + "\n";
		} catch (Exception emsg) {
			return emsg.toString();
		}
	}

	public static String b1MatrixToString(AclfNetwork net) {
		String str = "\n        B1-matrix\n";

		for (Bus b : net.getBusList()) {
			AclfBus bus = (AclfBus) b;
			if (bus.isActive()) {
				str += "bus: " + bus.getId() + "    " + "bii: "
						+ Number2String.toStr(bus.b1ii()) + "\n";
				for (Branch br : bus.getBranchList()) {
					AclfBranch bra = (AclfBranch) br;
					if (bra.isActive())
						str += "          " + bra.getId() + "   " + "bij: "
							+ Number2String.toStr(bra.b1ft()) + "\n";
				}

			}
		}
		return str + "\n";
	}
}