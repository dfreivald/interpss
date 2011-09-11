 /*
  * @(#)NBCustomStabilizerEditPanel.java   
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

package ipss.custom.dstab.pss;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.util.Num2Str;
import org.interpss.dstab.control.common.ui.InputVerifyUtil;

/**
 *
 * @author  mzhou
 */

public class NBCustomStabilizerEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;
	
	CustomStabilizerData _data;

    /** Creates new form FaultLocDataPanel */
    public NBCustomStabilizerEditPanel() {
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
		_data = ((CustomStabilizer)controller).getData();
	}
	
	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    ksTextField.setText(Num2Str.toStr(_data.getKs(), "#0.00"));
  	    t1TextField.setText(Num2Str.toStr(_data.getT1(), "#0.000"));
  	    t2TextField.setText(Num2Str.toStr(_data.getT2(), "#0.000"));
  	    t3TextField.setText(Num2Str.toStr(_data.getT3(), "#0.000"));
  	    t4TextField.setText(Num2Str.toStr(_data.getT4(), "#0.000"));
  	    vsmaxTextField.setText(Num2Str.toStr(_data.getVsmax(), "#0.00"));
  	    vsminTextField.setText(Num2Str.toStr(_data.getVsmin(), "#0.00"));
  	    
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
    	_data.setKs(InputVerifyUtil.getDouble(ksTextField));
    	_data.setT1(InputVerifyUtil.getDouble(t1TextField));
    	_data.setT2(InputVerifyUtil.getDouble(t2TextField));
    	_data.setT3(InputVerifyUtil.getDouble(t3TextField));
    	_data.setT4(InputVerifyUtil.getDouble(t4TextField));
    	_data.setVsmax(InputVerifyUtil.getDouble(vsmaxTextField));
    	_data.setVsmin(InputVerifyUtil.getDouble(vsminTextField));
		
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

        setLayout(new java.awt.GridBagLayout());

        ksLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        ksLabel.setText("Ks");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(ksLabel, gridBagConstraints);

        ksTextField.setColumns(5);
        ksTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        ksTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(ksTextField, gridBagConstraints);

        t1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t1Label.setText("T1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(t1Label, gridBagConstraints);

        t1TextField.setColumns(5);
        t1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t1TextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t1TextField, gridBagConstraints);

        t2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t2Label.setText("T2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(t2Label, gridBagConstraints);

        t2TextField.setColumns(5);
        t2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t2TextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t2TextField, gridBagConstraints);

        t3Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t3Label.setText("T3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(t3Label, gridBagConstraints);

        t3TextField.setColumns(5);
        t3TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t3TextField.setText("0.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t3TextField, gridBagConstraints);

        t4Label.setFont(new java.awt.Font("Dialog", 0, 12));
        t4Label.setText("T4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(t4Label, gridBagConstraints);

        t4TextField.setColumns(5);
        t4TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        t4TextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(t4TextField, gridBagConstraints);

        vsmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vsmaxLabel.setText("Vsmax");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(vsmaxLabel, gridBagConstraints);

        vsmaxTextField.setColumns(5);
        vsmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vsmaxTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vsmaxTextField, gridBagConstraints);

        vsminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vsminLabel.setText("Vsmin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(vsminLabel, gridBagConstraints);

        vsminTextField.setColumns(5);
        vsminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vsminTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vsminTextField, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
    
    
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
    	       		return InputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;           			
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}