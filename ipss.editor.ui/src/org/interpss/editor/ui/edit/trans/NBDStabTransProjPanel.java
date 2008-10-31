 /*
  * @(#)NBDStabTransProjPanel.java   
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
 
package org.interpss.editor.ui.edit.trans;
  
import java.util.Vector;

import org.interpss.editor.data.dstab.DStabNetData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.jgraph.ui.form.IGNetForm;

public class NBDStabTransProjPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;

	public void initPanel() {
	}
    
	public void init(Object netContainer, Object form) {
		_netContainer = (GFormContainer)netContainer;
		allowParalellBranchCheckBox.setSelected(false);
		allowParalellBranchCheckBox.setEnabled(false);
	}
	
    public boolean setForm2Editor() {
		GNetForm form = (GNetForm)_netContainer.getGNetForm();
		DStabNetData data = form.getDStabNetData();
		
	    saturatedRadioButton.setSelected(data.isSaturatedMachData());

	    adjustmentCheckBox.setSelected(form.getAcscNetData().isHasAdjustment());
    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) {
		GNetForm form = (GNetForm)_netContainer.getGNetForm();
		DStabNetData data = form.getDStabNetData();

		form.setNetType(IGNetForm.NetType_DStabilityNet);

		data.setSaturatedMachData(saturatedRadioButton.isSelected());
	    
		form.setAllowParallelBranch(allowParalellBranchCheckBox.isSelected());
		
		if (adjustmentCheckBox.isSelected()) {
			data.getAcscNetData().setHasAdjustment(true);
		}
		return true;
    }
    
    /** Creates new form AclfEditPanel */
    public NBDStabTransProjPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        machDataButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        unsaturatedRadioButton = new javax.swing.JRadioButton();
        saturatedRadioButton = new javax.swing.JRadioButton();
        allowParalellBranchCheckBox = new javax.swing.JCheckBox();
        adjustmentCheckBox = new javax.swing.JCheckBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Machine Data"));

        machDataButtonGroup.add(unsaturatedRadioButton);
        unsaturatedRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        unsaturatedRadioButton.setSelected(true);
        unsaturatedRadioButton.setText("Unsaturated     ");
        unsaturatedRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        unsaturatedRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(unsaturatedRadioButton);

        machDataButtonGroup.add(saturatedRadioButton);
        saturatedRadioButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        saturatedRadioButton.setText("Saturated");
        saturatedRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        saturatedRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(saturatedRadioButton);

        allowParalellBranchCheckBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        allowParalellBranchCheckBox.setSelected(true);
        allowParalellBranchCheckBox.setText("Allow paralell branches");
        allowParalellBranchCheckBox.setName("allowParalellBranchCheckBox"); // NOI18N

        adjustmentCheckBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        adjustmentCheckBox.setSelected(true);
        adjustmentCheckBox.setText("Include adjustments/Controls");
        adjustmentCheckBox.setName("adjustmentCheckBox"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(75, 75, 75)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(adjustmentCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 225, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(allowParalellBranchCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .add(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(7, 7, 7)
                .add(allowParalellBranchCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(adjustmentCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adjustmentCheckBox;
    private javax.swing.JCheckBox allowParalellBranchCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup machDataButtonGroup;
    private javax.swing.JRadioButton saturatedRadioButton;
    private javax.swing.JRadioButton unsaturatedRadioButton;
    // End of variables declaration//GEN-END:variables
    
}
