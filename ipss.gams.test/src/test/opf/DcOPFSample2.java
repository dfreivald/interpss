package test.opf;

import java.io.File;
import java.io.FileInputStream;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.model.opf.OpfModelParser;
import org.interpss.IpssCorePlugin;
import org.interpss.mapper.odm.ODMOpfDataMapper;
import org.interpss.numeric.sparse.ISparseEqnDouble;

import com.gams.api.gamsglobals;
import com.interpss.CoreObjectFactory;
import com.interpss.SimuObjectFactory;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBranch;
import com.interpss.core.aclf.JacobianMatrixType;
import com.interpss.core.net.Branch;
import com.interpss.core.net.Bus;
import com.interpss.gams.GAMS;
import com.interpss.gams.common.GAMSException;
import com.interpss.gams.common.GAMSLogger;
import com.interpss.gams.util.GAMSHelper;
import com.interpss.opf.OpfBus;
import com.interpss.opf.OpfGenBus;
import com.interpss.opf.OpfNetwork;
import com.interpss.pssl.simu.BaseDSL;
import com.interpss.simu.SimuContext;
import com.interpss.simu.SimuCtxType;
import com.interpss.spring.CoreCommonSpringFactory;

/**
 *    ODM -> OpfNetwork object -> GAMS routine -> InterPSS Display 
 * 
 */

public class DcOPFSample2 {
	 public static void main(String[] args) {
	    	GAMS.GamsDir = "c:\\Program Files (x86)\\GAMS23.7";
	    	GAMS.JNIDir = "c:/eclipse/JNI";
	    	
	    	new DcOPFSample2().run();
	 }
	
	private void run() {
	 		try {
	   	 		GAMS.init();
	   	 			
	   	 		OpfNetwork opfNet = loadOpfNet("basecase\\opf_3bus.xml");
	   	   	    writeModelInputData("dcopf_input.gdx", opfNet);
	   	 			
	   	 		GAMSHelper helper = new GAMSHelper();
	   	   	    helper.CallGams("model\\dcopf1.gms", GAMS.OutLogLevel_Log, GAMS.RunLogLevel_WARN);
	   	   	    
	   	   	    helper.readResult("results.gdx", new String[] {"result"}, 
	   	        			helper.getResultReader1D());	   	   	    
	 		} catch (Exception e) {
		 		GAMSLogger.getLogger().severe(e.toString());
	 	 	} finally {
	   	   	    GAMS.free();
	   	 	}	
	}

	private OpfNetwork loadOpfNet(String filename) throws Exception {
		IpssCorePlugin.init();
		IPSSMsgHub msg = CoreCommonSpringFactory.getIpssMsgHub();
		BaseDSL.setMsgHub(msg);
					
		File file = new File(filename);
		OpfModelParser parser = ODMObjectFactory.createOpfModelParser();
		if (parser.parse(new FileInputStream(file))) {
			//System.out.println(parser.toXmlDoc(false));
				
			SimuContext simuCtx = SimuObjectFactory.createSimuNetwork(SimuCtxType.OPF_NET);
			if (!new ODMOpfDataMapper()
						.map2Model(parser, simuCtx)) {
		  		throw new Exception("Error: ODM model to InterPSS SimuCtx mapping error, please contact support@interpss.com");
			}	
			return (OpfNetwork) simuCtx.getOpfNet();
		}		 
  		throw new Exception("Error: reading file " + filename);
	 }
	 
