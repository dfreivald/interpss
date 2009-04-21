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

package org.ieee.pes.odm.pss.adapter.bpa;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GovHydroSteamGeneralModelXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GovHydroTurbineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GovHydroXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.SteamTurbineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineGovernorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TurbineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageXmlType;
import org.ieee.pes.odm.pss.model.IEEEODMPSSModelParser;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;
import org.ieee.pes.odm.pss.model.TranStabSimuHelper;


public class BPADynamicTurbineGovernorRecord {
	
	public static void processTurbineGovernorData(String str,TransientSimulationXmlType tranSimu,
    		IEEEODMPSSModelParser parser,BPAAdapter adapter){
    	
    	
    	final String strAry[]=getTGDataFields(str,adapter);
    	
    	if(strAry[0].equals("GG")){ 
    		TurbineGovernorXmlType tg=TranStabSimuHelper.addNewTurbineGovernor(tranSimu);
    		tg.setTurbineGovernorType(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_STREAM_GENERAL_MODEL);
    		GovHydroSteamGeneralModelXmlType gg=
    			tg.addNewTurbineGovernorModel().addNewHydroStreamGeneralModel();
    		//busId
    		String busId=strAry[1];
    		tg.addNewLocatedBus().setName(busId);			
			//bus Voltage
    		double v= new Double(strAry[2]).doubleValue();    		
    		ODMData2XmlHelper.setVoltageData(tg.addNewBusRatedVoltage(), v,
    				VoltageXmlType.Unit.KV);			
			//excId
    		String tgId;
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];
    			tg.addNewTgId().setName(tgId);
    		}			
			//PMAX 
    		double pmax=StringUtil.getDouble(strAry[4], 0.0);
    		gg.setPMAX(pmax);
			//R
    		double r=StringUtil.getDouble(strAry[5], 0.0);
    		gg.setR(r);
			
