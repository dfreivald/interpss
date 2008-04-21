/*
 * @(#)XmlScriptRunWorker.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 01/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.editor.runAct;

import org.apache.xmlbeans.XmlException;
import org.interpss.PluginSpringAppContext;
import org.interpss.editor.runAct.xml.XmlScriptAclfRun;
import org.interpss.editor.runAct.xml.XmlScriptAcscRun;
import org.interpss.editor.runAct.xml.XmlScriptDStabRun;
import org.interpss.editor.runAct.xml.XmlScriptDclfRun;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.SimuContext;

public class XmlScriptRunWorker {
	/**
	 * Run the XMl scripts
	 * 
	 * @param scripts
	 *            run scripts, a string representing an XML document
	 * @param simuCtx
	 *            the SimuContext object
	 * @return
	 */
	public static boolean runCase(String scripts, SimuContext simuCtx) {
		// create the XML parser and parse the run scripts
		IpssXmlParser parser;
		try {
			parser = new IpssXmlParser(scripts);
		} catch (XmlException e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog(
					"Invalid Xml", e.toString());
			return false;
		}

		// Apply the modification to the base Network object
		IPSSMsgHub msg = simuCtx.getMsgHub();
		if (parser.getModification() != null) {
			IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
			mapper.mapping(parser.getModification(), simuCtx.getNetwork(), ModificationXmlType.class);
		}
		
		RunStudyCaseXmlType xmlStudyCase = parser.getRunStudyCase();
		IpssGridGainUtil.RemoteNodeDebug = xmlStudyCase.getGridRun() != null
				&& xmlStudyCase.getGridRun().getRemoteNodeDebug();
		if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACLF) {
			return XmlScriptAclfRun.runAclf(parser.getRootDoc(), simuCtx.getAclfAdjNet(),
					msg);
		} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_DCLF) {
			return XmlScriptDclfRun.runDclf(parser.getRootDoc(), simuCtx.getAclfNet(),
					msg);
		} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_ACSC) {
			return XmlScriptAcscRun.runAcsc(parser.getRootDoc(), simuCtx.getAcscFaultNet(),
					msg);
		} else if (xmlStudyCase.getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.RUN_D_STAB) {
			return XmlScriptDStabRun.runDStab(parser.getRootDoc(), simuCtx, msg);
		}
		msg.sendErrorMsg("Error: wrong analysus type, " + xmlStudyCase.getAnalysisRunType());
		return false;
	}
}
