 /*
  * @(#)SimuCtxReportMapper.java   
  *
  * Copyright (C) 2006 www.interpss.org
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
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.report.mapper;

import java.util.Map;

import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.mapper.report.AclfResultMapperImpl;
import org.interpss.mapper.report.AcscResultMapperImpl;
import org.interpss.mapper.report.MasterfResultMapperImpl;
import org.interpss.report.bean.RptMainTitleBean;
import org.interpss.report.bean.aclf.RptAclfBusStyleBean;
import org.interpss.report.bean.aclf.RptAclfMaxMismatchBean;
import org.interpss.report.bean.aclf.RptAclfSummaryBusBean;
import org.interpss.report.bean.acsc.RptAcscVoltAmpsBean;
import org.interpss.report.bean.acsc.RptFaultSummaryBean;

import com.interpss.common.mapper.AbstractMapper;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.simu.SimuContext;

/**
*	Mapper to map SimuContext result to a list of report beans.
*/

public class SimuCtxReportMapper extends AbstractMapper {

	/**
	 * Constructor
	 * 
	 * @param msg
	 */
	public SimuCtxReportMapper(IPSSMsgHub msg) {
		setMsg(msg);
	}

	/**
	 * map a SimuNetwork object to an aclf report bean object
	 * 
	 * @param fromObj an AppSimuContext object
	 * @param toObj a report bean object
	 * @param kclass class type of the toObj 
	 */	
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		IAppSimuContext appSimuCtx = null;
		SimuContext simuCtx = null;
		if (fromObj instanceof IAppSimuContext) {
			appSimuCtx = (IAppSimuContext)fromObj;
			simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		}
		else if (fromObj instanceof SimuContext) {
			simuCtx = (SimuContext)fromObj;
		}
		
		if (klass == RptAclfMaxMismatchBean.class) {
			AclfResultMapperImpl.mapAclfMaxMismatch(simuCtx.getAclfNet(), (RptAclfMaxMismatchBean)toObj);
			return true;
		}
		if (klass == RptFaultSummaryBean.class) {
			AcscResultMapperImpl.mapAcscFaultSummary(simuCtx.getAcscFaultNet(), (RptFaultSummaryBean)toObj);
			return true;
		}
		else if (klass == RptMainTitleBean.class) {
			MasterfResultMapperImpl.mapMasterTitleBean(appSimuCtx, (RptMainTitleBean)toObj);
			return true;
		}
		throw new UnsupportedOperationException();
		
	}
	
	/**
	 *	Map SimuContext result to a list of report beans.
	 *
	 * @param fromObj an AppSimuContext object
	 * @param kclass report bean class
	 * @param a set of attributes
	 */
	public Object[] mappingMultiObject(Object fromObj, Class<?> klass, Map<String, Object> parameters) {
		SimuContext simuCtx = null;
		if (fromObj instanceof IAppSimuContext) {
			IAppSimuContext appSimuCtx = (IAppSimuContext)fromObj;
			simuCtx = (SimuContext)appSimuCtx.getSimuCtx();
		}
		else if (fromObj instanceof SimuContext) {
			simuCtx = (SimuContext)fromObj;
		}
		
		if (klass == RptAclfSummaryBusBean.class) {
			return AclfResultMapperImpl.createAclfSummaryBusBeanArray(simuCtx.getAclfNet());
		}
		else if (klass == RptAclfBusStyleBean.class) {
			return AclfResultMapperImpl.createAclfBusStyleBeanArray(simuCtx.getAclfNet());
		}
		else if (klass == PVBusLimit.class) {
			return AclfResultMapperImpl.createPVBusLimitBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == PQBusLimit.class) {
			return AclfResultMapperImpl.createPQBusLimitBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == FunctionLoad.class) {
			return AclfResultMapperImpl.createFunctionLoadBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == PSXfrPControl.class) {
			return AclfResultMapperImpl.createPSXfrPControlBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == RemoteQBus.class) {
			return AclfResultMapperImpl.createRemoteQBusBeanArray(simuCtx.getAclfAdjNet());
		}
		else if (klass == TapControl.class) {
			return AclfResultMapperImpl.createTapVControlBeanArray(simuCtx.getAclfAdjNet());
		}
		
		else if (klass == RptAcscVoltAmpsBean.class) {
			return AcscResultMapperImpl.createAcscVoltAmpsBeanArray(simuCtx.getAcscFaultNet());
		}
		throw new UnsupportedOperationException();
	}	
}