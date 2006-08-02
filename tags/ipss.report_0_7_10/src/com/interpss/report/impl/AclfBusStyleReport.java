package com.interpss.report.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
import com.interpss.editor.data.proj.CaseData;
import com.interpss.editor.jgraph.GraphSpringAppContext;
import com.interpss.editor.jgraph.ui.app.IAppSimuContext;
import com.interpss.report.IIpssReport;
import com.interpss.report.bean.RptMainTitleBean;
import com.interpss.report.bean.aclf.AclfRptBeanFactory;
import com.interpss.report.mapper.SimuCtxReportMapper;
import com.interpss.simu.SimuContext;

public class AclfBusStyleReport extends AclfBaseReport implements IIpssReport {
	private String fnameAclfBusStyleMaster = "reportTemplate/aclf/AclfBusStyleMaster.jasper";
	
	public JasperPrint createReport(String version) {
		Map<String, Object> parameters = new HashMap<String, Object>(); 
		addSubreportFile(parameters);
		
		try {
			IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
			SimuContext simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
			SimuCtxReportMapper mapper = new SimuCtxReportMapper(SpringAppContext.getIpssMsgHub());

			// map the title bean
			RptMainTitleBean titleBean = new RptMainTitleBean();
			mapper.mapping(appSimuCtx, titleBean, RptMainTitleBean.class);
			titleBean.setReportTitle("Load Flow (IEEE Bus Style)");
			titleBean.setCaseName(appSimuCtx.getCurrentCaseName(CaseData.CaseType_Aclf));
			parameters.put("ReportMainTitleBean", titleBean);	
	
			addSubreports(parameters, appSimuCtx, mapper);

			return JasperFillManager.fillReport(fnameAclfBusStyleMaster, parameters,
					   							AclfRptBeanFactory.getBusStyleDataSource(simuCtx));
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getIpssMsgHub().sendErrorMsg(e.toString());
		}			
		return null;
	}

	/**
	 * @param fnameAclfSummaryMaster the fnameAclfBusStyleMaster to set
	 */
	public void setFnameAclfBusStyleMaster(String fnameAclfBusStyleMaster) {
		this.fnameAclfBusStyleMaster = fnameAclfBusStyleMaster;
	}
}
