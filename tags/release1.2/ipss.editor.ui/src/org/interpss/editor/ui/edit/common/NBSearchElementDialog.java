 /*
  * @(#)NBSearchElementDialog.java   
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

package org.interpss.editor.ui.edit.common;

import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.jgraph.ui.IGraphicEditor;
import org.interpss.editor.jgraph.ui.edit.IFormDataDialog;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.ui.WinUtilities;

public class NBSearchElementDialog extends javax.swing.JDialog implements IFormDataDialog {
	private static final long serialVersionUID = 1;

	private GFormContainer _netContainer = null;
    private Object _selected = null;
    
    private static NBSearchBusPanel _findBusPanel = new NBSearchBusPanel();
    private static NBSearchBranchPanel _findBranchPanel = new NBSearchBranchPanel();

    public NBSearchElementDialog(java.awt.Frame parent, IPSSMsgHub aMsgHub) {
        super(parent, "Find Element Dialog", true);
        initComponents();
        WinUtilities.center(this);
    }

	public NBSearchElementDialog(IGraphicEditor parent, IPSSMsgHub aMsg) {
        this(parent.getFrame(), aMsg);
    }
	
	public boolean isReturnOk() {
		return true;
	}
	
    public Object getSelectedObj() {
        return _selected;
    }

    /**
     *  form is not used.
     */
    public void init(Object netContainer, Object form) {
        _netContainer = (GFormContainer)netContainer;
        _selected = null;
        
        if (_netContainer.getBusFormTotal() > 0) 
            _findBusPanel.init(_netContainer);
        if (_netContainer.getBranchFormTotal() > 0) 
            _findBranchPanel.init(_netContainer);
        
        this.busRadioButton.setSelected(true);
        if (_netContainer.getBusFormTotal() > 0) {
            this.selectPanel.removeAll();
            this.selectPanel.add(_findBusPanel, java.awt.BorderLayout.CENTER);
        }

        pack();
        setVisible(true);
    }
    
    public boolean saveEditor2Form(java.util.Vector errMsg) throws Exception {
        return true;
    }
    
    public boolean setForm2Editor() {
        return true;
    }
        
    /** Creates new form NBFindDialog */
    public NBSearchElementDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        typeSelectButtonGroup = new javax.swing.ButtonGroup();
        inputPanel = new javax.swing.JPanel();
        typeSelectPanel = new javax.swing.JPanel();
        busRadioButton = new javax.swing.JRadioButton();
        branchRadioButton = new javax.swing.JRadioButton();
        adjustmentRadioButton = new javax.swing.JRadioButton();
        machineDeviceRadioButton = new javax.swing.JRadioButton();
        selectPanel = new javax.swing.JPanel();
        emptyLabel = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        inputPanel.setLayout(new java.awt.GridBagLayout());

        inputPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(20, 20, 10, 20)));
        typeSelectPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        typeSelectPanel.setBorder(new javax.swing.border.TitledBorder(null, "Element Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS Sans Serif", 0, 10)));
        typeSelectPanel.setPreferredSize(new java.awt.Dimension(450, 61));
        typeSelectButtonGroup.add(busRadioButton);
        busRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        busRadioButton.setSelected(true);
        busRadioButton.setText("Bus");
        busRadioButton.setPreferredSize(new java.awt.Dimension(60, 23));
        busRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busRadioButtonActionPerformed(evt);
            }
        });

        typeSelectPanel.add(busRadioButton);

        typeSelectButtonGroup.add(branchRadioButton);
        branchRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        branchRadioButton.setText("Branch");
        branchRadioButton.setPreferredSize(new java.awt.Dimension(65, 23));
        branchRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchRadioButtonActionPerformed(evt);
            }
        });

        typeSelectPanel.add(branchRadioButton);

        typeSelectButtonGroup.add(adjustmentRadioButton);
        adjustmentRadioButton.setText("Adjust/Control");
        adjustmentRadioButton.setEnabled(false);
        typeSelectPanel.add(adjustmentRadioButton);

        typeSelectButtonGroup.add(machineDeviceRadioButton);
        machineDeviceRadioButton.setText("Machine/Device");
        machineDeviceRadioButton.setEnabled(false);
        typeSelectPanel.add(machineDeviceRadioButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        inputPanel.add(typeSelectPanel, gridBagConstraints);

        selectPanel.setLayout(new java.awt.BorderLayout());

        selectPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153)));
        emptyLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        emptyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emptyLabel.setText("The network has no bus and/or branch.");
        emptyLabel.setPreferredSize(new java.awt.Dimension(250, 50));
        selectPanel.add(emptyLabel, java.awt.BorderLayout.NORTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        inputPanel.add(selectPanel, gridBagConstraints);

        getContentPane().add(inputPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(10, 1, 10, 1)));
        okButton.setFont(new java.awt.Font("Dialog", 0, 12));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        controlPanel.add(okButton);

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 12));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        controlPanel.add(cancelButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        _selected = null;
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (this.busRadioButton.isSelected() && _netContainer.getBusFormTotal() > 0)
            _selected = _findBusPanel.getSelectedObj();
        else if (this.branchRadioButton.isSelected() && _netContainer.getBranchFormTotal() > 0)
            _selected = _findBranchPanel.getSelectedObj();
        setVisible(false);        
    }//GEN-LAST:event_okButtonActionPerformed

    private void branchRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchRadioButtonActionPerformed
   	  this.selectPanel.removeAll();
        if (_netContainer.getBranchFormTotal() > 0) 
        		this.selectPanel.add(_findBranchPanel, java.awt.BorderLayout.CENTER);
        else
        		this.selectPanel.add(this.emptyLabel, java.awt.BorderLayout.CENTER);
  		  pack();
    }//GEN-LAST:event_branchRadioButtonActionPerformed

    private void busRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busRadioButtonActionPerformed
        if (_netContainer.getBusFormTotal() > 0) {
        		this.selectPanel.removeAll();
        		this.selectPanel.add(_findBusPanel, java.awt.BorderLayout.CENTER);
        		pack();
        }
    }//GEN-LAST:event_busRadioButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new NBSearchElementDialog(new javax.swing.JFrame(), true).show();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adjustmentRadioButton;
    private javax.swing.JRadioButton branchRadioButton;
    private javax.swing.JRadioButton busRadioButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel emptyLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JRadioButton machineDeviceRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel selectPanel;
    private javax.swing.ButtonGroup typeSelectButtonGroup;
    private javax.swing.JPanel typeSelectPanel;
    // End of variables declaration//GEN-END:variables
    
}