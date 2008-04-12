/*
 * @(#)XmlNetParamModifier.java   
 *
 * Copyright (C) 2006-2007 www.interpss.org
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
 * @Date 09/15/2007
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.xml;

import org.apache.commons.math.complex.Complex;
import org.interpss.schema.BranchChangeRecXmlType;
import org.interpss.schema.BusChangeRecXmlType;
import org.interpss.schema.ComplexValueChangeXmlType;
import org.interpss.schema.ComplexXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.UnitXmlData;
import org.interpss.schema.ValueChangeXmlType;
import org.interpss.schema.BusChangeRecXmlType.AclfBusChangeData.LoadChangeData;

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.core.net.Network;

public class XmlNetParamModifier {
	private static enum ComplexValueType {
		Power, Z
	};

	private static enum ValueType {
		Voltage
	};

	/**
	 * Apply the modification record to the network object
	 * 
	 * @param net a Network/AclfNetwork/AclfAdjNetwork/... object to be modified
	 * @param mod the modification record
	 */
	public static boolean applyModification(Network net, ModificationXmlType mod, IPSSMsgHub msg) {
		IpssLogger.getLogger().info("Apply Network modification");
		
		if (mod.getBusChangeRecList() != null) {
			for (BusChangeRecXmlType busRec : mod.getBusChangeRecList().getBusChangeRecArray()) {
				if (!applyBusChange(busRec, net, msg))
					return false;
			}
		}

		if (mod.getBranchChangeRecList() != null) {
			for (BranchChangeRecXmlType braRec : mod.getBranchChangeRecList().getBranchChangeRecArray()) {
				if (!applyBranchChange(braRec, net, msg))
					return false;
			}
		}
		return true;
	}
	
	public static boolean applyBusChange(BusChangeRecXmlType busRec, Network net, IPSSMsgHub msg) {
		Bus bus = IpssXmlParser.getBus(busRec, net);
		if (bus == null) {
			msg.sendErrorMsg("Error: cannot fin bus, id: " + busRec.getRecId());
			return false;
		}

		bus.setStatus(!busRec.getOffLine());
		IpssLogger.getLogger().info("Bus " + bus.getId() + " status has been set to " + bus.isActive());
		
		if (bus instanceof AclfBus) {
			AclfBus aclfBus = (AclfBus)bus;
			if (busRec.getGenOutage()) {
				aclfBus.setGenCode(AclfGenCode.NON_GEN);
				IpssLogger.getLogger().info("Generator outage at bus " + bus.getId());
			}
			
			if (busRec.getLoadShedding()) {
				aclfBus.setLoadCode(AclfLoadCode.NON_LOAD);
				IpssLogger.getLogger().info("Load shedding at bus " + bus.getId());
			}
			
			if (busRec.getAclfBusChangeData() != null &&
					busRec.getAclfBusChangeData().getLoadChangeData() != null) {
				if (aclfBus.isLoad())
					modifyBusLoad(aclfBus, busRec, net.getBaseKva());
			}

			if (busRec.getAclfBusChangeData() != null &&
					busRec.getAclfBusChangeData().getGenChangeData() != null) {
				if (aclfBus.isGen())
					if (!modifyBusGen(aclfBus, busRec, net.getBaseKva(), msg))
						return false;
			}
		}
		return true;
	}
	
	public static boolean applyBranchChange(BranchChangeRecXmlType braRec, Network net, IPSSMsgHub msg) {
		Branch branch = IpssXmlParser.getBranch(braRec, net);
		if (branch == null) {
			msg.sendErrorMsg("Error: cannot fin branch, " + braRec.getFromBusId() + "->" + braRec.getToBusId());
			return false;
		}

		branch.setStatus(!braRec.getOffLine());
		IpssLogger.getLogger().info("Branch " + branch.getId() + " service status has been set to "	+ branch.isActive());

		if (branch instanceof AclfBranch) {
			AclfBranch aclfBra = (AclfBranch)branch;
			if (braRec.getAclfBranchChangeData() != null &&
					braRec.getAclfBranchChangeData().getBranchZChange() != null) {
				if (branch.isActive()) {
					Complex z = applyComplexValueChangeRec(aclfBra.getZ(), 
							braRec.getAclfBranchChangeData().getBranchZChange(), ComplexValueType.Z,
							net.getBaseKva(), aclfBra.getHigherBaseVoltage());
					aclfBra.setZ(z);
				}
			}
		}
		return true;
	}

	private static Complex applyPowerChangeRec(Complex original,
			ComplexValueChangeXmlType changeRec, double baseKva) {
		return applyComplexValueChangeRec(original, changeRec, ComplexValueType.Power,
				baseKva, 1.0);
	}
	
	private static boolean modifyBusGen(AclfBus bus, BusChangeRecXmlType busRec, double baseKva, IPSSMsgHub msg) {
		// swing bus voltage modification
		if (busRec.getAclfBusChangeData().getGenChangeData().getSwingVoltageChange() != null) {
			if (bus.isSwing()) {
	  			final SwingBusAdapter gen = (SwingBusAdapter)bus.adapt(SwingBusAdapter.class);
				double x = applyValueChangeRec(gen.getVoltMag(UnitType.PU),
						busRec.getAclfBusChangeData().getGenChangeData().getSwingVoltageChange(),
						ValueType.Voltage, bus.getBaseVoltage());
				gen.setVoltMag(x, UnitType.PU);
			}
			else {
				msg.sendErrorMsg("Error: try to set swing bus voltage of a non-swing bus, id: " + bus.getId());
				return false;
			}
		}
		return true;
	}
	
	private static void modifyBusLoad(AclfBus bus, BusChangeRecXmlType busRec, double baseKva) {
		// modify load value
		if (busRec.getAclfBusChangeData().getLoadChangeData().getValueChange() != null) {
			Complex x = applyPowerChangeRec(
					bus.getLoad(),
					busRec.getAclfBusChangeData().getLoadChangeData().getValueChange(),
					baseKva);
			bus.setLoadP(x.getReal());
			bus.setLoadQ(x.getImaginary());
		}

		// modify load code
		if (busRec.getAclfBusChangeData().getLoadChangeData().getCodeChange() != null) {
			LoadChangeData.CodeChange codeChange = busRec.getAclfBusChangeData().getLoadChangeData().getCodeChange();
			bus.setLoadCode(codeChange.getLoadCode() == 
				LoadChangeData.CodeChange.LoadCode.CONST_P ? AclfLoadCode.CONST_P
						: (codeChange.getLoadCode() == LoadChangeData.CodeChange.LoadCode.CONST_I ? 
							AclfLoadCode.CONST_I : (codeChange.getLoadCode() == 
								LoadChangeData.CodeChange.LoadCode.CONST_Z ? AclfLoadCode.CONST_Z
									: (codeChange.getLoadCode() == 
										LoadChangeData.CodeChange.LoadCode.EXPONENTIAL ? AclfLoadCode.EXPONENTIAL
											: AclfLoadCode.NON_LOAD))));
			if (bus.getLoadCode() == AclfLoadCode.EXPONENTIAL) {
				bus.setExpLoadP(codeChange.getExpLoadP());
				bus.setExpLoadQ(codeChange.getExpLoadQ());
			}
		}		
	}

	private static Complex applyComplexValueChangeRec(Complex original,
			ComplexValueChangeXmlType changeRec, ComplexValueType ptype,
			double baseKva, double busBaseVolt) {
		if (changeRec.getChangeAction() == ComplexValueChangeXmlType.ChangeAction.ADD
				|| changeRec.getChangeAction() == ComplexValueChangeXmlType.ChangeAction.SET) {
			// for add/set, use value and unit (PU or power unit)
			ComplexXmlType c = changeRec.getValue();
			double re = c.getRe(), im = c.getIm();
			// the original is in PU
			if (changeRec.getUnit() != UnitXmlData.PU) {
				// convert set/add value to PU
				byte unit = IpssXmlParser.mapXmlUnitType2IpssUnitType(changeRec
						.getUnit());
				if (ptype == ComplexValueType.Power) {
					re = UnitType.pConversion(re, baseKva, unit, UnitType.PU);
					im = UnitType.pConversion(im, baseKva, unit, UnitType.PU);
				} else if (ptype == ComplexValueType.Z) {
					Complex z = UnitType.zConversion(new Complex(re, im),
							busBaseVolt, baseKva, unit, UnitType.PU);
					re = z.getReal();
					im = z.getImaginary();
				}
			}
			if (changeRec.getChangeAction() == ComplexValueChangeXmlType.ChangeAction.ADD) {
				re += original.getReal();
				im += original.getImaginary();
			}
			Complex cReturn = new Complex(re, im);
			IpssLogger.getLogger().info( "Gen/Load add/set to: " + ComplexFunc.toString(cReturn));
			return cReturn;
		} else if (changeRec.getChangeAction() == ComplexValueChangeXmlType.ChangeAction.INCREASE
				|| changeRec.getChangeAction() == ComplexValueChangeXmlType.ChangeAction.DECREASE) {
			// for increase/decrease, use percent and unit (PU or percent)
			double factor = changeRec.getPercent();
			if (changeRec.getUnit() == UnitXmlData.PERCENT)
				factor *= 0.01;
			if (changeRec.getChangeAction() == ComplexValueChangeXmlType.ChangeAction.DECREASE)
				factor = -factor;
			Complex cReturn = new Complex(original.getReal() * (1.0 + factor), original
					.getImaginary()
					* (1.0 + factor));
			IpssLogger.getLogger().info( "Gen/Load add/set to: " + ComplexFunc.toString(cReturn));
			return cReturn;
		}

		IpssLogger.getLogger().warning(
				"Wrong ChangeAction, changeRec: " + changeRec.toString());
		return original;
	}

	private static double applyValueChangeRec(double original,
			ValueChangeXmlType changeRec, ValueType ptype, double busBaseVolt) {
		if (changeRec.getChangeAction() == ValueChangeXmlType.ChangeAction.ADD
				|| changeRec.getChangeAction() ==ValueChangeXmlType.ChangeAction.SET) {
			// for add/set, use value and unit (PU or power unit)
			double c = changeRec.getValue();
			if (changeRec.getUnit() != UnitXmlData.PU) {
				// convert set/add value to PU
				byte unit = IpssXmlParser.mapXmlUnitType2IpssUnitType(changeRec
						.getUnit());
				if (ptype == ValueType.Voltage) {
					c = UnitType.vConversion(c, busBaseVolt, unit, UnitType.PU);
				} 
			}
			if (changeRec.getChangeAction() == ValueChangeXmlType.ChangeAction.ADD) {
				c += original;
			}
			return c;
		} else if (changeRec.getChangeAction() == ValueChangeXmlType.ChangeAction.INCREASE
				|| changeRec.getChangeAction() == ValueChangeXmlType.ChangeAction.DECREASE) {
			// for increase/decrease, use percent and unit (PU or percent)
			double factor = changeRec.getPercent();
			if (changeRec.getUnit() == UnitXmlData.PERCENT)
				factor *= 0.01;
			if (changeRec.getChangeAction() == ValueChangeXmlType.ChangeAction.DECREASE)
				factor = -factor;
			return original * (1.0 + factor);
		}
		IpssLogger.getLogger().warning(
				"Wrong ChangeAction, changeRec: " + changeRec.toString());
		return original;
	}
}