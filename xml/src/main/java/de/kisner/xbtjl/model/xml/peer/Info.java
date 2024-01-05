
package de.kisner.xbtjl.model.xml.peer;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="interested" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="choked" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="interesting" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="choking" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="connected" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "info")
public class Info
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "interested")
    protected Boolean interested;
    @XmlAttribute(name = "choked")
    protected Boolean choked;
    @XmlAttribute(name = "interesting")
    protected Boolean interesting;
    @XmlAttribute(name = "choking")
    protected Boolean choking;
    @XmlAttribute(name = "connected")
    protected Boolean connected;

    /**
     * Gets the value of the interested property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInterested() {
        return interested;
    }

    /**
     * Sets the value of the interested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInterested(Boolean value) {
        this.interested = value;
    }

    /**
     * Gets the value of the choked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChoked() {
        return choked;
    }

    /**
     * Sets the value of the choked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChoked(Boolean value) {
        this.choked = value;
    }

    /**
     * Gets the value of the interesting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInteresting() {
        return interesting;
    }

    /**
     * Sets the value of the interesting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInteresting(Boolean value) {
        this.interesting = value;
    }

    /**
     * Gets the value of the choking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChoking() {
        return choking;
    }

    /**
     * Sets the value of the choking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChoking(Boolean value) {
        this.choking = value;
    }

    /**
     * Gets the value of the connected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConnected() {
        return connected;
    }

    /**
     * Sets the value of the connected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConnected(Boolean value) {
        this.connected = value;
    }

}
