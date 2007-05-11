 /*
  * @(#)Ieee1992PSS1AStabilizer.java   
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


package org.interpss.dstab.control.pss.ieee.y1992.pss1a;

import java.lang.reflect.Field;

import com.interpss.common.func.CMLFieldType;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.dstab.DStabBus;
import com.interpss.dstab.controller.annotate.AnController;
import com.interpss.dstab.controller.annotate.AnControllerField;
import com.interpss.dstab.controller.annotate.AnnotateStabilizer;
import com.interpss.dstab.controller.block.DelayControlBlock;
import com.interpss.dstab.controller.block.FilterControlBlock;
import com.interpss.dstab.controller.block.TFunc2ndOrderBlock;
import com.interpss.dstab.controller.block.WashoutControlBlock;
import com.interpss.dstab.mach.Machine;

@AnController(
        input="mach.speed",
        output="this.filterBlock2.y",
        refPoint="1.0",
        display= {})
public class Ieee1992PSS1AStabilizer extends AnnotateStabilizer {
	    public double one = 1.0, t6 = 0.05;
	    @AnControllerField(
	            type= CMLFieldType.ControlBlock,
	            input="mach.speed - this.refPoint",
	            parameter={"type.NoLimit", "this.one", "this.t6"},
	            y0="this.washoutBlock.u0"	)
	    DelayControlBlock delayBlock;

	    public double ks = 1.0, t5 = 0.1;
	    @AnControllerField(
	            type= CMLFieldType.ControlBlock,
	            input="this.delayBlock.y",
	            parameter={"type.NoLimit", "this.ks", "this.t5"},
	            y0="this.order2ndBlock.u0"	)
	    WashoutControlBlock washoutBlock;

	    public double a1 = 0.05, a2 = 0.5;
	    @AnControllerField(
	            type= CMLFieldType.ControlBlock,
	            input="this.washoutBlock.y",
	            parameter={"type.NoLimit", "this.one", "this.a1", "this.a2"},
	            y0="this.filterBlock1.u0"	)
	    TFunc2ndOrderBlock order2ndBlock;

	    public double k1 = 10.0, t1 = 0.05, t2 = 0.5;
	    @AnControllerField(
	            type= CMLFieldType.ControlBlock,
	            input="this.order2ndBlock.y",
	            parameter={"type.NoLimit", "this.k1", "this.t1", "this.t2"},
	            y0="this.filterBlock2.u0"	)
	    FilterControlBlock filterBlock1;
		
	    public double k2 = 1.0, t3 = 0.05, t4 = 0.25, vmax = 0.2, vmin = -0.2;
	    @AnControllerField(
	            type= CMLFieldType.ControlBlock,
	            input="this.filterBlock1.y",
	            parameter={"type.Limit", "this.k2", "this.t3", "this.t4", "this.vmax", "this.vmin"},
	            y0="pss.vs"	)
	    FilterControlBlock filterBlock2;

	// UI Editor panel
	private static final NBIeee1992PSS1AEditPanel _editPanel = new NBIeee1992PSS1AEditPanel();
	
	public Ieee1992PSS1AStabilizer() {
		this("pssId", "SimpleStabilizer", "InterPSS");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id pss id
	 * @param name pss name
	 */	
	public Ieee1992PSS1AStabilizer(final String id, final String name, final String caty) {
		super(id, name, caty);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new Ieee1992PSS1AStabilizerData();
	}
	
	/**
	 * Get the PSS data 
	 * 
	 * @return the data object
	 */
	public Ieee1992PSS1AStabilizerData getData() {
		return (Ieee1992PSS1AStabilizerData)_data;
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public boolean initStates(DStabBus abus, Machine mach, final IPSSMsgHub msg) {
        this.k1 = getData().getKs();
        this.t1 = getData().getT1();
        this.t2 = getData().getT2();
        this.t3 = getData().getT3();
        this.t4 = getData().getT4();
        this.vmax = getData().getVstmax();
        this.vmin = getData().getVstmin();
        return super.initStates(abus, mach, msg);
	}

	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */	
	@Override
	public Object getEditPanel() {
		_editPanel.init(this);
		return _editPanel;
	}
	
    public AnController getAnController() {
    	return (AnController)getClass().getAnnotation(AnController.class);  }
    public Field getField(String fieldName) throws Exception {
    	return getClass().getField(fieldName);   }
    public Object getFieldObject(Field field) throws Exception {
    	return field.get(this);    }

} // SimpleStabilizer
