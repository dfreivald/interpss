/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * An implementation of the Simple governor model
 *
 * $Id$
 */

package com.interpss.dstab.control.gov.ieee.ieeeST2;

import com.interpss.common.datatype.LimitType;
import com.interpss.common.exp.InvalidInputException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.common.util.XmlUtil;
import com.interpss.dstab.DynamicSimuMethods;
import com.interpss.dstab.control.gov.AbstractGovernor;

public class IeeeST2Governor extends AbstractGovernor {
	// state variables
	private double statePm = 0.0, statePref = 0.0, stateX1 = 0.0, stateX2 = 0.0, stateX3 = 0.0, stateX4 = 0.0, stateX5 = 0.0;
	private LimitType limit = null;

	// UI Editor panel
	private static final NBIeeeST2GovernorEditPanel _editPanel = new NBIeeeST2GovernorEditPanel();

	/**
	 * Default Constructor
	 *
	 */
	public IeeeST2Governor() {
		this("govId", "IeeeST2Governor");
	}
	
	/**
	 * Constructor
	 * 
	 * @param id governor id
	 * @param name governor name
	 */	
	public IeeeST2Governor(final String id, final String name) {
		super(id, name);
		// _data is defined in the parent class. However init it here is a MUST
		_data = new IeeeST2GovernorData();
	}
	
	/**
	 * Get the governor data 
	 * 
	 * @return the data object
	 */
	public IeeeST2GovernorData getData() {
		return (IeeeST2GovernorData)_data;
	}
	
	/**
	 * Set controller parameters
	 * 
	 * @param xmlString controller parameter xml string
	 */
	@Override
	public void setDataXmlString(final String xmlString) {
		super.setDataXmlString(xmlString);
		_data = XmlUtil.toObject(xmlString, IeeeST2GovernorData.class);
	}
	
	/**
	 *  Init the controller states
	 *  
	 *  @param msg the SessionMsg object
	 */
	@Override
	public void initStates(final IPSSMsgHub msg) {
		limit = new LimitType(getData().getPmax(), getData().getPmin());
		statePref = getMachine().getPm();
        if (limit.isViolated(statePref)) {
        	msg.sendErrorMsg("Machine initial mechanical power Pm0 violates its governor power limits, " +
        			"machine id: " + getMachine().getId());
        }
		stateX1 = 0.0;
		stateX2 = statePref;
		stateX3 = stateX2;
		stateX4 = stateX3;
		stateX5 = stateX4;
		IpssLogger.getLogger().fine("Governor Limit:      " + limit);
	}
	
	/**
	 * Perform one step d-eqn calculation
	 *  
	 * @param dt simulation time interval
	 * @param method d-eqn solution method
	 *  @param msg the SessionMsg object
	 */	
	@Override
	public void nextStep(final double dt, final DynamicSimuMethods method, final double baseFreq, final IPSSMsgHub msg) {
		if (method == DynamicSimuMethods.MODIFIED_EULER_LITERAL) {
			/*
			 *     Step-1 : x(1) = x(0) + dx_dt(1) * dt
			 *     Step-2 : x(2) = x(0) + 0.5 * (dx_dt(2) + dx_dt(1)) * dt
			 */
			final double dX1_dt = cal_dX1_dt(stateX1);
			final double dX2_dt = cal_dX2_dt(stateX1, stateX2);
			final double dX3_dt = cal_dX3_dt(stateX2, stateX3);
			final double dX4_dt = cal_dX4_dt(stateX3, stateX4);
			final double dX5_dt = cal_dX5_dt(stateX4, stateX5);
			
			final double X1_1 = stateX1 + dX1_dt * dt;
			final double X2_1 = limit.limit(stateX2 + dX2_dt * dt);
			final double X3_1 = stateX3 + dX3_dt * dt;
			final double X4_1 = stateX4 + dX4_dt * dt;
			final double X5_1 = stateX5 + dX5_dt * dt;
			stateX1 = stateX1 + 0.5 * (cal_dX1_dt(X1_1) + dX1_dt) * dt;
			stateX2 = limit.limit(stateX2 + 0.5 * (cal_dX2_dt(X1_1,X2_1) + dX2_dt) * dt);
			stateX3 = stateX3 + 0.5 * (cal_dX3_dt(X2_1,X3_1) + dX3_dt) * dt;
			stateX4 = stateX4 + 0.5 * (cal_dX4_dt(X3_1,X4_1) + dX4_dt) * dt;
			stateX5 = stateX5 + 0.5 * (cal_dX5_dt(X4_1,X5_1) + dX5_dt) * dt;
		}
		else if (method == DynamicSimuMethods.RUNGE_KUTTA_LITERAL) {
			// TODO: TBImpl
		} else {
			throw new InvalidInputException("SimpleGovernor.nextStep(), invalid method");
		}
	}	

	private double cal_dX1_dt(final double X1) {
		return ( 100.0*(getMachine().getSpeed() - 1.0)/getData().getR()  - X1 ) / getData().getT1();
	}
	
	private double cal_dX2_dt(final double X1, final double X2) {
		double p = getData().getOptMode() == AbstractGovernor.DroopMode? statePref : statePm;
		return ( p - X1 - X2 ) / getData().getT2();
	}

	private double cal_dX3_dt(final double X2, final double X3) {
		return ( X2 - X3 ) / getData().getT3();
	}

	private double cal_dX4_dt(final double X3, final double X4) {
		return ( X3 - X4 ) / getData().getT4();
	}

	private double cal_dX5_dt(final double X4, final double X5) {
		return ( X4 - X5 ) / getData().getT5();
	}

	/**
	 * Get the controller output
	 * 
	 * @return the output
	 */	
	@Override
	public double getOutput() {
		return stateX5 * getData().getFp3() + stateX4 * getData().getFp2() + stateX3 * getData().getFp1();
	}

	/**
	 * Get the editor panel for controller data editing
	 * 
	 * @return the editor panel object
	 */	
	@Override
	public Object getEditPanel() {
		_editPanel.init(this);
		return _editPanel;
	}
} // SimpleExcAdapter
