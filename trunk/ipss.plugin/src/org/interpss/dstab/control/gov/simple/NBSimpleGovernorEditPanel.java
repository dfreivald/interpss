 /*
  * @(#)NBSimpleGovernorEditPanel.java   
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

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Number2String;

public class NBSimpleGovernorEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;
	
	SimpleGovernorData _data;

    /** Creates new form FaultLocDataPanel */
    public NBSimpleGovernorEditPanel() {
        initComponents();

  		DataVerifier verifier = new DataVerifier();
  	    kTextField.setInputVerifier(verifier);
  	    t1TextField.setInputVerifier(verifier);
  	    pmaxTextField.setInputVerifier(verifier);
  	    pminTextField.setInputVerifier(verifier);
  	}
    
	public void init(Object controller) {
		_data = ((SimpleGovernor)controller).getData();
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    kTextField.setText(Number2String.toStr(_data.getK(), "#0.00"));
  	    t1TextField.setText(Number2String.toStr(_data.getT1(), "#0.00"));
  	    pmaxTextField.setText(Number2String.toStr(_data.getPmax(), "#0.00"));
  	    pminTextField.setText(Number2String.toStr(_data.getPmin(), "#0.00"));
  	    
        return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector<String> errMsg) throws Exception {
		boolean ok = true;
		
		if (!SwingInputVerifyUtil.largeThan(this.kTextField, 0.0d)) {
			errMsg.add("K <= 0.0");
			ok = false;
		}
		_data.setK(SwingInputVerifyUtil.getDouble(kTextField));
    	
		if (!SwingInputVerifyUtil.largeThan(this.t1TextField, 0.0d)) {
			errMsg.add("T1 <= 0.0");
			ok = false;
		}		
		_data.setT1(SwingInputVerifyUtil.getDouble(t1TextField));
    	
		if (!SwingInputVerifyUtil.largeThan(this.pmaxTextField, 0.0d)) {
			errMsg.add("Pmax <= 0.0");
			ok = false;
		}
		_data.setPmax(SwingInputVerifyUtil.getDouble(pmaxTextField));
    	
		if (!SwingInputVerifyUtil.largeEqualThan(this.pminTextField, 0.0d)) {
			errMsg.add("Pmin <= 0.0");
			ok = false;
		}
		_data.setPmin(SwingInputVerifyUtil.getDouble(pminTextField));
    	
		if (_data.getPmax() <= _data.getPmin()) {
			errMsg.add("Pmax <= Pmin");
			ok = false;
		}
		return ok;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        kLabel = new javax.swing.JLabel();
        kTextField = new javax.swing.JTextField();
        t1Label = new javax.swing.JLabel();
        t1TextField = new javax.swing.JTextField();
        pmaxLabel = new javax.swing.JLabel();
        pmaxTextField = new javax.swing.JTextField();
        pminLabel = new javax.swing.JLabel();
        pminTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        kLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kLabel.setText("K(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(kLabel, gridBagConstraints);

        kTextField.setColumns(5);
        kTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(kTextField, gridBagConstraints);

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setText("T1(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(t1Label, gridBagConstraints);

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setText("0.5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t1TextField, gridBagConstraints);

        pmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pmaxLabel.setText("Pmax(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(pmaxLabel, gridBagConstraints);

        pmaxTextField.setColumns(5);
        pmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pmaxTextField.setText("1.5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(pmaxTextField, gridBagConstraints);

        pminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        pminLabel.setText("Pmin(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(pminLabel, gridBagConstraints);

        pminTextField.setColumns(5);
        pminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        pminTextField.setText("0.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(pminTextField, gridBagConstraints);

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
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
    			if ( input == kTextField ||
                	 input == t1TextField ||
                	 input == pmaxTextField ||
                	 input == pminTextField )
       	       		return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
       	    } catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
