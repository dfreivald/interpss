 /*
  * @(#)Test_IEEECommonFormat.java   
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

package org.interpss.core.adapter.ieee;

import static org.junit.Assert.assertTrue;

import org.ieee.odm.adapter.IODMPSSAdapter;
import org.ieee.odm.adapter.ieeecdf.IeeeCDFAdapter;
import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.interpss.mapper.IEEEODMMapper;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class IEEECommonFormatTest extends BaseTestSetup {
	@Test 
	public void testCase1() throws Exception {
		IODMPSSAdapter adapter = new IeeeCDFAdapter(IpssLogger.getLogger());
		adapter.parseInputFile("testdata/ieee_format/Ieee14Bus.ieee");
		
		IEEEODMMapper mapper = new IEEEODMMapper();
		final SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.NOT_DEFINED, msg);
		if (mapper.mapping(adapter.getModel(), simuCtx, SimuContext.class)) {
  	  		simuCtx.setName("IEEE14");
		}		
		AclfNetwork net = simuCtx.getAclfNet();
  		System.out.println(net.net2String());
		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.32393)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.16549)<0.0001);
	}

	@Test
	public void testCase2() throws Exception{
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee30.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 30 && net.getBranchList().size() == 41));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		assertTrue( Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.6095)<0.0001);
  		assertTrue( Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.1653)<0.0001);
  		
  		//System.out.println(AclfOut.lfResultsBusStyle(net));
	}

	@Test
	public void testCase3() throws Exception{
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee57.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 57 && net.getBranchList().size() == 80));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-4.7942)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()-1.2951)<0.0001);
  		
  		//System.out.println(AclfOut.lfResultsBusStyle(net));
	}

	@Test
	public void testCase4() throws Exception{
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee118.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 118 && net.getBranchList().size() == 186));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus69");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-5.1348)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.8239)<0.0001);
	}

	public void xtestCase5() throws Exception{
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ieee");
		SimuContext simuCtx = adapter.load("testData/ieee_format/ieee300.ieee");

		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 300 && net.getBranchList().size() == 411));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, SpringAppContext.getIpssMsgHub());
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
 		AclfBus swingBus = (AclfBus)net.getBus("Bus69");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).re);
		//System.out.println(swing.getGenResults(UnitType.PU, net.getBaseKva()).im);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-5.1348)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.8239)<0.0001);
	}
}

