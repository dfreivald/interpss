//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.19 at 05:09:52 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for AcscFaultCategoryDataType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcscFaultCategoryDataType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fault_3P"/>
 *     &lt;enumeration value="Fault_LG"/>
 *     &lt;enumeration value="Fault_LL"/>
 *     &lt;enumeration value="Fault_LLG"/>
 *     &lt;enumeration value="Fault_ALL"/>
 *     &lt;enumeration value="Outage_3Phase"/>
 *     &lt;enumeration value="Outage_1Phase"/>
 *     &lt;enumeration value="Outage_2Phase"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum AcscFaultCategoryDataType {

    @XmlEnumValue("Fault_3P")
    FAULT_3_P("Fault_3P"),
    @XmlEnumValue("Fault_LG")
    FAULT_LG("Fault_LG"),
    @XmlEnumValue("Fault_LL")
    FAULT_LL("Fault_LL"),
    @XmlEnumValue("Fault_LLG")
    FAULT_LLG("Fault_LLG"),
    @XmlEnumValue("Fault_ALL")
    FAULT_ALL("Fault_ALL"),
    @XmlEnumValue("Outage_3Phase")
    OUTAGE_3_PHASE("Outage_3Phase"),
    @XmlEnumValue("Outage_1Phase")
    OUTAGE_1_PHASE("Outage_1Phase"),
    @XmlEnumValue("Outage_2Phase")
    OUTAGE_2_PHASE("Outage_2Phase");
    private final String value;

    AcscFaultCategoryDataType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AcscFaultCategoryDataType fromValue(String v) {
        for (AcscFaultCategoryDataType c: AcscFaultCategoryDataType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
