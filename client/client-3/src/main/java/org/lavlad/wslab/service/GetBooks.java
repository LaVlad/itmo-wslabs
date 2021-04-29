
package org.lavlad.wslab.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getBooks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getBooks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchTO" type="{http://service.wslab.lavlad.org/}bookSearchTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBooks", propOrder = {
    "searchTO"
})
public class GetBooks {

    protected BookSearchTO searchTO;

    /**
     * Gets the value of the searchTO property.
     * 
     * @return
     *     possible object is
     *     {@link BookSearchTO }
     *     
     */
    public BookSearchTO getSearchTO() {
        return searchTO;
    }

    /**
     * Sets the value of the searchTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookSearchTO }
     *     
     */
    public void setSearchTO(BookSearchTO value) {
        this.searchTO = value;
    }

}
