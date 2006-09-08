package org.interpss.test.ui.run.acsc;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppContext;
import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.proj.AcscCaseData;
import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.runAct.AcscRunForm;
import org.interpss.editor.ui.run.NBCaseInfoDialog;
import org.interpss.test.ui.TestUI_UtilFunc;
import org.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;


public class TestAcscCaseInfoCase extends TestCaseInfoBase {
	public void testSimpleRunCase() {
		System.out.println("TesAcscCaseInfoCase testSimpleRunCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm((GFormContainer)netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
		// click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());

	    ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		AcscCaseData acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
	    
		System.out.println("TesAcscCaseInfoCase testSimpleRunCase end");
	}
	
	public void testUnitVoltCase() {
		System.out.println("TesAcscCaseInfoCase testUnitVoltCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm((GFormContainer)netContainer);
		
	    NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "fixedVoltRadioButton");
	    TestUI_UtilFunc.setTextField(finder, caseDialog, "mFactorTextField", "90.0");

		// click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());

	    ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		AcscCaseData acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt));
		assertTrue(acscCaseData.getMFactor() == 90.0);
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt));
		assertTrue(acscCaseData.getMFactor() == 90.0);

		// lauch the editor again
		caseDialog.init(netContainer, appSimuCtx);
		// click the Run button
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_UnitVolt));
		assertTrue(acscCaseData.getMFactor() == 90.0);
		
		System.out.println("TesAcscCaseInfoCase testUnitVoltCase end");
	}
	
	public void testLFVoltCase() {
		System.out.println("TesAcscCaseInfoCase testLFVoltCase begin");

		TestUI_UtilFunc.createTestingAcscGNetForm((GFormContainer)netContainer);
		appSimuCtx.setLfConverged(true);
		
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_Acsc, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Acsc Analysis Case" has been created
		
	    TestUI_UtilFunc.radioButtonClickAction(finder, caseDialog, "loadflowVoltRadioButton");
	    
		// click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
		assertTrue(appSimuCtx.getProjData().isDirty());
	    assertTrue(caseDialog.isReturnOk());

	    ProjData projData = (ProjData)appSimuCtx.getProjData();
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		
		// At this point, we have two ways to access the AclfCaseData
		// 1: From the projData.caseList
		CaseData caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		AcscCaseData acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_LFVolt));
		
		// 2: through the current case hold by the AclfRunForm object
		AcscRunForm runForm = SimuAppSpringAppContext.getAcscRunForm();
		acscCaseData = runForm.getAcscCaseData();    
			// ref the current case data, which is the same as the one
			// hold by CaaseData
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_LFVolt));

		// lauch the editor again
		caseDialog.init(netContainer, appSimuCtx);
		// click the Run button
		finder.setName("runButton");		
	    runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );
	    
		assertTrue(projData.getAcscCaseName().equals("Acsc Analysis Case"));
		caseData = appSimuCtx.getCaseData("Acsc Analysis Case", CaseData.CaseType_Acsc);
		assertNotNull(caseData);
		acscCaseData = caseData.getAcscCaseData();
		assertNotNull(acscCaseData);
		assertTrue(acscCaseData.getBusInitVolt().equals(AcscCaseData.ScBusVolt_LFVolt));
		
		System.out.println("TesAcscCaseInfoCase testLFVoltCase end");
	}
}

