 /*
  * @(#)TestSimpleStabilizerCase.java   
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

package org.interpss.test.simu.dstab.controller.annotate;

import org.interpss.dstab.control.annotate.CustomAnnotateExciter;
import org.interpss.dstab.control.annotate.CustomAnnotateGovernor;
import org.interpss.dstab.control.annotate.CustomAnnotateStabilizer;
import org.interpss.test.simu.dstab.controller.TestSetupBase;

import com.interpss.common.func.ExpCalculator;
import com.interpss.dstab.controller.annotate.ControlBlockField;
import com.interpss.dstab.controller.annotate.StaticBlockField;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.mach.Machine;

public class TestAnnotateParserCase extends TestSetupBase {

	public void test_Case1() {
		System.out.println("\nBegin TestAnnotateParserCase Case1");

		Machine mach = createMachine();

		ControlBlockField cfield = null;
		StaticBlockField sfield = null;

		try {
			/*
				public double k = 50.0, t = 0.05, vmax = 10.0, vmin = 0.0;
	    		@AnControllerField(
            	type= "type.ControlBlock",
            	input="this.refPoint + pss.vs - mach.vt",
            	parameter={"type.Limit", "this.k", "this.t", "this.vmax", "this.vmin"},
            	y0="mach.efd"	)
    		DelayControlBlock delayBlock;
    		 */
			CustomAnnotateExciter exc = new CustomAnnotateExciter();
			assertTrue(exc.getDoubleField("k") == 50.0);
			
			exc.initStates(mach.getDStabBus(), mach, null);
			//System.out.println(exc.toString());
			assertTrue(exc.getBlock("delayBlock") != null);
			DelayControlBlock block = (DelayControlBlock)(exc.getBlock("delayBlock"));
			assertTrue(block.getK() == 50.0);
			assertTrue(block.getT() == 0.05);
			assertTrue(block.getLimit().getMax() == 10.0);
			assertTrue(block.getLimit().getMin() == 0.0);

			cfield = (ControlBlockField)(exc.getBlockField("delayBlock"));
			assertTrue(cfield.getInitOrder() == 1);
			assertTrue(cfield.hasRefPointAsInput());
			assertTrue(!cfield.hasRefPointAsOutput());
			assertTrue(cfield.getInputExp().getRecList().length == 3);
			assertTrue(cfield.getInputExp().hasVarType(ExpCalculator.VarType.ControllerRefPoint));
			assertTrue(cfield.getInputExp().hasVarType(ExpCalculator.VarType.PssVs));
			assertTrue(cfield.getInputExp().hasVarType(ExpCalculator.VarType.MachVt));

			assertTrue(cfield.getParameters().length == 5);
			
			assertTrue(cfield.getY0Exp().getRecList().length == 1);
			assertTrue(cfield.getY0Exp().hasVarType(ExpCalculator.VarType.MachEfd));

			/*
			public double ka = 10.0, ta = 0.5;
    		@AnControllerField(
            	type= "type.ControlBlock",
            	input="mach.speed - 1.0",
            	parameter={"type.NoLimit", "this.ka", "this.ta"},
            	y0="this.refPoint - this.gainBlock.u0"	)
    		DelayControlBlock delayBlock;
	
    		public double ks = 1.0, pmax = 1.2, pmin = 0.0;
    		@AnControllerField(
            	type= "type.StaticBlock",
            	input="this.refPoint - this.delayBlock.y",
            	parameter={"type.Limit", "this.ks", "this.pmax", "this.pmin"},
            	y0="mach.pm"	)
    		GainBlock gainBlock;
			*/
			CustomAnnotateGovernor gov = new CustomAnnotateGovernor();
			gov.initStates(mach.getDStabBus(), mach, null);
			
			assertTrue(gov.getBlock("delayBlock") != null);
			cfield = (ControlBlockField)(gov.getBlockField("delayBlock"));
			assertTrue(cfield.getInitOrder() == -1);
			assertTrue(cfield.getY0Exp().hasField("gainBlock"));

			assertTrue(gov.getBlock("gainBlock") != null);
			sfield = (StaticBlockField)(gov.getBlockField("gainBlock"));
			assertTrue(sfield.getInitOrder() == 1);
			assertTrue(sfield.getInputExp().hasField("delayBlock"));
			//System.out.println(gov.toString());

			/*
			public double k1 = 1.0, t1 = 0.05, t2 = 0.5;
    		@AnControllerField(
            	type= "type.ControlBlock",
            	input="mach.speed - this.refPoint",
            	parameter={"type.NoLimit", "this.k1", "this.t1", "this.t2"},
            	y0="this.filterBlock2.u0"	)
    		FilterControlBlock filterBlock1;
	
    		public double k2 = 1.0, t3 = 0.05, t4 = 0.25, vmax = 0.2, vmin = -0.2;
    		@AnControllerField(
            	type= "type.ControlBlock",
            	input="this.filterBlock1.y",
            	parameter={"type.Limit", "this.k2", "this.t3", "this.t4", "this.vmax", "this.vmin"},
            	y0="pss.vs"	)
    		FilterControlBlock filterBlock2;
			*/
			CustomAnnotateStabilizer pss = new CustomAnnotateStabilizer();
			pss.initStates(mach.getDStabBus(), mach, null);

			assertTrue(pss.getBlock("filterBlock1") != null);
			cfield = (ControlBlockField)(pss.getBlockField("filterBlock1"));
			assertTrue(cfield.getInitOrder() == 1);
			assertTrue(cfield.getY0Exp().hasField("filterBlock2"));

			assertTrue(pss.getBlock("filterBlock2") != null);
			cfield = (ControlBlockField)(pss.getBlockField("filterBlock2"));
			assertTrue(cfield.getInitOrder() == 2);
			assertTrue(cfield.getInputExp().hasField("filterBlock1"));
			//System.out.println(pss.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nEnd TestAnnotateParserCase Case1");
	}

	public void test_Case2() {
		System.out.println("\nBegin TestAnnotateParserCase Case2");

		Machine mach = createMachine();

		ControlBlockField cfield = null;
		StaticBlockField sfield = null;

		try {
			TestAnnotateStabilizer001 pss = new TestAnnotateStabilizer001();
			pss.initStates(mach.getDStabBus(), mach, null);

			assertTrue(pss.getBlock("gainBlock1") != null);
			sfield = (StaticBlockField)(pss.getBlockField("gainBlock1"));
			assertTrue(sfield.getInitOrder() == -2);

			assertTrue(pss.getBlock("gainBlock2") != null);
			sfield = (StaticBlockField)(pss.getBlockField("gainBlock2"));
			assertTrue(sfield.getInitOrder() == -1);
			
			assertTrue(pss.getBlock("filterBlock1") != null);
			cfield = (ControlBlockField)(pss.getBlockField("filterBlock1"));
			assertTrue(cfield.getInitOrder() == 1);
			assertTrue(cfield.getY0Exp().hasField("filterBlock2"));

			assertTrue(pss.getBlock("filterBlock2") != null);
			cfield = (ControlBlockField)(pss.getBlockField("filterBlock2"));
			assertTrue(cfield.getInitOrder() == 2);
			assertTrue(cfield.getInputExp().hasField("filterBlock1"));
			//System.out.println(pss.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nEnd TestAnnotateParserCase Case2");
	}
}
