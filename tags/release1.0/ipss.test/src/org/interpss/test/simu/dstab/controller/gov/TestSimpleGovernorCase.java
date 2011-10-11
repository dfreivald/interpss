 /*
  * @(#)TestSimpleGovernorCase.java   
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

package org.interpss.test.simu.dstab.controller.gov;

import org.interpss.test.simu.dstab.controller.TestSetupBase;

import com.interpss.dstab.DynamicSimuMethods;
import org.interpss.dstab.control.gov.simple.SimpleGovernor;
import com.interpss.dstab.mach.Machine;

public class TestSimpleGovernorCase extends TestSetupBase {

	public void test_Case1() {
		System.out.println("\nBegin TestSimpleGovernorCase Case1");

		Machine mach = createMachine();

		SimpleGovernor gov = new SimpleGovernor("GovId", "GovName", "InterPSS");
		gov.getData().setK(10.0);
		gov.getData().setT1(0.5);
		gov.getData().setPmax(1.2);
		gov.getData().setPmin(0.0);
		mach.addExciter(gov);
		
		mach.setPm(1.0);
		mach.setSpeed(1.0);
		gov.initStates(this.msg);
		//System.out.println("Pm0, X1 " + gov._Pm0 + ", " + gov._X1);
		assertTrue(Math.abs(gov.getPm0() - 1.0) < 0.0001);
		assertTrue(Math.abs(gov.getStateX1()) < 0.0001);
		
		// calculate a step, the state should remain the same
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		assertTrue(Math.abs(gov.getStateX1()) < 0.0001);
		
		// calculate more steps, the state should remain the same also
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		assertTrue(Math.abs(gov.getStateX1()) < 0.0001);

		/*
		 * Set mach speed to 1.01 pu
		 * 
		 * dw = 0.01, X1(0) = 0.0
		 * dXdt = [10*0.01 - 0.0] / 0.5 = 0.2
		 * X1(1) = 0.0 + 0.2 * 0.01 = 0.002
		 * dXdt = [10.0*0.01 - 0.002] / 0.5 = 0.196
		 * X1 = 0.0 + 0.5 * [0.2 + 0.196] * 0.01 = 0.00198
		 */
		mach.setSpeed(1.01);
		gov.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		//System.out.println("X1 " + gov._X1);
		assertTrue(Math.abs(gov.getStateX1() - 0.00198) < 0.0001);
		
		System.out.println("\nEnd TestSimpleGovernorCase Case1");
	}
}