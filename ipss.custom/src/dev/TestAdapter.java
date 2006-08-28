package dev;

import ipss.custom.exchange.FileAdapter_PTIFormat;

import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.StdoutMsgListener;
import com.interpss.common.msg.TextMessage;
import com.interpss.core.CoreObjectFactory;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.algorithm.LoadflowAlgorithm;
import com.interpss.simu.SimuContext;
import com.interpss.simu.io.IpssFileAdapter;


public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPSSMsgHub msg = null;
		try {
			msg = new IPSSMsgHub();
			msg.addMsgListener(new StdoutMsgListener(TextMessage.TYPE_STATUS));
			
			testPTIAdapter(msg);
 		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

	public static void testPTIAdapter(IPSSMsgHub msg) throws Exception {
		IpssFileAdapter adapter = new FileAdapter_PTIFormat();
		SimuContext simuCtx = adapter.load("testData/psse_uguide_sample.psse", msg);

		AclfNetwork net = simuCtx.getAclfNet();

	  	LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm(net);
	  	algo.loadflow(msg);
  		System.out.println(net.net2String());
	}	
}
