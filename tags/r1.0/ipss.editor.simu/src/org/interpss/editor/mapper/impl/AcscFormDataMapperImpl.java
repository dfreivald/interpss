 /*
  * @(#)AcscFormDataMapperImpl.java   
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

package org.interpss.editor.mapper.impl;

import java.util.List;

import org.apache.commons.math.complex.Complex;
import org.interpss.editor.data.acsc.AcscBranchData;
import org.interpss.editor.data.acsc.AcscBusData;
import org.interpss.editor.data.acsc.AcscNetData;
import org.interpss.editor.data.common.XfrConnectData;
import org.interpss.editor.form.GBranchForm;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.form.IGBranchForm;

import com.interpss.common.datatype.Constants;
import com.interpss.common.datatype.ScGroundType;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.exp.InvalidParameterException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscLineAdapter;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.AcscXfrAdapter;
import com.interpss.core.acsc.BusScCode;
import com.interpss.core.acsc.SequenceCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.acsc.XfrConnectCode;

/**
 * Map functions for BaseNetForm, BaseBusForm, BaseBranchForm to/from Network, Bus, Branch simu objects
 */


public class AcscFormDataMapperImpl {
    /**
     * Map the GNetContainer object to a SimpleFaultNetwork object
     * 
     * @param editNet the GFormContainer object
     * @param msg the SessionMsg object
     * @return a SimpleFaultNetwork object
     */
	public static SimpleFaultNetwork mapEditNet2AcscNet(GFormContainer editNet, IPSSMsgHub msg) {
		SimpleFaultNetwork acscNet = CoreObjectFactory.createSimpleFaultNetwork();

		BaseFormDataMapperImpl.setBaseNetInfo((GNetForm)editNet.getGNetForm(), acscNet);
		
		AcscNetData data = ((GNetForm)editNet.getGNetForm()).getAcscNetData();
		if (data.isHasAclfData()) {
			// all buese/branches are added in the following setup process
			acscNet.setLfDataLoaded(true);
			AclfFormDataMapperImpl.setAclfNetInfo(editNet, acscNet, msg);
		}
		else {
			acscNet.setLfDataLoaded(false);
		}

		List busList = editNet.getBusFormList();
		for ( int i = 0; i < busList.size(); i++ ) {
			// For each AcscBus xml object, parse for an AcscBus form object
			GBusForm busForm = (GBusForm)busList.get(i);
			if (!acscNet.isLfDataLoaded()) 
				setAddBusForm2Net(busForm, acscNet);
			else {
				AcscBus bus = (AcscBus)acscNet.getBus(busForm.getId());
				setBusInfo(busForm, bus, acscNet);
			}	
			//System.out.println("\nBus info, #:" + (i+1));
			//System.out.println(busForm.toString());
		}

		List branchList = editNet.getBranchFormList();
		for ( int i = 0; i < branchList.size(); i++ ) {
			// For each AcscBranch xml object, parse for an AcscBranch form object
			GBranchForm branchForm = (GBranchForm)branchList.get(i);
			if (!acscNet.isLfDataLoaded()) 
				setAddBranchForm2Net(branchForm, acscNet, msg);
			else {
				// TODO: multiple branch situation
				AcscBranch branch = (AcscBranch)acscNet.getBranch(branchForm.getFromId(), branchForm.getToId());
				setBranchInfo(branchForm, branch, acscNet, msg);
			}	
			//System.out.println("\nBranch info, #:" + (i+1));
			//System.out.println(branchForm.toString());
		}

		acscNet.setScDataLoaded(true);
		// if load flow info loaded, the ckeckData will also perform checking for LF.
		/* the checkData() need to be called at high level
		if (!acscNet.checkData(msg)) {
			msg.sendErrorMsg("AcscNetwork data ckeck error, \n" + acscNet.toString());
			throw new InterpssRuntimeException("AcscAdjNetwork data ckeck error, \n" + acscNet.toString());
		}
		*/
		//System.out.println(acscNet.net2String());
		return acscNet;
	}
	
