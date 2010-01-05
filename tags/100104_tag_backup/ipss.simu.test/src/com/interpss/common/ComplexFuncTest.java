 /*
  * @(#)ComplexFuncTest.java   
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
  * @Date 07/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package com.interpss.common;

import static org.junit.Assert.*;
import org.junit.*;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.ComplexFunc;
import com.interpss.common.datatype.Constants;
import com.interpss.common.util.TestUtilFunc;

public class ComplexFuncTest {
	/*
	public static Complex add(final Complex a, final Complex b )	{
	public static Complex add(final Complex a, final Complex b, final Complex c )	{
	*/	
	@Test
	public void addTest() {
		Complex a = new Complex(1.0, 2.0);
		Complex b = new Complex(1.0, 2.0);
		Complex c = new Complex(1.0, 2.0);
		assertTrue(TestUtilFunc.equal(ComplexFunc.add(a,b), new Complex(2.0, 4.0)));
		assertTrue(TestUtilFunc.equal(ComplexFunc.add(a,b,c), new Complex(3.0, 6.0)));
	}	
	
	/*
	public static Complex sub(final Complex a, final Complex b )	{
	*/	
	@Test
	public void subTest() {
		Complex a = new Complex(1.0, 2.0);
		Complex b = new Complex(2.0, 3.0);
		assertTrue(TestUtilFunc.equal(ComplexFunc.sub(a,b), new Complex(-1.0, -1.0)));
	}	

	/*
	public static Complex mul( final double d, final Complex c )	{
	public static Complex mul( final Complex d, final Complex c )	{
	*/	
	@Test
	public void mulTest() {
		Complex c = new Complex(1.0, 1.0);
		assertTrue(TestUtilFunc.equal(ComplexFunc.mul(2.0, c), new Complex(2.0, 2.0)));
		assertTrue(TestUtilFunc.equal(ComplexFunc.mul(c, c), new Complex(0.0, 2.0)));
	}	

	/*
	public static Complex div( final double d, final Complex c )	{
	public static Complex div( final Complex d, final Complex c )	{
	public static Complex div( final Complex c, final double d )	{
	*/	
	@Test
	public void divTest() {
		Complex c = new Complex(1.0, 1.0);
		assertTrue(TestUtilFunc.equal(ComplexFunc.div(2.0, c), new Complex(1.0, -1.0)));
		assertTrue(TestUtilFunc.equal(ComplexFunc.div(c, 2.0), new Complex(0.5, 0.5)));
		assertTrue(TestUtilFunc.equal(ComplexFunc.div(c, c), new Complex(1.0, 0.0)));
	}	
	
	/*
	public static Complex polar( final double mag, final double angle ) 	{
	*/	
	@Test
	public void polarTest() {
		assertTrue(TestUtilFunc.equal(ComplexFunc.polar(1.0, 0.0), new Complex(1.0, 0.0)));
	}	

	/*
	public static double arg(final Complex c) {
	*/	
	@Test
	public void argTest() {
		double ang = ComplexFunc.arg(new Complex(1.0, 1.0))*Constants.RtoD;
		assertTrue(TestUtilFunc.equal(ang, 45.0));
		ang = ComplexFunc.arg(new Complex(1.0, -1.0))*Constants.RtoD;
		assertTrue(TestUtilFunc.equal(ang, -45.0));
		ang = ComplexFunc.arg(new Complex(-1.0, 1.0))*Constants.RtoD;
		assertTrue(TestUtilFunc.equal(ang, 135.0));
		ang = ComplexFunc.arg(new Complex(-1.0, -1.0))*Constants.RtoD;
		assertTrue(TestUtilFunc.equal(ang, 225.0));
	}	

	/*
	public static boolean sameValue(final Complex a, final Complex b )	{
	*/	
	@Test
	public void sampleValueTest() {
		Complex c = new Complex(1.0, 0.0);
		assertTrue(ComplexFunc.sameValue(c, c));
	}	

	/*
	public createComplex(String str)
	*/	
	@Test
	public void stringConstructorTest() {
		Complex c = ComplexFunc.createComplex("1.0 + j2.0");
		assertTrue(ComplexFunc.sameValue(c, new Complex(1.0, 2.0)));

		c = ComplexFunc.createComplex("1.0+j2.0");
		assertTrue(ComplexFunc.sameValue(c, new Complex(1.0, 2.0)));

		c = ComplexFunc.createComplex("1.0");
		assertTrue(ComplexFunc.sameValue(c, new Complex(1.0, 0.0)));
		
		c = ComplexFunc.createComplex("j2.0");
		assertTrue(ComplexFunc.sameValue(c, new Complex(0.0, 2.0)));
	}	
}
