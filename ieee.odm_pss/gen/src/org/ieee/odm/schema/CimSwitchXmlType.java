//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.12.21 at 03:20:14 PM GMT-05:00 
//


package org.ieee.odm.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CimSwitchXmlType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CimSwitchXmlType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ieee.org/odm/Schema/2008}CimRdfXmlType">
 *       &lt;attribute name="offStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CimSwitchXmlType")
public class CimSwitchXmlType
    extends CimRdfXmlType
{

    @XmlAttribute(required = true)
    protected boolean offStatus;

    /**
     * Gets the value of the offStatus property.
     * 
     */
    public boolean isOffStatus() {
        return offStatus;
    }

    /**
     * Sets the value of the offStatus property.
     * 
     */
    public void setOffStatus(boolean value) {
        this.offStatus = value;
    }

}
