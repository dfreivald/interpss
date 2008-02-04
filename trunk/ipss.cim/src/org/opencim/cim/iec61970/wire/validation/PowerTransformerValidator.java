/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.opencim.cim.iec61970.wire.validation;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.domain.TransformerCoolingType;
import org.opencim.cim.iec61970.domain.TransformerType;

import org.opencim.cim.iec61970.wire.HeatExchanger;

import org.opencim.datatype.real.PerCent;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.PhaseCode;

/**
 * A sample validator interface for {@link org.opencim.cim.iec61970.wire.PowerTransformer}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface PowerTransformerValidator {
	boolean validate();

	boolean validateBmagSat(PerCent value);
	boolean validateMagBaseKV(Voltage value);
	boolean validateMagSatFlux(PerCent value);
	boolean validatePhases(PhaseCode value);
	boolean validateTransfCoolingType(TransformerCoolingType value);
	boolean validateTransformerType(TransformerType value);
	boolean validateHeatExchanger(HeatExchanger value);
	boolean validateTransformerWindings(EList value);
}
