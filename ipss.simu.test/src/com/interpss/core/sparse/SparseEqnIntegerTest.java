 /*
  * @(#)SparseEqnIntegerTest.java   
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

package com.interpss.core.sparse;

import static org.junit.Assert.*;
import org.junit.*;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.interpss.common.SpringAppContext;
import com.interpss.BaseTestSetup;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algorithm.BusArrangeRule;
import com.interpss.core.algorithm.NetworkAlgorithm;
import com.interpss.core.net.NetPackage;
import com.interpss.core.net.Network;
import com.interpss.core.sparse.SparseEqnInteger;
import com.interpss.core.sparse.impl.SparseEqnIntegerImpl;

/**
 * @author mzhou
 *
 */
public class SparseEqnIntegerTest extends BaseTestSetup {
  	private static ResourceSet resourceSet = null;

  	@BeforeClass
  	public static void sparseEqnIntegerTestSetup() {
	  	resourceSet = new ResourceSetImpl();
	  	// the following registeration only needed for stand-alone applicaiton.
	  	resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	  			"net", new XMIResourceFactoryImpl()); 	
	  	NetPackage packageInstance = NetPackage.eINSTANCE;
  	}
  	
	@Test
	public void arrangeRowNoT1Test() {
	  	Network net = loadNetwork("testData/testBusArrange.net");
  		assertEquals(true, (net.getBusList().size() == 9 && net.getBranchList().size() == 8));

  		NetworkAlgorithm netAlgo = CoreObjectFactory.createNetworkAlgorithm(net);
  		netAlgo.arrangeBusNumber(BusArrangeRule.TINNEY1, SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
  		
  		assertEquals(true, net.getBus("A").getSortNumber() == 1);
  		assertEquals(true, net.getBus("E").getSortNumber() == 6);
  		assertEquals(true, net.getBus("G").getSortNumber() == 9);
  		System.out.println("Bus no arrangement Tinney1, sucessful");
  	}

	public void testArrangeRowNoT2() {
	  	Network net = loadNetwork("testData/testBusArrange.net");
  		assertEquals(true, (net.getBusList().size() == 9 && net.getBranchList().size() == 8));

  		NetworkAlgorithm netAlgo = CoreObjectFactory.createNetworkAlgorithm(net);
  		netAlgo.arrangeBusNumber(BusArrangeRule.TINNEY2, SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());
  		
  		assertEquals(true, net.getBus("A").getSortNumber() == 1);
  		assertEquals(true, net.getBus("E").getSortNumber() == 7);
  		assertEquals(true, net.getBus("G").getSortNumber() == 8);
  		
  		System.out.println("Bus no arrangement Tinney2, sucessful");
  	}

	public void testArrangeRowNoT3() {
	  	Network net = loadNetwork("testData/testBusArrange.net");
  		assertEquals(true, (net.getBusList().size() == 9 && net.getBranchList().size() == 8));

  		NetworkAlgorithm netAlgo = CoreObjectFactory.createNetworkAlgorithm(net);
  		netAlgo.arrangeBusNumber(BusArrangeRule.TINNEY3, SpringAppContext.getIpssMsgHub());
  		//System.out.println(net.net2String());

  		assertEquals(true, net.getBus("A").getSortNumber() == 1);
  		assertEquals(true, net.getBus("E").getSortNumber() == 5);
  		assertEquals(true, net.getBus("G").getSortNumber() == 9);

  		System.out.println("Bus no arrangement Tinney3, sucessful");
  	}

	public void testSetAij() {
		SparseEqnIntegerImpl eqn = createSampleEqn();
		eqn.setAij(10, 2, 3);
		SparseEqnIntegerImpl.IntAii aii = eqn.getElem(2);
		assertTrue(eqn.getAij(aii,3).aij==10);
		assertTrue(eqn.getAij(aii,3).j==3);
	}

	public void testTotalElements() {
		SparseEqnInteger eqn = createSampleEqn();
		//System.out.println("total elements: " + eqn.totalElements());
		assertTrue(eqn.getTotalElements()==6);
	}
	private SparseEqnIntegerImpl createSampleEqn() {
		SparseEqnIntegerImpl eqn = new SparseEqnIntegerImpl(3);
		eqn.setAij(1, 1, 1);
		eqn.setAij(1, 2, 2);
		eqn.setAij(1, 3, 3);

		eqn.setAij(1, 1, 2);
		eqn.setAij(1, 2, 3);
		eqn.setAij(1, 3, 2);
		return eqn;
	}
	
	private Network loadNetwork(String filename) {
	  	String path = new File(filename).getAbsolutePath();
  		//System.out.println("path: " + path);
	  	URI fileURI = URI.createFileURI(path);
	  	Resource netRe = resourceSet.getResource(fileURI, true);
	  	Network net = (Network)netRe.getContents().get(0);
  		System.out.println("\nNetwork object loaded, xml file path: " + path);
  		return net;
	}	
}
