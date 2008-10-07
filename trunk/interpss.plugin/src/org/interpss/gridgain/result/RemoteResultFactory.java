 /*
  * @(#)RemoteResultFactory.java   
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
  * @Date 03/15/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.gridgain.result;

import org.interpss.gridgain.secass.ContingencyAnalysisResultHandler;
import org.interpss.gridgain.secass.ContingencyAnaysisJob;

import com.interpss.ext.gridgain.IRemoteResult;

public class RemoteResultFactory {
	public static IRemoteResult createHandler(Class<?> klass) {
		if (ContingencyAnaysisJob.class == klass)
			return new ContingencyAnalysisResultHandler();
		else
			return new DefaultRemoteResultHandler();
	}
}
