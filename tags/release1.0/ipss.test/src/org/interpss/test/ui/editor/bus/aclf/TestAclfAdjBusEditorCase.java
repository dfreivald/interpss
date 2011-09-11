 /*
  * @(#)TestAclfAdjBusEditorCase.java   
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

package org.interpss.test.ui.editor.bus.aclf;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.interpss.editor.SimuAppSpringAppCtxUtil;
import org.interpss.editor.data.aclf.AclfBusData;
import org.interpss.editor.data.acsc.AcscBusData;
import org.interpss.editor.form.GBusForm;
import org.interpss.editor.ui.edit.NBBusEditDialog;
import org.interpss.test.ui.TestUIBase;
import org.interpss.test.ui.TestUI_UtilFunc;


import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.*;

public class TestAclfAdjBusEditorCase extends TestUIBase {
	public void testSimpleSaveCase() {
		System.out.println("TestAclfAdjBusEditorCase testSimpleSaveCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
					netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

		TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "pqRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "pvRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "swingRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "remoteQRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "capRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "nonGenRadioButton", true);

	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "constPRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "constIRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "constZRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "funcLoadRadioButton", true);
	    TestUI_UtilFunc.radioButtonStatus(finder, busEditor, "nonLoadRadioButton", true);
	    
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
	    assertTrue(netContainer.isDataDirty());
	    
		System.out.println("TestAclfAdjBusEditorCase testSimpleSaveCase end");
	}

	public void testRemoteQCase() {
		System.out.println("TestAclfAdjBusEditorCase testRemoteQCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

	    TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "remoteQRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qGenTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, busEditor, "maxTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "minTextField", "-1.0");
//	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", false);
	    
		JComboBox remoteBusComboBox = TestUI_UtilFunc.findComboBox(finder, busEditor, "remoteBusComboBox");
		remoteBusComboBox.setSelectedIndex(1);
		assertTrue(((String)remoteBusComboBox.getSelectedItem()).equals("Bus2(0002)"));
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PQ));
		assertTrue(data.isHasRemoteVControl());
		assertTrue(data.getGenP() == 1.0);
		assertTrue(data.getGenQ() == 0.0);
		assertTrue(data.getVoltageMag() == 1.05);
		assertTrue(data.getMaxGenQ() == 1.0);
		assertTrue(data.getMinGenQ() == -1.0);
		assertTrue(data.getRemoteControlBusId().equals("Bus2(0002)"));
		
		// launch editor again to check data population
		busEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PQ));
		assertTrue(data.isHasRemoteVControl());
		assertTrue(data.getGenP() == 1.0);
		assertTrue(data.getGenQ() == 0.0);
		assertTrue(data.getVoltageMag() == 1.05);
		assertTrue(data.getMaxGenQ() == 1.0);
		assertTrue(data.getMinGenQ() == -1.0);
		assertTrue(data.getRemoteControlBusId().equals("Bus2(0002)"));
		
		System.out.println("TestAclfAdjBusEditorCase testRemoteQCase end");
	}

	public void testPVBusCase() {
		System.out.println("TestAclfAdjBusEditorCase testPVBusCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

	    TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "pvRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qGenTextField", "1.05");
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", true);
	    TestUI_UtilFunc.checkBoxAction(finder, busEditor, "adjustCheckBox", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "maxTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "minTextField", true);
		TestUI_UtilFunc.setTextField(finder, busEditor, "maxTextField", "1.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "minTextField", "-1.0");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PV));
		assertTrue(data.getGenP() == 1.0);
		assertTrue(data.getVoltageMag() == 1.05);
		assertTrue(data.getMaxGenQ() == 1.0);
		assertTrue(data.getMinGenQ() == -1.0);

		// launch editor again to check data population
		busEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PV));
		assertTrue(data.getGenP() == 1.0);
		assertTrue(data.getVoltageMag() == 1.05);
		assertTrue(data.getMaxGenQ() == 1.0);
		assertTrue(data.getMinGenQ() == -1.0);

		System.out.println("TestAclfAdjBusEditorCase testPVBusCase end");
	}

	public void testPQBusCase() {
		System.out.println("TestAclfAdjBusEditorCase testPQBusCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

	    TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "pqRadioButton");
		TestUI_UtilFunc.setTextField(finder, busEditor, "pGenTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qGenTextField", "1.0");
	    TestUI_UtilFunc.checkBoxStatus(finder, busEditor, "adjustCheckBox", true);
	    TestUI_UtilFunc.checkBoxAction(finder, busEditor, "adjustCheckBox", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "maxTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "minTextField", true);
		TestUI_UtilFunc.setTextField(finder, busEditor, "maxTextField", "1.05");
		TestUI_UtilFunc.setTextField(finder, busEditor, "minTextField", "0.95");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PQ));
		assertTrue(data.getGenP() == 2.0);
		assertTrue(data.getGenQ() == 1.0);
		assertTrue(data.getMaxVoltMag() == 1.05);
		assertTrue(data.getMinVoltMag() == 0.95);

		// launch editor again to check data population
		busEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getGenCode().equals(AclfBusData.GenCode_PQ));
		assertTrue(data.getGenP() == 2.0);
		assertTrue(data.getGenQ() == 1.0);
		assertTrue(data.getMaxVoltMag() == 1.05);
		assertTrue(data.getMinVoltMag() == 0.95);

		System.out.println("TestAclfAdjBusEditorCase testPQBusCase end");
	}

	public void testFuncLoadBusCase() {
		System.out.println("TestAclfAdjBusEditorCase testFuncLoadBusCase begin");
		
		TestUI_UtilFunc.createTestingAclfAdjGNetForm(netContainer);
		GBusForm form = (GBusForm)netContainer.getGBusForm("0001");
		NBBusEditDialog busEditor = (NBBusEditDialog)SimuAppSpringAppCtxUtil.getBusDataEditor(
				netContainer, form, false);
		
		NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "");

	    TestUI_UtilFunc.radioButtonClickAction(finder, busEditor, "funcLoadRadioButton");
	    
		TestUI_UtilFunc.setTextField(finder, busEditor, "pLoadTextField", "2.0");
		TestUI_UtilFunc.setTextField(finder, busEditor, "qLoadTextField", "1.0");

		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "constP_PTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "constP_QTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "constI_PTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "constI_QTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "constZ_PTextField", true);
		TestUI_UtilFunc.setTextFieldStatus(finder, busEditor, "constZ_QTextField", true);

		TestUI_UtilFunc.setTextField(finder, busEditor, "constP_PTextField", "30");
		TestUI_UtilFunc.setTextField(finder, busEditor, "constP_QTextField", "50");
		TestUI_UtilFunc.setTextField(finder, busEditor, "constI_PTextField", "40");
		TestUI_UtilFunc.setTextField(finder, busEditor, "constI_QTextField", "30");
		TestUI_UtilFunc.setTextField(finder, busEditor, "constZ_PTextField", "30");
		TestUI_UtilFunc.setTextField(finder, busEditor, "constZ_QTextField", "20");
		
		finder.setName("saveButton");
		JButton saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );
		
		AcscBusData data = form.getAcscBusData();
		assertTrue(data.getLoadCode().equals(AclfBusData.LoadCode_FuncLoad));
		assertTrue(data.getLoadP() == 2.0);
		assertTrue(data.getLoadQ() == 1.0);
		assertTrue(data.getLoadP_PPct() == 30.0);
		assertTrue(data.getLoadQ_PPct() == 50.0);
		assertTrue(data.getLoadP_IPct() == 40.0);
		assertTrue(data.getLoadQ_IPct() == 30.0);

		// launch editor again to check data population
		busEditor.init(netContainer, form);
		finder.setName("saveButton");
		saveButton = ( JButton ) finder.find( busEditor, 0);
	    getHelper().enterClickAndLeave( new MouseEventData( this, saveButton ) );

		data = form.getAcscBusData();
		assertTrue(data.getLoadCode().equals(AclfBusData.LoadCode_FuncLoad));
		assertTrue(data.getLoadP() == 2.0);
		assertTrue(data.getLoadQ() == 1.0);
		assertTrue(data.getLoadP_PPct() == 30.0);
		assertTrue(data.getLoadQ_PPct() == 50.0);
		assertTrue(data.getLoadP_IPct() == 40.0);
		assertTrue(data.getLoadQ_IPct() == 30.0);
		assertTrue(data.getLoadP_PPct() == 30.0);
		assertTrue(data.getLoadQ_PPct() == 50.0);
		assertTrue(data.getLoadP_IPct() == 40.0);
		assertTrue(data.getLoadQ_IPct() == 30.0);

		System.out.println("TestAclfAdjBusEditorCase testFuncLoadBusCase end");
	}
}
