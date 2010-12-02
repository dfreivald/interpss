/*
 * @(#)PSSEBusRecord.java   
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */
package org.ieee.odm.adapter.dep.xbean.psse;

import java.util.StringTokenizer;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LoadflowBusDataXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ReactivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ShuntCompensatorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.odm.adapter.psse.PsseVersion;
import org.ieee.odm.model.ModelStringUtil;
import org.ieee.odm.model.xbean.XBeanDataSetter;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

public class XBeanPSSEBusRecord {
	public static  void processSwitchedShuntData(final String str, PsseVersion version, final XBeanODMModelParser parser, Logger logger) {
		/*
		Format V26
		I,    MODSW,VSWHI, VSWLO,  SWREM,   BINIT,    N1,      B1,   N2,        B2...N8,B8
		34606,0,    1.1000,0.9000,     0,-190.800,     1, -47.700,     1, -47.700,     1, -47.700,     1, -47.700,
		
		Format V30
		I, MODSW, VSWHI, VSWLO, SWREM, RMPCT, �RMIDNT�, BINIT, N1, B1, N2, B2, ... N8, B8
		8441,1,1.03869,0.99869,    0,100.0,'        ',  334.80, 3,  50.40, 1,  37.80, 2,  36.00, 1,  37.80, 1,  36.00
    
			I - Bus number
			MODSW - Mode 0 - fixed 1 - discrete 2 - continuous
			VSWHI - Desired voltage upper limit, per unit
			VSWLO - Desired voltage lower limit, per unit
			SWREM - Number of remote bus to control. 0 to control own bus.
			RMPCT Percent of the total Mvar required to hold the voltage at the bus controlled by bus
					I that are to be contributed by this switched shunt; RMPCT must be positive.
					RMPCT is needed only if SWREM specifies a valid remote bus and there is more
					than one local or remote voltage controlling device (plant, switched shunt, FACTS
					device shunt element, or VSC dc line converter) controlling the voltage at bus
					SWREM to a setpoint, or SWREM is zero but bus I is the controlled bus, local or
					remote, of one or more other setpoint mode voltage controlling devices. Only used
					if MODSW = 1 or 2. RMPCT = 100.0 by default.
			RMIDNT When MODSW is 4, the name of the VSC dc line whose converter bus is specified
					in SWREM. RMIDNT is not used for other values of MODSW. RMIDNT is a
					blank name by default.
			BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
			N1 - Number of steps for block 1, first 0 is end of blocks
			B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts.
			N2, B2, etc, as N1, B1
		 */		
		// parse the input data line
	    final String[] strAry = getSwitchedShuntDataFields(str, version);
		final String busId = XBeanODMModelParser.BusIdPreFix+strAry[0];
		// get the responding-bus data with busId
		BusRecordXmlType busRec = parser.getBusRecord(busId);
		if (busRec==null){
			logger.severe("Error: Bus not found in the network, bus number: " + busId);
        	return;
        }
				
	    LoadflowBusDataXmlType lfData = busRec.getLoadflowData();
	    if (lfData == null)
	    	lfData = busRec.addNewLoadflowData();
	    if (lfData.getShuntCompensatorData() == null) {  // there may be multiple contribute switched shunt records on a bus
	    	lfData.addNewShuntCompensatorData().addNewShuntCompensatorList();
	    }
	    ShuntCompensatorXmlType shunt = lfData.getShuntCompensatorData().getShuntCompensatorList().addNewShunCompensator();
		
		// genId is used to distinguish multiple generations at one bus		
		int mode = ModelStringUtil.getInt(strAry[1], 0);
		shunt.setMode(mode ==0? ShuntCompensatorXmlType.Mode.FIXED :
						mode ==1? ShuntCompensatorXmlType.Mode.DISCRETE : 
							ShuntCompensatorXmlType.Mode.CONTINUOUS);
		
		//VSWHI - Desired voltage upper limit, per unit
		//VSWLO - Desired voltage lower limit, per unit
		final double vmax = ModelStringUtil.getDouble(strAry[2], 1.0);
		final double vmin = ModelStringUtil.getDouble(strAry[3], 1.0);
		XBeanDataSetter.setVoltageLimitData(shunt.addNewDesiredVoltageRange(), vmax, vmin, VoltageUnitType.PU);
		
		//SWREM - Number of remote bus to control. 0 to control own bus.
		int busNo = ModelStringUtil.getInt(strAry[4], 0);
		if (busNo != 0) {
			shunt.addNewRemoteControlledBus().setIdRef(XBeanODMModelParser.BusIdPreFix+strAry[4]);
		}

		/* V30
			RMPCT Percent of the total Mvar required to hold the voltage at the bus controlled by bus
					I that are to be contributed by this switched shunt; RMPCT must be positive.
					RMPCT is needed only if SWREM specifies a valid remote bus and there is more
					than one local or remote voltage controlling device (plant, switched shunt, FACTS
					device shunt element, or VSC dc line converter) controlling the voltage at bus
					SWREM to a setpoint, or SWREM is zero but bus I is the controlled bus, local or
					remote, of one or more other setpoint mode voltage controlling devices. Only used
					if MODSW = 1 or 2. RMPCT = 100.0 by default.
			RMIDNT When MODSW is 4, the name of the VSC dc line whose converter bus is specified
					in SWREM. RMIDNT is not used for other values of MODSW. RMIDNT is a
					blank name by default.
		 */
		int bintPos = 5;
		if (version == PsseVersion.PSSE_30) {
			bintPos = 7;
			shunt.setVarPercent(ModelStringUtil.getDouble(strAry[5], 100.0));
			shunt.setVscDcLine(strAry[6]);
		}
		
		//BINIT - Initial switched shunt admittance, MVAR at 1.0 per unit volts
		
		final double binit = ModelStringUtil.getDouble(strAry[bintPos], 0.0);
		shunt.setBInit(binit);
		
		double equiQ = 0.0;
		if (lfData.getShuntCompensatorData().getEquivQ() != null)
			equiQ = lfData.getShuntCompensatorData().getEquivQ().getValue();
		XBeanDataSetter.setReactivePower(lfData.getShuntCompensatorData().addNewEquivQ(), equiQ+binit, ReactivePowerUnitType.MVAR);
		
		//N1 - Number of steps for block 1, first 0 is end of blocks
		//B1 - Admittance increment of block 1 in MVAR at 1.0 per unit volts. N2, B2, etc, as N1, B1
  		int pos = getNBPos(version);
		for (int i = 0; i < 8; i++) {
	  		String nStr = strAry[pos+i*2];
	  		String bStr = strAry[pos+1+i*2];
	  		if (nStr != null) {
	  			int n = ModelStringUtil.getInt(nStr, 0);
	  			double b = ModelStringUtil.getDouble(bStr, 0.0);
	  			ShuntCompensatorXmlType.Block block = shunt.addNewBlock();
	  			block.setSteps(n);
	  			XBeanDataSetter.setReactivePower(block.addNewIncrementB(), b, ReactivePowerUnitType.MVAR);
	  		}
		}
	}

