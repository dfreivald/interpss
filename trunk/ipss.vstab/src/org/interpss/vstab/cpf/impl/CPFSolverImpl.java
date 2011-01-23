package org.interpss.vstab.cpf.impl;

import org.interpss.vstab.cpf.CPFAlgorithm;
import org.interpss.vstab.cpf.CPFSolver;
import org.interpss.vstab.cpf.CpfStopCriteria.AnalysisStopCriteria;

import com.interpss.core.CoreObjectFactory;
import com.interpss.core.algo.LoadflowAlgorithm;

public class CPFSolverImpl implements CPFSolver{

//    protected LoadIncPattern _loadIncPtn=null;
//    protected GenDispPattern _genDispPtn=null;
    private boolean cpfConverged=false;
    private boolean isCpfStop=false;
	private LambdaParam lambda=null;
	CPFAlgorithm cpfAlgo=null;
    private CorrectorStepSolver corrStepSolver;
    private PredictorStepSolver predStepSolver;
	private int sortNumOfContPara;
    
	public CPFSolverImpl() {
		
	}
	public CPFSolverImpl(CPFAlgorithm algo,LambdaParam newLambda) {
		this.cpfAlgo=algo;
		this.lambda=newLambda;
		this.corrStepSolver=new CorrectorStepSolver(algo);
		this.predStepSolver=new PredictorStepSolver(algo,lambda);
		
	}

	@Override
	public boolean isCPFConverged() {
		
		return cpfConverged;
	}
	public void setCpfConverged(boolean convg) {
		this.cpfConverged=convg;
	}

	@Override
	public boolean solveCPF() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean correctorStep() {
		LoadflowAlgorithm algo = CoreObjectFactory.createLoadflowAlgorithm();
		algo.setNrSolver(corrStepSolver);
		if(!this.cpfAlgo.getAclfNetwork().accept(algo)) {
			return false;
		}
		return true;
	       

	}
	@Override
	public boolean predictorStep() {
		
		return true;
	}
	private boolean isCpfStop() {
		if(this.cpfAlgo.getAnalysisStopCriteria()==AnalysisStopCriteria.FULL_CUREVE) {
			if(this.lambda.getValue()<0.1) return this.isCpfStop=true;
		}
		else if(this.cpfAlgo.getAnalysisStopCriteria()==AnalysisStopCriteria.MAX_POWER_POINT) {
			if(this.predStepSolver.isCrossMPP) return isCpfStop=true;
		}
		else{ if(cpfAlgo.isAnyViolation()) return isCpfStop=true;
		}
		return isCpfStop=false;
		
	}
	@Override
	public CorrectorStepSolver getCorrStepSolver() {
		
		return this.corrStepSolver;
	}
	@Override
	public LambdaParam getLambda() {
		
		return this.lambda;
	}
	@Override
	public PredictorStepSolver getPredStepSolver() {
		
		return this.predStepSolver;
	}

	@Override
	public int getSortNumOfContParam() {
		
		return this.sortNumOfContPara;
	}


	@Override
	public void setSorNumofContParam(int sortNum) {
		this.sortNumOfContPara=sortNum;
		
	}


	@Override
	public boolean isLmdaContParam() {
		return this.getSortNumOfContParam()==this.lambda.getPosition();
	}
	

}
