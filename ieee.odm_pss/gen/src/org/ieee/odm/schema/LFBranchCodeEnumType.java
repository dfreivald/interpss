//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.09.06 at 05:03:11 PM MST 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for LFBranchCodeEnumType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LFBranchCodeEnumType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Line"/>
 *     &lt;enumeration value="Transformer"/>
 *     &lt;enumeration value="PhaseShiftXformer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum LFBranchCodeEnumType {

    @XmlEnumValue("Line")
    LINE("Line"),
    @XmlEnumValue("Transformer")
    TRANSFORMER("Transformer"),
    @XmlEnumValue("PhaseShiftXformer")
    PHASE_SHIFT_XFORMER("PhaseShiftXformer");
    private final String value;

    LFBranchCodeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LFBranchCodeEnumType fromValue(String v) {
        for (LFBranchCodeEnumType c: LFBranchCodeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
