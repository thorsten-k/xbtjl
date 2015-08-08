
package de.kisner.xbtjl.model.xml.tracker;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="announce" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "tracker")
public class Tracker
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "announce")
    protected String announce;

    /**
     * Gets the value of the announce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnounce() {
        return announce;
    }

    /**
     * Sets the value of the announce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnounce(String value) {
        this.announce = value;
    }

    public boolean isSetAnnounce() {
        return (this.announce!= null);
    }

}
