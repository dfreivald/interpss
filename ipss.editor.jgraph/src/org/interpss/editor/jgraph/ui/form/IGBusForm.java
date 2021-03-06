 /*
  * @(#)IGBusForm.java   
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

package org.interpss.editor.jgraph.ui.form;

/**
 * Bus form interface. A bus form object is a placeholder for bus data
 */

public interface IGBusForm extends IUserData {
	public static final byte
			H_Orientation = 1,
			V_Orientation = 2;

	/**
	 * Get bus orientation
	 * 
	 * @return
	 */
	byte getOrientation();
	
	/**
	 * Set bus orientation
	 * 
	 * @param b
	 */
	void setOrientation(byte b);
	
	/**
	 * Set Bus annotation label
	 * 
	 * @param l
	 */
	void setAnnotateLabel(String l);
	
}