 /*
  * @(#)NBServiceScheduleDialog.java   
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

package org.interpss.editor.ui.edit.dist.branch;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.interpss.editor.data.dist.DistBranchData;
import org.interpss.editor.form.GFormContainer;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.ui.IGraphicEditor;
import org.interpss.editor.jgraph.ui.edit.IFormDataDialog;
import org.interpss.ui.WinUtilities;

import com.interpss.common.util.IpssLogger;
import com.interpss.spring.CoreCommonSpringCtx;
 
public class NBServiceScheduleDialog extends javax.swing.JDialog implements IFormDataDialog {
	private static final long serialVersionUID = 1;

	private GFormContainer netContainer = null;
	private DistBranchData branchData = null;

	/**
	*	Constructor
	*
	* @parem parent the parent Frame object	
	*/
	public NBServiceScheduleDialog(java.awt.Frame parent) {
        super(parent, "Service Schedule Editor", true);
        initComponents();
        WinUtilities.center(this);
    }

	public NBServiceScheduleDialog(IGraphicEditor parent) {
        this(parent.getFrame());
    }
	
	public boolean isReturnOk() {
		return true;
	}
	
	/**
	*
	* @param netContainer null
	* @param obj the DistBranchData object
	*/    
	public void init(Object aNetContainer, Object obj) {
		IpssLogger.getLogger().info("NBServiceScheduleDialog.init() called");
    		
		netContainer = (GFormContainer)aNetContainer;
		branchData = (DistBranchData)obj;
		
		// copy data from the form to the editor input panels, including 
		// child panels 
    	setForm2Editor();
		
		// pack the form and display
		pack();
        setVisible(true);
	}

	/**
	*	Set form data to the editor
	*
	* @return false if there is any problem
	*/	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBServiceScheduleDialog.setForm2Editor() called");
	    setTableData();
		return true;
    }
    
	/**
	*	Save editor screen data to the form
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
	public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBServiceScheduleDialog.saveEditor2Form() called");
		boolean ok = true;
	    saveTableData();
		return ok;
    }

	private DefaultTableModel getScheduleDataModel(){
    	return (DefaultTableModel)this.sheduleDataTable.getModel();
    }
    
    private void setTableData() {
    	int points = ((GNetForm)netContainer.getGNetForm()).getDistNetData().getLoadSchedulePoints();
    	int row = points/4;
    	if (points % 4 > 0) row++;
    	getScheduleDataModel().setRowCount(row);

    	int cnt = 0;
    	for (int i = 0; i < row; i++) {
        	for (int j = 0; j < 4; j++) {
        		cnt++;
        		if (cnt <= points) {
        			getScheduleDataModel().setValueAt(new Integer(cnt), i, j*2);
        			boolean b = branchData.getServiceSchedule(cnt-1);
        			getScheduleDataModel().setValueAt(new Boolean(b), i, j*2+1);
        		}
        		else {
        			getScheduleDataModel().setValueAt("", i, j*2);
        			getScheduleDataModel().setValueAt(new Boolean(false), i, j*2+1);
        		}
    		}
    	}
	}    
    
    private void saveTableData() {
    	int points = ((GNetForm)netContainer.getGNetForm()).getDistNetData().getLoadSchedulePoints();
    	int row = points/4;
    	if (points % 4 > 0) row++;
    	
    	int cnt = 0;
    	for (int i = 0; i < row; i++) {
        	for (int j = 0; j < 4; j++) {
        		cnt++;
        		if (cnt <= points) {
        			boolean b = ((Boolean)getScheduleDataModel().getValueAt(i, j*2+1)).booleanValue();
        			branchData.setServiceSchedule(b, cnt-1);
        		}
    		}
    	}
	}  
	
	// The following code is controlled by NetBean IDE
	// ===============================================
	
    /** Creates new form NBNetEditDialog */
    public NBServiceScheduleDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataInputPanel = new javax.swing.JPanel();
        serviceSchedulePanel = new javax.swing.JPanel();
        tableTitlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sheduleDataTable = new javax.swing.JTable();
        controlPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        dataInputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        dataInputPanel.setFont(new java.awt.Font("Dialog", 0, 10));
        dataInputPanel.setMinimumSize(new java.awt.Dimension(400, 150));
        dataInputPanel.setPreferredSize(new java.awt.Dimension(450, 200));
        dataInputPanel.setVerifyInputWhenFocusTarget(false);
        dataInputPanel.setLayout(new java.awt.BorderLayout());

        serviceSchedulePanel.setLayout(new java.awt.BorderLayout());

        tableTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 10, 1));
        tableTitlePanel.setLayout(new java.awt.GridLayout(1, 4, 0, 5));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/interpss/editor/ui/edit/dist/branch/Bundle"); // NOI18N
        jLabel2.setText(bundle.getString("NBServiceScheduleDialog.jLabel2.text")); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(bundle.getString("NBServiceScheduleDialog.jLabel3.text")); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(bundle.getString("NBServiceScheduleDialog.jLabel4.text")); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel4);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(bundle.getString("NBServiceScheduleDialog.jLabel1.text")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel1);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(bundle.getString("NBServiceScheduleDialog.jLabel5.text")); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(bundle.getString("NBServiceScheduleDialog.jLabel6.text")); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(bundle.getString("NBServiceScheduleDialog.jLabel7.text")); // NOI18N
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(bundle.getString("NBServiceScheduleDialog.jLabel8.text")); // NOI18N
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableTitlePanel.add(jLabel8);

        serviceSchedulePanel.add(tableTitlePanel, java.awt.BorderLayout.CENTER);

        sheduleDataTable.setFont(new java.awt.Font("Dialog", 0, 10));
        sheduleDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", new Boolean(true), "7", new Boolean(true), "13", new Boolean(true), "19", new Boolean(true)},
                {"2", new Boolean(true), "8", new Boolean(true), "14", new Boolean(true), "20", new Boolean(true)},
                {"3", new Boolean(true), "9", new Boolean(true), "15", new Boolean(true), "21", new Boolean(true)},
                {"4", new Boolean(true), "10", new Boolean(true), "16", new Boolean(true), "22", new Boolean(true)},
                {"5", new Boolean(true), "11", new Boolean(true), "17", new Boolean(true), "23", new Boolean(true)},
                {"6", new Boolean(true), "12", new Boolean(true), "18", new Boolean(true), "24", new Boolean(true)}
            },
            new String [] {
                "point", "status", "point", "status", "point", "status", "point", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sheduleDataTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        sheduleDataTable.setAutoscrolls(false);
        sheduleDataTable.setCellSelectionEnabled(true);
        sheduleDataTable.setMinimumSize(new java.awt.Dimension(100, 112));
        sheduleDataTable.setName("zTable"); // NOI18N
        serviceSchedulePanel.add(sheduleDataTable, java.awt.BorderLayout.SOUTH);

        dataInputPanel.add(serviceSchedulePanel, java.awt.BorderLayout.NORTH);

        controlPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        okButton.setFont(new java.awt.Font("Dialog", 0, 12));
        okButton.setText(bundle.getString("NBServiceScheduleDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        controlPanel.add(okButton);

        cancelButton.setFont(new java.awt.Font("Dialog", 0, 12));
        cancelButton.setText(bundle.getString("NBServiceScheduleDialog.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        controlPanel.add(cancelButton);

        dataInputPanel.add(controlPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(dataInputPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
		IpssLogger.getLogger().info("NBServiceScheduleDialog.okButtonActionPerformed() called");
		Vector errMsg = new Vector();
		try {
        	if (!saveEditor2Form(errMsg)) {
        		CoreCommonSpringCtx.getEditorDialogUtil().showMsgDialog(this, "Service Schedule Data Error", errMsg);
        		IpssLogger.getLogger().info("Service Schedule  Data Error" + errMsg.toString());
				return;
        	}
        } catch (Exception e) {
      		IpssLogger.logErr(e);
      		CoreCommonSpringCtx.getEditorDialogUtil().showMsgDialog(this, "Service Schedule  Data Error", e.toString());
			return;
        }	
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new NBServiceScheduleDialog(new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel dataInputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel serviceSchedulePanel;
    private javax.swing.JTable sheduleDataTable;
    private javax.swing.JPanel tableTitlePanel;
    // End of variables declaration//GEN-END:variables

	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			try {
 	       	} catch (Exception e) {
				return false;
 	       	}				
			return true;
        }
    }
}
