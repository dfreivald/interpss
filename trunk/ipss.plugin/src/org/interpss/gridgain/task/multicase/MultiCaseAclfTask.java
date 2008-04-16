/*
 * @(#)MultiCaseAclfTask.java   
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

/*
 *  This Class is for performing grid computing on the GridMultiStudyCase model 
 */

package org.interpss.gridgain.task.multicase;

import java.util.ArrayList;
import java.util.List;

import org.gridgain.grid.GridException;
import org.interpss.gridgain.job.AbstractIpssGridGainJob;
import org.interpss.gridgain.job.IpssGridGainAclfJob;
import org.interpss.gridgain.util.IpssGridGainUtil;
import org.interpss.gridgain.util.RemoteMessageTable;

import com.interpss.common.datatype.Constants;
import com.interpss.common.util.IpssLogger;
import com.interpss.simu.multicase.MultiStudyCase;
import com.interpss.simu.multicase.ReturnRemoteCaseOpt;
import com.interpss.simu.multicase.StudyCase;

public class MultiCaseAclfTask extends AbstractMultiCaseTask {
	private static final long serialVersionUID = 1;

	protected List<? extends AbstractIpssGridGainJob> createRemoteJobList(MultiStudyCase model) throws GridException {
		// set AclfOptions 
		int reOpt = model.getAclfGridOption().getReturnCase() == ReturnRemoteCaseOpt.ALL_STUDY_CASE? RemoteMessageTable.Const_ReturnAllStudyCase :
							(model.getAclfGridOption().getReturnCase() == ReturnRemoteCaseOpt.DIVERGED_CASE? RemoteMessageTable.Const_ReturnDivergedCase :
								(model.getAclfGridOption().getReturnCase() == ReturnRemoteCaseOpt.DIVERGED_AND_VIOLATION? 
										RemoteMessageTable.Const_ReturnDivergedViolation : RemoteMessageTable.Const_ReturnNoStudyCase));
		getSession().setAttribute(Constants.GridToken_AclfOpt_ReturnStudyCase, new Integer(reOpt));
		getSession().setAttribute(Constants.GridToken_AclfOpt_CalBranchLimitViolation, 
							model.getAclfGridOption().isCalBranchLimitViolation()? Boolean.TRUE : Boolean.FALSE);
		getSession().setAttribute(Constants.GridToken_AclfOpt_CalBusVoltViolation, 
							model.getAclfGridOption().isCalBusVoltageViolation()? Boolean.TRUE : Boolean.FALSE);
		getSession().setAttribute(Constants.GridToken_AclfOpt_BusVoltageUpperLimitPU, 
							new Double(model.getAclfGridOption().getBusVoltageUpperLimitPU()));
		getSession().setAttribute(Constants.GridToken_AclfOpt_BusVoltageLowerLimitPU, 
							new Double(model.getAclfGridOption().getBusVoltageLowerLimitPU()));

		// use grid session to sent network model to the remote node
		getSession().setAttribute(Constants.GridToken_RemoteJobCreation,  
							model.isRemoteJobCreation()?Boolean.TRUE : Boolean.FALSE);
		if (model.isRemoteJobCreation())
			getSession().setAttribute(Constants.GridToken_BaseStudyCaseNetworkModel, model.getBaseNetModelString());
			
		// send protective rule set
		getSession().setAttribute(Constants.GridToken_ApplyAclfRuleBase, 
							model.isApplyAclfRuleBase()?Boolean.TRUE : Boolean.FALSE);
		if (model.isApplyAclfRuleBase())
			getSession().setAttribute(Constants.GridToken_AclfRuleBaseXml, model.getAclfRuleBaseXmlString());
		
		List<IpssGridGainAclfJob> jobList = new ArrayList<IpssGridGainAclfJob>();
		for (StudyCase studyCase : model.getStudyCaseList()) {
			// send the Aclf Net model (String) the remote node directly
			RemoteMessageTable remoteMsg = new RemoteMessageTable();
			remoteMsg.put(RemoteMessageTable.KEY_StudyCaseId, studyCase.getId());
			if (model.isRemoteJobCreation()) {
				if (studyCase.getModifyModelString() != null) {
					remoteMsg.put(RemoteMessageTable.KEY_StudyCaseModification, studyCase.getModifyModelString());
					//IpssLogger.getLogger().info("Study Case Modification: " + studyCase.getModifyModelString());
				}
			}
			else {
				remoteMsg.put(RemoteMessageTable.KEY_StudyCaseNetworkModel, studyCase.getNetModelString());
			}
			IpssGridGainAclfJob job = new IpssGridGainAclfJob(remoteMsg);

			// send the AclfAlgo string to the remote node through the task session
			// studyCase.id=net.id is used as the id for retrieving StudyCase info
			getSession().setAttribute(
					Constants.GridToken_AclfAlgo + studyCase.getId(),
					studyCase.getAclfAlgoModelString());

			if (IpssGridGainUtil.RemoteNodeDebug) {
				IpssLogger.getLogger().info("CaseId: " + studyCase.getId());
				IpssLogger.getLogger().info("Model String: " + studyCase.getNetModelString());
				IpssLogger.getLogger().info("AclfAlgo String: " + studyCase.getAclfAlgoModelString());
			}

			jobList.add(job);
		}
		return jobList;
	}
}
