 /*
  * @(#)TestProjEditorCancelCase.java   
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

package org.interpss.test.ui.editor.proj;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.ui.edit.NBProjectEditDialog;
import org.interpss.test.ui.TestUIBase;


import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestProjEditorCancelCase extends TestUIBase {
	public void testCancelCase() {
		System.out.println("TestProjEditorCase testCancelCase begin");
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "CancelButton" );
		
		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer, appSimuCtx.getProjData(), false);
		
		JButton cancelButton = ( JButton ) finder.find( projDialog, 0);
		assertNotNull( "Could not find the Cancel button", cancelButton );
		
		getHelper().enterClickAndLeave( new MouseEventData( this, cancelButton ) );
		
		System.out.println("TestProjEditorCase testCancelCase end");
	}
}

