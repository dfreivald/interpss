 /*
  * @(#)AclfBusStyleReport.java   
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

package org.interpss.report.impl;

import java.util.HashMap;
import java.util.Map;

import org.interpss.editor.data.proj.CaseData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.report.IIpssReport;
import org.interpss.report.bean.RptMainTitleBean;
import org.interpss.report.bean.aclf.AclfRptBeanFactory;
import org.interpss.report.mapper.SimuCtxReportMapper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.interpss.common.SpringAppContext;
import com.interpss.common.util.IpssLogger;
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