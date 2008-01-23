package org.interpss.schema;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.interpss.BaseTestSetup;
import org.interpss.xml.IpssXmlParser;
import org.junit.Test;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.dclf.DclfAlgorithm;
import com.interpss.core.dclf.DclfSensitivityType;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.simu.SimuObjectFactory;

public class DclfSchemaIeee14BusCaseTest extends BaseTestSetup {
	@Test
	public void runSingleAclfCaseTest() throws Exception {
		SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.ACLF_ADJ_NETWORK, msg);
		loadCaseData("testData/aclf/IEEE-14Bus.ipss", simuCtx);
		
		File xmlFile = new File("testData/xml/RunDclfCase.xml");
  		IpssXmlParser parser = new IpssXmlParser(xmlFile);
  		//System.out.println("----->" + parser.getRootElem().toString());

	  	assertTrue(parser.getRunStudyCase().getAnalysisRunType() == AnalysisRunTypeXmlData.RUN_DCLF);
		
	  	IPSSMsgHub msg = SpringAppContext.getIpssMsgHub();
	  	
		DclfAlgorithm algo = CoreObjectFactory.createDclfAlgorithm(simuCtx.getAclfAdjNet());
		assertTrue(algo.checkCondition(msg));
			
		RunDclfStudyCaseXmlType dclfCase = parser.getRunDclfStudyCaseList()[0];

		if (dclfCase.getCaculatelDclf()) {
			algo.calculateDclf(SpringAppContext.getIpssMsgHub());
			//System.out.println("0014->" + algo.getBusAngle(simuCtx.getAclfAdjNet().getBus("0014").getSortNumber())*Constants.RtoD);
			assertTrue(Math.abs(algo.getBusAngle(simuCtx.getAclfAdjNet().getBus("0012").getSortNumber())*Constants.RtoD+16.27115) < 0.0001);
			assertTrue(Math.abs(algo.getBusAngle(simuCtx.getAclfAdjNet().getBus("0013").getSortNumber())*Constants.RtoD+16.43665) < 0.0001);
			assertTrue(Math.abs(algo.getBusAngle(simuCtx.getAclfAdjNet().getBus("0014").getSortNumber())*Constants.RtoD+17.42943) < 0.0001);
		}
		
		for (DclfBusSensitivityXmlType sen : dclfCase.getSensitivityArray()) {
			if (sen.getType() == DclfSensitivityTypeXmlData.P_ANGLE) {
				algo.calculateSensitivity(DclfSensitivityType.PANGLE, sen.getInjectBusId(), msg);
				//System.out.println("P-0013->" + algo.getBusSensitivity(DclfSensitivityType.PANGLE, "0013", msg));
				//System.out.println("p-0012->" + algo.getBusSensitivity(DclfSensitivityType.PANGLE, "0012", msg));
				/*
				P-0013->-0.06163210033109512
				p-0012->-0.06132364240087546
				*/				
				for (BusRecXmlType bus : sen.getBusArray()) {
					double pang = algo.getBusSensitivity(DclfSensitivityType.PANGLE, bus.getBusId(), msg);
					assertTrue(	Math.abs(pang+0.06163) < 0.0001 ||
								Math.abs(pang+0.06132) < 0.0001);
				}
			}
			else if (sen.getType() == DclfSensitivityTypeXmlData.Q_VOLTAGE) {
				algo.calculateSensitivity(DclfSensitivityType.QVOLTAGE, sen.getInjectBusId(), msg);
				//System.out.println("Q-0013->" + algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE, "0013", msg));
				//System.out.println("Q-0012->" + algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE, "0012", msg));
				/*
				Q-0013->-0.06086676048791753
				Q-0012->-0.025252754409984517
				*/				
				for (BusRecXmlType bus : sen.getBusArray()) {
					double qvolt = algo.getBusSensitivity(DclfSensitivityType.QVOLTAGE, bus.getBusId(), msg);
					assertTrue(	Math.abs(qvolt+0.060867) < 0.0001 ||
								Math.abs(qvolt+0.025253) < 0.0001);
				}
			}
		}
		
		for (DclfBranchSensitivityXmlType gsFactor : dclfCase.getGenShiftFactorArray()) {
			algo.calculateSensitivity(DclfSensitivityType.PANGLE, gsFactor.getInjectBusId(), msg);
			for (BranchRecXmlType branch : gsFactor.getBranchArray()) {
				double gsf = algo.getGenShiftFactor(branch.getFromBusId(), branch.getToBusId(), msg);
				//System.out.println("GSF " + branch.getFromBusId() + "->" + branch.getToBusId() + " " + gsf);
				/*
				GSF 0004->0007 0.011086980682516566
				GSF 0004->0009 0.006361588236203221
				GSF 0005->0006 -0.017448568918720087
				*/				
				assertTrue(	Math.abs(gsf-0.011087) < 0.0001 ||
							Math.abs(gsf-0.006362) < 0.0001 ||
							Math.abs(gsf+0.017449) < 0.0001 );
			}
		}

		for (DclfBranchSensitivityXmlType tdFactor : dclfCase.getPTransferDistFactorArray()) {
			algo.calculateSensitivity(DclfSensitivityType.PANGLE, tdFactor.getInjectBusId(), tdFactor.getWithdrawBusId(), msg);
			double sum = 0.0;
			for (BranchRecXmlType branch : tdFactor.getBranchArray()) {
				double ptdf = algo.getPTransferDistFactor(branch.getFromBusId(), branch.getToBusId(), msg);
				sum += ptdf;
				//System.out.println("PTDF " + branch.getFromBusId() + "->" + branch.getToBusId() + " " + ptdf);
			}
			assertTrue(Math.abs(sum-1.0) < 0.0001);
		}
	}
}
