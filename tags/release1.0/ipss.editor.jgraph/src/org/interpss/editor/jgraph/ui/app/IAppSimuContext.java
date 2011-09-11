 /*
  * @(#)IAppSimuContext.java   
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

package org.interpss.editor.jgraph.ui.app;

import javax.swing.JPopupMenu;

import org.interpss.editor.jgraph.ui.data.IProjectData;


public interface IAppSimuContext {
	void reset();
	void releaseResource();
	
	Object getSimuCtx();
	void setSimuCtx(Object ctx);
	boolean isSimuNetDataDirty();
	void setSimuNetDataDirty(boolean b);
	
	IProjectData getProjData();
	void setProjData(IProjectData info);
	
	boolean isLfConverged();
	void setLfConverged(boolean b);

	boolean isScCalculated();
	void setScCalculated(boolean scCalculated);
   
	String getCurrentCaseName(String caseType);

	int getLastRunType();
	void setLastRunType(int lastRunType);	
	boolean hasLastRun();	
	
	/**
	 * Check if the current AcscRunForm has a non-symmetric fault
	 * 
	 * @return
	 */
	boolean isNonSymmetricFault();
	
	void addPopupMenuAction(JPopupMenu menu, final Object cell);
}