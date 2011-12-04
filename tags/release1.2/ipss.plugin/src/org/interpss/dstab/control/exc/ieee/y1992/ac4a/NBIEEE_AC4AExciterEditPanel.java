 /*
  * @(#)NBIEEE_AC4AExciterEditPanel.java   
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

package org.interpss.dstab.control.exc.ieee.y1992.ac4a;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Number2String;

public class NBIEEE_AC4AExciterEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;
	
	IEEE_AC4AExciterData _data;

    /** Creates new form FaultLocDataPanel */
    public NBIEEE_AC4AExciterEditPanel() {
        initComponents();

        // associate the editing fields with the verifier class defined at the end of this calss
  	DataVerifier verifier = new DataVerifier();
  	kaTextField.setInputVerifier(verifier);
  	kcTextField.setInputVerifier(verifier);
  	tbTextField.setInputVerifier(verifier);
        tcTextField.setInputVerifier(verifier);
  	trTextField.setInputVerifier(verifier);
  	taTextField.setInputVerifier(verifier);
  	vuelTextField.setInputVerifier(verifier);
  	voelTextField.setInputVerifier(verifier);
  	vimaxTextField.setInputVerifier(verifier);
  	viminTextField.setInputVerifier(verifier);
  	vrmaxTextField.setInputVerifier(verifier);
  	vrminTextField.setInputVerifier(verifier);
    }
    
	public void init(Object controller) {
		// init the data object from the bus object being edited
		_data = ((IEEE_AC4AExciter)controller).getData();
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    kaTextField.setText(Number2String.toStr(_data.getKa(), "#0.00"));
  	    taTextField.setText(Number2String.toStr(_data.getTa(), "#0.000"));
  	    tbTextField.setText(Number2String.toStr(_data.getTb(), "#0.000"));
  	    tcTextField.setText(Number2String.toStr(_data.getTc(), "#0.000"));
  	    trTextField.setText(Number2String.toStr(_data.getTr(), "#0.000"));
  	    kcTextField.setText(Number2String.toStr(_data.getKc(), "#0.000"));
  	    vuelTextField.setText(Number2String.toStr(_data.getVuel(), "#0.000"));
  	    voelTextField.setText(Number2String.toStr(_data.getVoel(), "#0.000"));
  	    vimaxTextField.setText(Number2String.toStr(_data.getVimax(), "#0.000"));
  	    viminTextField.setText(Number2String.toStr(_data.getVimin(), "#0.000"));
  	    vrmaxTextField.setText(Number2String.toStr(_data.getVrmax(), "#0.00"));
  	    vrminTextField.setText(Number2String.toStr(_data.getVrmin(), "#0.00"));

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
		// TODO: add verification rules
    	_data.setKa(SwingInputVerifyUtil.getDouble(kaTextField));
    	_data.setKc(SwingInputVerifyUtil.getDouble(kcTextField));
    	_data.setTb(SwingInputVerifyUtil.getDouble(tbTextField));
    	_data.setTc(SwingInputVerifyUtil.getDouble(tcTextField));
    	_data.setTr(SwingInputVerifyUtil.getDouble(trTextField));
    	_data.setTa(SwingInputVerifyUtil.getDouble(taTextField));
    	_data.setVoel(SwingInputVerifyUtil.getDouble(voelTextField));
    	_data.setVuel(SwingInputVerifyUtil.getDouble(vuelTextField));
    	_data.setVimax(SwingInputVerifyUtil.getDouble(vimaxTextField));
    	_data.setVimin(SwingInputVerifyUtil.getDouble(viminTextField));
    	_data.setVrmax(SwingInputVerifyUtil.getDouble(vrmaxTextField));
    	_data.setVrmin(SwingInputVerifyUtil.getDouble(vrminTextField));	
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

        kaLabel = new javax.swing.JLabel();
        kaTextField = new javax.swing.JTextField();
        kcLabel = new javax.swing.JLabel();
        kcTextField = new javax.swing.JTextField();
        trLabel = new javax.swing.JLabel();
        trTextField = new javax.swing.JTextField();
        tcLabel = new javax.swing.JLabel();
        tcTextField = new javax.swing.JTextField();
        tbLabel = new javax.swing.JLabel();
        tbTextField = new javax.swing.JTextField();
        taLabel = new javax.swing.JLabel();
        taTextField = new javax.swing.JTextField();
        vimaxLabel = new javax.swing.JLabel();
        vimaxTextField = new javax.swing.JTextField();
        viminLabel = new javax.swing.JLabel();
        viminTextField = new javax.swing.JTextField();
        vrmaxLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        voelLabel = new javax.swing.JLabel();
        voelTextField = new javax.swing.JTextField();
        vuelLabel = new javax.swing.JLabel();
        vuelTextField = new javax.swing.JTextField();

        kaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kaLabel.setText("Ka");

        kaTextField.setColumns(5);
        kaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kaTextField.setText("200.0");

        kcLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kcLabel.setText("Kc");

        kcTextField.setColumns(5);
        kcTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kcTextField.setText("0.0");

        trLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        trLabel.setText("Tr");

        trTextField.setColumns(5);
        trTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        trTextField.setText("0.0");

        tcLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        tcLabel.setText("Tc");

        tcTextField.setColumns(5);
        tcTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tcTextField.setText("1.0");

        tbLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        tbLabel.setText("Tb");

        tbTextField.setColumns(5);
        tbTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tbTextField.setText("10.0");

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setText("Ta");

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setText("0.015");

        vimaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vimaxLabel.setText("Vimax");

        vimaxTextField.setColumns(5);
        vimaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vimaxTextField.setText("10.0");

        viminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        viminLabel.setText("Vimin");

        viminTextField.setColumns(5);
        viminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        viminTextField.setText("-10.0");

        vrmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxLabel.setText("Vrmax");

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("5.64");

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin");

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("-4.53");

        voelLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        voelLabel.setText("Voel");

        voelTextField.setColumns(5);
        voelTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        voelTextField.setText("10.0");

        vuelLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vuelLabel.setText("Vuel");

        vuelTextField.setColumns(5);
        vuelTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vuelTextField.setText("-1.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(kaLabel)
                        .add(48, 48, 48)
                        .add(kaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(kcLabel)
                        .add(47, 47, 47)
                        .add(kcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(trLabel)
                        .add(53, 53, 53)
                        .add(trTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(tcLabel)
                        .add(50, 50, 50)
                        .add(tcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(tbLabel)
                        .add(47, 47, 47)
                        .add(tbTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(taLabel)
                        .add(50, 50, 50)
                        .add(taTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(vimaxLabel)
                        .add(30, 30, 30)
                        .add(vimaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(viminLabel)
                        .add(30, 30, 30)
                        .add(viminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(vrmaxLabel)
                        .add(30, 30, 30)
                        .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(vrminLabel)
                        .add(31, 31, 31)
                        .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(voelLabel)
                        .add(37, 37, 37)
                        .add(voelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(30, 30, 30)
                        .add(vuelLabel)
                        .add(40, 40, 40)
                        .add(vuelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(kaLabel)
                    .add(kaTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(kcLabel)
                    .add(kcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(trLabel)
                    .add(trTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tcLabel)
                    .add(tcTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tbLabel)
                    .add(tbTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(taLabel)
                    .add(taTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(vimaxLabel)
                    .add(vimaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(viminLabel)
                    .add(viminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vrmaxLabel)
                    .add(vrmaxTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(vrminLabel)
                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(voelLabel)
                    .add(voelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vuelLabel)
                    .add(vuelTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kaLabel;
    private javax.swing.JTextField kaTextField;
    private javax.swing.JLabel kcLabel;
    private javax.swing.JTextField kcTextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel tbLabel;
    private javax.swing.JTextField tbTextField;
    private javax.swing.JLabel tcLabel;
    private javax.swing.JTextField tcTextField;
    private javax.swing.JLabel trLabel;
    private javax.swing.JTextField trTextField;
    private javax.swing.JLabel vimaxLabel;
    private javax.swing.JTextField vimaxTextField;
    private javax.swing.JLabel viminLabel;
    private javax.swing.JTextField viminTextField;
    private javax.swing.JLabel voelLabel;
    private javax.swing.JTextField voelTextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    private javax.swing.JLabel vuelLabel;
    private javax.swing.JTextField vuelTextField;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == kaTextField ||
             		 input == taTextField ||
             		 input == tbTextField ||
             		 input == tcTextField ||
             		 input == trTextField ||
             		 input == kaTextField || 
             		 input == kcTextField ||
             		 input == vimaxTextField || 
             		 input == viminTextField ||
             		 input == vrmaxTextField ||
             		 input == vrminTextField ||
             		 input == voelTextField ||
             		 input == vuelTextField )
    	       		return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}