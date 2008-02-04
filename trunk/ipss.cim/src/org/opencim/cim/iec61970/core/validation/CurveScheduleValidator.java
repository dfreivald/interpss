/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.opencim.cim.iec61970.core.validation;

import org.eclipse.emf.common.util.EList;

import org.opencim.cim.iec61970.domain.AxisQuantity;
import org.opencim.cim.iec61970.domain.CurveStyle;
import org.opencim.cim.iec61970.domain.NumericType;
import org.opencim.cim.iec61970.domain.RampMethod;
import org.opencim.cim.iec61970.domain.RampStartMethod;
import org.opencim.cim.iec61970.domain.RampUnits;

/**
 * A sample validator interface for {@link org.opencim.cim.iec61970.core.CurveSchedule}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CurveScheduleValidator {
	boolean validate();

	boolean validateCurveStyle(CurveStyle value);
	boolean validateRampMethod(RampMethod value);
	boolean validateRampStartMethod(RampStartMethod value);
	boolean validateRampUnits(RampUnits value);
	boolean validateXAxisType(NumericType value);
	boolean validateXAxisQuantity(AxisQuantity value);
	boolean validateY1AxisQuantity(AxisQuantity value);
	boolean validateY2AxisQuantity(AxisQuantity value);
	boolean validateYAxisType(NumericType value);
	boolean validateCurveScheduleDatas(EList value);
	boolean validateCurveScheduleFormula(EList value);
}
