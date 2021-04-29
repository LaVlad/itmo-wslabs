
package org.lavlad.wslab.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createBook complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createBook">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createTO" type="{http://service.wslab.lavlad.org/}bookCreateTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBook", propOrder = {
    "createTO"
})
public class CreateBook {

    protected BookCreateTO createTO;

    /**
     * Gets the value of the createTO property.
     * 
     * @return
     *     possible object is
     *     {@link BookCreateTO }
     *     
     */
    public BookCreateTO getCreateTO() {
        return createTO;
    }

    /**
     * Sets the value of the createTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookCreateTO }
     *     
     */
    public void setCreateTO(BookCreateTO value) {
        this.createTO = value;
    }

}
