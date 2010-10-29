package org.interpss.contigency;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.mapper.IpssXmlMapper;
import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.ModificationXmlType;
import org.interpss.schema.RunStudyCaseXmlType;
import org.interpss.xml.IpssXmlParser;
import org.interpss.xml.PreventiveRuleHanlder;

import com.interpss.common.SpringAppContext;
import com.interpss.common.mapper.IpssMapper;
import com.interpss.common.util.SerializeEMFObjectUtil;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.netAdj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfAdjustAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;
import com.interpss.simu.multicase.aclf.AclfStudyCase;
import com.interpss.simu.multicase.aclf.ContingencyAnalysis;
import com.interpss.simu.multicase.result.AclfBranchResultRec;
import com.interpss.simu.multicase.result.AclfBusResultRec;

public class ContingencyXmlCaseTest extends BaseTestSetup {
	//@Test
	public void simpleCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_NETWORK, simuCtx.getAclfNet());

	  	String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfNet());

		File xmlFile = new File("testData/xml/contingency/simpleTest.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
  		
	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == RunStudyCaseXmlType.AnalysisRunType.CONTINGENCY_ANALYSIS);
  		
	  	int cnt = 0;
	  	for ( AclfStudyCaseXmlType aclfCase : parser.getContingencyAnalysis().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfNetwork net = (AclfNetwork)SerializeEMFObjectUtil.loadModel(netStr);
			net.rebuildLookupTable();
			AclfAdjustAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, SpringAppContext.getIpssMsgHub());
		  	IpssMapper mapper = new IpssXmlMapper();
		  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	mapper.mapping(parser.getContingencyAnalysis().getDefaultAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		  	
	  		assertTrue(algo.loadflow());
	  		
	  		AclfStudyCase scase = SimuObjectFactory
	  				.createAclfStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.getResult().transferAclfResult(net);
	  		
	  		mscase.updateResult("Description", scase.getResult());
	  	}

		AclfBusResultRec rbus = mscase.getBusResultSummary().get("0001");
  		assertTrue(rbus != null);
	  	assertTrue(Math.abs(rbus.getHighVoltMagPU()-1.0600) < 0.001);
	  	assertTrue(Math.abs(rbus.getLowVoltMagPU()-1.0600) < 0.001);
		
		rbus = mscase.getBusResultSummary().get("0014");
  		assertTrue(rbus != null);
	  	assertTrue(Math.abs(rbus.getHighVoltMagPU()-1.0486) < 0.001);
	  	assertTrue(Math.abs(rbus.getLowVoltMagPU()-1.04355) < 0.001);

	  	AclfBranchResultRec rbra = mscase.getBranchResultSummary().get("0002->0003(1)");
  		assertTrue(rbra != null);
	  	assertTrue(Math.abs(rbra.getMvaFlow()-76.535) < 0.01);
/*	  	
		IRemoteResult resultHandler = RemoteResultFactory
				.createHandler(ContingencyAnaysisJob.class);
		System.out.println(resultHandler
				.toString(IRemoteResult.DisplayType_SecAssessment, mscase)
				.toString());

		System.out.println(resultHandler
				.toString(IRemoteResult.DisplayType_SecViolation, mscase)
				.toString());
*/				
	}
	
	//@Test
	public void ieee14BusCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/xml/contingency/IEEE-14Bus.ipss", simuCtx);
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_NETWORK, simuCtx.getAclfNet());

	  	String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfNet());

		File xmlFile = new File("testData/xml/contingency/IEEE-14Bus_ContingencyAnalysis.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
  		
	  	int cnt = 0;
	  	for ( AclfStudyCaseXmlType aclfCase : parser.getContingencyAnalysis().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
			net.rebuildLookupTable();
			AclfAdjustAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, SpringAppContext.getIpssMsgHub());
		  	IpssMapper mapper = new IpssXmlMapper();
		  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	mapper.mapping(parser.getContingencyAnalysis().getDefaultAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		  	
	  		assertTrue(algo.loadflow());
	  		
	  		AclfStudyCase scase = SimuObjectFactory
	  				.createAclfStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.getResult().transferAclfResult(net);
	  		
	  		mscase.updateResult("Description", scase.getResult());
	  	}
/*	  	
		IRemoteResult resultHandler = RemoteResultFactory
				.createHandler(ContingencyAnaysisJob.class);
		System.out.println(resultHandler
				.toString(IRemoteResult.DisplayType_SecViolation, mscase)
				.toString());
*/
	  	AclfBranchResultRec r = mscase.getBranchResultSummary().get("0001->0002(1)");
	  	assertTrue(Math.abs(r.getMvaFlow() - 241.1) < 0.1);
	}
	
	//@Test
	public void ieee14BusRuleSetCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_NETWORK, msg);
		loadCaseData("testData/xml/contingency/IEEE-14Bus.ipss", simuCtx);
	  	ContingencyAnalysis mscase = SimuObjectFactory.createContingencyAnalysis(SimuCtxType.ACLF_NETWORK, simuCtx.getAclfNet());

	  	String netStr = SerializeEMFObjectUtil.saveModel(simuCtx.getAclfNet());

		File xmlFile = new File("testData/xml/contingency/IEEE-14Bus_RuleSet.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());
  		
	  	int cnt = 0;
	  	for ( AclfStudyCaseXmlType aclfCase : parser.getContingencyAnalysis().getAclfStudyCaseList().getAclfStudyCaseArray()) {
			AclfAdjNetwork net = (AclfAdjNetwork)SerializeEMFObjectUtil.loadModel(netStr);
			net.rebuildLookupTable();
			AclfAdjustAlgorithm algo = CoreObjectFactory.createAclfAdjAlgorithm(net, SpringAppContext.getIpssMsgHub());
		  	IpssMapper mapper = new IpssXmlMapper();
		  	mapper.mapping(aclfCase.getModification(), net, ModificationXmlType.class);
		  	mapper.mapping(parser.getContingencyAnalysis().getDefaultAclfAlgorithm(), algo, AclfAlgorithmXmlType.class);
		  	
	  		assertTrue(algo.loadflow());
			PreventiveRuleHanlder.applyRuleSet2AclfNet(algo, parser.getRuleBase(), 1.1, 0.9, msg);
	  		
	  		AclfStudyCase scase = SimuObjectFactory
	  				.createAclfStudyCase(aclfCase.getRecId(), aclfCase.getRecName(), ++cnt, mscase);
	  		scase.getResult().transferAclfResult(net);
	  		
	  		mscase.updateResult("Description", scase.getResult());
	  	}
/*
		IRemoteResult resultHandler = RemoteResultFactory
				.createHandler(ContingencyAnaysisJob.class);
		System.out.println(resultHandler
				.toString(IRemoteResult.DisplayType_SecViolation, mscase)
				.toString());
*/
		AclfBranchResultRec r = mscase.getBranchResultSummary().get("0001->0002(1)");
	  	assertTrue(Math.abs(r.getMvaFlow() - 207.96) < 0.1);
	}
}
