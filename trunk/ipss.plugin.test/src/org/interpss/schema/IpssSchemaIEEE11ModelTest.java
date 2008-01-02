 /*
  * @(#)TestEq1MachineCase.java   
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

package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.dstab.ieeeModel.DStabTestSetupBase;
import org.interpss.editor.mapper.RunForm2AlgorithmMapper;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.mapper.IpssMapper;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.test.StateVariableTestRecorder;
import com.interpss.dstab.util.DStabOutSymbol;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class IpssSchemaIEEE11ModelTest extends DStabTestSetupBase {
	/*
	private double[] 
	      timePoints    = {0.0,    1.0,    2.0,    3.0,    4.0,    5.0,    6.0,    7.0,    8.0,    9.0,    10.0},
	      machAngPoints = {49.460, 49.460, 46.705, 47.171, 47.563, 47.883, 48.145, 48.361, 48.540, 48.689, 48.814},
	      machPePoints  = {0.426,  0.426,  0.333,  0.352,  0.367,  0.379,  0.389,  0.396,  0.402,  0.407,  0.411};
	private Complex yFault = new Complex(1.2595,-100000012.97521),
	                yClear = new Complex(1.2595,-12.97521);
	*/
	@Test
	public void test_Case1() throws Exception {
		File xmlFile = new File("testData/xml/RunDStabCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.DSTABILITY_NET, msg);
		loadCaseData("testData/dstab_test/ieee1-1Model.ipss", simuCtx);
		
		DStabilityNetwork net = simuCtx.getDStabilityNet();
		//System.out.println(net.net2String());
		
		DynamicSimuAlgorithm algo = DStabObjectFactory.createDynamicSimuAlgorithm(net, msg);
	  	IpssMapper mapper = new RunForm2AlgorithmMapper();
	  	int caseCnt = 0;
	  	for ( RunDStabStudyCaseXmlType dstabCase : parser.getRunDStabStudyCaseList()) {
	  		mapper.mapping(dstabCase, algo, RunDStabStudyCaseXmlType.class);
	  		
	  		if (caseCnt++ == 0) {
			  	assertTrue(algo.getTotalSimuTimeSec() == 1.0);
			  	assertTrue(algo.getSimuStepSec() == 0.002);
			  	assertTrue(algo.getSimuMethod() == DynamicSimuMethods.MODIFIED_EULER);
			  	assertTrue(algo.getRefMachine() != null);
			  	assertTrue(algo.getRefMachine().getId().equals("Mach@0003"));
			  	assertTrue(algo.getDStabNet().getDEventList().size() == 0);

			  	LoadflowAlgorithm aclfAlgo = algo.getAclfAlgorithm();
				aclfAlgo.loadflow(msg);
			  	assertTrue(simuCtx.getDStabilityNet().isLfConverged());
				
				double[] timePoints    = {0.0,  0.5,  1.0},
		     	 machAngPoints = {49.460, 49.460, 49.460};
				StateVariableTestRecorder stateTestRecorder = new StateVariableTestRecorder(0.0001);
				stateTestRecorder.addTestRecords("Mach@0001", StateVariableTestRecorder.RecType_Machine, 
						DStabOutSymbol.OUT_SYMBOL_MACH_ANG, timePoints, machAngPoints);
				algo.setSimuOutputHandler(stateTestRecorder);
			  	
				if (algo.initialization(msg)) {
					System.out.println("Running DStab simulation ...");
					algo.performSimulation(msg);
				}
				
				assertTrue(stateTestRecorder.diffTotal("Mach@0001", StateVariableTestRecorder.RecType_Machine, 
						DStabOutSymbol.OUT_SYMBOL_MACH_ANG) < 0.01);	  		}
	  	}
	}
}
