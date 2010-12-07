package org.interpss.facts;

import org.apache.commons.math.complex.Complex;

import com.interpss.common.datatype.Matrix_xy;
import com.interpss.common.datatype.Vector_xy;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.impl.AbstractAclfBus;
import com.interpss.core.sparse.SparseEqnMatrix2x2;

/**
 * A SVC implementation
 * 
 *     i - The SVC connected bus position in the J-matrix
 *     n - The SVC position in the J-matrix
 * 
 */

public class SVCControl extends AbstractAclfBus {

	// network variables
	//AclfBus busi = null;  // bus the SVC connected to
	int position = 0;     // SVC position in the J-matrix

	// SVC variables
    private double vsh = 1.0;
    private double thetash = 0.0;  
    
    // SVC constants, do not change in the Loadflow calculation process
    SVCControlType ctype;
    private double gsh;
    private double bsh;
    private double qc;
    
	public SVCControl(AclfBus bus, int n, SVCControlType type) {
		this.setParentAclfBus(bus);
		this.position = n;
		this.ctype = type;
	}

	public AclfBus getBus() {
		return this.getParentAclfBus();
	}

	public int getPosition() {
		return position;
	} 
	
	public void setQc(double qc) {
		this.qc = qc;
	}
	
	public double getVsh() {
		return this.vsh;
	}

	public double getThedash() {
		return this.thetash;
	}

	public void setYsh(double gsh, double bsh) {
		this.gsh = gsh;
		this.bsh = bsh;
	}

	public Complex mismatch() {
		Complex pIn2Net = this.getParentAclfBus().powerIntoNet();
		// equivalent P+jQ of SVC
		Vector_xy pq = getBi();
		// extra load on the same bus
		Complex load = new Complex(getLoadP(), getLoadQ());
		return new Complex(pq.x,pq.y).subtract(load).subtract(pIn2Net);
	}
	
	// define extra load on the same bus
	@Override
	public boolean isLoad() {
		return true;
	}

	@Override
	public double getLoadP() {
		return 1.0;
	}

	@Override
	public double getLoadQ() {
		return 0.8;
	}

    /**
     * J-matrix element at [i,i]. It will used to modify (add to) the network J-matrix element
     * 
     * @return
     */
    public Matrix_xy getJii() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        if (this.ctype == SVCControlType.ConstV) {
        	// TODO: please verify
        	m.xy = -(-(2 * vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))) * vi); // dPi/dVi
        	m.xx = -(vi * vsh * (-gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash))); // dPi/dthetai
        	m.yy = -((2 * vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) * vi); // dQi/dVi
        	m.yx = -(vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dQi/dthetai
        }
        else if (this.ctype == SVCControlType.ConstQ) { 
        	// TODO: to be implemented
        }
        else if (this.ctype == SVCControlType.ConstX) { 
        	// TODO: to be implemented
        }
        return m;
    }
    
    /**
     * J-matrix element at [n,n]
     * 
     * @return
     */
    public Matrix_xy getJnn() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        // Update A part of the extended Jacobian
        Matrix_xy m = new Matrix_xy();
        // TODO
        m.yx = (2 * vsh * gsh - vi * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash))); // dPeq/dVsh
        m.yy = -vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetash
        m.xx = -vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash)); // dFSVC/dvsh
        m.xy = vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dFSVC/dthetash
        return m;
    }

    /**
     * J-matrix element at [i,n]
     * 
     * @return
     */
    public Matrix_xy getJin() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        
    	Matrix_xy m = new Matrix_xy();
        // TODO
    	m.xx = -(vi * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dPi/dVsh
        m.xy = -(vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dPi/dthetash
        m.yx = -(vi * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dQi/dVsh
        m.yy = -(-vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dQi/dthetash
    
        return m;
    }

    /**
     * J-matrix element at [n,i]
     * 
     * @return
     */
    public Matrix_xy getJni() {
    	double vi = getBus().getVoltageMag();
    	double thetai = getBus().getVoltageAng();
        Matrix_xy m = new Matrix_xy();
        
        // TODO
        m.yy = -vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)) * vi; // dPeq/dVi
        m.yx = vi * vsh * (gsh * Math.sin(thetai - thetash) + bsh * Math.cos(thetai - thetash)); // dPeq/dthetai
        m.xy = -(2 * vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) * vi; // dFSVC/dVi
        m.xx = -vi * vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash)); // dFSVC/dthetai
        return m;
    }

    
    /**
     * B vector element at [i]. It will be used to modify (add to) the network power mismatch vector
     * 
     * @return
     */
    public Vector_xy getBi() {
        double vi = getBus().getVoltageMag();
        double thetai = getBus().getVoltageAng();
        
        // TODO
        Vector_xy b = new Vector_xy();
        b.x = (vi * gsh - vsh * (gsh * Math.cos(thetai - thetash) + bsh * Math.sin(thetai - thetash))); // dFpi/Vi
        b.y = -(vi * bsh + vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))); // dFqi/Vi
        return b;
    }
    
    /**
     * B vector element at [n].
     * 
     * @return
     */
    public Vector_xy getBn() {
        double vi = getBus().getVoltageMag();
        double thetai = getBus().getVoltageAng();
        
        // TODO
        Vector_xy b = new Vector_xy();
        // dPeq
        b.y = (vsh * vsh * gsh - vi * vsh * (gsh * Math.cos(thetai - thetash) - bsh * Math.sin(thetai - thetash)));
        // dQi
        b.x = (-(vi * vi * bsh + vi * vsh * (gsh * Math.sin(thetai - thetash) - bsh * Math.cos(thetai - thetash))) - qc);
        return b;
    }

    /**
     * Update the SVC controller internal states only
     * 
     * @param lfEqn
     */
    public void update(SparseEqnMatrix2x2 lfEqn) {
        vsh -= lfEqn.getBVect_xy(this.position).x;
        thetash -= lfEqn.getBVect_xy(this.position).y;
//        System.out.println("vsh: " + vsh + ", thetash: " + thetash);
    }

}
