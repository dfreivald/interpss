/*
 * @(#)LowValueExpFunction.java   
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
 * @Date 10/30/2006
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.dstab.control.cml.func;

/**
 * A function to select high input value y = max[u1Expression, u2Expression]. u1, u2 are expression of
 * system variables, for example, "mach.vt - this.delay.y" 
 * 
 * @author mzhou
 *
 */

public class LowValueExpFunction extends GateValueExpFunction {
	/**
	 * Calculate input from the output value
	 * 
	 * @return input u
	 */
	@Override
	public double getU(double y) throws Exception {
		return y;
	}

	/**
	 * evaluate function value based on the input 2D double array. The array matches the input expression list
	 *
	 * @param dAry2D contains two arrays [u1Ary, u2Ary]
	 * @return the function value
	 */
	public double eval(double[][] dAry2D) throws Exception {
		return eval(dAry2D, false);
	}
}
