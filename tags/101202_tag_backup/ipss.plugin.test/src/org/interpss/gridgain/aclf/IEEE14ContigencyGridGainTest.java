 /*
  * @(#)DStab_5BusGridGainTest.java   
  *
  * Copyright (C) 2007 www.interpss.org
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
  * @Date 10/15/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.aclf;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.interpss.gridgain.GridBaseTestSetup;
import org.interpss.gridgain.GridRunner;
import org.interpss.gridgain.job.ContingencyAnaysisJob;
import org.interpss.gridgain.msg.RemoteMessageTable;
import org.interpss.gridgain.result.IRemoteResult;
import org.interpss.gridgain.result.RemoteResultFactory;
import org.interpss.gridgain.util.GridUtil;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.BranchChangeRecXmlType;
import org.interpss.schema.ModificationXmlType;
import org.junit.Test;

import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.core.net.Branch;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.RemoteMessageType;
import com.interpss.simu.multicase.aclf.AclfStudyCase;
import com.interpss.simu.multicase.aclf.ContingencyAnalysis;
import com.interpss.simu.multicase.modify.BranchModification;
import com.interpss.simu.multicase.modify.Modification;

public class IEEE14ContigencyGridGainTest extends GridBaseTestSetup {
	@Test
	public void AlgoEMFCaseTest() throws Exception {
		/*
		 * step-1 Build the base case
		 */
    	SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
		//System.out.println(net.net2String());	
		// network id needs to be set. It is used for identification purpse
		net.setId("IEEE 14_Bus");
		
		/*
		 * step-2 Define LF algorithem
		 */
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, msg);
	  	//algo.setLfMethod(AclfMethod.PQ);

	  	/*
	  	 * step-3 define multiple study cases
	  	 */
		ContingencyAnalysis mCaseContainer = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_NETWORK, net);
		// save the base case Network model to the netStr
		mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(net));

		int caseNo = 0;
		for (Branch branch : net.getBranchList()) {
			AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase("caseId"+caseNo++, 
					"Open Branch "+branch.getId(), caseNo, mCaseContainer);
			// if Grid computing, save the Algo object to the study case object
			studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));

			/*
			// define modification to the case
			AclfStudyCaseXmlType xmlCase = AclfStudyCaseXmlType.Factory.newInstance();
			ModificationXmlType mod = xmlCase.addNewModification();
			BranchChangeRecXmlType branchChange = mod.addNewBranchChangeRecList().addNewBranchChangeRec();
			branchChange.setFromBusId(branch.getFromBus().getId());
			branchChange.setToBusId(branch.getToBus().getId());
			branchChange.setCircuitNumber(branch.getCircuitNumber());
			branchChange.setOffLine(true);
			
			// persist modification to be sent to the remote grid node
			studyCase.setModificationString(xmlCase.getModification().xmlText());
			studyCase.setModStringType(RemoteMessageType.IPSS_XML);
			*/
			
			BranchModification braMod = SimuObjectFactory.createBranchModification(
					branch.getFromBus().getId(), 
					branch.getToBus().getId(), 
					branch.getCircuitNumber(), net);
			braMod.setOutService(true);
			
			Modification mod = SimuObjectFactory.createModification(braMod);
			studyCase.setModification(mod);			
		}

		/**
		 * Step-5 perform grid computing
		 */
		try {
			Grid grid = GridUtil.getDefaultGrid();
			long timeout = 0;
			RemoteMessageTable[] objAry = new GridRunner(grid,	"InterPSS Grid Aclf Calculation", 
							mCaseContainer).executeMultiJob(timeout);
			for (RemoteMessageTable result : objAry) {
				IRemoteResult resultHandler = RemoteResultFactory.createHandler(ContingencyAnaysisJob.class);
				resultHandler.transferRemoteResult(mCaseContainer, result);
			}
		} catch (GridException e) {
			System.out.println(e.toString());
		} 
		
		/**
		 * Step-6 process results
		 */
		//IRemoteResult resultHandler = RemoteResultFactory.createHandler(IpssGridGainAclfJob.class);
		//System.out.println(resultHandler.toString(IRemoteResult.DisplayType_NoUsed, mCaseContainer).toString());
		
		IRemoteResult resultHandler = RemoteResultFactory.createHandler(ContingencyAnaysisJob.class);
		System.out.println(resultHandler.toString(IRemoteResult.DisplayType_SecViolation, mCaseContainer).toString());		
		System.out.println(resultHandler.toString(IRemoteResult.DisplayType_SecAssessment, mCaseContainer).toString());		
		
		/*
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		AclfStudyCase aclfCase = (AclfStudyCase)scase;
    		if (scase.getNetModelString() != null) {
    			AclfAdjNetwork aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
    			aclfAdjNet.rebuildLookupTable();
    			assertTrue(aclfAdjNet.isLfConverged());
    		}
    	}
    	*/	
	}	

	@Test
	public void AlgoXmlCaseTest() throws Exception {
		/*
		 * step-1 Build the base case
		 */
    	SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
		//System.out.println(net.net2String());	
		// network id needs to be set. It is used for identification purpse
		net.setId("IEEE 14_Bus");
		
		/*
		 * step-2 Define LF algorithem
		 */
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net, msg);
	  	//algo.setLfMethod(AclfMethod.PQ);

	  	/*
	  	 * step-3 define multiple study cases
	  	 */
		ContingencyAnalysis mCaseContainer = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_NETWORK, net);
		// save the base case Network model to the netStr
		mCaseContainer.setBaseNetModelString(SerializeEMFObjectUtil.saveModel(net));

		int caseNo = 0;
		for (Branch branch : net.getBranchList()) {
			AclfStudyCase studyCase = SimuObjectFactory.createAclfStudyCase("caseId"+caseNo++, 
					"Open Branch "+branch.getId(), caseNo, mCaseContainer);
			// if Grid computing, save the Algo object to the study case object
			studyCase.setAclfAlgoModelString(SerializeEMFObjectUtil.saveModel(algo));

			// define modification to the case
			AclfStudyCaseXmlType xmlCase = AclfStudyCaseXmlType.Factory.newInstance();
			ModificationXmlType mod = xmlCase.addNewModification();
			BranchChangeRecXmlType branchChange = mod.addNewBranchChangeRecList().addNewBranchChangeRec();
			branchChange.setFromBusId(branch.getFromBus().getId());
			branchChange.setToBusId(branch.getToBus().getId());
			branchChange.setCircuitNumber(branch.getCircuitNumber());
			branchChange.setOffLine(true);
			
			// persist modification to be sent to the remote grid node
			studyCase.setModificationString(xmlCase.getModification().xmlText());
			studyCase.setModStringType(RemoteMessageType.IPSS_XML);
		}

		/**
		 * Step-5 perform grid computing
		 */
		try {
			Grid grid = GridUtil.getDefaultGrid();
			long timeout = 0;
			RemoteMessageTable[] objAry = new GridRunner(grid,	"InterPSS Grid Aclf Calculation", 
							mCaseContainer).executeMultiJob(timeout);
			for (RemoteMessageTable result : objAry) {
				IRemoteResult resultHandler = RemoteResultFactory.createHandler(ContingencyAnaysisJob.class);
				resultHandler.transferRemoteResult(mCaseContainer, result);
			}
		} catch (GridException e) {
			System.out.println(e.toString());
		} 
		
		/**
		 * Step-6 process results
		 */
		//IRemoteResult resultHandler = RemoteResultFactory.createHandler(IpssGridGainAclfJob.class);
		//System.out.println(resultHandler.toString(IRemoteResult.DisplayType_NoUsed, mCaseContainer).toString());
		
		IRemoteResult resultHandler = RemoteResultFactory.createHandler(ContingencyAnaysisJob.class);
		System.out.println(resultHandler.toString(IRemoteResult.DisplayType_SecViolation, mCaseContainer).toString());		
		System.out.println(resultHandler.toString(IRemoteResult.DisplayType_SecAssessment, mCaseContainer).toString());		
		
		/*
    	for (StudyCase scase : mCaseContainer.getStudyCaseList()) {
    		AclfStudyCase aclfCase = (AclfStudyCase)scase;
    		if (scase.getNetModelString() != null) {
    			AclfAdjNetwork aclfAdjNet = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(scase.getNetModelString());
    			aclfAdjNet.rebuildLookupTable();
    			assertTrue(aclfAdjNet.isLfConverged());
    		}
    	}
    	*/	
	}	
}