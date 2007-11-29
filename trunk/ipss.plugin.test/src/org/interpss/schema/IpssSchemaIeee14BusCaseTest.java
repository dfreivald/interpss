package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.core.adapter.IpssXmlAdapter;
import org.interpss.core.adapter.XmlNetParamModifier;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class IpssSchemaIeee14BusCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/RunAclfCase.xml");
  		IpssXmlAdapter parser = new IpssXmlAdapter(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		RunAclfStudyCaseXmlType aclfCase = parser.getRunAclfStudyCaseList()[0];
	  	assertTrue(parser.getRunStudyCase().getAnalysisRunTask() == AnalysisRunTaskXmlData.RUN_ACLF);
  		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	parser.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);
	  	
	  	assertTrue(algo.getMaxIterations() == 20);
	  	assertTrue(algo.getTolerance() == 1.0E-4);
	  	
  		assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	}			

	@Test
	public void runSingleAclfCaseModificationTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/RunAclfCaseModification.xml");
  		IpssXmlAdapter parser = new IpssXmlAdapter(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		RunAclfStudyCaseXmlType aclfCase = parser.getRunAclfStudyCaseList()[0];
  		
	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	// modification of the study case also applied
	  	parser.mapping(aclfCase, algo, RunAclfStudyCaseXmlType.class);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadCode() == AclfLoadCode.EXPONENTIAL);
	  	
	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);

	  	assertTrue(algo.loadflow(SpringAppContext.getIpssMsgHub()));
	}

	@Test
	public void modificationOnlyTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		AclfNetwork net = simuCtx.getAclfNet();
  		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

		File xmlFile = new File("testData/xml/ModificationOnly.xml");
  		IpssXmlAdapter parser = new IpssXmlAdapter(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

  		ModificationXmlType mod = parser.getModification();
  		XmlNetParamModifier.applyModification2Net(net, mod);
	  	
	  	assertTrue(!net.getBranch("0010->0009(1)").isActive());
	  	assertTrue(!net.getBus("0006").isActive());
	  	
	  	// load increased by 0.1 pu
	  	assertTrue(net.getAclfBus("0014").getLoadP() == 1.1*0.149);
	  	assertTrue(net.getAclfBus("0014").getLoadQ() == 1.1*0.05);
	  	
	  	// load set to 0.15+j0.06 pu
	  	assertTrue(net.getAclfBus("0013").getLoadP() == 0.15);
	  	assertTrue(net.getAclfBus("0013").getLoadQ() == 0.06);

	  	// load added 1.0+j1.0 MVA
	  	assertTrue(net.getAclfBus("0012").getLoadP() == 0.071);
	  	assertTrue(Math.abs(net.getAclfBus("0012").getLoadQ()-0.026) < 1.0E-5);

	  	// branch Z increase by 10%
	  	assertTrue(Math.abs(net.getAclfBranch("0004->0007(1)").getZ().getImaginary()-0.20912*1.1) < 1.0E-5);
	}
}
