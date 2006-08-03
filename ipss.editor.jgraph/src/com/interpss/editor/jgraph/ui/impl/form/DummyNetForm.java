package com.interpss.editor.jgraph.ui.impl.form;

import java.util.TreeSet;

import com.interpss.common.util.XmlUtil;
import com.interpss.editor.jgraph.ui.form.IGNetForm;
import com.interpss.editor.jgraph.ui.form.IUserData;

public class DummyNetForm implements IGNetForm, java.io.Serializable {
	private static final long serialVersionUID = 1;
	
    private String  netType = NetType_AclfNetwork;   		
	private String  appType = AppType_Transmission;  
	
    protected String id = "A Dummy Network";
    protected String name = "";
    private String  description = "This is a dummy network for dev purpose";

    private double  baseKVA = 0.0d;
    private double  freqHZ = 0.0d;

    private boolean newState = true;
	private TreeSet baseVoltList = new TreeSet();
	private int nextBusNumber = 0;
	private int nextBranchNumber = 0;

	/**
	*	Default constructor
	*/
    public DummyNetForm() {
    }	

	/**
	*	Constructor
	*
	* @param id net id
	*/
    public DummyNetForm(String id) {
        setId(id);
        rebuildRelation();
    }	    

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description;}

    public double getBaseKVA() {return this.baseKVA;}
    public void setBaseKVA(double baseKVA) {this.baseKVA = baseKVA;}

    public double getFreqHZ() {return this.freqHZ;}
    public void setFreqHZ(double freqHZ) {this.freqHZ = freqHZ;}

	public String getAppType() { return this.appType; }
	public void setAppType(String str) { this.appType = str; }
	
    public String getNetType() { return this.netType; }
    public void setNetType(String netType) { this.netType = netType; }
    
	public boolean isNewState() { return this.newState; }
	public void setNewState(boolean b) { this.newState = b; } 

	public TreeSet getBaseVoltList() { return this.baseVoltList; }
	public void setBaseVoltList(TreeSet vect) { this.baseVoltList = vect; } 
   
	public int getNextBusNumber() { return this.nextBusNumber; }
	public void setNextBusNumber(int n) { this.nextBusNumber = n; } 

	public int getNextBranchNumber() { return this.nextBranchNumber; }
	public void setNextBranchNumber(int n) { this.nextBranchNumber = n; } 

	public String getName() { return name;}
	public void setName(String name) {this.name = name;	}    
	
	// Additional functions
	// ====================

    public Object clone() {
		String xml = XmlUtil.toXmlString(this);
		return XmlUtil.toObject(xml);
    }

	/**
	 * @return Returns the name.
	 */
    public void rebuildRelation() {
    }
    
	/**
	*	Get the display string
	*
	* @return the display string
	*/
	public String getLabel(String type) {
		if (IUserData.NET_LABEL.equals(type))
			return getId();
		else if (IUserData.NET_ANNOTATE_LABEL.equals(type))
			return "Network Annotate Str";
		else
			return "Wrong label type: " + type;
	}

    /**
	*	Convert the object to a string representation
	*
	* @return the string representation
	*/
	public String toString() {
		return XmlUtil.toXmlString(this);
	}
}