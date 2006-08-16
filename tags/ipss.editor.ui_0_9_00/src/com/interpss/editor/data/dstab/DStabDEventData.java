package com.interpss.editor.data.dstab;

import com.interpss.common.rec.BaseDataBean;
import com.interpss.editor.data.acsc.AcscFaultData;

public class DStabDEventData extends BaseDataBean {
	public static final String DEventType_BusFault = "BusFault";
	public static final String DEventType_BranchFault = "BranchFault";
	public static final String DEventType_LoadChange = "LoadChange";
	
	public static final String NewEventName = "<Not Defined>";
	
	private String eventName = NewEventName;
    private double startTime = 0.0;
    private double duration = 0.0;
    private boolean permanent = false;
    private String type = DEventType_BusFault;
    private AcscFaultData faultData = null;
    private DStabLoadChangeData loadChangeData = null;

	/**
	 * @return Returns the faultData.
	 */
	public AcscFaultData getFaultData() {
		if (faultData == null)
			faultData = new AcscFaultData();
		return faultData;
	}

	/**
	 * @param faultData The faultData to set.
	 */
	public void setFaultData(AcscFaultData faultData) {
		this.faultData = faultData;
	}

	/**
	 * @return Returns the duration.
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration The duration to set.
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return Returns the startTime.
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime The startTime to set.
	 */
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return Returns the eventName.
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName The eventName to set.
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return Returns the permanent.
	 */
	public boolean isPermanent() {
		return permanent;
	}

	/**
	 * @param permanent The permanent to set.
	 */
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the loadChangeData.
	 */
	public DStabLoadChangeData getLoadChangeData() {
		if (loadChangeData == null)
			loadChangeData = new DStabLoadChangeData();
		return loadChangeData;
	}

	/**
	 * @param loadChangeData The loadChangeData to set.
	 */
	public void setLoadChangeData(DStabLoadChangeData loadChangeData) {
		this.loadChangeData = loadChangeData;
	}
}