	 private void writeModelInputData(String inputFile, OpfNetwork opfNet) throws GAMSException {
		double baseMav = opfNet.getBaseKva() * 0.001;
		 
		GAMS.gdxOpenWrite(inputFile, "DCOPF");

		GAMS.gdxDataWriteStrStart("BusIndex", "bus index", 1, gamsglobals.dt_set, 0);
		for (Bus b : opfNet.getBusList()) {
			GAMS.gdxDataWriteIndex(b.getId());
		}
		GAMS.gdxDataWriteDone();
		
		GAMS.gdxDataWriteStrStart("GenIndex", "generator bus index", 1, gamsglobals.dt_set, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfBus bus = (OpfBus)b;
			if (bus.isGen())
				GAMS.gdxDataWriteIndex("gen"+b.getId());
		}
		GAMS.gdxDataWriteDone();
		
        GAMS.gdxDataWriteStrStart("RealPower", "real power load drawn at LSE k", 1, gamsglobals.dt_par, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfBus bus = (OpfBus)b;
			GAMS.gdxDataWriteStr(b.getId(), bus.getLoadP());
		}
		GAMS.gdxDataWriteDone();
		
        GAMS.gdxDataWriteStrStart("ACoeff", "linear cost coefficient at generator i", 1, gamsglobals.dt_par, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfGenBus bus = (OpfGenBus)b;
			GAMS.gdxDataWriteStr("gen"+b.getId(), bus.getIncCost().getQuadraticCurve().getA());
		}
		GAMS.gdxDataWriteDone();
		
        GAMS.gdxDataWriteStrStart("BCoeff", "quantratic  const coefficient at generator i", 1, gamsglobals.dt_par, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfGenBus bus = (OpfGenBus)b;
			GAMS.gdxDataWriteStr("gen"+b.getId(), bus.getIncCost().getQuadraticCurve().getB());
		}
		GAMS.gdxDataWriteDone();
		
        GAMS.gdxDataWriteStrStart("Pgmax", "max real power output at generator i(in pu unit)", 1, gamsglobals.dt_par, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfGenBus bus = (OpfGenBus)b;
			GAMS.gdxDataWriteStr("gen"+b.getId(), bus.getPGenLimit().getMax()/baseMav);
		}
		GAMS.gdxDataWriteDone();
		
        GAMS.gdxDataWriteStrStart("Pgmin", "min real power output at generator i(in pu unit)", 1, gamsglobals.dt_par, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfGenBus bus = (OpfGenBus)b;
			GAMS.gdxDataWriteStr("gen"+b.getId(), bus.getPGenLimit().getMin()/baseMav);
		}
		GAMS.gdxDataWriteDone();
		
		GAMS.gdxDataWriteStrStart("BMatrix", "the [B] matrix of the network", 2, gamsglobals.dt_par, 0);
        opfNet.accept(CoreObjectFactory.createBusNoArrangeVisitor());
		ISparseEqnDouble eqn = opfNet.formB1Matrix(JacobianMatrixType.FULL_BMATRIX);
		//System.out.println(eqn.toString());

		for (Bus bi : opfNet.getBusList()) {
			int i = bi.getSortNumber(); 
			for (Bus bj : opfNet.getBusList()) {
				int j = bj.getSortNumber();
				double b = eqn.getAij(i, j);
				if (b != 0.0)
					GAMS.gdxDataWrite2D(bi.getId(), bj.getId(), (i==j?-b:b));   
			}
		}
        GAMS.gdxDataWriteDone();
        
        GAMS.gdxDataWriteStrStart("Rating", "branch rating limit in pu unit", 2, gamsglobals.dt_par, 0);
        for (Branch bra : opfNet.getBranchList()) {
			AclfBranch branch = (AclfBranch)bra;
	        GAMS.gdxDataWrite2D(bra.getFromBusId(), bra.getToBusId(), branch.getRatingMva1()/baseMav);   
	        GAMS.gdxDataWrite2D(bra.getToBusId(), bra.getFromBusId(), branch.getRatingMva1()/baseMav);
		}
        GAMS.gdxDataWriteDone();

        GAMS.gdxDataWriteStrStart("BusGenRelation", "bus and generator relationship table", 2, gamsglobals.dt_par, 0);
		for (Bus b : opfNet.getBusList()) {
			OpfBus bus = (OpfBus)b;
			if (bus.isGen())
	            GAMS.gdxDataWrite2D(b.getId(), "gen"+b.getId(), 1);   
		}
        GAMS.gdxDataWriteDone();
		
        GAMS.gdxClose();
	}
}
