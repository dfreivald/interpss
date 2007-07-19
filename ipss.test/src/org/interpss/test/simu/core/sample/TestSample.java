 /*
  * @(#)TestSample.java   
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

package org.interpss.test.simu.core.sample;

import org.apache.commons.math.complex.Complex;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.core.acsc.AcscBusFault;
import com.interpss.core.acsc.SimpleFaultCode;
import com.interpss.core.acsc.SimpleFaultNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.algorithm.SimpleFaultAlgorithm;
import com.interpss.core.util.sample.SampleCases;

public class TestSample extends TestBaseAppCtx {
	/*
	 * load the 5-bus system
	 */
	public void testCase1() {
  		System.out.println("Begin TestSample.testCase1()");

  		AclfNetwork net = CoreObjectFactory.createAclfNetwork();
		SampleCases.load_LF_5BusSystem(net, SpringAppContext.getIpssMsgHub());
		//System.out.println(net.net2String());

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertEquals(true, net.isLfConverged());
  		
  		//System.out.println("Area1 output power: " + net.areaOutputPower(1, UnitType.PU));
  		assertEquals(true, Math.abs(net.areaOutputPower(1, UnitType.PU)-1.28164)<0.0001);

  		AclfBus swingBus = (AclfBus)net.getBus("5");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.adapt(SwingBusAdapter.class);
  		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()));
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.57943)<0.0001);
  		assertEquals(true, Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-2.2994)<0.0001);
  		
		System.out.println("End TestSample.testCase1()");
	}

	public void testCase2() {
  		System.out.println("Begin TestSample.testCase2()");

  		SimpleFaultNetwork faultNet = CoreObjectFactory.createSimpleFaultNetwork();
		SampleCases.load_SC_5BusSystem(faultNet, SpringAppContext.getIpssMsgHub());
		//System.out.println(faultNet.net2String());

  		assertEquals(true, (faultNet.getBusList().size() == 5 && faultNet.getBranchList().size() == 5));
  		
  		AcscBusFault fault = CoreObjectFactory.createAcscBusFault("2", faultNet);
		fault.setFaultCode(SimpleFaultCode.GROUND_3P);
		fault.setZLGFault(new Complex(0.0, 0.0));
		fault.setZLLFault(new Complex(0.0, 0.0));
		
	  	SimpleFaultAlgorithm algo = CoreObjectFactory.createSimpleFaultAlgorithm(faultNet);
	  	algo.calculateBusFault(fault, SpringAppContext.getIpssMsgHub());
  		//System.out.println(fault.toString(faultBus.getBaseVoltage(), faultNet.getBaseKva()));
		/*
		 fault amps(1): (  0.0000 + j 32.57143) pu
		 fault amps(2): (  0.0000 + j  0.0000) pu
		 fault amps(0): (  0.0000 + j  0.0000) pu
		 */
		assertEquals(true, compare(fault.getFaultResult().getSCCurrent_012(), 0.0, 0.0, 0.0, 32.57143, 0.0, 0.0) );
		
		//System.out.println(AcscOut.faultResult2String(faultNet));
		
		System.out.println("End TestSample.testCase2()");
	}
}

