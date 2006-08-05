package com.interpss.test.unit.dstab.controller.exc;

import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.exc.simple.SimpleExciter;
import com.interpss.dstab.mach.Machine;
import com.interpss.test.unit.dstab.controller.TestSetupBase;

public class TestSimpleExcitorCase extends TestSetupBase {
	
	public void test_Case1() {
		System.out.println("\nBegin TestSimpleExcitorCase Case1");

		Machine mach = createMachine();

		SimpleExciter exc = new SimpleExciter("ExcId", "ExcName", "InterPSS");
		exc.getData().setKa(50.0);
		exc.getData().setTa(0.05);
		exc.getData().setVrmax(10.0);
		exc.getData().setVrmin(0.0);
		mach.addExciter(exc);
		
		mach.setEfd(2.0);
		exc.initStates(this.msg);
		assertTrue(Math.abs(exc.getStateVref() - 1.04) < 0.0001);
		assertTrue(Math.abs(exc.getStateX1() - 2.0) < 0.0001);
		
		// calculate a step, the state should remain the same
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		assertTrue(Math.abs(exc.getStateX1() - 2.0) < 0.0001);
		
		// calculate more steps, the state should remain the same also
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		assertTrue(Math.abs(exc.getStateX1() - 2.0) < 0.0001);

		/* Set machine voltage to 0.99 and move forward a step
		 * 
		 * vt = 0.99, X1(0) = 2.0
		 * dXdt = [50*(1.04-0.99) - 2.0]/0.05 = 10.0
		 * X1(1) = 2.0 + 10.0 * 0.01
		 * dXdt = [50*(1.04-0.99) - 2.1]/0.05 = 8.0
		 * X1 = 2.0 + 0.5 * (10.0 + 8.0) * 0.01 = 2.09
		 */
		mach.getBus().setVoltageMag(0.99);
		exc.nextStep(0.01, DynamicSimuMethods.MODIFIED_EULER_LITERAL, 60.0, msg);
		//System.out.println("X1 " + exc._X1);
		assertTrue(Math.abs(exc.getStateX1() - 2.09) < 0.0001);

		System.out.println("\nEnd TestSimpleExcitorCase Case1");
	}
}
