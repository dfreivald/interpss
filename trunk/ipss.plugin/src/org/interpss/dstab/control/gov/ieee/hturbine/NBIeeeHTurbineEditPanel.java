 /*
  * @(#)NBIeeeHTurbineEditPanel.java   
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

package org.interpss.dstab.control.gov.ieee.hturbine;

import java.util.Vector;

import org.interpss.dstab.control.base.EditUtilFunct;

import com.interpss.common.ui.IControllerEditor;

public class NBIeeeHTurbineEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	IeeeHTurbineGovernorData _data;

    /** Creates new form FaultLocDataPanel */
    public NBIeeeHTurbineEditPanel() {
        initComponents();
        // init the field to the default values
        _data = new IeeeHTurbineGovernorData();
        setData2Editor();
        
        // associate the editing fields with the verifier class defined at the end of this calss
  		DataVerifier verifier = new DataVerifier();
  	    kTextField.setInputVerifier(verifier);
  	    t1TextField.setInputVerifier(verifier);
  	    t2TextField.setInputVerifier(verifier);
  	    t3TextField.setInputVerifier(verifier);
  	    pmaxTextField.setInputVerifier(verifier);
  	    pminTextField.setInputVerifier(verifier);
  	    twTextField.setInputVerifier(verifier);
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object controller) {
		// init the data object from the bus object being edited
		_data = ((IeeeHTurbineGovernor)controller).getData();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
    	EditUtilFunct.setDblTextFiled(kTextField, 	_data.getK(), "#0.00");
    	EditUtilFunct.setDblTextFiled(t1TextField, 	_data.getT1(), "#0.000");
    	EditUtilFunct.setDblTextFiled(t2TextField, 	_data.getT2(), "#0.000");
    	EditUtilFunct.setDblTextFiled(t3TextField, 	_data.getT3(), "#0.000");
    	EditUtilFunct.setDblTextFiled(pmaxTextField, 	_data.getPmax(), "#0.000");
    	EditUtilFunct.setDblTextFiled(pminTextField, 	_data.getPmin(), "#0.000");
    	EditUtilFunct.setDblTextFiled(twTextField, 	_data.getTw(), "#0.000");

    	return true;
	}
    
	/**
	*	Save editor screen data to the controller data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
    	errMsg.clear();
    	
    	EditUtilFunct.saveDblTextField(_data, kTextField, "k", errMsg);
    	EditUtilFunct.saveDblTextField(_data, t1TextField, "t1", errMsg);
    	EditUtilFunct.saveDblTextField(_data, t2TextField, "t2", errMsg);
    	EditUtilFunct.saveDblTextField(_data, t3TextField, "t3", errMsg);
    	EditUtilFunct.saveDblTextField(_data, pmaxTextField, "pmax", errMsg);
    	EditUtilFunct.saveDblTextField(_data, pminTextField, "pmin", errMsg);
    	EditUtilFunct.saveDblTextField(_data, twTextField, "tw", errMsg);

    	return errMsg.size() == 0;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        kLabel = new javax.swing.JLabel();
        kTextField = new javax.swing.JTextField();
        t1Label = new javax.swing.JLabel();
        t1TextField = new javax.swing.JTextField();
        t2Label = new javax.swing.JLabel();
        t2TextField = new javax.swing.JTextField();
        t3Label = new javax.swing.JLabel();
        t3TextField = new javax.swing.JTextField();
        pmaxLabel = new javax.swing.JLabel();
        pmaxTextField = new javax.swing.JTextField();
        pminLabel = new javax.swing.JLabel();
        pminTextField = new javax.swing.JTextField();
        twLabel = new javax.swing.JLabel();
        twTextField = new javax.swing.JTextField();

        kLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kLabel.setText("K(pu)");

        kTextField.setColumns(5);
        kTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kTextField.setText("0.0");

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setText("T1(s)");

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setText("0.0");

        t2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t2Label.setText("T2(s)");

        t2TextField.setColumns(5);
        t2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t2TextField.setText("0.0");

        t3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t3Label.setText("T3(s)");

        t3TextField.setColumns(5);
        t3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t3TextField.setText("0.0");

        pmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pmaxLabel.setText("Pmax(pu)");

        pmaxTextField.setColumns(5);
        pmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pmaxTextField.setText("0.0");

        pminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pminLabel.setText("Pmin(pu)");

        pminTextField.setColumns(5);
        pminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pminTextField.setText("0.0");

        twLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        twLabel.setText("Tw(s)");

        twTextField.setColumns(5);
        twTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        twTextField.setText("0.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(45, 45, 45)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(kLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, twLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, t3Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, twTextField, 0, 0, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, t3TextField, 0, 0, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, kTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(55, 55, 55)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(t1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pmaxLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pmaxTextField, 0, 0, Short.MAX_VALUE))
                    .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(46, 46, 46)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .add(t2Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, t2TextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .add(pminTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .add(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(t2TextField)
                            .add(t2Label))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(pminTextField)
                            .add(pminLabel)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(t1TextField)
                                .add(t1Label))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(kTextField)
                                .add(kLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pmaxTextField)
                            .add(t3TextField)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(t3Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(pmaxLabel)))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(twTextField)
                            .add(twLabel))))
                .add(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kLabel;
    private javax.swing.JTextField kTextField;
    private javax.swing.JLabel pmaxLabel;
    private javax.swing.JTextField pmaxTextField;
    private javax.swing.JLabel pminLabel;
    private javax.swing.JTextField pminTextField;
    private javax.swing.JLabel t1Label;
    private javax.swing.JTextField t1TextField;
    private javax.swing.JLabel t2Label;
    private javax.swing.JTextField t2TextField;
    private javax.swing.JLabel t3Label;
    private javax.swing.JTextField t3TextField;
    private javax.swing.JLabel twLabel;
    private javax.swing.JTextField twTextField;
    // End of variables declaration//GEN-END:variables

    // define data validation rules
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == kTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "k");
    			if ( input == t1TextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "t1");
    			if ( input == t2TextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "t2");
    			if ( input == t3TextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "t3");
    			if ( input == pmaxTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "pmax");
    			if ( input == pminTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "pmin");
    			if ( input == twTextField)
    				return EditUtilFunct.checkDblDataRange(input, _data, "tw");
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
