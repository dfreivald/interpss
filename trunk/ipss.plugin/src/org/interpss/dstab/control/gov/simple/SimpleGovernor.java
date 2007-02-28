 /*
  * @(#)SimpleGovernor.java   
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

package org.interpss.dstab.control.gov.simple;

import java.lang.reflect.Field;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.controller.annotate.AnController;
import com.interpss.dstab.controller.annotate.AnControllerField;
import com.interpss.dstab.controller.annotate.AnnotateGovernor;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.GainBlock;
import com.interpss.dstab.mach.Controller;
import com.interpss.dstab.mach.Machine;

@AnController(
        input="mach.speed - 1.0",
        output="this.gainBlock.y",
        refPoint="this.gainBlock.u0 + this.delayBlock.y",
        display= {"str.Pm, this.output", "str.GovState, this.delayBlock.state"})
public class SimpleGovernor extends AnnotateGovernor {
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
 	
    // UI Editor panel
    private static NBSimpleGovernorEditPanel _editPanel = new NBSimpleGovernorEditPanel();
    
    /**
     * Default Constructor
     *
     */
    public SimpleGovernor() {
        this("govId", "govName", "InterPSS");
    }
    
    /**
     * Constructor
     *
     * @param id excitor id
     * @param name excitor name
     */
    public SimpleGovernor(String id, String name, String caty) {
        super(id, name, caty);
        // _data is defined in the parent class. However init it here is a MUST
        _data = new SimpleGovernorData();
    }
    
    /**
     * Get the excitor data
     *
     * @return the data object
     */
    public SimpleGovernorData getData() {
        return (SimpleGovernorData)_data;
    }
    
    /**
     *  Init the controller states
     *
     *  @param msg the SessionMsg object
     */
    public boolean initStates(DStabBus bus, Machine mach, IPSSMsgHub msg) {
        this.ka = getData().getK();
        this.ta = getData().getT1();
        this.pmax = getData().getPmax();
        this.pmin = getData().getPmin();
        return super.initStates(bus, mach, msg);
    }

    /**
     * Get the editor panel for controller data editing
     *
     * @return the editor panel object
     */
    public Object getEditPanel() {
        _editPanel.init(this);
        return _editPanel;
    }
 
    public AnController getAnController() {
    	return (AnController)getClass().getAnnotation(AnController.class);  }
    public double getDoubleField(String fieldName) throws Exception {
    	Field field = getClass().getField(fieldName);
    	return ((Double)field.get(this)).doubleValue();   }
    public Controller getControllerField(Field field) throws Exception {
    	return (Controller)field.get(this);    }
} // SimpleGovernor
