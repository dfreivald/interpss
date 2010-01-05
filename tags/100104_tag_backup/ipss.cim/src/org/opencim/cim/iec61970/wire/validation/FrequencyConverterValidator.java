/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.opencim.cim.iec61970.wire.validation;

import org.opencim.datatype.real.ActivePower;
import org.opencim.datatype.real.Frequency;
import org.opencim.datatype.real.Voltage;

import org.opencim.datatype.string.OperatingMode;

/**
 * A sample validator interface for {@link org.opencim.cim.iec61970.wire.FrequencyConverter}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface FrequencyConverterValidator {
	boolean validate();

	boolean validateFrequency(Frequency value);
	boolean validateMaximumMW(ActivePower value);
	boolean validateMaximumKV(Voltage value);
	boolean validateMinimumMW(ActivePower value);
	boolean validateMinimumKV(Voltage value);
	boolean validateOperatingMode(OperatingMode value);
}
