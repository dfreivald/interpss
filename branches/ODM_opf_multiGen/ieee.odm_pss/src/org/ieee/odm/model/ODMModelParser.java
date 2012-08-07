 /*
  * @(#)ODMModelParser.java   
  *
  * Copyright (C) 2009 www.interpss.org
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
  * @Date 04/11/2009
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.model;

import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.acsc.AcscModelParser;
import org.ieee.odm.model.dc.DcSystemModelParser;
import org.ieee.odm.model.dist.DistModelParser;
import org.ieee.odm.model.dstab.DStabModelParser;
import org.ieee.odm.model.opf.OpfModelParser;
import org.ieee.odm.schema.NetworkXmlType;

/**
 * A generic Xml parser for the IEEE DOM schema, used when the network type is unknown 
 */

public class ODMModelParser extends AbstractModelParser {
	/**
	 * Default Constructor 
	 * 
	 */
	public ODMModelParser() {
		super();
	}
	
	/**
	 * create the base case object of type LoadflowXmlType
	 */
	@Override public NetworkXmlType createBaseCase() {
		ODMLogger.getLogger().severe("Programming error: ODMModelParser.createBaseCase() called");
		return null;
	}
	
	public AclfModelParser toAclfModelParser() {
		return (AclfModelParser)copyTo(new AclfModelParser());
	}
 	
	public AcscModelParser toAcscModelParser() {
		return (AcscModelParser)copyTo(new AcscModelParser());
	}

	public DcSystemModelParser toDcSystemModelParser() {
		return (DcSystemModelParser)copyTo(new DcSystemModelParser());
	}

	public DistModelParser toDistModelParser() {
		return (DistModelParser)copyTo(new DistModelParser());
	}

	public DStabModelParser toDStabModelParser() {
		return (DStabModelParser)copyTo(new DStabModelParser());
	}

	public OpfModelParser toOpfModelParser() {
		return (OpfModelParser)copyTo(new OpfModelParser(OpfModelParser.OpfNetType.OPF));
	}
	
	private AbstractModelParser copyTo(AbstractModelParser parser) {
		parser.objectCache = this.objectCache;
		parser.pssStudyCase = this.pssStudyCase;
		return parser;
	}
}
