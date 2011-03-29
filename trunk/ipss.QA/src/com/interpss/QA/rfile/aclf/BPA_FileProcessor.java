package com.interpss.QA.rfile.aclf;

import org.interpss.numeric.util.NumericUtil;

import com.interpss.QA.rfile.Base_FileProcessor;
import com.interpss.common.datatype.UnitType;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;


public class BPA_FileProcessor extends Base_FileProcessor {
	private boolean busDataProcessed = false,
	                busRecordBegin = false,
	                busRecordEnd = false;
	
	private AclfBus bus = null;
	
	public BPA_FileProcessor(AclfNetwork net) {
		this.net = net;
	}
	
	@Override
	public boolean processLine(String lineStr) throws InterpssException {
		if (!busDataProcessed) {
			if (lineStr.contains("kV        MW      MVAR")) {
				this.busRecordBegin = true;
				
			}
			else if (lineStr.contains("-------  -------          -------  -------  ------  ------  ------")) {
				this.busRecordEnd = true;
				this.busDataProcessed = true;
			}
			else if (this.busRecordBegin && !this.busRecordEnd) {
				if (!lineStr.trim().equals("")) {
/*
                     kV        MW      MVAR 功率因数     MW     MVAR    使用的  存在的  未安排                      PU/度           
   bus-1    100.0   104.0     71.6     27.0  0.94        0.0      0.0     0.0     0.0     0.0    S           1   1.040/   0.0
 */
					this.totalBus++;
					this.busId = lineStr.substring(0, 8).trim();
					//System.out.println(busid.trim() + ":" + lineStr);
					String str = lineStr.substring(113,125);
					String[] ary = str.split("/");
					this.busVoltage = new Double(ary[0].trim()).doubleValue();  // 0.9920PU
					this.busAngle = new Double(ary[1].trim()).doubleValue();
					//System.out.println(this.busId + ", " + this.busVoltage + ", " + this.busAngle);
					
					bus = this.net.getAclfBus(this.busId);
					if (bus == null) {
						IpssLogger.getLogger().severe("bus = null, " + lineStr);
					}
					
					double volt = bus.getVoltageMag();
					if (!NumericUtil.equals(this.busVoltage, volt, 0.001)) {
						String msg = "Bus voltage mag mismatch: Bus-" + this.busNo + ", " + 
								     this.busVoltage + ", " + String.format("%5.4f, %4.3f", volt,  
								     Math.abs(100.0*(this.busVoltage - volt)/this.busVoltage)) + "%";
						//IpssLogger.getLogger().warning(msg);
						addErrMsg(msg, lineStr);
					}

					double ang = bus.getVoltageAng(UnitType.Deg);
					if (!NumericUtil.equals(this.busAngle, ang, 0.1)) {
						String msg = "Bus voltage ang mismatch: Bus-" + this.busNo + ", " + 
										this.busAngle + ", " + String.format("%5.2f, %4.3f", ang,
										Math.abs(100.0*(this.busAngle - ang)/this.busAngle)) + "%";
						//IpssLogger.getLogger().warning(msg);
						addErrMsg(msg, lineStr);
					}					
				}
			}
		}
		return true;
	}
}
