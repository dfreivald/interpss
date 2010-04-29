/*
 * @(#)IEEEODMMapper.java   
 *
 * Copyright (C) 2008 www.interpss.org
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
 * @Date 02/21/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.mapper;

import org.ieee.odm.model.JaxbODMModelParser;
import org.ieee.odm.model.xbean.XBeanODMModelParser;

import com.interpss.common.mapper.AbstractMapper;
import com.interpss.simu.SimuContext;

public class IEEEODMMapper extends AbstractMapper {

	public IEEEODMMapper() {
	}

	/**
	 * map(load) a IEEEODMPSSModelParser object into an InterPSS object of Type Class
	 * 
	 * @param fromObj a IEEEODMPSSModelParser object
	 * @param toObj an object of type Class
	 * @param kclass class type of the toObj 
	 */
	public boolean mapping(Object fromObj, Object toObj, Class<?> klass) {
		if (klass == SimuContext.class) {
			if (fromObj instanceof XBeanODMModelParser) {
				XBeanODMModelParser parser = (XBeanODMModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return org.interpss.mapper.ieee_odm.xbean.ODM2SimuCtxMapperImpl.odm2SimuCtxMapping(parser, simuCtx);
			}
			else if (fromObj instanceof JaxbODMModelParser) {
				JaxbODMModelParser parser = (JaxbODMModelParser) fromObj;
				SimuContext simuCtx = (SimuContext) toObj;
				return org.interpss.mapper.ieee_odm.jaxb.ODM2SimuCtxMapperImpl.odm2SimuCtxMapping(parser, simuCtx);
			}
		} 
		return true;
	}
}
