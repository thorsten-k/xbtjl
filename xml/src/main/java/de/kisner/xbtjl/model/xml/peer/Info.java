
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="interested" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="choked" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="interesting" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="choking" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="connected" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
    public boolean isInterested() {
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
    public void setInterested(boolean value) {
        this.interested = value;
    }

    public boolean isSetInterested() {
        return (this.interested!= null);
    }

    public void unsetInterested() {
        this.interested = null;
    }

    /**
     * Gets the value of the choked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isChoked() {
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
    public void setChoked(boolean value) {
        this.choked = value;
    }

    public boolean isSetChoked() {
        return (this.choked!= null);
    }

    public void unsetChoked() {
        this.choked = null;
    }

    /**
     * Gets the value of the interesting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isInteresting() {
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
    public void setInteresting(boolean value) {
        this.interesting = value;
    }

    public boolean isSetInteresting() {
        return (this.interesting!= null);
    }

    public void unsetInteresting() {
        this.interesting = null;
    }

    /**
     * Gets the value of the choking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isChoking() {
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
    public void setChoking(boolean value) {
        this.choking = value;
    }

    public boolean isSetChoking() {
        return (this.choking!= null);
    }

    public void unsetChoking() {
        this.choking = null;
    }

    /**
     * Gets the value of the connected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isConnected() {
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
    public void setConnected(boolean value) {
        this.connected = value;
    }

    public boolean isSetConnected() {
        return (this.connected!= null);
    }

    public void unsetConnected() {
        this.connected = null;
    }

}