	private static String[] getSwitchedShuntDataFields(final String lineStr, PsseVersion version) {
		// V26 - I,    MODSW,VSWHI, VSWLO,  SWREM,   BINIT,    N1,      B1,   N2,        B2...N8,B8
		// V30 - I, MODSW, VSWHI, VSWLO, SWREM, RMPCT, �RMIDNT�, BINIT, N1, B1, N2, B2, ... N8, B8
		final String[] strAry = new String[24];		
  		StringTokenizer st = new StringTokenizer(lineStr, ",");
  		
  		int pos = getNBPos(version);
  		for ( int i = 0; i < pos; i++) 
  	  		strAry[i]=st.nextToken().trim();
  		
  		for ( int i = 0; i < 8; i++) {
  			if (st.hasMoreTokens()) {
  		  		String str = st.nextToken().trim();
  		  		if (!str.trim().equals("")) {
  		  			strAry[pos+i*2]=str;
  	  		  		strAry[pos+1+i*2]=st.nextToken().trim();
  		  		}
  			}
  			else {
		  		strAry[pos+i*2]=null;
  	  		  	strAry[pos+1+i*2]=null;
  			}
  		}
		return strAry;
	}
	
	private static int getNBPos(PsseVersion version) {
  		int pos = 6;
  		if (version == PsseVersion.PSSE_30)
  			pos = 8;
  		return pos;
	}
}
