/*
 * @(#)BPADynamicRecord.java   
 *
 * Copyright (C) 2006-2008 www.interpss.org
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
 * @Author Stephen Hau
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.adapter.bpa.impl.dynamic;

import org.ieee.odm.adapter.bpa.impl.BusRecord;
import org.ieee.odm.common.ODMException;
import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.base.BaseDataSetter;
import org.ieee.odm.model.base.ModelStringUtil;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.model.dstab.DStabParserHelper;
import org.ieee.odm.schema.DStabBusXmlType;
import org.ieee.odm.schema.DynamicGeneratorXmlType;
import org.ieee.odm.schema.ExcBPAFJXmlType;
import org.ieee.odm.schema.ExcIEEE1968Type1XmlType;
import org.ieee.odm.schema.ExcIEEE1981NewExcSystemXmlType;
import org.ieee.odm.schema.ExcIEEE1981ST1XmlType;
import org.ieee.odm.schema.ExcIEEE1981TypeAC2XmlType;
import org.ieee.odm.schema.ExcIEEETypeDC2XmlType;

public class BPADynamicExciterRecord {
	private final static int EA=1;
	private final static int EC=2;
	private final static int EK=3;    	
	private final static int FJ=4;
	private final static int FK=5;
	private final static int FQ=6;
	private final static int FV=7;
	private final static int FF=8;
	private final static int FA=9;
	
	public static void processExciterData(String str, DStabModelParser parser ) throws ODMException {
    	final String strAry[]=getExciterDataFields(str);
    	int type= getExcType(strAry[0]);
    	
    	String busId = BusRecord.getBusId(strAry[1]);
    	DStabBusXmlType bus = parser.getDStabBus(busId);
    	
    	DynamicGeneratorXmlType dynGen = DStabParserHelper.getDynamicGenRec(bus);
    	
    	if(type==EA||type==EC||type==EK){
    		ExcIEEE1968Type1XmlType exc = DStabParserHelper.createExcIEEE1968Type1XmlType(dynGen);

    		//excId
    		String excId="1";
    		if(!strAry[3].equals("")){
    			excId=strAry[3];
    		} 
    		exc.setDesc("IEEE1968 Type1 excId-" + excId);
    		
    		//TR
    		double Tr=ModelStringUtil.getDouble(strAry[4], 0.0);
    		exc.setTR(BaseDataSetter.createTimeConstSec(Tr));
    		    		
    		//KA for all, KV for EE
    		double Ka=ModelStringUtil.getDouble(strAry[5], 0.0);
    		exc.setKA(Ka);
    		   		
    		//TA for all, TRH for EE
    		double Ta=ModelStringUtil.getDouble(strAry[6], 0.0);
    		exc.setTA(BaseDataSetter.createTimeConstSec(Ta));
    		
    		//VRminMult, VRmax*multi=Vrmin. VRmin for ED EJ
    		double multi=ModelStringUtil.getDouble(strAry[8], 0.0);
    		// KE
    		double Ke=ModelStringUtil.getDouble(strAry[9], 0.0);
    		exc.setKE(Ke);
    		    		
    		//TE
    		double Te= ModelStringUtil.getDouble(strAry[10], 0.0);
    		exc.setTE(BaseDataSetter.createTimeConstSec(Te));
    		
    		//SE0.75MAX for all, KI for DD
    		exc.setE1(0.75);
    		double SE1= ModelStringUtil.getDouble(strAry[11], 0.0);
    		exc.setSE1(SE1);    		
    		
    		//EFDMin
    		double Efdmin=ModelStringUtil.getDouble(strAry[13], 0.0);
    		exc.setEFDMIN(Efdmin);
    		
    		//EFDMax for all, VNmax for ED
    		double Efdmax=ModelStringUtil.getDouble(strAry[14], 0.0);  		
    		// SEmax for all, Kp for DD
    		exc.setE2(Efdmax);
    		double SE2= ModelStringUtil.getDouble(strAry[12], 0.0);
    		exc.setSE2(SE2);    		
    		//KF
    		double Kf= ModelStringUtil.getDouble(strAry[15], 0.0);
    		exc.setKF(Kf);
    		    		
    		//TF    		
    		double Tf= ModelStringUtil.getDouble(strAry[16], 0.0);
    		exc.setTF(BaseDataSetter.createTimeConstSec(Tf));
    		//VRmax=(SE2+Ke)*EFDmax,Vrmin
    		
    		double VRmax=(SE2+Ke)*Efdmax;
    		double VRmin=VRmax*multi;
    		exc.setVRMAX(VRmax);
    		exc.setVRMIN(VRmin);
    	}
    	else if(type==FA){
    		//EXDC2
    		ExcIEEETypeDC2XmlType exc = DStabParserHelper.createExcIEEETypeDC2XmlType(dynGen);
    		
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}	
    		exc.setDesc("IEEE Type DC2 excId-" + excId);
			
			//TR
			double Tr= ModelStringUtil.getDouble(strAry[6], 0.0);
			exc.setTR(BaseDataSetter.createTimeConstSec(Tr));			
			
			// TB
			double Tb= ModelStringUtil.getDouble(strAry[9], 0.0);
			exc.setTB(BaseDataSetter.createTimeConstSec(Tb));
			
			//TC
			double Tc= ModelStringUtil.getDouble(strAry[10], 0.0);
			exc.setTC(BaseDataSetter.createTimeConstSec(Tc));
			
			//KA, KV for FE
			double Ka= ModelStringUtil.getDouble(strAry[11], 0.0);
			exc.setKa(Ka);			
			
			// TA, TRH for FE
			double Ta= ModelStringUtil.getDouble(strAry[12], 0.0);
			exc.setTa(BaseDataSetter.createTimeConstSec(Ta));
			
			//VRmax, Vamax for FH
			double Vrmax= ModelStringUtil.getDouble(strAry[13], 0.0);
			exc.setVrmax(Vrmax);
			
			//VRmin, Vamin			
			double Vrmin= ModelStringUtil.getDouble(strAry[14], 0.0);	
			exc.setVrmin(Vrmin);
			
			//Ke
			double ke=ModelStringUtil.getDouble(strAry[15], 0.0);
			exc.setKE(ke);
			
			//Te
			double Te=ModelStringUtil.getDouble(strAry[16], 0.0);
			exc.setTE(BaseDataSetter.createTimeConstSec(Te));
    	}
    	else if(type==FK){
			// IEEE 1981 ST1
    		ExcIEEE1981ST1XmlType exc = DStabParserHelper.createExcIEEE1981ST1XmlType(dynGen);
    		
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];
			}	
    		exc.setDesc("IEEE1981 ST1 Type excId-" + excId);

			//TR
			double Tr= ModelStringUtil.getDouble(strAry[6], 0.0);
			exc.setTR(BaseDataSetter.createTimeConstSec(Tr));
			
			//VIMax for G K L,VAmax for FF
			double Vimax= ModelStringUtil.getDouble(strAry[7], 0.0);
			exc.setVIMAX(Vimax);
			
			//VIMin for G K L,VAmin for FF
			//VIMax for G K L,VAmax for FF
			double Vimin= ModelStringUtil.getDouble(strAry[8], 0.0);
			exc.setVIMIN(Vimin);

			// TB
			double Tb= ModelStringUtil.getDouble(strAry[9], 0.0);
			exc.setTB(BaseDataSetter.createTimeConstSec(Tb));
			
			//TC
			double Tc= ModelStringUtil.getDouble(strAry[10], 0.0);
			exc.setTC(BaseDataSetter.createTimeConstSec(Tc));
			
			//KA, KV for FE
			double Ka= ModelStringUtil.getDouble(strAry[11], 0.0);
			exc.setKa(Ka);
			
			// TA, TRH for FE
			double Ta= ModelStringUtil.getDouble(strAry[12], 0.0);
			exc.setTa(BaseDataSetter.createTimeConstSec(Ta));
			
			//VRmax, Vamax for FH
			double Vrmax= ModelStringUtil.getDouble(strAry[13], 0.0);
			exc.setVrmax(Vrmax);
			
			//VRmin, Vamin			
			double Vrmin= ModelStringUtil.getDouble(strAry[14], 0.0);	
			exc.setVrmin(Vrmin);
    	}
    	else if(type==FJ){
    		ExcBPAFJXmlType exc = DStabParserHelper.createExcBPAFJXmlType(dynGen);
    			    		
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}	
    		exc.setDesc("BPAJ Type excId-" + excId);
			
			// TB
			double Tb= ModelStringUtil.getDouble(strAry[9], 0.0);
			exc.setTB(BaseDataSetter.createTimeConstSec(Tb));
			
			//TC
			double Tc= ModelStringUtil.getDouble(strAry[10], 0.0);
			exc.setTC(BaseDataSetter.createTimeConstSec(Tc));
			
			//KA, KV for FE
			double Ka= ModelStringUtil.getDouble(strAry[11], 0.0);
			exc.setKa(Ka);			
			
			// TA, TRH for FE
			double Ta= ModelStringUtil.getDouble(strAry[12], 0.0);
			exc.setTa(BaseDataSetter.createTimeConstSec(Ta));
			
			//VRmax, Vamax for FH
			double Vrmax=ModelStringUtil.getDouble(strAry[13], 0.0);
			exc.setVrmax(Vrmax);
			
			//VRmin, Vamin
			double Vrmin= ModelStringUtil.getDouble(strAry[14], 0.0);
			exc.setVrmin(Vrmin);
    	}
    	else if(type==FQ||type==FV){
    		ExcIEEE1981NewExcSystemXmlType exc = DStabParserHelper.createExcIEEE1981NewExcSystemXmlType(dynGen);
    		
    		/*
    		ExciterXmlType exc=XBeanTranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_NEW_EXC_SYSTEM);
    		ExcIEEE1981NewExcSystemXmlType newExc=exc.addNewExciterModel().addNewIEEE1981NewExcSystem();
    		
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);
			//bus Voltage
			double voltage=ModelStringUtil.getDouble(strAry[2], 0.0);
			XBeanDataSetter.setVoltageData(exc.addNewBusRatedVoltage(), 
					voltage, VoltageUnitType.KV);
					*/			
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}			
    		exc.setDesc("IEEE1981 new exc system excId-" + excId);

    		//Rc
			double Rc=ModelStringUtil.getDouble(strAry[4], 0.0);
			exc.setRc(Rc);
						
			//Xc
			double Xc=ModelStringUtil.getDouble(strAry[5], 0.0);
			exc.setXc(Xc);
						
			//TR
			double Tr=ModelStringUtil.getDouble(strAry[6], 0.0);
			exc.setTr(BaseDataSetter.createTimeConstSec(Tr));
						
			//K
			double k=ModelStringUtil.getDouble(strAry[7], 0.0);
			exc.setK(k);
						
			//Kv
			double kv=ModelStringUtil.getDouble(strAry[8], 0.0);
			exc.setKv(kv);
						
			// T1
			double T1=ModelStringUtil.getDouble(strAry[9], 0.0);
			exc.setT1(BaseDataSetter.createTimeConstSec(T1));
			
			//T2
			double T2=ModelStringUtil.getDouble(strAry[10], 0.0);
			exc.setT2(BaseDataSetter.createTimeConstSec(T2));
						
			//T3			
			double T3=ModelStringUtil.getDouble(strAry[11], 0.0);
			exc.setT3(BaseDataSetter.createTimeConstSec(T3));
						
			// T4			
			double T4=ModelStringUtil.getDouble(strAry[12], 0.0);
			exc.setT4(BaseDataSetter.createTimeConstSec(T4));
						
			//KA
			double ka=ModelStringUtil.getDouble(strAry[13], 0.0);
			exc.setKa(ka);
					
			//TA
			double Ta=ModelStringUtil.getDouble(strAry[14], 0.0);
			exc.setTa(BaseDataSetter.createTimeConstSec(Ta));
						
			//KF
			double kf=ModelStringUtil.getDouble(strAry[15], 0.0);
			exc.setKf(kf);
			
			//TF
			double Tf=ModelStringUtil.getDouble(strAry[16], 0.0);
			exc.setTf(BaseDataSetter.createTimeConstSec(Tf));
					
			//KH
			double kh=ModelStringUtil.getDouble(strAry[17], 0.0);
			exc.setKh(kh);
    	}
    	else if(type==FF){
    		ExcIEEE1981TypeAC2XmlType exc = DStabParserHelper.createExcIEEE1981TypeAC2XmlType(dynGen);
    		
    		/*
    		ExciterXmlType exc=XBeanTranStabSimuHelper.addNewExciter(tranSimu);
    		exc.setExciterType(ExciterXmlType.ExciterType.IEEE_1981_TYPE_AC_2);
    		ExcIEEE1981TypeAC2XmlType newExc=exc.addNewExciterModel().addNewIEEE1981TypeAC2();
    		
			//busId
    		String busId=strAry[1];
			exc.addNewLocatedBus().setName(busId);
			//bus Voltage
			double voltage=ModelStringUtil.getDouble(strAry[2], 0.0);
			XBeanDataSetter.setVoltageData(exc.addNewBusRatedVoltage(), 
					voltage, VoltageUnitType.KV);
			*/					
			//excId
			String excId="1";
			if(!strAry[3].equals("")){
				excId=strAry[3];				
			}			
    		exc.setDesc("IEEE1981 AC2 Type excId-" + excId);

			//TR
			double Tr=ModelStringUtil.getDouble(strAry[6], 0.0);
			exc.setTR(BaseDataSetter.createTimeConstSec(Tr));
						
			//Vamax
			double Vamax=ModelStringUtil.getDouble(strAry[7], 0.0);
			exc.setVAMAX(Vamax);
						
			//Vamin
			double Vamin=ModelStringUtil.getDouble(strAry[8], 0.0);
			exc.setVAMIN(Vamin);
						
			// Tb
			double Tb=ModelStringUtil.getDouble(strAry[9], 0.0);
			exc.setTB(BaseDataSetter.createTimeConstSec(Tb));
			
			//Tc
			double Tc=ModelStringUtil.getDouble(strAry[10], 0.0);
			exc.setTC(BaseDataSetter.createTimeConstSec(Tc));
						
			//Ka			
			double Ka=ModelStringUtil.getDouble(strAry[11], 0.0);
			exc.setKa(Ka);
						
			// Ta			
			double Ta=ModelStringUtil.getDouble(strAry[12], 0.0);
			exc.setTa(BaseDataSetter.createTimeConstSec(Ta));
			
			//Vrmax
			double Vrmax=ModelStringUtil.getDouble(strAry[13], 0.0);
			exc.setVrmin(Vrmax);
						
			//Vrmin
			double Vrmin=ModelStringUtil.getDouble(strAry[14], 0.0);
			exc.setVrmin(Vrmin);
									
			//Ke
			double ke=ModelStringUtil.getDouble(strAry[15], 0.0);
			exc.setKE(ke);
			
			//Te
			double Te=ModelStringUtil.getDouble(strAry[16], 0.0);
			exc.setTE(BaseDataSetter.createTimeConstSec(Te));
    	}
    	else if(str.substring(0, 2).trim().equals("FZ")||
    			str.substring(0, 2).trim().equals("F+")){
    		/*
    		String busId=str.substring(3, 11).trim();
        	String excId="1";
        	if(!str.substring(15, 16).trim().equals("")){
        		excId=str.substring(15, 16).trim();
        	}    	
        	ExciterXmlType exc=XBeanParserHelper.getExciterRecord(tranSimu, busId, excId);
        	if(str.substring(0, 2).trim().equals("FZ")){
        		if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_1981_ST_1)){        		
            		//KF
            		double Kf= ModelStringUtil.getDouble(strAry[8], 0.0);
            		exc.getExciterModel().getIEEE1981ST1().setKF(Kf);
            					
        			// TF
            		double TF= ModelStringUtil.getDouble(strAry[9], 0.0);
        			XBeanDataSetter.setTimePeriodData(exc.getExciterModel().getIEEE1981ST1().addNewTF(), 
        					TF, TimePeriodUnitType.SEC);
        			strAry[9]=str.substring(41, 46).trim();
        			//KC
        			double Kc= ModelStringUtil.getDouble(strAry[10], 0.0);
            		exc.getExciterModel().getIEEE1981ST1().setKC(Kc); 
            	}
            	else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.BPAFJ)){        		
            		//EFDmax
            		double EFDmax= ModelStringUtil.getDouble(strAry[7], 0.0);
        			exc.getExciterModel().getBPAFJ().setEFDMAX(EFDmax);
        			
        			//EFDmin
        			double EFDmin= ModelStringUtil.getDouble(strAry[6], 0.0);
        			exc.getExciterModel().getBPAFJ().setEFDMIN(EFDmin);    		
        			//KF
            		double Kf= ModelStringUtil.getDouble(strAry[8], 0.0);
            		exc.getExciterModel().getBPAFJ().setKF(Kf);
            					
        			// TF
            		double TF= ModelStringUtil.getDouble(strAry[9], 0.0);
        			XBeanDataSetter.setTimePeriodData(exc.getExciterModel().getBPAFJ().addNewTF(), 
        					TF, TimePeriodUnitType.SEC);
        			
        			//KC
        			double Kc= ModelStringUtil.getDouble(strAry[10], 0.0);
            		exc.getExciterModel().getBPAFJ().setKC(Kc);
            	}
            	else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_TYPE_DC_2)){
            		           		
            		//Se1            		
            		double SE1=ModelStringUtil.getDouble(strAry[4], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setSE1(SE1);
            		//Se2            		
            		double SE2=ModelStringUtil.getDouble(strAry[5], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setSE1(SE2);
            		// e1
            		double E1=ModelStringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setE1(E1);
            		// e2
            		double E2=0.75*ModelStringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEETypeDC2().setE1(E2);
            		//Kf
        			double Kf= ModelStringUtil.getDouble(strAry[8], 0.0);
            		exc.getExciterModel().getIEEETypeDC2().setKF(Kf);
            		// TF
            		double TF= ModelStringUtil.getDouble(strAry[9], 0.0);
        			XBeanDataSetter.setTimePeriodData(exc.getExciterModel().getIEEETypeDC2().addNewTF1(), 
        					TF, TimePeriodUnitType.SEC);
        			
            	}
            	else if(exc.getExciterType().equals(ExciterXmlType.ExciterType.IEEE_1981_TYPE_AC_2)){
            		           		
            		//Se1            		
            		double SE1=ModelStringUtil.getDouble(strAry[4], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setSE1(SE1);
            		//Se2            		
            		double SE2=ModelStringUtil.getDouble(strAry[5], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setSE1(SE2);
            		// e1
            		double E1=ModelStringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setE1(E1);
            		// e2
            		double E2=0.75*ModelStringUtil.getDouble(strAry[7], 0.0);  
            		exc.getExciterModel().getIEEE1981TypeAC2().setE1(E2);
            		//Kf
        			double Kf= ModelStringUtil.getDouble(strAry[8], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setKF(Kf);
            		// TF
            		double TF= ModelStringUtil.getDouble(strAry[9], 0.0);
        			XBeanDataSetter.setTimePeriodData(exc.getExciterModel().getIEEE1981TypeAC2().addNewTF(), 
        					TF, TimePeriodUnitType.SEC);
        			//Kc
        			double Kc= ModelStringUtil.getDouble(strAry[10], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setKC(Kc);
            		//Kd
        			double Kd= ModelStringUtil.getDouble(strAry[11], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setKD(Kd);
            		//Kb
        			double Kb= ModelStringUtil.getDouble(strAry[12], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setKB(Kb);
            		//Kl
        			double Kl= ModelStringUtil.getDouble(strAry[13], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setKL(Kl);
            		//Kh
        			double Kh= ModelStringUtil.getDouble(strAry[14], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setKH(Kh);
            		//vlr
        			double vlr= ModelStringUtil.getDouble(strAry[15], 0.0);
            		exc.getExciterModel().getIEEE1981TypeAC2().setVLR(vlr);
            	}
        		*/
        	}
    	else if(str.substring(0, 2).trim().equals("F+")){
    		ExcIEEE1981NewExcSystemXmlType exc = DStabParserHelper.createExcIEEE1981NewExcSystemXmlType(dynGen);
    		//VAMAX 
    		double Vamax= ModelStringUtil.getDouble(strAry[4], 0.0);
    		exc.setVAmax(Vamax);    		
			
			//VAMIN 
    		double Vamin= ModelStringUtil.getDouble(strAry[5], 0.0);
    		exc.setVAmin(Vamin);
    		
			strAry[5]=str.substring(21, 26).trim();
			//KB
			double Kb=ModelStringUtil.getDouble(strAry[6], 0.0);
			exc.setKb(Kb);
    		    			
			//T5
    		double T5=ModelStringUtil.getDouble(strAry[7], 0.0);
			exc.setT5(BaseDataSetter.createTimeConstSec(T5));
    					
			//KE
    		double Ke=ModelStringUtil.getDouble(strAry[8], 0.0);
    		exc.setKe(Ke);
    			
			// TE
    		double Te=ModelStringUtil.getDouble(strAry[9], 0.0);
			exc.setTe(BaseDataSetter.createTimeConstSec(Te));
    				
			//SE1-0.75
    		double SE1=ModelStringUtil.getDouble(strAry[10], 0.0);
    		exc.setE1(0.75);
    		exc.setSE1(SE1);
    				
			// VRMAX
			double Vrmax= ModelStringUtil.getDouble(strAry[12], 0.0);
			exc.setVrmax(Vrmax); 			
			
			//VRMIN
			double Vrmin= ModelStringUtil.getDouble(strAry[13], 0.0);
			exc.setVrmin(Vrmin);			
			
			//KC
    		double KC=ModelStringUtil.getDouble(strAry[14], 0.0);
    		exc.setKc(KC);
    		    					
			//KD
    		double Kd=ModelStringUtil.getDouble(strAry[15], 0.0);
    		exc.setKd(Kd);
    					
			//KL1
    		double KL1=ModelStringUtil.getDouble(strAry[16], 0.0);
    		exc.setKL1(KL1);
    				
			//VLIR
    		double VLIR=ModelStringUtil.getDouble(strAry[17], 0.0);
    		exc.setVL1R(VLIR);
    					
			//EFDMAX
    		double EFDMAX=ModelStringUtil.getDouble(strAry[18], 0.0);
    		exc.setEFDmax(EFDMAX);

    		//SE2--EFDMAX
    		double SE2=0.0;
    		if(!strAry[11].equals("")){
    			SE2=new Double(strAry[11]).doubleValue();
    			exc.setE2(EFDMAX);
    			exc.setSE2(SE2);
    		}
    	}	
	}
	
	private static int getExcType(String str) {
		int type = 0;
    	if(str.equals("EA")){
    		type=EA;
    	}else if(str.equals("EC")){
    		type=EC;
    	}else if(str.equals("EK")){
    		type=EK;
    	}else if(str.equals("FJ")){
    		type=FJ;
    	}else if(str.equals("FK")){
    		type=FK;
    	}else if(str.equals("FQ")){
    		type=FQ;
    	}else if(str.equals("FV")){
    		type=FV;
    	}else if(str.equals("FF")){
    		type=FF;
    	}else if(str.equals("FA")){
    		type=FA;
    	}		
    	return type;
	}
	
	private static String[] getExciterDataFields ( final String str ) {
    	final String[] strAry = new String[19];	
    	try{
    		if(str.substring(0,1).trim().equals("E")){
				strAry[0]=ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
				//busId
				strAry[1]=ModelStringUtil.getStringReturnEmptyString(str,4, 11).trim();
				//bus Voltage
				strAry[2]=ModelStringUtil.getStringReturnEmptyString(str,12, 15).trim();
				//excId
				strAry[3]=ModelStringUtil.getStringReturnEmptyString(str,16, 16).trim();
				//TR
				strAry[4]=ModelStringUtil.getStringReturnEmptyString(str,17, 20).trim();
				//KA for all, KV for EE
				strAry[5]=ModelStringUtil.getStringReturnEmptyString(str,21, 25).trim();
				//TA for all, TRH for EE
				strAry[6]=ModelStringUtil.getStringReturnEmptyString(str,26, 29).trim();
				//TA1
				strAry[7]=ModelStringUtil.getStringReturnEmptyString(str,30, 33).trim();
				//VRminMult, VRmax, VRmin for ED EJ
				strAry[8]=ModelStringUtil.getStringReturnEmptyString(str,34, 37).trim();
				// KE
				strAry[9]=ModelStringUtil.getStringReturnEmptyString(str,38, 41).trim();
				//TE
				strAry[10]=ModelStringUtil.getStringReturnEmptyString(str,42, 45).trim();
				//SE0.75MAX for all, KI for DD
				strAry[11]=ModelStringUtil.getStringReturnEmptyString(str,46, 49).trim();
				// SEmax for all, Kp for DD
				strAry[12]=ModelStringUtil.getStringReturnEmptyString(str,50, 53).trim();
				//EFDMin
				strAry[13]=ModelStringUtil.getStringReturnEmptyString(str,54, 58).trim();
				//EFDMax for all, VNmax for ED
				strAry[14]=ModelStringUtil.getStringReturnEmptyString(str,59, 62).trim();
				//KF
				strAry[15]=ModelStringUtil.getStringReturnEmptyString(str,63, 66).trim();
				//TF
				strAry[16]=ModelStringUtil.getStringReturnEmptyString(str,67, 70).trim();
				// XL for ED
				strAry[17]=ModelStringUtil.getStringReturnEmptyString(str,71, 75).trim();
				//TF1 for ED
				strAry[18]=ModelStringUtil.getStringReturnEmptyString(str,76, 80).trim();
				
			}else if(str.substring(0, 2).trim().equals("FA")||
					str.substring(0, 2).trim().equals("FB")||str.substring(0, 2).trim().equals("FC")
					||str.substring(0, 2).trim().equals("FD")||str.substring(0, 2).trim().equals("FE")||
					str.substring(0, 2).trim().equals("FF")||str.substring(0, 2).trim().equals("FG")
					||str.substring(0, 2).trim().equals("FH")||str.substring(0, 2).trim().equals("FJ")
					||str.substring(0, 2).trim().equals("FK")||str.substring(0, 2).trim().equals("FL")
					){
				
				strAry[0]=ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
				//busId
				strAry[1]=ModelStringUtil.getStringReturnEmptyString(str,4, 11).trim();
				//bus Voltage
				strAry[2]=ModelStringUtil.getStringReturnEmptyString(str,12, 15).trim();
				//excId
				strAry[3]=ModelStringUtil.getStringReturnEmptyString(str,16, 16).trim();
				//Rc
				strAry[4]=ModelStringUtil.getStringReturnEmptyString(str,17, 21).trim();
				//Xc
				strAry[5]=ModelStringUtil.getStringReturnEmptyString(str,22, 26).trim();
				//TR
				strAry[6]=ModelStringUtil.getStringReturnEmptyString(str,27, 31).trim();
				//VIMax for G K L,VAmax for FF
				strAry[7]=ModelStringUtil.getStringReturnEmptyString(str,32, 36).trim();
				//VIMin for G K L,VAmin for FF
				strAry[8]=ModelStringUtil.getStringReturnEmptyString(str,37, 41).trim();
				// TB
				strAry[9]=ModelStringUtil.getStringReturnEmptyString(str,42, 46).trim();
				//TC
				strAry[10]=ModelStringUtil.getStringReturnEmptyString(str,47, 51).trim();
				//KA, KV for FE
				strAry[11]=ModelStringUtil.getStringReturnEmptyString(str,52, 56).trim();
				// TA, TRH for FE
				strAry[12]=ModelStringUtil.getStringReturnEmptyString(str,57, 61).trim();
				//VRmax, Vamax for FH
				strAry[13]=ModelStringUtil.getStringReturnEmptyString(str,62, 66).trim();					
				//VRmin, Vamin
				strAry[14]=ModelStringUtil.getStringReturnEmptyString(str,67, 71).trim();
				//KE, KJ for FL
				strAry[15]=ModelStringUtil.getStringReturnEmptyString(str,72, 76).trim();
				//TE
				strAry[16]=ModelStringUtil.getStringReturnEmptyString(str,77, 80).trim();
			}else if(str.substring(0, 2).trim().equals("FQ")||str.substring(0, 2).trim().equals("FV")){
				
				strAry[0]=ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
				//busId
				strAry[1]=ModelStringUtil.getStringReturnEmptyString(str,4, 11).trim();
				//bus Voltage
				strAry[2]=ModelStringUtil.getStringReturnEmptyString(str,12, 15).trim();
				//excId
				strAry[3]=ModelStringUtil.getStringReturnEmptyString(str,16, 16).trim();
				//Rc
				strAry[4]=ModelStringUtil.getStringReturnEmptyString(str,17, 20).trim();
				//Xc
				strAry[5]=ModelStringUtil.getStringReturnEmptyString(str,21, 24).trim();
				//TR
				strAry[6]=ModelStringUtil.getStringReturnEmptyString(str,25, 29).trim();
				//K
				strAry[7]=ModelStringUtil.getStringReturnEmptyString(str,30, 34).trim();
				//Kv
				strAry[8]=ModelStringUtil.getStringReturnEmptyString(str,35, 37).trim();
				// T1
				strAry[9]=ModelStringUtil.getStringReturnEmptyString(str,38, 42).trim();
				//T2
				strAry[10]=ModelStringUtil.getStringReturnEmptyString(str,43, 47).trim();
				//K3
				strAry[11]=ModelStringUtil.getStringReturnEmptyString(str,48, 52).trim();
				// T4
				strAry[12]=ModelStringUtil.getStringReturnEmptyString(str,53, 57).trim();
				//KA
				strAry[13]=ModelStringUtil.getStringReturnEmptyString(str,58, 62).trim();
				//TA
				strAry[14]=ModelStringUtil.getStringReturnEmptyString(str,63, 67).trim();
				//KF
				strAry[15]=ModelStringUtil.getStringReturnEmptyString(str,68, 72).trim();
				//TF
				strAry[16]=ModelStringUtil.getStringReturnEmptyString(str,73, 76).trim();
				//KH
				strAry[17]=ModelStringUtil.getStringReturnEmptyString(str,77, 80).trim();
			}
			else if(str.substring(0,2).trim().equals("FZ")){
				strAry[0]=ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
				//busId
				strAry[1]=ModelStringUtil.getStringReturnEmptyString(str,4, 11).trim();
				//bus Voltage
				strAry[2]=ModelStringUtil.getStringReturnEmptyString(str,12, 15).trim();
				//excId
				strAry[3]=ModelStringUtil.getStringReturnEmptyString(str,16, 16).trim();
				//SE1, 
				strAry[4]=ModelStringUtil.getStringReturnEmptyString(str,17, 21).trim();
				//SE2, 
				strAry[5]=ModelStringUtil.getStringReturnEmptyString(str,22, 26).trim();
				//EFDmin
				strAry[6]=ModelStringUtil.getStringReturnEmptyString(str,27, 31).trim();
				//
				strAry[7]=ModelStringUtil.getStringReturnEmptyString(str,32, 36).trim();
				//KF
				strAry[8]=ModelStringUtil.getStringReturnEmptyString(str,37, 41).trim();
				// TF
				strAry[9]=ModelStringUtil.getStringReturnEmptyString(str,42, 46).trim();
				//KC
				strAry[10]=ModelStringUtil.getStringReturnEmptyString(str,47, 51).trim();
				//KD
				strAry[11]=ModelStringUtil.getStringReturnEmptyString(str,52, 56).trim();
				// 
				strAry[12]=ModelStringUtil.getStringReturnEmptyString(str,57, 61).trim();
				//
				strAry[13]=ModelStringUtil.getStringReturnEmptyString(str,62, 66).trim();
				//
				strAry[14]=ModelStringUtil.getStringReturnEmptyString(str,67, 71).trim();
				//
				strAry[15]=ModelStringUtil.getStringReturnEmptyString(str,72, 76).trim();			
				
			}else if(str.substring(0,2).trim().equals("F+")){
				strAry[0]=ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
				//busId
				strAry[1]=ModelStringUtil.getStringReturnEmptyString(str,4, 11).trim();
				//bus Voltage
				strAry[2]=ModelStringUtil.getStringReturnEmptyString(str,12, 15).trim();
				//excId
				strAry[3]=ModelStringUtil.getStringReturnEmptyString(str,16, 16).trim();
				//VAMAX 
				strAry[4]=ModelStringUtil.getStringReturnEmptyString(str,17, 21).trim();
				//VAMIN 
				strAry[5]=ModelStringUtil.getStringReturnEmptyString(str,22, 26).trim();
				//KB
				strAry[6]=ModelStringUtil.getStringReturnEmptyString(str,27, 30).trim();
				//T5
				strAry[7]=ModelStringUtil.getStringReturnEmptyString(str,31, 34).trim();
				//KE
				strAry[8]=ModelStringUtil.getStringReturnEmptyString(str,35, 38).trim();
				// TE
				strAry[9]=ModelStringUtil.getStringReturnEmptyString(str,40, 42).trim();
				//SE1-0.75
				strAry[10]=ModelStringUtil.getStringReturnEmptyString(str,43, 47).trim();
				//SE2--EFDMAX
				strAry[11]=ModelStringUtil.getStringReturnEmptyString(str,48, 52).trim();
				// VRMAX
				strAry[12]=ModelStringUtil.getStringReturnEmptyString(str,53, 56).trim();
				//VRMIN
				strAry[13]=ModelStringUtil.getStringReturnEmptyString(str,57, 60).trim();
				//KC
				strAry[14]=ModelStringUtil.getStringReturnEmptyString(str,61, 64).trim();
				//KD
				strAry[15]=ModelStringUtil.getStringReturnEmptyString(str,65, 68).trim();	
				//KL1
				strAry[16]=ModelStringUtil.getStringReturnEmptyString(str,69, 72).trim();
				//VLIR
				strAry[17]=ModelStringUtil.getStringReturnEmptyString(str,73, 76).trim();
				//EFDMAX
				strAry[18]=ModelStringUtil.getStringReturnEmptyString(str,77, 80).trim();
				
			}
    	}catch (Exception e){
    		ODMLogger.getLogger().severe(e.toString());
    	}
        return strAry;
	}
}
