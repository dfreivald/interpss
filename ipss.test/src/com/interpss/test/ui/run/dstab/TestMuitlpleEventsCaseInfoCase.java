package com.interpss.test.ui.run.dstab;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.interpss.common.util.IpssLogger;
import com.interpss.editor.app.AppSimuContextImpl;
import com.interpss.editor.data.acsc.AcscFaultData;
import com.interpss.editor.data.dstab.DStabDEventData;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.data.proj.DStabCaseData;
import com.interpss.editor.ui.SimuAppSpringAppCtxUtil;
import com.interpss.editor.ui.run.NBCaseInfoDialog;
import com.interpss.test.ui.TestUI_UtilFunc;
import com.interpss.test.ui.run.TestCaseInfoBase;

import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestMuitlpleEventsCaseInfoCase extends TestCaseInfoBase {

	public void testAddDeleteEventCase() {
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddDeleteEventCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);

	    AppSimuContextImpl appSimuCtx = (AppSimuContextImpl)editor.getAppSimuContext();
	    
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		finder.setName("detailInfoTabbedPane");
		JTabbedPane detailInfoTabbedPane = ( JTabbedPane ) finder.find( caseDialog, 0);
		detailInfoTabbedPane.setSelectedIndex(0);
		IpssLogger.getLogger().info("The Dynamic Events Panel selected");
		
		// At this point, a "A Dynamic Event" created
		finder.setName("eventListComboBox");
		JComboBox eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		eventListComboBox.setSelectedIndex(0);
		eventListComboBox.setSelectedItem("My First Event Case");
	    
		// Add a event, name "A Dynamic Event"
		finder.setName("addEventButton");		
	    JButton addEventButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addEventButton ) );
		assertTrue(eventListComboBox.getItemCount() == 2);
		eventListComboBox.setSelectedIndex(1);
		assertTrue(((String)eventListComboBox.getSelectedItem()).equals("A Dynamic Event"));
		eventListComboBox.setSelectedItem("My 2nd Event Case");
		
		// click the Cancel button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

		CaseData caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		DStabCaseData dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		DStabDEventData event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);

		event = dstabCaseData.getDEventData("My 2nd Event Case");
		assertNotNull(event);
	    
		// launch the Dialog again
		caseDialog.init(netContainer, editor.getAppCtx());

		finder.setName("eventListComboBox");
		eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		assertTrue(eventListComboBox.getItemCount() == 2);

		eventListComboBox.setSelectedIndex(1);
		System.out.println("Delete event: " + eventListComboBox.getSelectedItem());
		finder.setName("deleteEventButton");		
	    JButton deleteEventButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, deleteEventButton ) );
		assertTrue(eventListComboBox.getItemCount() == 1);

		eventListComboBox.setSelectedIndex(0);
		System.out.println("Remaining event: " + eventListComboBox.getSelectedItem());

		caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddDeleteEventCase end");
	}

	public void testAddSaveEventCase() {
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddSaveEventCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);
		
	    AppSimuContextImpl appSimuCtx = (AppSimuContextImpl)editor.getAppSimuContext();
	    
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		finder.setName("detailInfoTabbedPane");
		JTabbedPane detailInfoTabbedPane = ( JTabbedPane ) finder.find( caseDialog, 0);
		detailInfoTabbedPane.setSelectedIndex(0);
		IpssLogger.getLogger().info("The Dynamic Events Panel selected");
		
		// At this point, a "A Dynamic Event" created
		finder.setName("eventListComboBox");
		JComboBox eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		eventListComboBox.setSelectedIndex(0);
		eventListComboBox.setSelectedItem("My First Event Case");
		
		// edit 1st event data
		finder.setName( "stratTimeTextField" );
		JTextField stratTimeTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    stratTimeTextField.setText("0.1");	
	    
	    finder.setName( "durationTextField" );
	    JTextField durationTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    durationTextField.setText("1.0");	
	    
	    finder.setName( "permanetCheckBox" );
	    JCheckBox permanetCheckBox = ( JCheckBox ) finder.find( caseDialog, 0 );
	    permanetCheckBox.setSelected(false);
	    
	    // Save the 1st event data
		finder.setName("saveEventButton");		
		JButton saveEventButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveEventButton ) );
	    
		// Add a event, name "A Dynamic Event"
		finder.setName("addEventButton");		
	    JButton addEventButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addEventButton ) );
		assertTrue(eventListComboBox.getItemCount() == 2);
		eventListComboBox.setSelectedIndex(1);
		assertTrue(((String)eventListComboBox.getSelectedItem()).equals("A Dynamic Event"));
		// change the event name
		eventListComboBox.setSelectedItem("My 2nd Event Case");

		// edit 2nd event data
		finder.setName( "stratTimeTextField" );
		stratTimeTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    stratTimeTextField.setText("0.0");	
	    
	    finder.setName( "durationTextField" );
	    durationTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    durationTextField.setText("0.1");	
	    
	    finder.setName( "permanetCheckBox" );
	    permanetCheckBox = ( JCheckBox ) finder.find( caseDialog, 0 );
	    permanetCheckBox.setSelected(true);
	    
	    // no need to Save the 2st event data, the Run will save the data

	    // click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

	    CaseData caseData = appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		DStabCaseData dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		
		DStabDEventData event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getStartTime() == 0.1);
		assertTrue(event.getDuration() == 1.0);
		assertTrue(!event.isPermanent());
		
		event = dstabCaseData.getDEventData("My 2nd Event Case");
		assertNotNull(event);
		assertTrue(event.getStartTime() == 0.0);
		assertTrue(event.getDuration() == 0.1);
		assertTrue(event.isPermanent());
		
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddSaveEventCase end");
	}

	public void testAddSaveFaultEventCase() {
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddSaveFaultEventCase begin");

		TestUI_UtilFunc.createTestingDStabGNetForm(netContainer);
		
	    AppSimuContextImpl appSimuCtx = (AppSimuContextImpl)editor.getAppSimuContext();
	    
		NBCaseInfoDialog caseDialog = (NBCaseInfoDialog)SimuAppSpringAppCtxUtil.getCaseInfoDialog(
				CaseData.CaseType_DStab, netContainer, appSimuCtx, false);

		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "casenameComboBox" );
		JComboBox casenameComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		casenameComboBox.setSelectedIndex(0); // at this point, a case "Transient Stability Case" has been created
	
		finder.setName("detailInfoTabbedPane");
		JTabbedPane detailInfoTabbedPane = ( JTabbedPane ) finder.find( caseDialog, 0);
		detailInfoTabbedPane.setSelectedIndex(0);
		IpssLogger.getLogger().info("The Dynamic Events Panel selected");
		
		// At this point, a "A Dynamic Event" created
		finder.setName("eventListComboBox");
		JComboBox eventListComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		eventListComboBox.setSelectedIndex(0);
		eventListComboBox.setSelectedItem("My First Event Case");
		
		// edit 1st event data
	    finder.setName( "busFaultRadioButton" );
	    JRadioButton busFaultRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    busFaultRadioButton.doClick();
	    
	    finder.setName( "faultBusComboBox" );
		JComboBox faultBusComboBox = ( JComboBox ) finder.find( caseDialog, 0);
		faultBusComboBox.setSelectedIndex(1); 
	    System.out.println(faultBusComboBox.getSelectedItem());
	    
	    finder.setName( "type3PRadioButton" );
	    JRadioButton type3PRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    type3PRadioButton.doClick(); 
	    
	    finder.setName( "rLGTextField" );
	    JTextField rLGTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    rLGTextField.setText("0.1");
	    
	    finder.setName( "xLGTextField" );
	    JTextField xLGTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    xLGTextField.setText("0.2");
	    
	    // Save the 1st event data
		finder.setName("saveEventButton");		
		JButton saveEventButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveEventButton ) );
	    
		// Add a event, name "A Dynamic Event"
		finder.setName("addEventButton");		
	    JButton addEventButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, addEventButton ) );
		eventListComboBox.setSelectedIndex(1);
		eventListComboBox.setSelectedItem("My 2nd Event Case");

		// edit 1st event data
	    finder.setName( "branchFaultRadioButton" );
	    JRadioButton branchFaultRadioButton = ( JRadioButton ) finder.find( caseDialog, 0 );
	    branchFaultRadioButton.doClick();
	    
	    finder.setName( "distanceTextField" );
	    JTextField distanceTextField = ( JTextField ) finder.find( caseDialog, 0 );
	    distanceTextField.setText("50.0");
		
	    // no need to Save the 2st event data

	    // click the Run button
		finder.setName("runButton");		
	    JButton runButton = ( JButton ) finder.find( caseDialog, 0 );
	    getHelper().enterClickAndLeave( new MouseEventData( this, runButton ) );

	    CaseData caseData =appSimuCtx.getCaseData("Transient Stability Case", CaseData.CaseType_DStab);
		assertNotNull(caseData);
		DStabCaseData dstabCaseData = caseData.getDStabCaseData();
		assertNotNull(dstabCaseData);
		
		DStabDEventData event = dstabCaseData.getDEventData("My First Event Case");
		assertNotNull(event);
		assertTrue(event.getFaultData().getType().equals(AcscFaultData.FaultType_Bus));
		assertTrue(event.getFaultData().getBusId().equals("0002"));
		assertTrue(event.getFaultData().getCategory().equals(AcscFaultData.FaultCaty_3P));
		assertTrue(event.getFaultData().getLG_R() == 0.1);
		assertTrue(event.getFaultData().getLG_X() == 0.2);
		
		event = dstabCaseData.getDEventData("My 2nd Event Case");
		assertNotNull(event);
		assertTrue(event.getFaultData().getType().equals(AcscFaultData.FaultType_Branch));
		assertTrue(event.getFaultData().getBusId().equals("0001->0002"));
		assertTrue(event.getFaultData().getDistance() == 50.0);
		
		System.out.println("TestMuitlpleEventsCaseInfoCase testAddSaveFaultEventCase end");
	}
}