			//T1
    		double T1=StringUtil.getDouble(strAry[6], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(gg.addNewT1(), 
    					T1, TimePeriodXmlType.Unit.SEC);
			//T2
    	    double T2=StringUtil.getDouble(strAry[7], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gg.addNewT2(), 
					       T2, TimePeriodXmlType.Unit.SEC);		   
			//T3
		    double T3=StringUtil.getDouble(strAry[8], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gg.addNewT3(), 
					       T3, TimePeriodXmlType.Unit.SEC);			
			// T4
		    double T4=StringUtil.getDouble(strAry[9], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gg.addNewT4(), 
					       T4, TimePeriodXmlType.Unit.SEC);			
			//T5
		    double T5=StringUtil.getDouble(strAry[10], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gg.addNewT5(), 
					       T5, TimePeriodXmlType.Unit.SEC);
			
			//F
		    double f=StringUtil.getDouble(strAry[11], 0.0);
    		gg.setF(f);
			
    	}else if(strAry[0].equals("GH")){
    		TurbineGovernorXmlType tg=TranStabSimuHelper.addNewTurbineGovernor(tranSimu);
    		tg.setTurbineGovernorType(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER_AND_TURBINE);
    		GovHydroTurbineXmlType gh=
    			tg.addNewTurbineGovernorModel().addNewHydroGovernerAndTurbine();
    		//busId
    		String busId=strAry[1];
    		tg.addNewLocatedBus().setName(busId);			
			//bus Voltage
    		double v= StringUtil.getDouble(strAry[2], 0.0);
    		ODMData2XmlHelper.setVoltageData(tg.addNewBusRatedVoltage(), v,
    				VoltageXmlType.Unit.KV);			
			//excId
    		String tgId;
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];
    			tg.addNewTgId().setName(tgId);
    		}			
			//PMAX 
    		double pmax=StringUtil.getDouble(strAry[4], 0.0);
    		gh.setPMAX(pmax);
    		//R
    		double r=StringUtil.getDouble(strAry[5], 0.0);
    		gh.setR(r);
			//TG
    		double Tg=StringUtil.getDouble(strAry[6], 0.0);    		
    		
		    ODMData2XmlHelper.setTimePeriodData(gh.addNewTG(), 
					       Tg, TimePeriodXmlType.Unit.SEC);			
			//TP
		    double Tp=StringUtil.getDouble(strAry[7], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gh.addNewTP(), 
					       Tp, TimePeriodXmlType.Unit.SEC);		
			//TD
		    double Td= StringUtil.getDouble(strAry[8], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gh.addNewTD(), 
				       Td, TimePeriodXmlType.Unit.SEC);			
			// TW/2
		    double Tw= StringUtil.getDouble(strAry[9], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gh.addNewTWhalf(), 
				       Tw, TimePeriodXmlType.Unit.SEC);			
			//VELCLOSE
		    double Uc=StringUtil.getDouble(strAry[10], 0.0);
    		gh.setUc(Uc);
			
			//FVELOPEN
    		double Uo=StringUtil.getDouble(strAry[11], 0.0);
    		gh.setUo(Uo);
			
			//Dd
    		double Dd=StringUtil.getDouble(strAry[12], 0.0);
    		gh.setD4(Dd);		
    	}else if(strAry[0].equals("GS")){
    		TurbineGovernorXmlType tg=TranStabSimuHelper.addNewTurbineGovernor(tranSimu);
    		tg.setTurbineGovernorType(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER);
    		GovHydroXmlType gs=
    			tg.addNewTurbineGovernorModel().addNewHydroGoverner();
    		//busId
    		String busId=strAry[1];
    		tg.addNewLocatedBus().setName(busId);
    		//bus Voltage
    		double v= StringUtil.getDouble(strAry[2], 0.0);    		
    		ODMData2XmlHelper.setVoltageData(tg.addNewBusRatedVoltage(), v,
    				VoltageXmlType.Unit.KV);			
			//excId
    		String tgId;
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];
    			tg.addNewTgId().setName(tgId);
    		}			
			//PMAX 
    		double pmax=new Double(strAry[4]).doubleValue();
    		gs.setPMAX(pmax);
    		//PMIN
    		double pmin=StringUtil.getDouble(strAry[5], 0.0);
    		gs.setPMIN(pmin);	
    			
    		//R
    		double r=StringUtil.getDouble(strAry[6], 0.0);
    		gs.setR(r);
			//T1
    		double T1=StringUtil.getDouble(strAry[7], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(gs.addNewT1(), 
    				       T1, TimePeriodXmlType.Unit.SEC);
    		
    					
			//T2
    		double T2=StringUtil.getDouble(strAry[8], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(gs.addNewT2(), 
    				       T2, TimePeriodXmlType.Unit.SEC);
    				    		
			// T3
		    double T3= StringUtil.getDouble(strAry[9], 0.0);
		    ODMData2XmlHelper.setTimePeriodData(gs.addNewT3(), 
				       T3, TimePeriodXmlType.Unit.SEC);			
			//VELOPEN
		    double Uo=StringUtil.getDouble(strAry[4], 0.0);
    		gs.setU0(Uo);			
			//FVELCLOSE
    		double Uc=StringUtil.getDouble(strAry[11], 0.0);
    		gs.setUC(Uc);
    	}else if(strAry[0].equals("TA")){
    		//busId
    		String busId=strAry[1];    		
    		String tgId="";
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];    			
    		}
    		TurbineGovernorXmlType tgOld=ODMData2XmlHelper.getTGRecord(tranSimu, busId, tgId);
    		if(tgOld.getTurbineGovernorType().equals
    				(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER)){
    			TurbineXmlType tur=tgOld.getTurbineGovernorModel().getHydroGoverner().addNewTurbine();
    			SteamTurbineXmlType steamTur=tur.addNewSteamTurbine();
    			//TCH
    			double TCH= new Double(strAry[4]).doubleValue();
    		    ODMData2XmlHelper.setTimePeriodData(steamTur.addNewTCH(),
    		    		TCH, TimePeriodXmlType.Unit.SEC);	    			
    			//k1
    		    double k1=new Double(strAry[5]).doubleValue();
    		    steamTur.setK(k1);
    		}
    		
    	}else if(strAry[0].equals("TB")){
    		//busId
    		String busId=strAry[1];    		
    		String tgId="";
    		if(!strAry[3].equals("")){
    			tgId=strAry[3];    			
    		}
    		TurbineGovernorXmlType tgOld=ODMData2XmlHelper.getTGRecord(tranSimu, busId, tgId);
    		if(tgOld.getTurbineGovernorType().equals
    				(TurbineGovernorXmlType.TurbineGovernorType.HYDRO_GOVERNER)){
    			TurbineXmlType tur=tgOld.getTurbineGovernorModel().getHydroGoverner().addNewTurbine();
    			
    			SteamTurbineXmlType steamTur=tur.addNewSteamTurbine();
    			
    			//TCH
    			double TCH= StringUtil.getDouble(strAry[4], 0.0);
    		    ODMData2XmlHelper.setTimePeriodData(steamTur.addNewTCH(),
    		    		TCH, TimePeriodXmlType.Unit.SEC);	  
    			//FHP
    		    double FHP= StringUtil.getDouble(strAry[5], 0.0);
    			steamTur.setFHP(FHP);
    			//TRH
    		    double TRH= StringUtil.getDouble(strAry[6], 0.0);
    		    ODMData2XmlHelper.setTimePeriodData(steamTur.addNewTRH(),
    		    		TRH, TimePeriodXmlType.Unit.SEC);	    			
    			//FIP
    		    double FIP= StringUtil.getDouble(strAry[7], 0.0);
    		    steamTur.setFIP(FIP);    			
    			//TCO
    		    double TCO=StringUtil.getDouble(strAry[8], 0.0);
    		    ODMData2XmlHelper.setTimePeriodData(steamTur.addNewTCO(),
        		    		TCO, TimePeriodXmlType.Unit.SEC);
    		       		    	    			
    			// FLP
    		    double FLP=StringUtil.getDouble(strAry[9], 0.0);
       		    steamTur.setFLP(FLP);
    		        		        			
    		}    
    	}
    	
    }
	
	 private static String[] getTGDataFields ( final String str,BPAAdapter adapter) {
		   	
	    	final String[] strAry = new String[19];
	    	
	    	try{
	    		if(str.substring(0, 2).trim().equals("GG")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//PMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
					//R
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 27).trim();
					//T1
					strAry[6]=StringUtil.getStringReturnEmptyString(str,28, 32).trim();
					//T2
					strAry[7]=StringUtil.getStringReturnEmptyString(str,33, 37).trim();
					//T3
					strAry[8]=StringUtil.getStringReturnEmptyString(str,38, 42).trim();
					// T4
					strAry[9]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
					//T5
					strAry[10]=StringUtil.getStringReturnEmptyString(str,48, 52).trim();
					//F
					strAry[11]=StringUtil.getStringReturnEmptyString(str,53, 57).trim();
					
		    		
		    	}else if(str.substring(0, 2).trim().equals("GH")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//PMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
					//R
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 27).trim();
					//TG
					strAry[6]=StringUtil.getStringReturnEmptyString(str,28, 32).trim();					
					//TP
					strAry[7]=StringUtil.getStringReturnEmptyString(str,33, 37).trim();
					//TD
					strAry[8]=StringUtil.getStringReturnEmptyString(str,38, 42).trim();
					// TW/2
					strAry[9]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
					//VELCLOSE
					strAry[10]=StringUtil.getStringReturnEmptyString(str,48, 52).trim();
					//FVELOPEN
					strAry[11]=StringUtil.getStringReturnEmptyString(str,53, 57).trim();
					//Dd
					strAry[12]=StringUtil.getStringReturnEmptyString(str,58, 62).trim();
					
		    		
		    	}
		    	else if(str.substring(0, 2).trim().equals("GS")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//PMAX 
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
					//PMIN
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 28).trim();
					//R
					strAry[6]=StringUtil.getStringReturnEmptyString(str,29, 33).trim();
					//T1
					strAry[7]=StringUtil.getStringReturnEmptyString(str,34, 38).trim();
					//T2
					strAry[8]=StringUtil.getStringReturnEmptyString(str,39, 43).trim();
					// T3
					strAry[9]=StringUtil.getStringReturnEmptyString(str,44, 48).trim();
					//VELOPEN
					strAry[10]=StringUtil.getStringReturnEmptyString(str,49, 54).trim();
					//FVELCLOSE
					strAry[11]=StringUtil.getStringReturnEmptyString(str,55, 60).trim();			
		    		
		    	}else if(str.substring(0, 2).trim().equals("TA")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
					//TCH
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//k1
					strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 26).trim();
		    	}else if(str.substring(0, 2).trim().equals("TB")){
		    		strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
					//busId
					strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
					//bus Voltage
					strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
					//excId
					strAry[3]=StringUtil.getStringReturnEmptyString(str,14, 16).trim();
					//tch
					strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
					//FHP
					strAry[5]=StringUtil.getStringReturnEmptyString(str,22, 26).trim();
					//TRH
					strAry[6]=StringUtil.getStringReturnEmptyString(str,32, 36).trim();
					//FIP
					strAry[7]=StringUtil.getStringReturnEmptyString(str,37, 41).trim();
					//TCO
					strAry[8]=StringUtil.getStringReturnEmptyString(str,47, 51).trim();
					// FLP
					strAry[9]=StringUtil.getStringReturnEmptyString(str,52, 56).trim();
					
		    	}
	    	}catch(Exception e){
	    		adapter.logErr(e.toString());
	    	}
	    	return strAry;
		
	    }

}
