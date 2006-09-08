package org.interpss.test.ui.editor.proj;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.acsc.AcscNetData;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.ui.edit.NBProjectEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;

import org.interpss.editor.jgraph.ui.form.IGNetForm;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestProjEditorAcscCase extends TestUIBase {
	public void testCase() {
		System.out.println("TestProjEditorAcscCase testCase begin");
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "" );

		netContainer.getGNetForm().setNewState(true);
		NBProjectEditDialog projDialog = (NBProjectEditDialog)SimuAppSpringAppCtxUtil.getProjectDataEditor(
				netContainer, appSimuCtx.getProjData(), false);
		
//		TestUI_UtilFunc.setTextField(finder, projDialog, "projNameTextField", "My Project Name");
		TestUI_UtilFunc.setTextArea(finder, projDialog, "descTextArea", "My Project Desc");
		TestUI_UtilFunc.radioButtonClickAction(finder, projDialog, "acscNetRadioButton");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseKvaTextField", "100000.0");
		TestUI_UtilFunc.setTextField(finder, projDialog, "baseFreqTextField", "50");
//		TestUI_UtilFunc.checkBoxAction(finder, projDialog, "allowParalellBranchCheckBox", false);
		TestUI_UtilFunc.checkBoxAction(finder, projDialog, "includeLFCheckBox", true);

	    finder.setName( "adjustmentCheckBox" );
	    JCheckBox adjustmentCheckBox = ( JCheckBox ) finder.find( projDialog, 0 );
	    adjustmentCheckBox.setEnabled(true);
	    adjustmentCheckBox.setSelected(true);
	    
	    finder.setName("SaveButton");
	    JButton saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
		assertTrue(netContainer.isDataDirty());
		
//		assertTrue(appSimuCtx.getProjData().getProjectName().equals("My Project Name"));
//    	assertTrue(netContainer.getGNetForm().getId().equals("My Project Name"));
		assertTrue(appSimuCtx.getProjData().getDescription().equals("My Project Desc"));
		
		GNetForm form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Transmission));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_AcscNetwork));
		assertTrue(form.getBaseKVA() == 100000.0);
		assertTrue(form.getFreqHZ() == 50.0);
		assertTrue(!form.isAllowParallelBranch());

		AcscNetData data = form.getAcscNetData();
		assertTrue(data.isHasAdjustment());
		assertTrue(data.isHasAclfData());
		
		// launch the editor again
		projDialog.init(netContainer, appSimuCtx.getProjData());
		
	    finder.setName("SaveButton");
		saveButton = ( JButton ) finder.find( projDialog, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    
//		assertTrue(appSimuCtx.getProjData().getProjectName().equals("My Project Name"));
//    	assertTrue(netContainer.getGNetForm().getId().equals("My Project Name"));
		assertTrue(appSimuCtx.getProjData().getDescription().equals("My Project Desc"));
		
		form = (GNetForm)netContainer.getGNetForm();
		assertTrue(form.getAppType().equals(IGNetForm.AppType_Transmission));
		assertTrue(form.getNetType().equals(IGNetForm.NetType_AcscNetwork));
		assertTrue(form.getBaseKVA() == 100000.0);
		assertTrue(form.getFreqHZ() == 50.0);
		assertTrue(!form.isAllowParallelBranch());

		data = form.getAcscNetData();
		assertTrue(data.isHasAdjustment());
		assertTrue(data.isHasAclfData());

		System.out.println("TestProjEditorAcscCase testCase end");
	}
	
}

