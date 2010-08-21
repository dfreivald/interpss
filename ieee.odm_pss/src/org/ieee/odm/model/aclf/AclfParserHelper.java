package org.ieee.odm.model.aclf;

import java.util.logging.Logger;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.model.BaseJaxbHelper;
import org.ieee.odm.schema.ActivePowerUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BusRecordXmlType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LFLoadCodeEnumType;
import org.ieee.odm.schema.LoadflowBusDataXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.LoadflowGenDataXmlType;
import org.ieee.odm.schema.LoadflowLoadDataXmlType;
import org.ieee.odm.schema.LoadflowNetXmlType;
import org.ieee.odm.schema.ReactivePowerUnitType;
import org.ieee.odm.schema.VoltageUnitType;

public class AclfParserHelper extends BaseJaxbHelper {
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
	 * create a Contribution Load object
	 * 
	 */
	public static LoadflowLoadDataXmlType createContriLoad(LoadflowBusXmlType busRec) {
		LoadflowBusXmlType.LoadData loadData = busRec.getLoadData();
		if (loadData == null) { 
			loadData = getFactory().createLoadflowBusXmlTypeLoadData();
			busRec.setLoadData(loadData);
			LoadflowLoadDataXmlType equivLoad = getFactory().createLoadflowLoadDataXmlType();
			loadData.setEquivLoad(equivLoad);
		}
		if (loadData.getContributeLoadList() == null) 
			loadData.setContributeLoadList(getFactory().createLoadflowBusXmlTypeLoadDataContributeLoadList());
		LoadflowLoadDataXmlType contribLoad = getFactory().createLoadflowLoadDataXmlType();
	    loadData.getContributeLoadList().getContributeLoad().add(contribLoad); 
	    return contribLoad;
	}
	
	/**
	 * create a Contribution Load object
	 * 
	 */
	public static LoadflowGenDataXmlType createContriGen(LoadflowBusXmlType busRec) {
		LoadflowBusXmlType.GenData genData = busRec.getGenData();
		if (genData == null) {
			genData = getFactory().createLoadflowBusXmlTypeGenData();
			busRec.setGenData(genData);
			LoadflowGenDataXmlType equivGen = new LoadflowGenDataXmlType();
			genData.setEquivGen(equivGen);
		}
		// some model does not need ContributeGenList
		if (genData.getContributeGenList() == null) 
			genData.setContributeGenList(getFactory().createLoadflowBusXmlTypeGenDataContributeGenList());
		LoadflowGenDataXmlType contribGen = getFactory().createLoadflowGenDataXmlType();
		genData.getContributeGenList().getContributeGen().add(contribGen);
		return contribGen;
	}
	
	/**
	 * consolidate bus genContributionList and loadContributionList to the equiv gen and load 
	 * 
	 */
	public static boolean createBusEquivData(AclfModelParser parser, Logger logger) {
		LoadflowNetXmlType baseCaseNet = parser.getAclfNet(); 
		boolean ok = true;

		for (JAXBElement<? extends BusXmlType> bus : baseCaseNet.getBusList().getBus()) {
			LoadflowBusXmlType busRec = (LoadflowBusXmlType)bus.getValue();
			LoadflowBusXmlType.GenData genData = busRec.getGenData();
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
									remoteBusId = ((BusXmlType)gen.getRemoteVoltageControlBus().getIdRef()).getId();
								}
							}
							else if (!remoteBusId.equals(gen.getRemoteVoltageControlBus().getIdRef())) {
								logger.severe("Inconsistant remote control bus id, " + remoteBusId +
										", " + gen.getRemoteVoltageControlBus().getIdRef());
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
									logger.severe("Inconsistant gen desired voltage, " + 
											gen.getRemoteVoltageControlBus().getIdRef());
									return false; 
								}
							}
						}
					}
					
					if (offLine && genData.getEquivGen().getCode() != LFGenCodeEnumType.SWING)
						// generator on a swing bus might turned off
						genData.getEquivGen().setCode(LFGenCodeEnumType.OFF);
					else {	
						equivGen.setPower(AclfDataSetter.createPowerValue(pgen, qgen, ApparentPowerUnitType.MVA));
						if (pmax != 0.0 || pmin != 0.0) {
							equivGen.setPLimit(AclfDataSetter.createActivePowerLimit(pmax, pmin, ActivePowerUnitType.MW));
						}
						if (qmax != 0.0 || qmin != 0.0) {
							equivGen.setQLimit(AclfDataSetter.createReactivePowerLimit(qmax, qmin, ReactivePowerUnitType.MVAR));
						}
						if (vSpec != 0.0) {
							equivGen.setDesiredVoltage(AclfDataSetter.createVoltageValue(vSpec, vSpecUnit));
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
			
			LoadflowBusXmlType.LoadData loadData = busRec.getLoadData();
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
			  			equivLoad.setConstPLoad(AclfDataSetter.createPowerValue(cp_p, cp_q, ApparentPowerUnitType.MVA));
			  		}
					else if ((ci_p != 0.0 || ci_q != 0.0) && (cp_p==0.0 && cp_q ==0.0 && cz_p==0.0 && cz_q ==0.0) ) {
						equivLoad.setCode(LFLoadCodeEnumType.CONST_I);
						equivLoad.setConstILoad(AclfDataSetter.createPowerValue(ci_p, ci_q, ApparentPowerUnitType.MVA));
			  		}
					else if ((cz_p != 0.0 || cz_q != 0.0) && (ci_p==0.0 && ci_q ==0.0 && cp_p==0.0 && cp_q ==0.0) ) {
						equivLoad.setCode(LFLoadCodeEnumType.CONST_Z);
						equivLoad.setConstZLoad(AclfDataSetter.createPowerValue(cz_p, cz_q, ApparentPowerUnitType.MVA));
			  		}
					else if ((cp_p != 0.0 || cp_q != 0.0 || ci_p!= 0.0 || ci_q != 0.0 || cz_p != 0.0 || cz_q !=0.0)) {
						equivLoad.setCode(LFLoadCodeEnumType.FUNCTION_LOAD);
						equivLoad.setConstPLoad(AclfDataSetter.createPowerValue(cp_p, cp_q, ApparentPowerUnitType.MVA));
						equivLoad.setConstILoad(AclfDataSetter.createPowerValue(ci_p, ci_q, ApparentPowerUnitType.MVA));
						equivLoad.setConstZLoad(AclfDataSetter.createPowerValue(cz_p, cz_q, ApparentPowerUnitType.MVA));
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

}