	private static boolean setAddBusForm2Net(GBusForm form, AcscNetwork acscNet) {
		AcscBus bus = CoreObjectFactory.createAcscBus(form.getId());
		acscNet.addBus(bus);

		BaseFormDataMapperImpl.setBaseBusInfo(form, bus, acscNet);
		return setBusInfo(form, bus, acscNet);
	}

	private static boolean setAddBranchForm2Net(GBranchForm form, AcscNetwork acscNet, IPSSMsgHub msg) {
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
	  	acscNet.addBranch(branch, form.getFromId(), form.getToId());
		
		BaseFormDataMapperImpl.setBaseBranchInfo(form, branch, acscNet);
		return setBranchInfo(form, branch, acscNet, msg);
	}

	public static boolean setBusInfo(GBusForm formBus, AcscBus bus, AcscNetwork net) {
		AclfFormDataMapperImpl.setAclfBusFormInfo(formBus, bus, net);

		AcscBusData data = formBus.getAcscBusData();
		if (data.getScCode().equals(AcscBusData.ScCode_Contribute)) {
			return setContributeBusFormInfo(data, bus, net);
		}
		else if (data.getScCode().equals(AcscBusData.ScCode_NonContribute)) {
			return setNonContributeBusFormInfo(data, bus, net);
		}
		else {
			throw new InvalidParameterException("Wrong bus Branch type for mapping AcscBusInfo, type: " + data.getScCode()); 
		}
	}

	private static boolean setContributeBusFormInfo(AcscBusData busData, AcscBus bus, AcscNetwork net) {
		bus.setScCode(BusScCode.CONTRIBUTE_LITERAL);
		try {
			setBusScZ(bus, net.getBaseKva(), 
					busData.getZ1R(), busData.getZ1X(), 
					busData.getZ2R(), busData.getZ2X(), 
					busData.getZ0R(), busData.getZ0X(), 
					UnitType.toUnit(busData.getZUnit()));
			setBusScZg(bus, net.getBaseKva(), 
					busData.getGround().getCode(), 
					busData.getGround().getR(), busData.getGround().getX(), 
					UnitType.toUnit(busData.getGround().getUnit()));
			return true;
		} catch (Exception e) {
      		IpssLogger.logErr(e);
      		throw new InterpssRuntimeException(e.toString());
		}
	}

	private static boolean setNonContributeBusFormInfo(AcscBusData busData, AcscBus bus, AcscNetwork net) {
		bus.setScCode(BusScCode.NON_CONTRI_LITERAL);
		bus.setZ(Constants.LargeBusZ, SequenceCode.POSITIVE_LITERAL);
		bus.setZ(Constants.LargeBusZ, SequenceCode.NEGATIVE_LITERAL);
		bus.setZ(Constants.LargeBusZ, SequenceCode.ZERO_LITERAL);
		bus.setGrounding(new ScGroundType());
		return true;
	}

	private static void setBusScZ(AcscBus bus, double baseKVA,
						double r1,    double x1,
						double r2,    double x2,
						double r0,    double x0, 
						byte zUnit	) {
		bus.setZ(new Complex(r1, x1), SequenceCode.POSITIVE_LITERAL, zUnit, baseKVA);
		bus.setZ(new Complex(r2, x2), SequenceCode.NEGATIVE_LITERAL, zUnit, baseKVA);
		bus.setZ(new Complex(r0, x0), SequenceCode.ZERO_LITERAL, zUnit, baseKVA);
	}

	private static void setBusScZg(AcscBus bus, double baseKVA,
						String   gType, double rg,    
						double xg, byte zgUnit) {
		ScGroundType gtype = new ScGroundType();
		gtype.setCode(gType);
		gtype.setZ(new Complex(rg, xg), zgUnit, bus.getBaseVoltage(), baseKVA);
		bus.setGrounding(gtype);
	}
	
