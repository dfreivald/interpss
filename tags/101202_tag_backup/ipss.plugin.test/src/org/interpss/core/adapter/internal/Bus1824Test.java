 /*
  * @(#)Test_Bus1824.java   
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

package org.interpss.core.adapter.internal;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringCtx;
import org.interpss.custom.IpssFileAdapter;
import org.junit.Test;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class Bus1824Test extends BaseTestSetup {
	@Test
	public void testCaseNR() throws Exception {
  		System.out.println("Start loading data ...");
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ipssdat");
		SimuContext simuCtx = adapter.load("testData/ipssdata/BUS1824.ipssdat");
  		System.out.println("End loading data ...");

		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
  		assertTrue((net.getBusList().size() == 1824));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, msg);
	  	algo.getLfAdjAlgo().setApplyAdjustAlgo(false);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
	}

	@Test
	public void testCasePQ() throws Exception {
  		System.out.println("Start loading data ...");
		IpssFileAdapter adapter = PluginSpringCtx.getCustomFileAdapter("ipssdat");
		SimuContext simuCtx = adapter.load("testData/ipssdata/BUS1824.ipssdat");
  		System.out.println("End loading data ...");

		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
  		assertTrue((net.getBusList().size() == 1824));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, msg);
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.getLfAdjAlgo().setApplyAdjustAlgo(false);
	  	algo.loadflow();
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
	}
}
