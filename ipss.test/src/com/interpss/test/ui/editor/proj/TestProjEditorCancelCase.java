package com.interpss.test.ui.editor.proj;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.edit.NBProjectEditDialog;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestProjEditorCancelCase extends TestProjEditorBase {
	public void testCancelCase() {
		System.out.println("TestProjEditorCase testCancelCase begin");
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "CancelButton" );
		
		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer, editor.getAppSimuContext().getProjData(), false);
		
		JButton cancelButton = ( JButton ) finder.find( projDialog, 0);
		assertNotNull( "Could not find the Cancel button", cancelButton );
		
		getHelper().enterClickAndLeave( new MouseEventData( this, cancelButton ) );
		
		System.out.println("TestProjEditorCase testCancelCase end");
	}
}

