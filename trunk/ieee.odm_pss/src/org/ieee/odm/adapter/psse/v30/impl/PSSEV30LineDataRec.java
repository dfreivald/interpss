package org.ieee.odm.adapter.psse.v30.impl;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.odm.schema.ApparentPowerUnitType;
import org.ieee.odm.schema.BaseBranchDataXmlType;
import org.ieee.odm.schema.BranchRecordXmlType;
import org.ieee.odm.schema.LFBranchCodeEnumType;
import org.ieee.odm.schema.LoadflowBranchDataXmlType;
import org.ieee.odm.schema.YUnitType;
import org.ieee.odm.schema.ZUnitType;
import org.ieee.odm.adapter.psse.PsseVersion;
import org.ieee.odm.adapter.psse.xbean.v30.XBeanPSSEV30Adapter;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.JaxbDataSetter;
import org.ieee.odm.model.JaxbParserHelper;
import org.ieee.odm.model.JaxbODMModelParser;

public class PSSEV30LineDataRec {
	private static int i, j, status;
	private static String ckt;
	private static double r, x, b, ratea, rateb, ratec, gi, bi, gj, bj, len; 
	private static int o1 = 0, o2 = 0, o3 = 0, o4 = 0;
	private static double f1 = 0.0, f2 = 0.0, f3 = 0.0, f4 = 0.0;	

	/*
	 * BranchData
	 * I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
	 */
	public static void procLineString(String lineStr, PsseVersion version, JaxbODMModelParser parser, Logger logger) {
		procLineFields(lineStr, version, logger);

/*
		I,J,CKT,R,X,B,RATEA,RATEB,RATEC,GI,BI,GJ,BJ,ST,LEN,O1,F1,...,O4,F4
		
		ST Initial branch status where 1 designates in-service and 0 designates out-of-service. ST = 1 by default.
*/
		boolean fromMetered = true;
		if (j < 0) {
			fromMetered = false;
			j = -j;
		}
      	
		final String fid = XBeanODMModelParser.BusIdPreFix+i;
		final String tid = XBeanODMModelParser.BusIdPreFix+j;
		String branchId = ModelStringUtil.formBranchId(fid, tid, ckt);

		BranchRecordXmlType branchRec;
		try {
			branchRec = parser.addNewBaseCaseBranch(branchId);
		} catch (Exception e) {
			logger.severe(e.toString());
			return;
		}		
		branchRec.addNewFromBus().setIdRef(fid);
		branchRec.addNewToBus().setIdRef(tid);	
		branchRec.setCircuitId(ckt);
		
		branchRec.setOffLine(status != 1);
		
		LoadflowBranchDataXmlType branchData = branchRec.addNewLoadflowData();	
		branchData.setCode(LFBranchCodeEnumType.LINE);
		
		branchData.setMeterLocation( fromMetered ? BaseBranchDataXmlType.MeterLocation.FROM_SIDE :
										BaseBranchDataXmlType.MeterLocation.TO_SIDE);
      	
		XBeanDataSetter.setLineData(branchData, r, x, ZUnitType.PU, 0.0, b, YUnitType.PU);

		XBeanDataSetter.setBranchRatingLimitData(branchData.addNewBranchRatingLimit(),
    				ratea, rateb, ratec, ApparentPowerUnitType.MVA);
        
       if ( gi != 0.0 || bi != 0.0)
    	   XBeanDataSetter.setYData(branchData.addNewFromShuntY(), gi, bi, YUnitType.PU);
       if ( gj != 0.0 || bj != 0.0)
    	   XBeanDataSetter.setYData(branchData.addNewFromShuntY(), gj, bj, YUnitType.PU);
      
    	XBeanParserHelper.addOwner(branchRec, 
    			new Integer(o1).toString(), f1, 
    			new Integer(o2).toString(), o2==0?0.0:f2, 
    			new Integer(o3).toString(), o3==0?0.0:f3, 
    			new Integer(o4).toString(), o4==0?0.0:f4);
	}
	
	private static void procLineFields(String lineStr, PsseVersion version, Logger logger) {
		StringTokenizer st;
		st = new StringTokenizer(lineStr, ",");
		i = new Integer(st.nextToken().trim()).intValue();
		j = new Integer(st.nextToken().trim()).intValue();
		ckt = XBeanPSSEV30Adapter.trimQuote(st.nextToken()).trim();
		r = new Double(st.nextToken().trim()).doubleValue();
		x = new Double(st.nextToken().trim()).doubleValue();
		b = new Double(st.nextToken().trim()).doubleValue();
		ratea = new Double(st.nextToken().trim()).doubleValue();
		rateb = new Double(st.nextToken().trim()).doubleValue();
		ratec = new Double(st.nextToken().trim()).doubleValue();
		gi = new Double(st.nextToken().trim()).doubleValue();
		bi = new Double(st.nextToken().trim()).doubleValue();
		gj = new Double(st.nextToken().trim()).doubleValue();
		bj = new Double(st.nextToken().trim()).doubleValue();
		status = new Integer(st.nextToken().trim()).intValue();
		len = new Double(st.nextToken().trim()).doubleValue();

		if (st.hasMoreTokens())
			o1 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f1 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o2 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f2 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o3 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f3 = new Double(st.nextToken().trim()).doubleValue();
		if (st.hasMoreTokens())
			o4 = new Integer(st.nextToken().trim()).intValue();
		if (st.hasMoreTokens())
			f4 = new Double(st.nextToken().trim()).doubleValue();
	}	
}
