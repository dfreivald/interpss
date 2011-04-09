package org.ieee.odm.adapter.bpa.impl;

import javax.xml.bind.JAXBElement;

import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.aclf.AclfDataSetter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.base.BaseDataSetter;
import org.ieee.odm.model.base.ModelStringUtil;
import org.ieee.odm.schema.AngleUnitType;
import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.LFGenCodeEnumType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.PowerXmlType;
import org.ieee.odm.schema.VoltageUnitType;

public class GenLoadDataModifyRecord {
	/*
	 * only AC Bus will be considered for generation and/or load data modification.
	 */
	private static final String Modify_Gen_n_Load_ALL="PA";        //PA
	private static final String Modify_Gen_n_Load_BY_ZONE="PZ";    //PZ
	private static final String Modify_Gen_n_Load_BY_OWNER="PO";   //PO
	// for the following, NOT implemented yet
	//TODO
	private static final String Modify_ConstZILoad_BY_ZONE="PC";   //PC
	private static final String Modify_ConstZILoad_BY_OWNER="PB";   //PB
	
	public static void processGenLoadModificationData(final String str, AclfModelParser parser)
	throws Exception {
		final String[] strAry =getModificationData(str);
		double loadP_Factor=1;
		double loadQ_Factor=1;
		double genP_Factor=1;
		double genQ_Factor=1;
		if(!strAry[2].equals(""))
			loadP_Factor= new Double(strAry[2]).doubleValue();
		if(!strAry[3].equals(""))
			loadQ_Factor= new Double(strAry[3]).doubleValue();
		if(!strAry[4].equals(""))
			genP_Factor= new Double(strAry[4]).doubleValue();
		if(!strAry[5].equals(""))
			genQ_Factor= new Double(strAry[5]).doubleValue();
		
		if(strAry[0].equals(Modify_Gen_n_Load_ALL)){
			
			for(JAXBElement<? extends BusXmlType> b : parser.getAclfNet().getBusList().getBus()){
				LoadflowBusXmlType bus=(LoadflowBusXmlType) b.getValue();
				modifyLoadData(bus,loadP_Factor,loadQ_Factor);
				modifyGenData(bus,genP_Factor,genQ_Factor);
			}
		}
		else if(strAry[0].equals(Modify_Gen_n_Load_BY_ZONE)){
			for(JAXBElement<? extends BusXmlType> b : parser.getAclfNet().getBusList().getBus()){
				LoadflowBusXmlType bus=(LoadflowBusXmlType) b.getValue();
				if(bus.getZoneName().equals(strAry[1])){
					modifyLoadData(bus,loadP_Factor,loadQ_Factor);
					modifyGenData(bus,genP_Factor,genQ_Factor);
				}
			}
		}
		else if (strAry[0].equals(Modify_Gen_n_Load_BY_OWNER)){
			for(JAXBElement<? extends BusXmlType> b : parser.getAclfNet().getBusList().getBus()){
				LoadflowBusXmlType bus=(LoadflowBusXmlType) b.getValue();
				if(bus.getZoneName().equals(strAry[1])){
					modifyLoadData(bus,loadP_Factor,loadQ_Factor);
					modifyGenData(bus,genP_Factor,genQ_Factor);
				}
			}
		}
		else ODMLogger.getLogger().severe("The input modification type #"+strAry[0]+" is not supported yet.");

	}
	private static String[] getModificationData(final String str){
		final String[] strAry = new String[20];
		try{
			// type
			strAry[0] = ModelStringUtil.getStringReturnEmptyString(str,1, 2);
			//zone name
			if(strAry[0].equals(Modify_Gen_n_Load_BY_ZONE)||strAry[0].equals(Modify_ConstZILoad_BY_ZONE))
               strAry[1] = ModelStringUtil.getStringReturnEmptyString(str,4, 5).trim();
			// ower name
			else if(strAry[0].equals(Modify_Gen_n_Load_BY_OWNER)||strAry[0].equals(Modify_ConstZILoad_BY_OWNER))
			  strAry[1] = ModelStringUtil.getStringReturnEmptyString(str,4, 6).trim();
			// LoadP and LoadQ modification factor
			strAry[2] = ModelStringUtil.getStringReturnEmptyString(str,10, 14).trim();
			strAry[3] = ModelStringUtil.getStringReturnEmptyString(str,16, 20).trim();
			// GenP and GenQ modification factor
			strAry[4] = ModelStringUtil.getStringReturnEmptyString(str,22, 26).trim();
			strAry[5] = ModelStringUtil.getStringReturnEmptyString(str,28, 32).trim();
			// for the rest optional setting, not implementation yet
			//TODO
			
		}catch(Exception e){
			ODMLogger.getLogger().severe(e.toString() + "\n" + str);
			e.printStackTrace();
		}
		return strAry;
		
	
		
	}
	private static boolean modifyGenData(LoadflowBusXmlType bus, double genPFactor,double genQFactor){
		try{
			if(bus.getGenData()!=null&&bus.getGenData().getEquivGen()!=null
					&&bus.getGenData().getEquivGen().getPower()!=null){
				double genP=bus.getGenData().getEquivGen().getPower().getRe();
				double genQ=bus.getGenData().getEquivGen().getPower().getIm();
				if(genP!=0.0)genP*=genPFactor;
				if(genQ!=0.0)genQ*=genQFactor;
				if(genP!=0.0||genQ!=0){
					  genP=ModelStringUtil.getNumberFormat(genP);
					  genQ=ModelStringUtil.getNumberFormat(genQ);
					bus.getGenData().getEquivGen().setPower(BaseDataSetter.createPowerValue(
						genP,genQ,ApparentPowerUnitType.MVA));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
		
	}
	private static boolean modifyLoadData(LoadflowBusXmlType bus, double loadPFactor,double loadQFactor){
		try{
			if(bus.getLoadData()!=null&&bus.getLoadData().getEquivLoad()!=null
					&&bus.getLoadData().getEquivLoad().getConstPLoad()!=null){
				  double loadP=bus.getLoadData().getEquivLoad().getConstPLoad().getRe();
				  double loadQ=bus.getLoadData().getEquivLoad().getConstPLoad().getIm();
				  if(loadP!=0.0)loadP*=loadPFactor;
				  if(loadQ!=0.0)loadQ*=loadQFactor;
				  if(loadP!=0.0||loadQ!=0.0){
					  loadP=ModelStringUtil.getNumberFormat(loadP);
					  loadQ=ModelStringUtil.getNumberFormat(loadQ);
					  bus.getLoadData().getEquivLoad().setConstPLoad(BaseDataSetter.createPowerValue(
							loadP,loadQ,ApparentPowerUnitType.MVA));
				  }

				 }
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
}
