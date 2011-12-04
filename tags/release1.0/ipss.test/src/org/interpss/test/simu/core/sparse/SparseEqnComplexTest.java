 /*
  * @(#)SparseEqnComplexTest.java   
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

package org.interpss.test.simu.core.sparse;

import org.apache.commons.math.complex.Complex;
import org.interpss.test.simu.TestBaseAppCtx;

import com.interpss.common.SpringAppContext;
import com.interpss.core.sparse.SparseEqnComplex;
import com.interpss.core.sparse.impl.SparseEqnComplexImpl;

/**
 * @author mzhou
 *
 */
public class SparseEqnComplexTest extends TestBaseAppCtx {
	public void testBegin() {
 		System.out.println("\n\nBegin com.interpss.core.sparse.test.SparseEqnComplexTest ...");
	}

	public void testLuMatrixAndSolveEqn() {
		SparseEqnComplex eqn = createSampleEqn();
		System.out.println(eqn.toString());
		try {
			eqn.luMatrixAndSolveEqn(1.0e-20, SpringAppContext.getIpssMsgHub());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		checkResult(eqn);
	}

	public void testSetB2Unit() {
		SparseEqnComplex eqn = createSampleEqn();
		eqn.setB2Unit(1);
		assertTrue((eqn.getBi(1).getReal()-1.0) < 0.0001);
		assertTrue(eqn.getBi(1).getImaginary() < 0.0001);
	}

	public void testSetBi() {
	}

	public void testReset() {
		SparseEqnComplex eqn = createSampleEqn();
		eqn.reset();
	}

	public void testSetToZero() {
		SparseEqnComplex eqn = createSampleEqn();
		eqn.setToZero();
		assertTrue(eqn.getBi(1).getReal() < 0.0001);
		assertTrue(eqn.getBi(1).getImaginary() < 0.0001);
	}

	public void testSolveEqn() {
		SparseEqnComplex eqn = createSampleEqn();
		try {
			eqn.luMatrix(1.0e-20, SpringAppContext.getIpssMsgHub());
			eqn.solveEqn(SpringAppContext.getIpssMsgHub());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		checkResult(eqn);
	}

	public void testTotalElements() {
		SparseEqnComplex eqn = createSampleEqn();
		assertTrue(eqn.getTotalElements()==4);
	}
	
	public void testEnd() {
 		System.out.println("End com.interpss.core.sparse.test.SparseEqnComplexTest");
	}
	
	public SparseEqnComplex createSampleEqn() {
		SparseEqnComplex eqn = new SparseEqnComplexImpl();
		eqn.setDimension(2);
		eqn.reset();

		Complex  a11 = new Complex( 1.0, 1.1 ),
			     a12 = new Complex( 3.1, 4.1 ),
			     a21 = new Complex( 2.1, 1.9 ),
			     a22 = new Complex( 3.0, 4.0 );
		eqn.addToAij( a11, 1, 1 );
		eqn.addToAij( a12, 1, 2 );
		eqn.addToAij( a21, 2, 1 );
		eqn.addToAij( a22, 2, 2 );

		Complex b1 = new Complex( 1.0, 2.0 ),
			     b2 = new Complex( 3.0, 4.0 );

		eqn.setBi( b1, 1 );
		eqn.setBi( b2, 2 );
		return eqn;
	}

	public void checkResult(SparseEqnComplex eqn) {
		Complex  a11 = new Complex( 1.0, 1.1 ),
                 a12 = new Complex( 3.1, 4.1 ),
                 a21 = new Complex( 2.1, 1.9 ),
                 a22 = new Complex( 3.0, 4.0 );

		Complex b1 = new Complex( 1.0, 2.0 ),
                b2 = new Complex( 3.0, 4.0 );
		Complex e1 = a11.multiply(eqn.getBi(1));
		e1 = e1.add( a12.multiply(eqn.getBi(2)) );
		e1 = e1.subtract(b1);
		Complex e2 = a21.multiply(eqn.getBi(1));
		e2 = e2.add( a22.multiply(eqn.getBi(2)) );
		e2 = e2.subtract(b2);

		assertEquals(true, (e1.abs()+e2.abs()) < 0.0001 );
	}
}