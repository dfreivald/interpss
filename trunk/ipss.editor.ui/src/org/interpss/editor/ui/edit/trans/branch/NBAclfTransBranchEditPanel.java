 /*
  * @(#)NBAclfTransBranchEditPanel.java   
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

package org.interpss.editor.ui.edit.trans.branch;
  
import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;

import com.interpss.common.util.IpssLogger;
 
public class NBAclfTransBranchEditPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

    private NBBranchPositivePanel _branchPositivePanel = new NBBranchPositivePanel();
    
	public void initPanel(JDialog aParent) {
		parent = aParent;
		_branchPositivePanel.initPanel(parent);	
		this.add(_branchPositivePanel);
	}
    
	public void init(Object netContainer, Object form) {
		IpssLogger.getLogger().info("NBAclfTransBranchEditPanel init() called");
		
	   _branchPositivePanel.init(netContainer, form);
	}
	
    public boolean setForm2Editor() {
		IpssLogger.getLogger().info("NBAclfTransBranchEditPanel setForm2Edtior() called");
		_branchPositivePanel.setForm2Editor();
    	return true;
	}
    
    public boolean saveEditor2Form(Vector errMsg) throws Exception {
		IpssLogger.getLogger().info("NBAclfTransBranchEditPanel saveEditor2Form() called");
		return _branchPositivePanel.saveEditor2Form(errMsg);
    }
    
    /** Creates new form AclfEditPanel */
    public NBAclfTransBranchEditPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}