	public static boolean setBranchInfo(GBranchForm formBranch, AcscBranch branch, 
							AcscNetwork net, IPSSMsgHub msg) {
	  	AclfFormDataMapperImpl.setAclfBranchFormInfo(formBranch, branch, net, msg);
	  	
	  	AcscBranchData data = formBranch.getAcscBranchData();
		if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Line)) {   // line branch
			return setAcscLineFormInfo(data, branch, net, msg);
		}
		else if (data.getLfCode().equals(IGBranchForm.TransBranchLfCode_Xfr) || 
				 data.getLfCode().equals(IGBranchForm.TransBranchLfCode_PsXfr)) {   // psxfr branch
			return setAcscXfrFormInfo(data, branch, net, msg);
		}
		else {
			throw new InvalidParameterException("Wrong Aclf Branch type for mapping AcscBranchInfo, type: " + data.getLfCode()); 
		}
	}

	private static boolean setAcscLineFormInfo(AcscBranchData branchData, AcscBranch branch, 
						AcscNetwork net, IPSSMsgHub msg) {
		double baseV = branch.getFromAclfBus().getBaseVoltage();
		AcscLineAdapter line = (AcscLineAdapter)branch.adapt(AcscLineAdapter.class);
		line.setZ0( new Complex(branchData.getZ0R(), branchData.getZ0X()), 
						UnitType.toUnit(branchData.getZ0Unit()), 
						baseV, net.getBaseKva(), msg );
		line.setHB0(branchData.getHalfShuntB0(), UnitType.toUnit(branchData.getHalfShuntB0Unit()), 
						baseV, net.getBaseKva());
		return true;
	}

	private static boolean setAcscXfrFormInfo(AcscBranchData branchData, AcscBranch branch, 
							AcscNetwork net, IPSSMsgHub msg) {
		double baseV = branch.getFromAclfBus().getBaseVoltage() > branch.getToAclfBus().getBaseVoltage()?
				branch.getFromAclfBus().getBaseVoltage() : branch.getToAclfBus().getBaseVoltage();
		AcscXfrAdapter xfr = (AcscXfrAdapter)branch.adapt(AcscXfrAdapter.class);
		xfr.setZ0( new Complex(branchData.getZ0R(), branchData.getZ0X()), 
						UnitType.toUnit(branchData.getZ0Unit()), 
						baseV, net.getBaseKva(), msg );
		
		XfrConnectData connect = branchData.getFromXfrConnectData();
		xfr.setFromConnectGroundZ(calXfrConnectCode(connect),
				new Complex(connect.getGrounding().getR(), connect.getGrounding().getX()),  
				UnitType.toUnit(connect.getGrounding().getUnit()), net.getBaseKva());
		
		connect = branchData.getToXfrConnectData();
		xfr.setToConnectGroundZ(calXfrConnectCode(connect),
				new Complex(connect.getGrounding().getR(), connect.getGrounding().getX()),  
				UnitType.toUnit(connect.getGrounding().getUnit()), net.getBaseKva());

 		return true;
	}
	
	private static XfrConnectCode calXfrConnectCode(XfrConnectData connect) {
		// connectCode : [Delta | Wye]
		// groundCode : [SolidGrounded | ZGrounded | Ungrounded ]
		if (connect.getCode().equals(XfrConnectData.Code_Delta)) 
			// str set [ DeltaConnected | SolidGrounded | ZGrounded | Ungrounded ]
			return XfrConnectCode.DELTA_LITERAL;
		else {
			if (connect.getGrounding().getCode().equals(ScGroundType.GType_Ungrounded))
				return XfrConnectCode.WYE_UNGROUNDED_LITERAL;
			else if (connect.getGrounding().getCode().equals(ScGroundType.GType_ZGrounded))
				return XfrConnectCode.WYE_ZGROUNDED_LITERAL;
			if (connect.getGrounding().getCode().equals(ScGroundType.GType_SolidGrounded))
				return XfrConnectCode.WYE_SOLID_GROUNDED_LITERAL;
		}	
		throw new InvalidParameterException("Wrong input in AcscFormDataMapperImpl.calXfrConnectCode()"); 
	}
}