/**
 * <copyright>
 * </copyright>
 *
 * $Id: Reservoir.java,v 1.1 2007/03/02 14:01:06 mzhou Exp $
 */
package org.opencim.cim.iec61970.gen.production;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.core.PowerSystemResource;

import org.opencim.cim.iec61970.domain.SpillwayGateType;

import org.opencim.datatype.real.Seconds;
import org.opencim.datatype.real.Volume;
import org.opencim.datatype.real.WaterLevel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reservoir</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A water storage facility within a hydro system, including: ponds, lakes, lagoons, and rivers. The storage is usually behind some type of dam.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getActiveStorageCapacity <em>Active Storage Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getEnergyStorageRating <em>Energy Storage Rating</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getFullSupplyLevel <em>Full Supply Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getGrossCapacity <em>Gross Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getNormalMinOperateLevel <em>Normal Min Operate Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getRiverOutletWorks <em>River Outlet Works</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillTravelDelay <em>Spill Travel Delay</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCapacity <em>Spillway Capacity</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLength <em>Spillway Crest Length</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLevel <em>Spillway Crest Level</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillWayGateType <em>Spill Way Gate Type</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getHydroPowerPlants <em>Hydro Power Plants</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getUpstreamFrom <em>Upstream From</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getLevelVsVolumeCurve <em>Level Vs Volume Curve</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getTargetLevelSchedule <em>Target Level Schedule</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getInflowForecast <em>Inflow Forecast</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsInto <em>Spills Into</em>}</li>
 *   <li>{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsFrom <em>Spills From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir()
 * @generated
 */
public interface Reservoir extends PowerSystemResource {
	/**
	 * Returns the value of the '<em><b>Active Storage Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Storage volume (in Mm3) between the full supply level and the normal minimum operating level
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Active Storage Capacity</em>' attribute.
	 * @see #setActiveStorageCapacity(Volume)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_ActiveStorageCapacity()
	 * @generated
	 */
	Volume getActiveStorageCapacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getActiveStorageCapacity <em>Active Storage Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Storage Capacity</em>' attribute.
	 * @see #getActiveStorageCapacity()
	 * @generated
	 */
	void setActiveStorageCapacity(Volume value);

	/**
	 * Returns the value of the '<em><b>Energy Storage Rating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The reservoir's energy storage rating in MWh for given head conditions
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Energy Storage Rating</em>' attribute.
	 * @see #setEnergyStorageRating(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_EnergyStorageRating()
	 * @generated
	 */
	Float getEnergyStorageRating();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getEnergyStorageRating <em>Energy Storage Rating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Energy Storage Rating</em>' attribute.
	 * @see #getEnergyStorageRating()
	 * @generated
	 */
	void setEnergyStorageRating(Float value);

	/**
	 * Returns the value of the '<em><b>Full Supply Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Full supply level, above which water will spill. This can be the spillway crest level or the top of closed gates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Full Supply Level</em>' attribute.
	 * @see #setFullSupplyLevel(WaterLevel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_FullSupplyLevel()
	 * @generated
	 */
	WaterLevel getFullSupplyLevel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getFullSupplyLevel <em>Full Supply Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Supply Level</em>' attribute.
	 * @see #getFullSupplyLevel()
	 * @generated
	 */
	void setFullSupplyLevel(WaterLevel value);

	/**
	 * Returns the value of the '<em><b>Gross Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Total capacity of reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gross Capacity</em>' attribute.
	 * @see #setGrossCapacity(Volume)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_GrossCapacity()
	 * @generated
	 */
	Volume getGrossCapacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getGrossCapacity <em>Gross Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gross Capacity</em>' attribute.
	 * @see #getGrossCapacity()
	 * @generated
	 */
	void setGrossCapacity(Volume value);

	/**
	 * Returns the value of the '<em><b>Normal Min Operate Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Normal minimum operating level below which the penstocks will draw air
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Normal Min Operate Level</em>' attribute.
	 * @see #setNormalMinOperateLevel(WaterLevel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_NormalMinOperateLevel()
	 * @generated
	 */
	WaterLevel getNormalMinOperateLevel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getNormalMinOperateLevel <em>Normal Min Operate Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Normal Min Operate Level</em>' attribute.
	 * @see #getNormalMinOperateLevel()
	 * @generated
	 */
	void setNormalMinOperateLevel(WaterLevel value);

	/**
	 * Returns the value of the '<em><b>River Outlet Works</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * River outlet works for riparian right releases or other purposes
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>River Outlet Works</em>' attribute.
	 * @see #setRiverOutletWorks(String)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_RiverOutletWorks()
	 * @generated
	 */
	String getRiverOutletWorks();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getRiverOutletWorks <em>River Outlet Works</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>River Outlet Works</em>' attribute.
	 * @see #getRiverOutletWorks()
	 * @generated
	 */
	void setRiverOutletWorks(String value);

	/**
	 * Returns the value of the '<em><b>Spill Travel Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The spillway water travel delay to the next downstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spill Travel Delay</em>' attribute.
	 * @see #setSpillTravelDelay(Seconds)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillTravelDelay()
	 * @generated
	 */
	Seconds getSpillTravelDelay();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillTravelDelay <em>Spill Travel Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spill Travel Delay</em>' attribute.
	 * @see #getSpillTravelDelay()
	 * @generated
	 */
	void setSpillTravelDelay(Seconds value);

	/**
	 * Returns the value of the '<em><b>Spillway Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The flow capacity of the spillway in cubic meters per second
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spillway Capacity</em>' attribute.
	 * @see #setSpillwayCapacity(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillwayCapacity()
	 * @generated
	 */
	Float getSpillwayCapacity();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCapacity <em>Spillway Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spillway Capacity</em>' attribute.
	 * @see #getSpillwayCapacity()
	 * @generated
	 */
	void setSpillwayCapacity(Float value);

	/**
	 * Returns the value of the '<em><b>Spillway Crest Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The length of the spillway crest in meters
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spillway Crest Length</em>' attribute.
	 * @see #setSpillwayCrestLength(Float)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillwayCrestLength()
	 * @generated
	 */
	Float getSpillwayCrestLength();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLength <em>Spillway Crest Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spillway Crest Length</em>' attribute.
	 * @see #getSpillwayCrestLength()
	 * @generated
	 */
	void setSpillwayCrestLength(Float value);

	/**
	 * Returns the value of the '<em><b>Spillway Crest Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Spillway crest level above which water will spill
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spillway Crest Level</em>' attribute.
	 * @see #setSpillwayCrestLevel(WaterLevel)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillwayCrestLevel()
	 * @generated
	 */
	WaterLevel getSpillwayCrestLevel();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillwayCrestLevel <em>Spillway Crest Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spillway Crest Level</em>' attribute.
	 * @see #getSpillwayCrestLevel()
	 * @generated
	 */
	void setSpillwayCrestLevel(WaterLevel value);

	/**
	 * Returns the value of the '<em><b>Spill Way Gate Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.opencim.cim.iec61970.domain.SpillwayGateType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of spillway gate, including parameters
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spill Way Gate Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SpillwayGateType
	 * @see #setSpillWayGateType(SpillwayGateType)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillWayGateType()
	 * @generated
	 */
	SpillwayGateType getSpillWayGateType();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillWayGateType <em>Spill Way Gate Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spill Way Gate Type</em>' attribute.
	 * @see org.opencim.cim.iec61970.domain.SpillwayGateType
	 * @see #getSpillWayGateType()
	 * @generated
	 */
	void setSpillWayGateType(SpillwayGateType value);

	/**
	 * Returns the value of the '<em><b>Hydro Power Plants</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getReservoir <em>Reservoir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generators discharge water to or pumps are supplied water from a downstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hydro Power Plants</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_HydroPowerPlants()
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getReservoir
	 * @generated
	 */
	EList getHydroPowerPlants();

	/**
	 * Returns the value of the '<em><b>Upstream From</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getGenSourcePumpDischarge <em>Gen Source Pump Discharge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generators are supplied water from or pumps discharge water to an upstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Upstream From</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_UpstreamFrom()
	 * @see org.opencim.cim.iec61970.gen.production.HydroPowerPlant#getGenSourcePumpDischarge
	 * @generated
	 */
	EList getUpstreamFrom();

	/**
	 * Returns the value of the '<em><b>Level Vs Volume Curve</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.LevelVsVolumeCurve}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reservoir may have a level versus volume relationship.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level Vs Volume Curve</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_LevelVsVolumeCurve()
	 * @generated
	 */
	EList getLevelVsVolumeCurve();

	/**
	 * Returns the value of the '<em><b>Target Level Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reservoir may have a water level target schedule.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Level Schedule</em>' containment reference.
	 * @see #setTargetLevelSchedule(TargetLevelSchedule)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_TargetLevelSchedule()
	 * @generated
	 */
	TargetLevelSchedule getTargetLevelSchedule();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getTargetLevelSchedule <em>Target Level Schedule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Level Schedule</em>' containment reference.
	 * @see #getTargetLevelSchedule()
	 * @generated
	 */
	void setTargetLevelSchedule(TargetLevelSchedule value);

	/**
	 * Returns the value of the '<em><b>Inflow Forecast</b></em>' containment reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.InflowForecast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reservoir may have a "natural" inflow forecast.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inflow Forecast</em>' containment reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_InflowForecast()
	 * @generated
	 */
	EList getInflowForecast();

	/**
	 * Returns the value of the '<em><b>Spills Into</b></em>' reference list.
	 * The list contents are of type {@link org.opencim.cim.iec61970.gen.production.Reservoir}.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsFrom <em>Spills From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reservoir may spill into a downstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spills Into</em>' reference list.
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillsInto()
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsFrom
	 * @generated
	 */
	EList getSpillsInto();

	/**
	 * Returns the value of the '<em><b>Spills From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsInto <em>Spills Into</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A reservoir may spill into a downstream reservoir
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spills From</em>' reference.
	 * @see #setSpillsFrom(Reservoir)
	 * @see org.opencim.cim.iec61970.gen.production.ProductionPackage#getReservoir_SpillsFrom()
	 * @see org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsInto
	 * @generated
	 */
	Reservoir getSpillsFrom();

	/**
	 * Sets the value of the '{@link org.opencim.cim.iec61970.gen.production.Reservoir#getSpillsFrom <em>Spills From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spills From</em>' reference.
	 * @see #getSpillsFrom()
	 * @generated
	 */
	void setSpillsFrom(Reservoir value);

} // Reservoir