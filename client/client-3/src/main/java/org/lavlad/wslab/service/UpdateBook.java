
package org.lavlad.wslab.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateBook complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateBook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateTO" type="{http://service.wslab.lavlad.org/}bookUpdateTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateBook", propOrder = {
    "updateTO"
})
public class UpdateBook {

    protected BookUpdateTO updateTO;

    /**
     * Gets the value of the updateTO property.
     * 
     * @return
     *     possible object is
     *     {@link BookUpdateTO }
     *     
     */
    public BookUpdateTO getUpdateTO() {
        return updateTO;
    }

    /**
     * Sets the value of the updateTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookUpdateTO }
     *     
     */
    public void setUpdateTO(BookUpdateTO value) {
        this.updateTO = value;
    }

}
