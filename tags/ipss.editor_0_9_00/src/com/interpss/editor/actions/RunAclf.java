package com.interpss.editor.actions;

import java.awt.event.ActionEvent;

import com.interpss.common.SpringAppContext;
import com.interpss.editor.coreframework.GPDocument;
import com.interpss.editor.coreframework.IpssAbstractActionDefault;
import com.interpss.editor.coreframework.IpssCustomDocument;
import com.interpss.editor.coreframework.IpssEditorDocument;
import com.interpss.editor.io.FileUtility;
import com.interpss.editor.ui.SimuActionAdapter;
import com.interpss.editor.util.DocumentUtilFunc;
import com.interpss.simu.SimuContext;

public class RunAclf extends IpssAbstractActionDefault {

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (graphpad.isBGProcessingBusy()) {
    		SpringAppContext.getEditorDialogUtil().showWarnMsgDialog("Simulation Thread Busy", 
				"The run-simulation thread is busy. Please wait for its finishing before starting another one.");
			return;
		}	

		IpssEditorDocument doc = getCurrentDocument();
		if (doc instanceof GPDocument) {
			SimuActionAdapter.menu_run_aclf(true, graphpad.getCurrentGraph());
		} 
		else if (doc instanceof IpssCustomDocument) {
			if (((IpssCustomDocument)doc).getDocFile().isModified()) {
				String filepath = graphpad.getCurrentProject().getProjectPath() + "/" + 
				((IpssCustomDocument)doc).getFileName();
				SimuContext simuCtx = (SimuContext)doc.getSimuAppContext().getSimuCtx();
				if (FileUtility.loadCustomFile(filepath, simuCtx)) {
					SimuActionAdapter.menu_run_aclf(false, null);
					doc.getSimuAppContext().setSimuNetDataDirty(false);
				}	
				else {
					SpringAppContext.getIpssMsgHub().sendWarnMsg("Custom data file loading error, filename: " + filepath);
				}
			} 
			else {
				SimuActionAdapter.menu_run_aclf(false, null);
			}
		}
		// After a run, some menuitems may need to be enabled
		graphpad.update();
	}

	@Override
	public void update() {
		IpssEditorDocument doc = getCurrentDocument();
		setEnabled(DocumentUtilFunc.isAclfDocument(doc) || DocumentUtilFunc.isDStabDocument(doc));
	}
}
