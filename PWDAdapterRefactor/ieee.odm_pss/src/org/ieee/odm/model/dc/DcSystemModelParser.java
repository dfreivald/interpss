 /*
  * @(#)DcSystemModelParser.java   
  *
  * Copyright (C) 2010 www.interpss.org
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
  * @Date 11/11/2010
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.odm.model.dc;

import static org.ieee.odm.ODMObjectFactory.odmObjFactory;

import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.model.base.BaseJaxbHelper;
import org.ieee.odm.schema.DcBranchXmlType;
import org.ieee.odm.schema.DcBusXmlType;
import org.ieee.odm.schema.DcNetworkXmlType;
import org.ieee.odm.schema.NetworkXmlType;

/**
 * A Xml parser for the IEEE DOM schema. 
 */

public class DcSystemModelParser extends AbstractModelParser {
	/**
	 * Default Constructor 
	 * 
	 */
	public DcSystemModelParser() {
		super();
	}	
	
	/**
	 * get the base case object of type DcNetworkXmlType
	 * 
	 * @return
	 */
	public DcNetworkXmlType getDcNet() {
		return (DcNetworkXmlType)getBaseCase();
	}
	
	/**
	 * create the base case object of type DcNetworkXmlType
	 */
	@Override
	public NetworkXmlType createBaseCase() {
		if (getStudyCase().getBaseCase() == null) {
			DcNetworkXmlType baseCase = odmObjFactory.createDcNetworkXmlType();
			
			baseCase.setBusList(odmObjFactory.createNetworkXmlTypeBusList());
			baseCase.setBranchList(odmObjFactory.createNetworkXmlTypeBranchList());
			getStudyCase().setBaseCase(BaseJaxbHelper.network(baseCase));
		}
		return getStudyCase().getBaseCase().getValue();
	}
	
	/*
	 * 		Bus functions
	 * 		=============
	 */

	/**
	 * add a new Bus record to the base case
	 * 
	 * @return
	 */
	public DcBusXmlType createDcBus() {
		DcBusXmlType busRec = odmObjFactory.createDcBusXmlType();
		busRec.setOffLine(false);
		busRec.setAreaNumber(1);
		busRec.setZoneNumber(1);
		getBaseCase().getBusList().getBus().add(BaseJaxbHelper.bus(busRec));
		return busRec;
	}	
	
	/**
	 * create a bus object with the id, make sure there is no duplication
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DcBusXmlType createDcBus(String id) throws Exception {
		DcBusXmlType busRec = createDcBus();
		busRec.setId(id);
		if (this.objectCache.get(id) != null) {
			throw new Exception("Bus record duplication, bus id: " + id);
		}
		this.objectCache.put(id, busRec);
		return busRec;
	}		
	
	/**
	 * add a new bus record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public DcBusXmlType createDcBus(String id, long number) throws Exception {
		DcBusXmlType busRec = createDcBus(id);
		busRec.setNumber(number);
		return busRec;
	}	
	
	/**
	 * get the bus object using the id
	 * 
	 * @param id
	 * @return
	 */
	public DcBusXmlType getDcBus(String id) {
		return (DcBusXmlType)getBus(id);
	}

	/*
	 * 		Branch functions
	 * 		================
	 */
	
	public void addDcBranch(DcBranchXmlType branch) {
		getBaseCase().getBranchList().getBranch().add(BaseJaxbHelper.branch(branch));
		this.objectCache.put(branch.getId(), branch);
	}
	
	/**
	 * get the Line branch object
	 * 
	 * @param fromId
	 * @param toId
	 * @param cirId
	 * @return
	 */
	public DcBranchXmlType getDcBranch(String fromId, String toId, String cirId) {
		return (DcBranchXmlType)getBranch(fromId, toId, cirId);
	}

	/**
	 * create a LineBranchXmlType object
	 * 
	 * @return
	 */
	public DcBranchXmlType createDcBranch() {
		DcBranchXmlType branch = odmObjFactory.createDcBranchXmlType();
		intiBranchData(branch);
		return branch;
	}

	/**
	 * add a new Line branch record to the base case and to the cache table
	 * 
	 * @param id
	 * @return
	 */
	public DcBranchXmlType createDcBranch(String fromId, String toId, String cirId) throws Exception {
		DcBranchXmlType branch = createDcBranch();
		addBranch2BaseCase(branch, fromId, toId, null, cirId);
		return branch;
	}
}
