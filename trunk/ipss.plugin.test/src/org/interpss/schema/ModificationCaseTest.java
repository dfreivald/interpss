/*
 * @(#)ModificationCaseTest.java   
 *
 * Copyright (C) 2006-2007 www.interpss.org
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
 * @Date 09/15/2007
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.PluginSpringAppContext;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.SwingBusAdapter;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class ModificationCaseTest extends BaseTestSetup {
	@Test
	public void modificationOnlyTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));
	  	assertTrue(net.getAclfBus("0003").getGenCode() != AclfGenCode.NON_GEN);
	  	assertTrue(net.getAclfBus("0009").getLoadCode() != AclfLoadCode.NON_LOAD);

		File xmlFile = new File("testData/xml/ModificationOnly.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		ModificationXmlType mod = parser.getModification();
  		
		IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
		mapper.mapping(mod, net, ModificationXmlType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	assertTrue(!net.getBus("0006").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadP() == 1.1*0.149);
	  	assertTrue(net.getAclfBus("0014").getLoadQ() == 1.1*0.05);
	  	
	  	// load set to 0.15+j0.06 pu
	  	assertTrue(net.getAclfBus("0013").getLoadP() == 0.15);
	  	assertTrue(net.getAclfBus("0013").getLoadQ() == 0.06);

	  	// load added 1.0+j1.0 MVA
	  	assertTrue(net.getAclfBus("0012").getLoadP() == 0.071);
	  	assertTrue(Math.abs(net.getAclfBus("0012").getLoadQ()-0.026) < 1.0E-5);

		final SwingBusAdapter gen = (SwingBusAdapter)net.getAclfBus("0001").getAdapter(SwingBusAdapter.class);
	  	assertTrue(gen.getVoltMag(UnitType.PU) == (1.06*1.01));

	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);

	  	assertTrue(net.getAclfBus("0003").getGenCode() == AclfGenCode.NON_GEN);

	  	assertTrue(net.getAclfBus("0009").getLoadCode() == AclfLoadCode.NON_LOAD);
	}
	
	@Test
	public void modificationPersistanceTest() throws Exception {
		File xmlFile = new File("testData/xml/ModificationOnly.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		ModificationXmlType mod = parser.getModification();
  		String xmlString = mod.xmlText();
  		
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

  		mod = ModificationXmlType.Factory.parse(xmlString);
  		
		IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
		mapper.mapping(mod, net, ModificationXmlType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	assertTrue(!net.getBus("0006").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadP() == 1.1*0.149);
	  	assertTrue(net.getAclfBus("0014").getLoadQ() == 1.1*0.05);
	  	
	  	// load set to 0.15+j0.06 pu
	  	assertTrue(net.getAclfBus("0013").getLoadP() == 0.15);
	  	assertTrue(net.getAclfBus("0013").getLoadQ() == 0.06);

	  	// load added 1.0+j1.0 MVA
	  	assertTrue(net.getAclfBus("0012").getLoadP() == 0.071);
	  	assertTrue(Math.abs(net.getAclfBus("0012").getLoadQ()-0.026) < 1.0E-5);

		final SwingBusAdapter gen = (SwingBusAdapter)net.getAclfBus("0001").getAdapter(SwingBusAdapter.class);
	  	assertTrue(gen.getVoltMag(UnitType.PU) == (1.06*1.01));

	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);
  		
	}  		
}
