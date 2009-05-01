 /*
  * @(#)Test_Bus11856.java   
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
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;

public class Bus11856Test extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
  		System.out.println("Start loading data ...");
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ipssdat");
		SimuContext simuCtx = adapter.load("testData/ipssdata/BUS11856.ipssdat");
  		System.out.println("End loading data ...");

		AclfNetwork net = simuCtx.getAclfNet();
  		//System.out.println(net.net2String());
  		assertTrue((net.getBusList().size() == 11856));

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.setLfMethod(AclfMethod.PQ);
	  	algo.loadflow(SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
	  	
  		assertTrue(net.isLfConverged());		
	}
}

