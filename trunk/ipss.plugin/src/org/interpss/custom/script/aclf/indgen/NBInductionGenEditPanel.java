 /*
  * @(#)InductionGeneratorData.java   
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

import java.util.Vector;

import org.interpss.numeric.util.Number2String;
import org.interpss.ui.ICustomPluginEditor;
import org.interpss.ui.SwingInputVerifyUtil;

public class NBInductionGenEditPanel extends javax.swing.JPanel implements ICustomPluginEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	InductionGeneratorData _data;

    public NBInductionGenEditPanel() {
        initComponents();

        // associate the editing fields with the verifier class defined at the end of this class
  		DataVerifier verifier = new DataVerifier();
  	    peTextField.setInputVerifier(verifier);
  	    rTextField.setInputVerifier(verifier);
  	    xsTextField.setInputVerifier(verifier);
  	    xmTextField.setInputVerifier(verifier);
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object data) {
		_data = (InductionGeneratorData)data;
	}
	
	/**
	*	Set plugin data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor(String desc) {
    	this.pluginInfoTextArea.setText("Plugin Description: " + desc);
  	    peTextField.setText(Number2String.toStr(_data.getPe(), "#0.00"));
  	    rTextField.setText(Number2String.toStr(_data.getR(), "#0.000"));
  	    xsTextField.setText(Number2String.toStr(_data.getXs(), "#0.00"));
  	    xmTextField.setText(Number2String.toStr(_data.getXm(), "#0.00"));
        return true;
	}
    
	/**
	*	Save editor screen data to the plugin data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector<String> errMsg) throws Exception {
    	errMsg.clear();
    	
		if (SwingInputVerifyUtil.within(this.peTextField, 0.0, 100.0, errMsg, 
				"Pe is out of the range [0.0, 100.0]"))
			_data.setPe(SwingInputVerifyUtil.getDouble(peTextField));

		if (SwingInputVerifyUtil.within(this.rTextField, 0.0, 100.0, errMsg,
				"R is out of the range [0.0, 100.0]"))
			_data.setR(SwingInputVerifyUtil.getDouble(rTextField));

    	if (SwingInputVerifyUtil.within(this.xsTextField, 0.0, 10.0, errMsg,
    			"Xs is out of the range [0.0, 20.0]"))
    		_data.setXs(SwingInputVerifyUtil.getDouble(xsTextField));

    	if (SwingInputVerifyUtil.within(this.xmTextField, 0.0, 10.0, errMsg,
    		"Vrmin is out of the range [0.0, 10.0]"))
    		_data.setXm(SwingInputVerifyUtil.getDouble(xmTextField));
		
    	return errMsg.size() == 0;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        peLabel = new javax.swing.JLabel();
        peTextField = new javax.swing.JTextField();
        rLabel = new javax.swing.JLabel();
        rTextField = new javax.swing.JTextField();
        xsLabel = new javax.swing.JLabel();
        xsTextField = new javax.swing.JTextField();
        xmLabel = new javax.swing.JLabel();
        xmTextField = new javax.swing.JTextField();
        textareaScrollPane = new javax.swing.JScrollPane();
        pluginInfoTextArea = new javax.swing.JTextArea();

        peLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        peLabel.setText("Pe");

        peTextField.setColumns(5);
        peTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        peTextField.setText("0.375");

        rLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        rLabel.setText("R");

        rTextField.setColumns(5);
        rTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        rTextField.setText("0.1");

        xsLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        xsLabel.setText("Xs");

        xsTextField.setColumns(5);
        xsTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        xsTextField.setText("0.2");

        xmLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        xmLabel.setText("Xm");

        xmTextField.setColumns(5);
        xmTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        xmTextField.setText("0.9");

        pluginInfoTextArea.setColumns(20);
        pluginInfoTextArea.setEditable(false);
        pluginInfoTextArea.setFont(new java.awt.Font("Dialog", 0, 12));
        pluginInfoTextArea.setLineWrap(true);
        pluginInfoTextArea.setRows(3);
        pluginInfoTextArea.setText("Plugin impl description");
        pluginInfoTextArea.setWrapStyleWord(true);
        textareaScrollPane.setViewportView(pluginInfoTextArea);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(83, 83, 83)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(peLabel)
                        .add(39, 39, 39)
                        .add(peTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(xsLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(xsTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(50, 50, 50)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(rLabel)
                        .add(45, 45, 45)
                        .add(rTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(xmLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(xmTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .add(textareaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 353, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(peLabel)
                    .add(peTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(rLabel)
                    .add(rTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(xsLabel)
                    .add(xsTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(xmLabel)
                    .add(xmTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27)
                .add(textareaScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel peLabel;
    private javax.swing.JTextField peTextField;
    private javax.swing.JTextArea pluginInfoTextArea;
    private javax.swing.JLabel rLabel;
    private javax.swing.JTextField rTextField;
    private javax.swing.JScrollPane textareaScrollPane;
    private javax.swing.JLabel xmLabel;
    private javax.swing.JTextField xmTextField;
    private javax.swing.JLabel xsLabel;
    private javax.swing.JTextField xsTextField;
    // End of variables declaration//GEN-END:variables

    // define data validation rules
	class DataVerifier extends javax.swing.InputVerifier {
    	@Override
		public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == peTextField ||
             		 input == rTextField ||
             		 input == xsTextField ||
             		 input == xmTextField )
    	       		return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}