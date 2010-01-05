 /*
  * @(#)TestRoundRotorMachineCase.java   
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

package org.interpss.dstab.mach;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.interpss.dstab.DStabBus;
import com.interpss.dstab.DStabObjectFactory;
import com.interpss.dstab.DStabilityNetwork;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.mach.MachineType;
import com.interpss.dstab.mach.RoundRotorMachine;

public class RoundRotorMachineTest extends TestSetupBase {
	
	@Test
	public void test_Case1() {
		// create a machine in a two-bus network. The loadflow already converged
		RoundRotorMachine mach = createMachine();
		
		// calculate mach state init values
		DStabBus bus = net.getDStabBus("Gen");
		mach.initStates(bus, msg);
		//System.out.println("Ygen: " + mach.getYgen());
		//System.out.println("Igen: " + mach.getIgen());
		assertTrue(Math.abs(mach.getYgen().getReal()-0.16658) < 0.00001);
		assertTrue(Math.abs(mach.getYgen().getImaginary()+7.49625) < 0.00001);
		assertTrue(Math.abs(mach.getIgen(mach.getDStabBus()).getReal()-0.96657) < 0.00001);
		assertTrue(Math.abs(mach.getIgen(mach.getDStabBus()).getImaginary()+8.09623) < 0.00001);

		// the following values to compare to are by long-hand calculation
		/*
		System.out.println("Angle, Eq1, Ed1, Ed11, Eq11, Efd, Pe: " + mach.getAngle()*Constants.RtoD + ", " + 
		                 mach.getEq1() + ", " + mach.getEd1() + ", " + mach.getEd11() +  ", " + 
		                 mach.getEq11() + ", " + mach.getEfd()+ ", " + mach.getPe());
		*/                 
		assertTrue(Math.abs(Math.toDegrees(mach.getAngle())-27.58341) < 0.00001);
		assertTrue(Math.abs(mach.getEq1()-1.09514) < 0.00001);
		assertTrue(Math.abs(mach.getEd1()+0.36656) < 0.00001);
		assertTrue(Math.abs(mach.getEq11()-0.99590) < 0.00001);
		assertTrue(Math.abs(mach.getEd11()+0.40106) < 0.00001);
		assertTrue(Math.abs(mach.getEfd()-1.8800642271660648) < 0.00001);
		assertTrue(Math.abs(mach.getPe()-0.803) < 0.00001);
		assertTrue(Math.abs(mach.getPm()-0.803) < 0.00001);
		
		// Move forward one step
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);

		// again, the following values to compare to are by long-hand calculation. There
		// should be no change
		/*
		 System.out.println("Angle, Eq1, Ed1, Ed11, Eq11, Efd, Pe: " + mach.getAngle()*Constants.RtoD + ", " + 
				mach.getEq1() + ", " + mach.getEd1() + ", " + mach.getEd11() +  ", " + 
				mach.getEq11() + ", " + mach.getEfd()+ ", " + mach.getPe());
		*/		
		assertTrue(Math.abs(Math.toDegrees(mach.getAngle())-27.58341) < 0.00001);
		assertTrue(Math.abs(mach.getEq1()-1.09514) < 0.00001);
		assertTrue(Math.abs(mach.getEd1()+0.36656) < 0.00001);
		assertTrue(Math.abs(mach.getEq11()-0.99590) < 0.00001);
		assertTrue(Math.abs(mach.getEd11()+0.40106) < 0.00001);
		assertTrue(Math.abs(mach.getEfd()-1.8800642271660648) < 0.00001);
		assertTrue(Math.abs(mach.getPe()-0.803) < 0.00001);
		assertTrue(Math.abs(mach.getPm()-0.803) < 0.00001);
		
		// Move forward more steps, we should have the same value, since there is no disturbance
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);
		assertTrue(Math.abs(Math.toDegrees(mach.getAngle())-27.58341) < 0.00001);
		assertTrue(Math.abs(mach.getEq1()-1.09514) < 0.00001);
		assertTrue(Math.abs(mach.getEd1()+0.36656) < 0.00001);
		assertTrue(Math.abs(mach.getEq11()-0.99590) < 0.00001);
		assertTrue(Math.abs(mach.getEd11()+0.40106) < 0.00001);
		assertTrue(Math.abs(mach.getEfd()-1.8800642271660648) < 0.00001);
		assertTrue(Math.abs(mach.getPe()-0.803) < 0.00001);
		assertTrue(Math.abs(mach.getPm()-0.803) < 0.00001);
		
		// create an event by changing Pm from 2.0 to 1.0
		mach.setPm(1.0);  
		mach.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER, net, msg);

		// again, the following values to compare to are by long-hand calculation
		/*
		System.out.println("Angle, Eq1, Ed1, Ed11, Eq11, Efd, Pe: " + mach.getAngle()*Constants.RtoD + ", " + 
				mach.getEq1() + ", " + mach.getEd1() + ", " + mach.getEd11() +  ", " + 
				mach.getEq11() + ", " + mach.getEfd()+ ", " + mach.getPe());
		*/		
		assertTrue(Math.abs(Math.toDegrees(mach.getAngle())-27.60114) < 0.00001);
		assertTrue(Math.abs(mach.getEq1()-1.09514) < 0.00001);
		assertTrue(Math.abs(mach.getEd1()+0.36656) < 0.00001);
		assertTrue(Math.abs(mach.getEq11()-0.9959) < 0.00001);
		assertTrue(Math.abs(mach.getEd11()+0.40106) < 0.00001);
		assertTrue(Math.abs(mach.getEfd()-1.8800642271660648) < 0.00001);
		assertTrue(Math.abs(mach.getPe()-0.803) < 0.00001);
		assertTrue(Math.abs(mach.getPm()-1.0) < 0.00001);
	}
	
	public RoundRotorMachine createMachine() {
		// create a two-bus network. Loadflow calculated
		DStabilityNetwork net = createTestDStabBus();

		// create a machine and connect to the bus "Gen"
		RoundRotorMachine mach = (RoundRotorMachine)DStabObjectFactory.
							createMachine("MachId", "MachName", MachineType.EQ11_ED11_ROUND_ROTOR, net, "Gen");
		DStabBus bus = net.getDStabBus("Gen");		
		// set machine data
		mach.setRating(100, "Mva", net.getBaseKva());
		mach.setRatedVoltage(1000.0);
		mach.setMultiFactors(bus);
		mach.setH(5.0);
		mach.setD(0.01);
		mach.setX0(0.1);
		mach.setX2(0.2);
		mach.setRa(0.003);
		mach.setXl(0.14);
		mach.setXd(1.1);
		mach.setXq(1.08);
		mach.setXd1(0.23);
		mach.setTd01(5.6);
		mach.setXq1(0.23);
		mach.setTq01(1.5);
		mach.setXd11(0.12);
		mach.setTq011(0.05);
		mach.setXq11(0.15);
		mach.setTd011(0.03);
		mach.setSliner(2.0);  // no saturation
		mach.setS100(1.0);
		mach.setS120(1.0);		
		
		//System.out.println(mach.toString());
		return mach;
	}	
}
