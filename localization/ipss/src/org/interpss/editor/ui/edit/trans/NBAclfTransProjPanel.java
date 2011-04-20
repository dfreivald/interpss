 /*
  * @(#)NBAclfTransProjPanel.java   
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

import org.interpss.editor.data.aclf.AclfNetData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.editor.jgraph.ui.form.IGNetForm;

 
 
public class NBAclfTransProjPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;

	public void initPanel() {
	}
    
	public void init(Object netContainer, Object form) {
		_netContainer = (GFormContainer)netContainer;
		allowParalellBranchCheckBox.setEnabled(false);
		allowParalellBranchCheckBox.setSelected(false);
	}
	
    public boolean setForm2Editor() {
		GNetForm form = (GNetForm)_netContainer.getGNetForm();

		// this function is not needed for the GEditor
		//allowParalellBranchCheckBox.setSelected(form.isAllowParallelBranch());
		
		adjustmentCheckBox.setSelected(form.getNetType().equals(IGNetForm.NetType_AclfAdjNetwork));
		
    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) {
		GNetForm form = (GNetForm)_netContainer.getGNetForm();
		AclfNetData data = form.getAcscNetData();

		form.setAllowParallelBranch(allowParalellBranchCheckBox.isSelected());
		
		if (adjustmentCheckBox.isSelected()) {
			form.setNetType(IGNetForm.NetType_AclfAdjNetwork);
			data.setHasAdjustment(true);
		}
		else {
			form.setNetType(IGNetForm.NetType_AclfNetwork);
			data.setHasAdjustment(false);
		}
		return true;
    }
    
    /** Creates new form AclfEditPanel */
    public NBAclfTransProjPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        allowParalellBranchCheckBox = new javax.swing.JCheckBox();
        adjustmentCheckBox = new javax.swing.JCheckBox();

        allowParalellBranchCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        allowParalellBranchCheckBox.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/interpss/editor/ui/edit/trans/Bundle"); // NOI18N
        allowParalellBranchCheckBox.setText(bundle.getString("NBAclfTransProjPanel.allowParalellBranchCheckBox.text")); // NOI18N
        allowParalellBranchCheckBox.setName("allowParalellBranchCheckBox"); // NOI18N

        adjustmentCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        adjustmentCheckBox.setSelected(true);
        adjustmentCheckBox.setText(bundle.getString("NBAclfTransProjPanel.adjustmentCheckBox.text")); // NOI18N
        adjustmentCheckBox.setName("adjustmentCheckBox"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(66, 66, 66)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(adjustmentCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(allowParalellBranchCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 188, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(allowParalellBranchCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(adjustmentCheckBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adjustmentCheckBox;
    private javax.swing.JCheckBox allowParalellBranchCheckBox;
    // End of variables declaration//GEN-END:variables
    
}
