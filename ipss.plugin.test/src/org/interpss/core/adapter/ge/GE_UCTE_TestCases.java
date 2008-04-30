 /*
  * @(#)CR_UserTestCases.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 02/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.core.adapter.ge;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.custom.IpssFileAdapter;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.simu.SimuContext;

public class GE_UCTE_TestCases extends BaseTestSetup {
	@Test
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = PluginSpringAppContext.getCustomFileAdapter("ge");
		SimuContext simuCtx = adapter.load("testData/ge/Test.epc", SpringAppContext.getIpssMsgHub());
//  		System.out.println(simuCtx.getAclfNet().net2String());
		
		assertTrue(true);
	}
}

