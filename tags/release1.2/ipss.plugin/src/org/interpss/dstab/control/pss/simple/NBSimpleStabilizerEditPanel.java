 /*
  * @(#)NBSimpleStabilizerEditPanel.java   
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


package org.interpss.dstab.control.pss.simple;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Number2String;

public class NBSimpleStabilizerEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;
	
	SimpleStabilizerData _data;

    /** Creates new form FaultLocDataPanel */
    public NBSimpleStabilizerEditPanel() {
        initComponents();

  		DataVerifier verifier = new DataVerifier();
  	    ksTextField.setInputVerifier(verifier);
  	    t1TextField.setInputVerifier(verifier);
  	    t2TextField.setInputVerifier(verifier);
  	    t3TextField.setInputVerifier(verifier);
  	    t4TextField.setInputVerifier(verifier);
  	    vsmaxTextField.setInputVerifier(verifier);
  	    vsminTextField.setInputVerifier(verifier);  		
    }
    
	public void init(Object controller) {
		_data = ((SimpleStabilizer)controller).getData();
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    ksTextField.setText(Number2String.toStr(_data.getKs(), "#0.00"));
  	    t1TextField.setText(Number2String.toStr(_data.getT1(), "#0.000"));
  	    t2TextField.setText(Number2String.toStr(_data.getT2(), "#0.000"));
  	    t3TextField.setText(Number2String.toStr(_data.getT3(), "#0.000"));
  	    t4TextField.setText(Number2String.toStr(_data.getT4(), "#0.000"));
  	    vsmaxTextField.setText(Number2String.toStr(_data.getVsmax(), "#0.00"));
  	    vsminTextField.setText(Number2String.toStr(_data.getVsmin(), "#0.00"));
  	    
        return true;
	}
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
		boolean ok = true;
		
		if (!SwingInputVerifyUtil.largeThan(this.ksTextField, 0.0d)) {
			errMsg.add("Ks <= 0.0");
			ok = false;
		}
    	_data.setKs(SwingInputVerifyUtil.getDouble(ksTextField));
    	
		if (!SwingInputVerifyUtil.largeThan(this.t1TextField, 0.0d)) {
			errMsg.add("T1 <= 0.0");
			ok = false;
		}
    	_data.setT1(SwingInputVerifyUtil.getDouble(t1TextField));

		if (!SwingInputVerifyUtil.largeThan(this.t2TextField, 0.0d)) {
			errMsg.add("T2 <= 0.0");
			ok = false;
		}
    	_data.setT2(SwingInputVerifyUtil.getDouble(t2TextField));

		if (!SwingInputVerifyUtil.largeThan(this.t3TextField, 0.0d)) {
			errMsg.add("T3 <= 0.0");
			ok = false;
		}
    	_data.setT3(SwingInputVerifyUtil.getDouble(t3TextField));

		if (!SwingInputVerifyUtil.largeThan(this.t4TextField, 0.0d)) {
			errMsg.add("T4 <= 0.0");
			ok = false;
		}
    	_data.setT4(SwingInputVerifyUtil.getDouble(t4TextField));

		if (!SwingInputVerifyUtil.largeThan(this.vsmaxTextField, 0.0d)) {
			errMsg.add("Vsmax <= 0.0");
			ok = false;
		}
    	_data.setVsmax(SwingInputVerifyUtil.getDouble(vsmaxTextField));

    	_data.setVsmin(SwingInputVerifyUtil.getDouble(vsminTextField));
		if (_data.getVsmax() <= _data.getVsmin()) {
			errMsg.add("Vsmax <= Vsmin");
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

        ksLabel = new javax.swing.JLabel();
        ksTextField = new javax.swing.JTextField();
        t1Label = new javax.swing.JLabel();
        t1TextField = new javax.swing.JTextField();
        t2Label = new javax.swing.JLabel();
        t2TextField = new javax.swing.JTextField();
        t3Label = new javax.swing.JLabel();
        t3TextField = new javax.swing.JTextField();
        t4Label = new javax.swing.JLabel();
        t4TextField = new javax.swing.JTextField();
        vsmaxLabel = new javax.swing.JLabel();
        vsmaxTextField = new javax.swing.JTextField();
        vsminLabel = new javax.swing.JLabel();
        vsminTextField = new javax.swing.JTextField();

        ksLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        ksLabel.setText("Ks(pu)");

        ksTextField.setColumns(5);
        ksTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        ksTextField.setText("10.0");

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setText("T1(s)");

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setText("0.05");

        t2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t2Label.setText("T2(s)");

        t2TextField.setColumns(5);
        t2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t2TextField.setText("10.0");

        t3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t3Label.setText("T3(s)");

        t3TextField.setColumns(5);
        t3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t3TextField.setText("0.0");

        t4Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t4Label.setText("T4(s)");

        t4TextField.setColumns(5);
        t4TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t4TextField.setText("10.0");

        vsmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vsmaxLabel.setText("Vsmax(pu)");

        vsmaxTextField.setColumns(5);
        vsmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vsmaxTextField.setText("0.05");

        vsminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vsminLabel.setText("Vsmin(pu)");

        vsminTextField.setColumns(5);
        vsminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vsminTextField.setText("10.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(103, 103, 103)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(ksLabel)
                        .add(40, 40, 40)
                        .add(ksTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(50, 50, 50)
                        .add(t1Label)
                        .add(50, 50, 50)
                        .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(t2Label)
                        .add(48, 48, 48)
                        .add(t2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(50, 50, 50)
                        .add(t3Label)
                        .add(50, 50, 50)
                        .add(t3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(t4Label)
                        .add(48, 48, 48)
                        .add(t4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(50, 50, 50)
                        .add(vsmaxLabel)
                        .add(20, 20, 20)
                        .add(vsmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(vsminLabel)
                        .add(20, 20, 20)
                        .add(vsminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(ksLabel))
                    .add(ksTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t1Label))
                    .add(t1TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t2Label))
                    .add(t2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t3Label))
                    .add(t3TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(t4Label))
                    .add(t4TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(vsmaxLabel))
                    .add(vsmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(vsminLabel))
                    .add(vsminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ksLabel;
    private javax.swing.JTextField ksTextField;
    private javax.swing.JLabel t1Label;
    private javax.swing.JTextField t1TextField;
    private javax.swing.JLabel t2Label;
    private javax.swing.JTextField t2TextField;
    private javax.swing.JLabel t3Label;
    private javax.swing.JTextField t3TextField;
    private javax.swing.JLabel t4Label;
    private javax.swing.JTextField t4TextField;
    private javax.swing.JLabel vsmaxLabel;
    private javax.swing.JTextField vsmaxTextField;
    private javax.swing.JLabel vsminLabel;
    private javax.swing.JTextField vsminTextField;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == ksTextField ||
             		 input == t1TextField ||
             		 input == t2TextField ||
             		 input == t3TextField ||
             		 input == t4TextField ||
             		 input == vsmaxTextField)
    	       		return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;       			
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
