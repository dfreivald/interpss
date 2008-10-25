/*
 * @(#)XmlCaseData2AlgorithmMapperImpl.java   
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
 * @Date 09/15/2006
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper.runCase;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.dstab.DStabDEventData;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AcscFaultCategoryDataType;
import org.interpss.schema.AcscFaultDataType;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.AcscStudyCaseXmlType;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.DynamicEventDataType;
import org.interpss.schema.MachineControllerDataType;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData.EventList.Event.LoadChangeData;
import org.interpss.schema.DStabStudyCaseXmlType.DynamicEventData.EventList.Event.LoadChangeData.LoadChangeType;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.NetUtilFunc;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBranchFault;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.ScBusVoltage;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.dstab.DStabBranch;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.StaticLoadModel;
import com.interpss.dstab.devent.BranchOutageEvent;
import com.interpss.dstab.devent.BranchOutageType;
import com.interpss.dstab.devent.DStabBranchFault;
import com.interpss.dstab.devent.DynamicEvent;
import com.interpss.dstab.devent.DynamicEventType;
import com.interpss.dstab.devent.LoadChangeEvent;
import com.interpss.dstab.devent.LoadChangeEventType;
import com.interpss.dstab.devent.SetPointChangeEvent;
import com.interpss.dstab.mach.ControllerType;
import com.interpss.dstab.mach.Machine;

public class XmlCaseData2AlgorithmMapperImpl {
	/**
	 * Map AclfCaseData to a LoadflowAlgorithm object
	 * 
	 * @param caseData
	 * @param algo
	 */
	public static void aclfCaseData2AlgoMapping(AclfAlgorithmXmlType xmlAlgo, LoadflowAlgorithm algo) {
		algo.setLfMethod(xmlAlgo.getLfMethod() == AclfAlgorithmXmlType.LfMethod.NR ? AclfMethod.NR
						: (xmlAlgo.getLfMethod() == AclfAlgorithmXmlType.LfMethod.PQ ? AclfMethod.PQ
								: AclfMethod.GS));
		/*
		 * no need for this. PQ method can handle PSXfr now if
		 * (algo.getAclfAdjNetwork().hasPSXfr() && algo.getLfMethod() ==
		 * AclfMethod.PQ) algo.setLfMethod(AclfMethod.NR);
		 */
		algo.setMaxIterations(xmlAlgo.getMaxIterations());
		algo.setTolerance(xmlAlgo.getTolerance());
		algo.setNonDivergent(xmlAlgo.getNonDivergent());
		algo.setInitBusVoltage(xmlAlgo.getInitBusVoltage());
		algo.setGsAccFactor(xmlAlgo.getAccFactor());
	}

	/**
	 * Map AcscCaseData to a SimpleFaultAlgorithm object, Fault data will be
	 * mapped into the SimpleFaultNetwork object
	 * 
	 * @param xmlCaseData
	 * @param algo
	 */
	public static boolean acscCaseData2AlgoMapping(AcscStudyCaseXmlType xmlCaseData, SimpleFaultAlgorithm algo) {
		SimpleFaultNetwork faultNet = algo.getSimpleFaultNetwork();
		String faultIdStr = algo.getDesc();
		if (xmlCaseData.getFaultData().getFaultType() == AcscFaultDataType.BUS_FAULT) {
			String id  = NetUtilFunc.getBusIdFromDisplayNameId(xmlCaseData.getFaultData().getBusBranchId());
			AcscBus faultBus = (AcscBus) faultNet.getBus(id);
			if (faultBus == null) {
				IpssLogger.getLogger().severe("Programming Error - Fault bus/branch not found, id: " + id);
				return false;
			}

			AcscBusFault fault = CoreObjectFactory.createAcscBusFault(Constants.Token_BusFaultId + faultBus.getId());
			acscFaultData2AcscBusFaultMapping(xmlCaseData.getFaultData(), fault);
			if (xmlCaseData.getFaultData().getFaultCategory() == AcscFaultCategoryDataType.FAULT_ALL) {
				addAllFaultCategory(faultBus.getId(), faultIdStr, fault, faultNet);
			} 
			else
				faultNet.addBusFault(faultBus.getId(), faultIdStr, fault);
		} 
		else if (xmlCaseData.getFaultData().getFaultType() == AcscFaultDataType.BRANCH_FAULT) {
			String id  = NetUtilFunc.getBranchIdFromDisplayNameId(xmlCaseData.getFaultData().getBusBranchId());
			AcscBranch faultBranch = (AcscBranch) faultNet.getBranch(id);
			if (faultBranch == null) {
				IpssLogger.getLogger().severe(
								"Programming Error - Fault bus/branch not found, this maybe a parallel branch issue, id: " + id);
				return false;
			}

			AcscBranchFault fault = CoreObjectFactory
					.createAcscBranchFault(Constants.Token_BranchFaultId
							+ faultBranch.getId());
			acscFaultData2AcscBranchFaultMapping(xmlCaseData.getFaultData(), fault);
			if (xmlCaseData.getFaultData().getFaultCategory() == AcscFaultCategoryDataType.FAULT_ALL) {
				addAllFaultCategory(faultBranch.getId(), faultIdStr, fault,
						faultNet);
			} else
				faultNet.addBranchFault(faultBranch.getId(), faultIdStr, fault);
		} 
		else {
			IpssLogger.getLogger().severe(
					"Programming Error - Branch outage not implemented");
			return false;
		}

		algo.setMultiFactor(xmlCaseData.getMultiFactor() * 0.01);
		// algo.multiFactor in PU and acscData.getMFactor in %
		algo.setScBusVoltage(xmlCaseData.getBusAcscInitVolt() == AcscStudyCaseXmlType.BusAcscInitVolt.UNIT_VOLT? 
				ScBusVoltage.UNIT_VOLT : ScBusVoltage.LOADFLOW_VOLT); // UnitV | LFVolt
		return true;
	}

	/**
	 * Map DstabCaseData to a stability algorithm object
	 * 
	 * @param xmlDstabData
	 * @param aclfData
	 * @param algo
	 */
	public static boolean dstabCaseData2AlgoMapping(DStabStudyCaseXmlType xmlDstabData, DynamicSimuAlgorithm algo, IPSSMsgHub msg) {
		//System.out.println(xmlDstabData.toString());
		
		XmlCaseData2AlgorithmMapperImpl.aclfCaseData2AlgoMapping(xmlDstabData.getAclfAlgorithm(), algo.getAclfAlgorithm());
		algo.setSimuMethod(xmlDstabData.getSimuConfig().getSimuMethod() == DStabStudyCaseXmlType.SimuConfig.SimuMethod.MODIFIED_EULER ? 
						DynamicSimuMethods.MODIFIED_EULER : DynamicSimuMethods.RUNGE_KUTTA );
		algo.setTotalSimuTimeSec(xmlDstabData.getSimuConfig().getTotalSimuTimeSec());
		algo.setSimuStepSec(xmlDstabData.getSimuConfig().getSimuStepSec());
		algo.setDisableDynamicEvent(xmlDstabData.getDynamicEventData().getDisableEvent());

		if (xmlDstabData.getSimuConfig().getAbsoluteMachAngValue()) {
			algo.setRefMachine(null);
		} else {
			Machine mach = algo.getDStabNet().getMachine(xmlDstabData.getSimuConfig().getRefMachineBusId());
			IpssLogger.getLogger().info("Ref mach set to : " + mach.getId());
			algo.setRefMachine(mach);
		}

		return dstabCaseData2NetMapping(xmlDstabData, algo.getDStabNet(), msg);
	}

	/**
	 * Map a DStabCaseData info to the DStabNet object
	 * 
	 * @param xmlDstabData
	 * @param dstabNet
	 * @param msg
	 */
	private static boolean dstabCaseData2NetMapping(DStabStudyCaseXmlType xmlDstabData, DStabilityNetwork dstabNet, IPSSMsgHub msg) {
		dstabNet.setNetEqnIterationNoEvent(3);
		dstabNet.setNetEqnIterationWithEvent(5);
		if (xmlDstabData.getNetEqnSolveConfig() != null) {
			dstabNet.setNetEqnIterationNoEvent(xmlDstabData.getNetEqnSolveConfig().getNetEqnItrNoEvent());
			dstabNet.setNetEqnIterationWithEvent(xmlDstabData.getNetEqnSolveConfig().getNetEqnItrWithEvent());
		}

		dstabNet.setStaticLoadModel(xmlDstabData.getStaticLoadModel().getStaticLoadType() == 
					DStabStudyCaseXmlType.StaticLoadModel.StaticLoadType.CONST_Z ? 
							StaticLoadModel.CONST_Z	: StaticLoadModel.CONST_P);
		dstabNet.setStaticLoadSwitchVolt(xmlDstabData.getStaticLoadModel().getSwitchVolt());
		dstabNet.setStaticLoadSwitchDeadZone(xmlDstabData.getStaticLoadModel().getSwitchDeadZone());

		if (xmlDstabData.getDynamicEventData().getDisableEvent()) {
			if (xmlDstabData.getDynamicEventData().getEventList() != null && 
					xmlDstabData.getDynamicEventData().getEventList().getEventArray().length > 0) {
				DStabStudyCaseXmlType.DynamicEventData.EventList.Event xmlEvent = xmlDstabData.getDynamicEventData().getEventList().getEventArray(0); 
				if (xmlEvent.getEventType() == DynamicEventDataType.SET_POINT_CHANGE) {
					IpssLogger.getLogger().info("Dynamic Event Type: SetPointChange");
					String machId = xmlEvent.getSetPointChangeData().getMachId();
					DynamicEvent event = DStabObjectFactory.createDEvent(
							Constants.Token_SetPointChangeId + machId,
							"SetPointChange", DynamicEventType.SET_POINT_CHANGE,
							dstabNet, msg);
					event.setStartTimeSec(0.0);
					event.setDurationSec(xmlDstabData.getSimuConfig().getTotalSimuTimeSec());
					SetPointChangeEvent eSetPoint = DStabObjectFactory.createSetPointChangeEvent(machId, dstabNet);
					eSetPoint.setControllerType(xmlEvent.getSetPointChangeData().getControllerType() == MachineControllerDataType.EXCITER ?
									ControllerType.EXCITER : 
										xmlEvent.getSetPointChangeData().getControllerType() == MachineControllerDataType.GOVERNOR ?
											ControllerType.GOVERNOR : ControllerType.STABILIZER);
					eSetPoint.setChangeValue(xmlEvent.getSetPointChangeData().getChangeValue());
					eSetPoint.setAbusoluteChange(xmlEvent.getSetPointChangeData().getValueChangeType() == 
									DStabStudyCaseXmlType.DynamicEventData.EventList.Event.SetPointChangeData.ValueChangeType.ABSOLUTE);
					event.setBusDynamicEvent(eSetPoint);
				}
			}
		} else {
			for (DStabStudyCaseXmlType.DynamicEventData.EventList.Event xmlEvent : xmlDstabData.getDynamicEventData().getEventList().getEventArray()) {
				// make sure that event name is not "" or NewEventName
				if (!xmlEvent.getRecName().equals(DStabDEventData.NewEventName)
						&& !xmlEvent.getRecName().trim().equals("")) {
					IpssLogger.getLogger().info("Event Data: " + xmlEvent.toString());
					// create event name
					String name = "EventAt_" + xmlEvent.getStartTimeSec() + xmlEvent.getEventType();
					// map event type
					DynamicEventType deType = XmlCaseData2AlgorithmMapperImpl.getDEventType(xmlEvent.getEventType(), xmlEvent.getFault().getFaultType());
					// create the DStabEvent
					DynamicEvent event = DStabObjectFactory.createDEvent(
							xmlEvent.getRecName(), name, deType, dstabNet,
							msg);
					if (event == null) {
						SpringAppContext.getEditorDialogUtil()
								.showErrMsgDialog("Error to create DynamicEvent", "Please see the log file for details");
						return false;
					}

					try {
						setEventData(event,	xmlEvent, xmlDstabData.getSimuConfig().getTotalSimuTimeSec(),
								dstabNet, msg);
					} catch (Exception e) {
						IpssLogger.logErr(e);
						SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
										"Error to process DynamicEvent", "See log file for details, " + e.toString());
						return false;
					}
				}
			}
		}
		return true;
	}

	private static void acscFaultData2AcscBusFaultMapping(AcscFaultXmlType xmlData, AcscBusFault fault) {
		fault.setFaultCode(xmlData.getFaultCategory() == AcscFaultCategoryDataType.FAULT_LLG ?
						SimpleFaultCode.GROUND_LLG : (xmlData.getFaultCategory() == AcscFaultCategoryDataType.FAULT_LG) ? 
								SimpleFaultCode.GROUND_LG : (xmlData.getFaultCategory() == AcscFaultCategoryDataType.FAULT_LL) ? 
										SimpleFaultCode.GROUND_LL : SimpleFaultCode.GROUND_3P);
		fault.setZLGFault(new Complex(xmlData.getZLG().getRe(), xmlData.getZLG().getIm()));
		fault.setZLLFault(new Complex(xmlData.getZLL().getRe(), xmlData.getZLL().getIm()));
	}

	private static void acscFaultData2AcscBranchFaultMapping(AcscFaultXmlType xmlData, AcscBranchFault fault) {
		acscFaultData2AcscBusFaultMapping(xmlData, fault);
		fault.setDistance(xmlData.getDistance(), UnitType.Percent);
	}

	private static void setEventData(DynamicEvent event,
			DStabStudyCaseXmlType.DynamicEventData.EventList.Event xmlEvent, double toltalSimuTime,
			DStabilityNetwork dstabNet, IPSSMsgHub msg) throws Exception {
		// for LoadChange  LowFreq and LowVolt startTime will set by system
		// FixedTime startTime = threshhold  always permanent
		if (xmlEvent.getEventType() == DynamicEventDataType.LOAD_CHANGE) {
			event.setPermanent(true);
			xmlEvent.setDurationSec(0.0);
			if (xmlEvent.getLoadChangeData().getLoadChangeType() == LoadChangeType.FIXED_TIME)
				xmlEvent.setStartTimeSec(xmlEvent.getLoadChangeData().getThreshhold());
			else
				xmlEvent.setStartTimeSec(toltalSimuTime);
		}

		event.setStartTimeSec(xmlEvent.getStartTimeSec());
		event.setPermanent(xmlEvent.getPermanent());
		if (event.isPermanent()) {
			event.setDurationSec(toltalSimuTime);
		} else {
			event.setDurationSec(xmlEvent.getDurationSec());
		}

		if (xmlEvent.getEventType() == DynamicEventDataType.LOAD_CHANGE) {
			IpssLogger.getLogger().info("Dynamic Event Type: LoadChange");
			event.setType(DynamicEventType.LOAD_CHANGE);
			LoadChangeData ldata = xmlEvent.getLoadChangeData();
			LoadChangeEvent eLoad = DStabObjectFactory.createLoadChangeEvent(ldata.getBusId(), dstabNet);
			eLoad.setType(ldata.getLoadChangeType() == LoadChangeType.LOW_FREQUENCY ? 
						LoadChangeEventType.LOW_FREQUENCY
							: (ldata.getLoadChangeType() == LoadChangeType.LOW_VOLTAGE? 
									LoadChangeEventType.LOW_VOLTAGE	: LoadChangeEventType.FIXED_TIME));
			eLoad.setChangeFactor(ldata.getChangeFactor());
			eLoad.setThreshhold(ldata.getThreshhold());
			eLoad.setDelaySec(ldata.getDelayTime());
			event.setBusDynamicEvent(eLoad);
		} 
		else if (xmlEvent.getEventType() == DynamicEventDataType.FAULT) {
			AcscFaultXmlType fdata = xmlEvent.getFault();
			if (xmlEvent.getFault().getFaultType() == AcscFaultDataType.BRANCH_OUTAGE) {
				IpssLogger.getLogger().info("Dynamic Event Type: BranchOutage");
				event.setType(DynamicEventType.BRANCH_OUTAGE);
				BranchOutageEvent bOutageEvent = DStabObjectFactory
						.createBranchOutageEvent(fdata.getBusBranchId(), dstabNet);
				if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_3_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.THREE_PHASE);
				else if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_1_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.SINGLE_PHASE);
				else if (fdata.getFaultCategory() == AcscFaultCategoryDataType.OUTAGE_2_PHASE)
					bOutageEvent.setOutageType(BranchOutageType.DOUBLE_PHASE);
				event.setBranchDynamicEvent(bOutageEvent);
			} 
			else if (fdata.getFaultType() == AcscFaultDataType.BUS_FAULT) {
				event.setType(DynamicEventType.BUS_FAULT);
				AcscBusFault fault = CoreObjectFactory.createAcscBusFault(Constants.Token_BusFaultId + fdata.getBusBranchId());
				XmlCaseData2AlgorithmMapperImpl.acscFaultData2AcscBusFaultMapping(fdata, fault);
				event.setBusFault(fault);
				DStabBus bus = dstabNet.getDStabBus(NetUtilFunc.getBusIdFromDisplayNameId(fdata.getBusBranchId()));
				if (bus != null)
					fault.setFaultBus(bus);
				else {
					throw new InvalidParameterException("Programming erroe, Bus cannot be found, id:" + fdata.getBusBranchId());
				}
			} 
			else if (fdata.getFaultType() == AcscFaultDataType.BRANCH_FAULT) {
				event.setType(DynamicEventType.BRANCH_FAULT);
				DStabBranchFault fault = XmlCaseData2AlgorithmMapperImpl.createDStabBranchFault(fdata, dstabNet);
				event.setBranchFault(fault);
				if (fault.isReclosure()) {
					String name = "EventAt_" + xmlEvent.getStartTimeSec() + xmlEvent.getEventType();
					DynamicEvent event2 = DStabObjectFactory.createDEvent(event.getId()
							+ "-Reclosure", name, DynamicEventType.BRANCH_RECLOSURE, dstabNet, msg);
					event2.setStartTimeSec(fault.getReclosureTime());
					event2.setDurationSec(toltalSimuTime);
					event2.setPermanent(true);
					event2.setBranchFault(XmlCaseData2AlgorithmMapperImpl
							.createDStabBranchFault(fdata, dstabNet));
				}
			}
		}
	}

	private static DStabBranchFault createDStabBranchFault(AcscFaultXmlType fdata,	DStabilityNetwork dstabNet) {
		DStabBranchFault fault = DStabObjectFactory
				.createDStabBranchFault(Constants.Token_BranchFaultId + fdata.getBusBranchId());
		acscFaultData2AcscBranchFaultMapping(fdata, fault);
		fault.setReclosure(fdata.getBranchReclosure());
		fault.setReclosureTime(fdata.getReclosureTime());
		DStabBranch branch = dstabNet.getDStabBranch(NetUtilFunc.getBranchIdFromDisplayNameId(fdata.getBusBranchId()));
		if (branch != null)
			fault.setFaultBranch(branch);
		else {
			throw new InvalidParameterException(
					"Programming error, Branch cannot be found, id:" + fdata.getBusBranchId());
		}
		return fault;
	}

	private static DynamicEventType getDEventType(DynamicEventDataType.Enum xmlEventType, AcscFaultDataType.Enum xmlFaultType) {
		if (xmlEventType == DynamicEventDataType.FAULT) {
			if (xmlFaultType == AcscFaultDataType.BUS_FAULT)
				return DynamicEventType.BUS_FAULT;
			else if (xmlFaultType == AcscFaultDataType.BRANCH_FAULT)
				return DynamicEventType.BRANCH_FAULT;
			else if (xmlFaultType == AcscFaultDataType.BRANCH_OUTAGE)
				return DynamicEventType.BRANCH_OUTAGE;
		}
		else if (xmlEventType == DynamicEventDataType.LOAD_CHANGE) 
			return DynamicEventType.LOAD_CHANGE;
		else if (xmlEventType == DynamicEventDataType.SET_POINT_CHANGE) 
			return DynamicEventType.SET_POINT_CHANGE;
		else {
			throw new InvalidParameterException("Programming error, eventDataType: " + xmlEventType);
		}
		return null;
	}

	private static void addAllFaultCategory(String busId, String faultIdStr,
			AcscBusFault fault, SimpleFaultNetwork faultNet) {
		String id = fault.getId();

		fault.setId(id + "_3P");
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		faultNet.addBusFault(busId, faultIdStr, fault);

		fault.setId(id + "_LG");
		fault.setFaultCode(SimpleFaultCode.GROUND_LG);
		faultNet.addBusFault(busId, faultIdStr, fault);

		fault.setId(id + "_LLG");
		fault.setFaultCode(SimpleFaultCode.GROUND_LLG);
		faultNet.addBusFault(busId, faultIdStr, fault);

		fault.setId(id + "_LL");
		fault.setFaultCode(SimpleFaultCode.GROUND_LL);
		faultNet.addBusFault(busId, faultIdStr, fault);
	}
}