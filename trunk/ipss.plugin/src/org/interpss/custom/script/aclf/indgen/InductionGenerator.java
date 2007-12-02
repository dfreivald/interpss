 /*
  * @(#)InductionGenerator.java   
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
  * @Date 11/27/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.custom.script.aclf.indgen;

import org.interpss.custom.script.aclf.AbstractAclfBusScriptEditing;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;

// all AclfBus scripting plugin needs to extends AbstractAclfBusScriptEditing
public class InductionGenerator extends AbstractAclfBusScriptEditing {  
	/**
	 * Default constructor
	 */
	public InductionGenerator() {
		this("", "");
	}

	public InductionGenerator(String name, String desc) {
		super(name, desc);
		// set the plugin data object
		setData(new InductionGeneratorData());
		// set the plugin editor Pandel
		setEditPanel(new NBInductionGenEditPanel());
	}
	
	/**
     * Get the data object
     *
     * @return the data object
     */
    public InductionGeneratorData getData() {
        return (InductionGeneratorData)super.getData();
    }
    
    /*
     *  BaseAclfBus interface implementation
     */
    
    public boolean isGenPQ() { 
    	return true; 
    }
    
    public double getGenP() { 
    	return getData().getPe(); 
    }
    
    public double getGenQ() {
         double v = getParentAclfBus().getVoltageMag();
         double v2 = v * v;
         double xs = getData().getXs();
         double xm = getData().getXm();
         double pe = getData().getPe();
         double r  = getData().getR();
         double x = v2 * v2 - 4 * xs * xs * pe * pe;
         if (x >=0 ) {
        	 double s = r * (v2 - Math.sqrt(x)) / 2 / pe / xs / xs;
             return -(r * r + xs * (xm + xs) * s * s) * pe / s / r / xm;
         }
         else {
        	 IpssLogger.getLogger().warning("No solution for Induction Generator Q, bus id: " + getParentAclfBus().getId());
        	 return Constants.LargeBusZ.abs();
         }
    }
}