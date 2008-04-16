/*
 * @(#)IpssGridGainAclfJob.java   
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
 *  This Class is for performing grid computing for DStab network model 
 */

package org.interpss.gridgain.job;

import java.io.Serializable;

import org.interpss.PluginSpringAppContext;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.util.RemoteMessageTable;
import org.interpss.schema.AclfRuleBaseXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.xml.ProtectionRuleHanlder;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;

public class IpssGridGainAclfJob extends AbstractIpssGridGainJob {
	private static final long serialVersionUID = 1;

	/**
	 * Constructor
	 * 
	 * @param modelStr the string object sent to this job node 
	 */
	public IpssGridGainAclfJob(RemoteMessageTable remoteMsg) {
		super(remoteMsg);
	}

	/**
	 * perform the actual grid job computation
	 * 
	 * @param modelStr serialized AclfNet object
	 */
	protected Serializable performGridJob(RemoteMessageTable remoteMsg) {
		AclfNetwork net = null;
		
		Object model = null;
		if (getSesBooleanAttrib(Constants.GridToken_RemoteJobCreation)) {
			model = SerializeEMFObjectUtil.loadModel(getSesStringAttrib(Constants.GridToken_BaseStudyCaseNetworkModel));
			IpssLogger.getLogger().info("Remote job contructed using the base study case");
		}
		else {
			String modelStr = remoteMsg.getStudyCaseNetworkModel();
			model = SerializeEMFObjectUtil.loadModel(modelStr);
			IpssLogger.getLogger().info("Remote job contructed using the current study case");
		}
		
		if (model instanceof AclfNetwork)
			net = (AclfNetwork) model;
		else if (model instanceof AclfAdjNetwork)
			net = (AclfAdjNetwork) model;

		String caseId = remoteMsg.getStudyCaseId();
		if (getSesBooleanAttrib(Constants.GridToken_RemoteJobCreation)) {
			if (remoteMsg.getStudyCaseModification() != null) {
				try {
					//IpssLogger.getLogger().info("Study Case Modification: " + remoteMsg.getStudyCaseModification());
					ModificationXmlType mod = ModificationXmlType.Factory.parse(remoteMsg.getStudyCaseModification());
					IpssMapper mapper = PluginSpringAppContext.getIpssXmlMapper();
					mapper.mapping(mod, net, ModificationXmlType.class);
				} catch (Exception e) {
					IpssLogger.getLogger().severe(e.toString());
					//e.printStackTrace();
				}
			}
		}

		// get serialized algo string from the task session
		String algoStr = getSesStringAttrib(Constants.GridToken_AclfAlgo + caseId);
		//System.out.println(algoStr);
		LoadflowAlgorithm algo;
		if (algoStr != null) {
			// set algo attributes. These attributes are not serialized
			algo = (LoadflowAlgorithm) SerializeEMFObjectUtil.loadModel(algoStr);
			if (net instanceof AclfAdjNetwork) {
				//algo.setAdjAlgorithm(AlgorithmFactory.eINSTANCE.createAclfAdjustAlgorithm());
				algo.setAclfAdjNetwork((AclfAdjNetwork) net);
			} else {
				algo.setAclfNetwork(net);
			}
		} else {
			// this is more for testing purpose
			algo = CoreObjectFactory.createLoadflowAlgorithm(net);
		}

		if (getSesBooleanAttrib(Constants.GridToken_RemoteNodeDebug))
			debugOut(net, algo);
		
		// perform loadflow calculation
		try {
			algo.loadflow(SpringAppContext.getIpssMsgHub());
			if (getSesBooleanAttrib(Constants.GridToken_ApplyAclfRuleBase)) {
				String str = getSesStringAttrib(Constants.GridToken_AclfRuleBaseXml);
				if (str != null) {
					AclfRuleBaseXmlType ruleBase = AclfRuleBaseXmlType.Factory.parse(str);
					double max = getSesDoubleAttrib(Constants.GridToken_AclfOpt_BusVoltageUpperLimitPU);
					double min = getSesDoubleAttrib(Constants.GridToken_AclfOpt_BusVoltageLowerLimitPU);
					ProtectionRuleHanlder.applyAclfRuleSet(algo, ruleBase, max, min, this.getMsgHub());
				}
			}
		} catch (Exception e) {
			getRemoteResult().put(RemoteMessageTable.KEY_ReturnStatus, Boolean.FALSE);
			getRemoteResult().put(RemoteMessageTable.KEY_ReturnMessage, e.toString());
		}
 
		IRemoteResult resultHandler = RemoteResultFactory.createRemoteResultHandler();
		resultHandler.saveAclfResult(getRemoteResult(), caseId, getGrid().getLocalNode().getId().toString(), net, getSession());
		return getRemoteResult();
	}
	
	private synchronized void debugOut(AclfNetwork net, LoadflowAlgorithm algo) {
		IpssLogger.getLogger().info("CaseId: " + net.getId());
		IpssLogger.getLogger().info("AclfNet -->" + net.net2String());
		IpssLogger.getLogger().info("AclfAlgo -->" + algo.toString());
	}
}
