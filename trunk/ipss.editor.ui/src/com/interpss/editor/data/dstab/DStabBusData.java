package com.interpss.editor.data.dstab;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.data.aclf.AclfBusData;
import com.interpss.editor.data.acsc.AcscBusData;

public class DStabBusData extends BaseDataBean {
	public boolean isMachineBus() {
		return getAcscBusData().getGenCode().equals(AclfBusData.GenCode_PQ) || 
			   getAcscBusData().getGenCode().equals(AclfBusData.GenCode_PV) ||
			   getAcscBusData().getGenCode().equals(AclfBusData.GenCode_Swing);
	}
	
	public boolean isMotorBus() {
		return getAcscBusData().getLoadCode().equals(AclfBusData.LoadCode_ConstI) || 
			   getAcscBusData().getLoadCode().equals(AclfBusData.LoadCode_ConstP) ||
			   getAcscBusData().getLoadCode().equals(AclfBusData.LoadCode_ConstZ) ||
		       getAcscBusData().getLoadCode().equals(AclfBusData.LoadCode_FuncLoad);
	}
	
	private AcscBusData acscBusData = null;
	public AcscBusData getAcscBusData() { return acscBusData; }
	public void setAcscBusData(AcscBusData data) { acscBusData = data; }
	
	private DStabMachData machData = new DStabMachData();
	public DStabMachData getMachData() { return machData; }
	public void setMachData(DStabMachData data) { machData = data; }
}
