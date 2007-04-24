/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JavaBean to store data for the Simple excitor model
 *
 * $Id$
 */

package org.interpss.dstab.control.exc.ieee.y1968.type4;

import org.interpss.dstab.control.base.BaseControllerData;

public class Ieee1968Type4ExciterData extends BaseControllerData {
	private double kv = 1.0;
	private double trh = 2.0;
	private double vrmax = 3.0;
	private double vrmin = 4.0;
	private double ke = 0.0;
	private double te = 0.0;
	private double e1 = 0.0;
	private double seE1 = 0.0;
	private double e2 = 0.0;
	private double seE2 = 0.0;
	private double kf = 0.0;
	private double tf = 0.0;
	
	private static String[][] controllerParameters= { 
		//          min         max
		{"kv", 		"-1000.0", 	"1000.0"}, 
		{"trh", 	"-1000.0", 	"1000.0"}, 
		{"vrmax", 	"-1000.0", 	"1000.0"}, 
		{"vrmin", 	"-1000.0", 	"1000.0"}, 
		{"ke", 		"-1000.0", 	"1000.0"}, 
		{"te", 		"-1000.0", 	"1000.0"}, 
		{"e1", 		"-1000.0", 	"1000.0"}, 
		{"seE1", 	"-1000.0", 	"1000.0"}, 
		{"e2", 		"-1000.0", 	"1000.0"}, 
		{"seE2", 	"-1000.0", 	"1000.0"}, 
		{"kf", 		"-1000.0", 	"1000.0"}, 
		{"tf", 		"-1000.0", 	"1000.0"} 
	};

	public Ieee1968Type4ExciterData() {
		setRangeParameters(controllerParameters);
	}

	public void setValue(String name, int value) {
	}

	public void setValue(String name, double value) {
		if (name.equals("kv"))
			this.kv = value;
		else if (name.equals("trh"))
			this.trh = value;
		else if (name.equals("vrmax"))
			this.vrmax = value;
		else if (name.equals("vrmin"))
			this.vrmin = value;
		else if (name.equals("ke"))
			this.ke = value;
		else if (name.equals("te"))
			this.te = value;
		else if (name.equals("e1"))
			this.e1 = value;
		else if (name.equals("seE1"))
			this.seE1 = value;
		else if (name.equals("e2"))
			this.e2 = value;
		else if (name.equals("seE2"))
			this.seE2 = value;
		else if (name.equals("kf"))
			this.kf = value;
		else if (name.equals("tf"))
			this.tf = value;
	}
	
	public double getKv() {
		return kv;
	}
	public void setKv(final double ka) {
		this.kv = ka;
	}
	public double getTrh() {
		return trh;
	}
	public void setTrh(final double ta) {
		this.trh = ta;
	}
	public double getVrmax() {
		return vrmax;
	}
	public void setVrmax(final double vrmax) {
		this.vrmax = vrmax;
	}
	public double getVrmin() {
		return vrmin;
	}
	public void setVrmin(final double vrmin) {
		this.vrmin = vrmin;
	}
	public double getE1() {
		return e1;
	}
	public void setE1(double e1) {
		this.e1 = e1;
	}
	public double getE2() {
		return e2;
	}
	public void setE2(double e2) {
		this.e2 = e2;
	}
	public double getKe() {
		return ke;
	}
	public void setKe(double ke) {
		this.ke = ke;
	}
	public double getKf() {
		return kf;
	}
	public void setKf(double kf) {
		this.kf = kf;
	}
	public double getSeE1() {
		return seE1;
	}
	public void setSeE1(double seE1) {
		this.seE1 = seE1;
	}
	public double getSeE2() {
		return seE2;
	}
	public void setSeE2(double seE2) {
		this.seE2 = seE2;
	}
	public double getTe() {
		return te;
	}
	public void setTe(double te) {
		this.te = te;
	}
	public double getTf() {
		return tf;
	}
	public void setTf(double tf) {
		this.tf = tf;
	}
}

