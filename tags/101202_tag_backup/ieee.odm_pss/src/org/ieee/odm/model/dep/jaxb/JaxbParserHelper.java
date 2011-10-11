 /*
  * @(#)ContainerHelper.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 02/11/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.model.dep.jaxb;

import java.util.logging.Logger;

import javax.xml.bind.JAXBElement;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.FaultTypeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.odm.model.BaseDataSetter;
import org.ieee.odm.model.BaseJaxbHelper;
import org.ieee.odm.schema.AcscFaultXmlType;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BranchFaultXmlType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.BusFaultXmlType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.DStabSimulationXmlType;
import org.ieee.odm.schema.DcLineFaultXmlType;
import org.ieee.odm.schema.ExciterXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.LoadflowBusDataXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowLoadDataXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.NetAreaXmlType;
import org.ieee.odm.schema.NetZoneXmlType;
import org.ieee.odm.schema.NetworkXmlType;
import org.ieee.odm.schema.ReactivePowerUnitType;
import org.ieee.odm.schema.ShuntCompensatorDataXmlType;
import org.ieee.odm.schema.ShuntCompensatorXmlType;
import org.ieee.odm.schema.StabilizerXmlType;
import org.ieee.odm.schema.StaticVarCompensatorXmlType;
import org.ieee.odm.schema.TurbineGovernorXmlType;
import org.ieee.odm.schema.VoltageUnitType;

public class JaxbParserHelper extends BaseJaxbHelper {
	/**
	 * consolidate bus genContributionList and loadContributionList to the equiv gen and load 
	 * for v07 
	 * 
	 */
	public static boolean createBusEquivData(JaxbODMModelParser parser, Logger logger) {
		LoadflowNetXmlType baseCaseNet = parser.getAclfBaseCase(); 
		boolean ok = true;

		for (JAXBElement<? extends BusXmlType> bus : baseCaseNet.getBusList().getBus()) {
			BusRecordXmlType busRec = (BusRecordXmlType)bus.getValue();
			LoadflowBusDataXmlType.GenData genData = busRec.getLoadflowData().getGenData();
			if (genData != null) {
				if ( genData.getContributeGenList() != null && 
						genData.getContributeGenList().getContributeGen().size() > 0) {
					LoadflowGenDataXmlType equivGen = genData.getEquivGen();
					double pgen = 0.0, qgen = 0.0, qmax = 0.0, qmin = 0.0, pmax = 0.0, pmin = 0.0, vSpec = 0.0;
					VoltageUnitType vSpecUnit = VoltageUnitType.PU;
					String remoteBusId = null;
					boolean offLine = true;
					for ( LoadflowGenDataXmlType gen : genData.getContributeGenList().getContributeGen()) {
						if (!gen.isOffLine()) {
							offLine = false;
							if (remoteBusId == null) {
								if (gen.getRemoteVoltageControlBus() != null) {
									remoteBusId = BaseJaxbHelper.getRecId(gen.getRemoteVoltageControlBus());
								}
							}
							else if (!remoteBusId.equals(BaseJaxbHelper.getRecId(gen.getRemoteVoltageControlBus()))) {
								logger.severe("Inconsistant remote control bus id, " + remoteBusId +
										", " + BaseJaxbHelper.getRecId(gen.getRemoteVoltageControlBus()));
								return false; 
							}
							
							pgen += gen.getPower().getRe();
							qgen += gen.getPower().getIm();
							if(gen.getQLimit() != null) {
								qmax += gen.getQLimit().getMax();
								qmin += gen.getQLimit().getMin();
							}
							if(gen.getPLimit() != null) {
								pmax += gen.getPLimit().getMax();
								pmin += gen.getPLimit().getMin();
							}
							
							if (gen.getDesiredVoltage() != null) {
								if (vSpec == 0.0) {
									vSpec = gen.getDesiredVoltage().getValue();
									vSpecUnit = gen.getDesiredVoltage().getUnit();
								}
								else if (vSpec != gen.getDesiredVoltage().getValue()) {
									logger.severe("Inconsistant gen desired voltage, " + BaseJaxbHelper.getRecId(gen.getRemoteVoltageControlBus()));
									return false; 
								}
							}
						}
					}
					
					if (offLine && genData.getEquivGen().getCode() != LFGenCodeEnumType.SWING)
						// generator on a swing bus might turned off
						genData.getEquivGen().setCode(LFGenCodeEnumType.OFF);
					else {	
						equivGen.setPower(BaseDataSetter.createPowerValue(pgen, qgen, ApparentPowerUnitType.MVA));
						if (pmax != 0.0 || pmin != 0.0) {
							equivGen.setPLimit(BaseDataSetter.createActivePowerLimit(pmax, pmin, ActivePowerUnitType.MW));
						}
						if (qmax != 0.0 || qmin != 0.0) {
							equivGen.setQLimit(BaseDataSetter.createReactivePowerLimit(qmax, qmin, ReactivePowerUnitType.MVAR));
						}
						if (vSpec != 0.0) {
							equivGen.setDesiredVoltage(BaseDataSetter.createVoltageValue(vSpec, vSpecUnit));
						}
					}
					
					if (remoteBusId != null && !remoteBusId.equals(busRec.getId()) && 
							genData.getEquivGen().getCode() == LFGenCodeEnumType.PV){
						// Remote Q  Bus control, we need to change this bus to a GPQ bus so that its Q could be adjusted
						genData.getEquivGen().setRemoteVoltageControlBus(parser.createBusRef(remoteBusId));
					}
				}
				else {
					genData.getEquivGen().setCode(LFGenCodeEnumType.NONE_GEN);
					if (genData.getEquivGen().getPower() != null)
						genData.getEquivGen().setPower(null);
					if (genData.getEquivGen().getVoltageLimit() != null)
						genData.getEquivGen().setVoltageLimit(null);
				}
			}
			
			LoadflowBusDataXmlType.LoadData loadData = busRec.getLoadflowData().getLoadData();
			if (loadData != null) {
				if (loadData.getContributeLoadList() != null &&
						loadData.getContributeLoadList().getContributeLoad().size() > 0) {
					LoadflowLoadDataXmlType equivLoad = loadData.getEquivLoad();
					double cp_p=0.0, cp_q=0.0, ci_p=0.0, ci_q=0.0, cz_p=0.0, cz_q=0.0; 
					for ( LoadflowLoadDataXmlType load : loadData.getContributeLoadList().getContributeLoad()) {
						if (!load.isOffLine()) {
							if (load.getConstPLoad() != null) {
								cp_p += load.getConstPLoad().getRe();
								cp_q += load.getConstPLoad().getIm();
							}
							if (load.getConstILoad() != null) {
								ci_p += load.getConstILoad().getRe();
								ci_q += load.getConstILoad().getIm();
							}
							if (load.getConstZLoad() != null) {
								cz_p += load.getConstZLoad().getRe();
								cz_q += load.getConstZLoad().getIm();
							}
						}					
					}
					
					if ((cp_p != 0.0 || cp_q != 0.0) && (ci_p==0.0 && ci_q ==0.0 && cz_p==0.0 && cz_q ==0.0) ) {
						equivLoad.setCode(LFLoadCodeEnumType.CONST_P);
			  			equivLoad.setConstPLoad(BaseDataSetter.createPowerValue(cp_p, cp_q, ApparentPowerUnitType.MVA));
			  		}
					else if ((ci_p != 0.0 || ci_q != 0.0) && (cp_p==0.0 && cp_q ==0.0 && cz_p==0.0 && cz_q ==0.0) ) {
						equivLoad.setCode(LFLoadCodeEnumType.CONST_I);
						equivLoad.setConstILoad(BaseDataSetter.createPowerValue(ci_p, ci_q, ApparentPowerUnitType.MVA));
			  		}
					else if ((cz_p != 0.0 || cz_q != 0.0) && (ci_p==0.0 && ci_q ==0.0 && cp_p==0.0 && cp_q ==0.0) ) {
						equivLoad.setCode(LFLoadCodeEnumType.CONST_Z);
						equivLoad.setConstZLoad(BaseDataSetter.createPowerValue(cz_p, cz_q, ApparentPowerUnitType.MVA));
			  		}
					else if ((cp_p != 0.0 || cp_q != 0.0 || ci_p!= 0.0 || ci_q != 0.0 || cz_p != 0.0 || cz_q !=0.0)) {
						equivLoad.setCode(LFLoadCodeEnumType.FUNCTION_LOAD);
						equivLoad.setConstPLoad(BaseDataSetter.createPowerValue(cp_p, cp_q, ApparentPowerUnitType.MVA));
						equivLoad.setConstILoad(BaseDataSetter.createPowerValue(ci_p, ci_q, ApparentPowerUnitType.MVA));
						equivLoad.setConstZLoad(BaseDataSetter.createPowerValue(cz_p, cz_q, ApparentPowerUnitType.MVA));
					}
					else {
						loadData.getEquivLoad().setCode(LFLoadCodeEnumType.NONE_LOAD);
					}
				}
				else
					loadData.getEquivLoad().setCode(LFLoadCodeEnumType.NONE_LOAD);
			}
		}
		
		return ok;
	}
	
	/*
	 *      Parser Container object creation and retrieval functions
	 *      ========================================================== 
	 */
	
	/**
	 * create a Contribution Load object
	 * 
	 */
	public static LoadflowLoadDataXmlType createContriLoad(BusRecordXmlType busRec) {
		LoadflowBusDataXmlType.LoadData loadData = busRec.getLoadflowData().getLoadData();
		if (loadData == null) { 
			loadData = getFactory().createLoadflowBusDataXmlTypeLoadData();
			busRec.getLoadflowData().setLoadData(loadData);
			LoadflowLoadDataXmlType equivLoad = getFactory().createLoadflowLoadDataXmlType();
			loadData.setEquivLoad(equivLoad);
		}
		if (loadData.getContributeLoadList() == null) 
			loadData.setContributeLoadList(getFactory().createLoadflowBusDataXmlTypeLoadDataContributeLoadList());
		LoadflowLoadDataXmlType contribLoad = getFactory().createLoadflowLoadDataXmlType();
	    loadData.getContributeLoadList().getContributeLoad().add(contribLoad); 
	    return contribLoad;
	}
	
	/**
	 * create a Contribution Load object
	 * 
	 */
	public static LoadflowGenDataXmlType createContriGen(BusRecordXmlType busRec) {
		LoadflowBusDataXmlType.GenData genData = busRec.getLoadflowData().getGenData();
		if (genData == null) {
			genData = getFactory().createLoadflowBusDataXmlTypeGenData();
			busRec.getLoadflowData().setGenData(genData);
			LoadflowGenDataXmlType equivGen = new LoadflowGenDataXmlType();
			genData.setEquivGen(equivGen);
		}
		// some model does not need ContributeGenList
		if (genData.getContributeGenList() == null) 
			genData.setContributeGenList(getFactory().createLoadflowBusDataXmlTypeGenDataContributeGenList());
		LoadflowGenDataXmlType contribGen = getFactory().createLoadflowGenDataXmlType();
		genData.getContributeGenList().getContributeGen().add(contribGen);
		return contribGen;
	}
	
	/**
	 * create a SVC object
	 * 
	 */
	public static StaticVarCompensatorXmlType createSVC(BusRecordXmlType bus) {
		if (bus.getSvcData() == null) {
			//LoadflowBusDataXmlType.
			BusRecordXmlType.SvcData data = getFactory().createBusRecordXmlTypeSvcData();
			bus.setSvcData(data);
		}
		if (bus.getSvcData().getSvcList() == null) {
			bus.getSvcData().setSvcList(getFactory().createBusRecordXmlTypeSvcDataSvcList());
			
		}		
		StaticVarCompensatorXmlType svc = getFactory().createStaticVarCompensatorXmlType();
		
		bus.getSvcData().getSvcList().getSvc().add(svc);
		return svc;
	}

	/**
	 * create a ShuntCompensatorXmlType object
	 * 
	 */
	public static ShuntCompensatorXmlType createShuntCompensator(BusRecordXmlType bus) {
		if (bus.getLoadflowData().getShuntCompensatorData() == null) {
			ShuntCompensatorDataXmlType data = getFactory().createShuntCompensatorDataXmlType(); 
			bus.getLoadflowData().setShuntCompensatorData(data);
		}
		if (bus.getLoadflowData().getShuntCompensatorData().getShuntCompensatorList() == null) {
			bus.getLoadflowData().getShuntCompensatorData().setShuntCompensatorList(getFactory().createShuntCompensatorDataXmlTypeShuntCompensatorList());
		}
		ShuntCompensatorXmlType compensator = getFactory().createShuntCompensatorXmlType();
		bus.getLoadflowData().getShuntCompensatorData().getShuntCompensatorList().getShunCompensator().add(compensator);
		return compensator; 
	}
	
	/**
	 * there might be multiple branch sections in the branchRec, this function gets the first for those
	 * formats only has one branch section
	 * 
	 * @param branchRec
	 * @return
	 */
	public static LoadflowBranchDataXmlType  getDefaultBranchData(BranchRecordXmlType branchRec) {
      	// there might be multiple branch sections, but UTCE only has one
		return branchRec.getLoadflowData().get(0);
	}
	
	/**
	 * Get area record with the areaname
	 * 
	 * @param areaName
	 * @param baseCaseNet
	 * @return
	 */
	public static NetAreaXmlType getAreaRecordByAreaName(String areaName, NetworkXmlType baseCaseNet) {
		for (NetAreaXmlType area:baseCaseNet.getAreaList().getArea()) {
			if (areaName.equals(area.getName()))
				return area;
		}
		return null;
	}
	
	/**
	 * Get area record with the zone
	 * 
	 * @param zoneName
	 * @param baseCaseNet
	 * @return
	 */
	public static NetAreaXmlType getAreaRecordByZone(int zoneNo, NetworkXmlType baseCaseNet) {
		for (NetAreaXmlType area:baseCaseNet.getAreaList().getArea()) {
			for(NetZoneXmlType zone : area.getZoneList().getZone()){
				if (zoneNo == zone.getNumber())
					return area;
			}			
		}
		return null;
	}
	
	/**
	 * Get zone record with the zonename
	 * 
	 * @param zoneName
	 * @param area
	 * @return
	 */
	public static NetZoneXmlType getZoneRecord(String zoneName, NetAreaXmlType area) {
		for (NetZoneXmlType zone:area.getZoneList().getZone()) {
			if (zoneName.equals(zone.getName()))
				return zone;
		}
		return null;
	}
	
	
	public static AcscFaultXmlType getFaultRecord(DStabSimulationXmlType tranSimu,
			FaultTypeEnumType faultType, String fbus,String tbus){
//		if(tranSimu.getDynamicDataList().getFaultList().getFault()!=null){			
//			for(FaultXmlType fault:tranSimu.getDynamicDataList().getFaultList().getFault()){				
//				if(faultType.equals(fault.getFaultType())){					
//					if(faultType.equals(FaultTypeEnumType.BUS_FAULT)){						
//						BusFaultXmlType busFault=fault.getBusFault();
//						if(fbus.equals(busFault.getFaultedBus().getName())&&
//								tbus.equals(busFault.getRemoteEndBus().getName())){							
//							return fault;							
//						}
//					}
//				}				
//			}		
//		}
		//FaultXmlType fault = new AcscFaultXmlType();
		//tranSimu.getDynamicDataList().getFaultList().getFault().add(fault);
		return null;
	}		
	
	public static BusFaultXmlType getBusFaultRecord(DStabSimulationXmlType tranSimu,
			String fbus,String tbus){
//		
//		for(FaultXmlType fault:tranSimu.getDynamicDataList().getFaultList().getFault()){
//			if(fault.getBusFault()!=null){
//				BusFaultXmlType busFault=fault.getBusFault();				
//				if(fbus.equals(busFault.getFaultedBus().getName())&& 
//						tbus.equals(busFault.getRemoteEndBus().getName()))					
//			         return busFault;
//			}else{
//				BusFaultXmlType busFault = new BusFaultXmlType();
//				fault.setBusFault(busFault);
//				return busFault;
//			}			
//		}
		return null;
	}
	
	public static BranchFaultXmlType getBranchFaultRecord(DStabSimulationXmlType tranSimu,
			String fbus,String tbus){		
//		for(FaultXmlType fault:tranSimu.getDynamicDataList().getFaultList().getFault()){
//			if(fault.getBranchFault()!=null){
//				BranchFaultXmlType braFault=fault.getBranchFault();				
//				if(fbus.equals(braFault.getFromBus().getName())&& tbus.equals(braFault.getToBus().getName()))
//			         return braFault;
//			}else{
//				BranchFaultXmlType branchFault = new BranchFaultXmlType();
//				fault.setBranchFault(branchFault);
//				return branchFault;
//			}			
//		}
		return null;
	}
	
	public static DcLineFaultXmlType getDCFaultRecord(DStabSimulationXmlType tranSimu,
			String fbus,String tbus){
//		for(FaultXmlType fault: tranSimu.getDynamicDataList().getFaultList().getFault()){
//			if(fault.getDcLineFault()!=null){				
//				DcLineFaultXmlType dcFault= fault.getDcLineFault();				
//				if(fbus.equals(dcFault.getFromACBus().getName())&&
//						tbus.equals(dcFault.getToACBus().getName())){					
//					return dcFault;
//				}else {	
//					DcLineFaultXmlType dcLineFault = new DcLineFaultXmlType();
//					fault.setDcLineFault(dcLineFault);
//					return dcLineFault;
//				}
//			}
//		}
		return null;
	}
	
	public static GeneratorXmlType getGeneratorRecord(DStabSimulationXmlType tranSimu,
			   String busId,String genId){		
//		for(GeneratorXmlType gen: tranSimu.getDynamicDataList().getBusDynDataList().getGeneratorDataList().getGenerator()){						
//			if(busId.equals(gen.getLocatedBus().getName())){
//				if(gen.getGenId()!=null){
//					if(genId.equals(gen.getGenId().getName())){
//						return gen;
//					}
//				}else{
//					return gen;
//				}			
//			}
//		}		
		return null;		
	}
	
	public static ExciterXmlType getExciterRecord(DStabSimulationXmlType tranSimu,
			 String busId, String excId){
//		for(ExciterXmlType exc: tranSimu.getDynamicDataList().getBusDynDataList().getExciterDataList().getExciter()){
//			if(busId.equals(exc.getLocatedBus().getName())){
//				if(exc.getExcId()!=null){
//					if(excId.equals(exc.getExcId().getName())){
//						return exc;
//					}
//				}else{
//					return exc;
//				}
//			}			
//		}		
		return null;		
	}
	
	public static TurbineGovernorXmlType getTGRecord(DStabSimulationXmlType tranSimu,
			 String busId, String tgId){
//		for(TurbineGovernorXmlType tg: tranSimu.getDynamicDataList().getBusDynDataList().getTurbineGovernorDataList().getTurbineGovernor()){
//			if(busId.equals(tg.getLocatedBus().getName())){
//				if(tg.getTgId()!=null){
//					if(tgId.equals(tg.getTgId().getName())){
//						return tg;
//					}
//				}else{
//					return tg;
//				}
//			}			
//		}	
		return null;		
	}
	
	public static StabilizerXmlType getPSSRecord(DStabSimulationXmlType tranSimu,
			 String busId, String macId){
//		for(StabilizerXmlType pss: tranSimu.getDynamicDataList().getBusDynDataList().getStabilizerDataList().getStabilizer()){
//			if(busId.equals(pss.getLocatedBus().getName())){
//				if(pss.getMachId()!=null){
//					if(macId.equals(pss.getMachId().getName())){
//						return pss;
//					}
//				}else{
//					return pss;
//				}
//			}			
//		}	
		return null;		
	}
}