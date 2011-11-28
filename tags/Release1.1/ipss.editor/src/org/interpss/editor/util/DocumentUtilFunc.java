package org.interpss.editor.util;

import org.interpss.editor.coreframework.GPDocument;
import org.interpss.editor.coreframework.IpssCustomDocument;
import org.interpss.editor.coreframework.IpssEditorDocument;
import org.interpss.editor.coreframework.IpssReportDocument;
import org.interpss.editor.form.GNetForm;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.jgraph.ui.form.IGNetForm;

import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;

public class DocumentUtilFunc  {
    /**
     * Check if the doc is a simulation document
     * 
     * @param doc
     * @return
     */
	public static boolean isSimuDocument(IpssEditorDocument doc) {
		return doc != null && 
			(doc instanceof GPDocument || doc instanceof IpssCustomDocument); 
	}
    
	/**
	 * Check if the doc is a Ipss graphic document
	 * 
	 * @param doc
	 * @return
	 */
	public static boolean isGraphicDocument(IpssEditorDocument doc) {
		return doc != null && (doc instanceof GPDocument); 
	}
	
	/**
     * Check if the doc is a Report document
     * 
     * @param doc
     * @return
     */
	public static boolean isReportDocument(IpssEditorDocument doc) {
		return doc != null && (doc instanceof IpssReportDocument); 
	}

	/**
	 * Check if Aclf report menuitems should be enabled 
	 * 
	 * @param doc
	 * @return
	 */
	public static boolean enableAclfReport(IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		if (appSimuCtx != null)
			return (isAclfDocument(doc) || isDStabDocument(doc)) && !appSimuCtx.isSimuNetDataDirty();
		else
			return false;
	}

	/**
	 * Check if Acsc report menuitems should be enabled 
	 * 
	 * @param doc
	 * @return
	 */
	public static boolean enableAcscReport(IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		if (appSimuCtx != null)
			return (isAcscDocument(doc) || isDStabDocument(doc)) && !appSimuCtx.isSimuNetDataDirty();
		else
			return false;
	}

	/**
	 * Check if DStab report menuitems should be enabled 
	 * 
	 * @param doc
	 * @return
	 */
	public static boolean enableDStabReport(IpssEditorDocument doc) {
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		if (appSimuCtx != null)
			return (isDStabDocument(doc)) && !appSimuCtx.isSimuNetDataDirty();
		else
			return false;
	}

	/**
     * Check if the doc is a Aclf simulation document
     * 
     * @param doc
     * @return
     */
	public static boolean isAclfDocument(IpssEditorDocument doc) {
		if (doc == null)
			return false;
		if (doc instanceof GPDocument) {
			IGNetForm form = ((GPDocument) doc).getGFormContainer().getGNetForm();
			if (form.getAppType().equals(IGNetForm.AppType_Distribution)) {
				return true;
			} else {
				if (form.getNetType().equals(IGNetForm.NetType_AclfNetwork)
						|| form.getNetType().equals(IGNetForm.NetType_AclfAdjNetwork)) {
					return true;
				} else if (form.getNetType().equals(IGNetForm.NetType_AcscNetwork)) {
					return ((GNetForm)form).getAcscNetData().isHasAclfData();
				}
			}
		} else if (doc instanceof IpssCustomDocument) {
			SimuContext simuCxt = (SimuContext)(((IpssCustomDocument) doc).getSimuAppContext()).getSimuCtx();
			if (simuCxt.getNetType() == SimuCtxType.ACLF_NETWORK_LITERAL
					|| simuCxt.getNetType() == SimuCtxType.ACLF_ADJ_NETWORK_LITERAL) {
				return true;
			} else if (simuCxt.getNetType() == SimuCtxType.ACSC_FAULT_NET_LITERAL) {
				return simuCxt.getAcscFaultNet().isLfDataLoaded();
			}
		} 
		return false;
	}

	/**
     * Check if the doc is a Acsc simulation document
     * 
     * @param doc
     * @return
     */
	public static boolean isAcscDocument(IpssEditorDocument doc) {
		if (doc == null) 
			return false;

		if (doc instanceof GPDocument) {
			IGNetForm form = ((GPDocument) doc).getGFormContainer().getGNetForm();
			if (form.getAppType().equals(IGNetForm.AppType_Distribution)) {
				return true;
			} else {
				if (form.getNetType().equals(IGNetForm.NetType_AcscNetwork)) {
					return true;
				}
			}
		} 
		return false;
	}

	/**
     * Check if the doc is a DStab simulation document
     * 
     * @param doc
     * @return
     */
	public static boolean isDStabDocument(IpssEditorDocument doc) {
		if (doc == null) 
			return false;

		if (doc instanceof GPDocument) {
			IGNetForm form = ((GPDocument) doc).getGFormContainer().getGNetForm();
			if (form.getAppType().equals(IGNetForm.AppType_Transmission)) {
				if (form.getNetType().equals(IGNetForm.NetType_DStabilityNet))
					return true;
			}
		} 
		return false;
	}
}