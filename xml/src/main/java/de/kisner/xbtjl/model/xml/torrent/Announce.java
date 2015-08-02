
package de.kisner.xbtjl.model.xml.torrent;

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
 *       &lt;attribute name="interval" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="complete" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="minInterval" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="private" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="incomplete" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "announce")
public class Announce
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "interval")
    protected Long interval;
    @XmlAttribute(name = "complete")
    protected Long complete;
    @XmlAttribute(name = "minInterval")
    protected Long minInterval;
    @XmlAttribute(name = "private")
    protected Long _private;
    @XmlAttribute(name = "incomplete")
    protected Long incomplete;

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterval(long value) {
        this.interval = value;
    }

    public boolean isSetInterval() {
        return (this.interval!= null);
    }

    public void unsetInterval() {
        this.interval = null;
    }

    /**
     * Gets the value of the complete property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getComplete() {
        return complete;
    }

    /**
     * Sets the value of the complete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setComplete(long value) {
        this.complete = value;
    }

    public boolean isSetComplete() {
        return (this.complete!= null);
    }

    public void unsetComplete() {
        this.complete = null;
    }

    /**
     * Gets the value of the minInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getMinInterval() {
        return minInterval;
    }

    /**
     * Sets the value of the minInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinInterval(long value) {
        this.minInterval = value;
    }

    public boolean isSetMinInterval() {
        return (this.minInterval!= null);
    }

    public void unsetMinInterval() {
        this.minInterval = null;
    }

    /**
     * Gets the value of the private property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getPrivate() {
        return _private;
    }

    /**
     * Sets the value of the private property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrivate(long value) {
        this._private = value;
    }

    public boolean isSetPrivate() {
        return (this._private!= null);
    }

    public void unsetPrivate() {
        this._private = null;
    }

    /**
     * Gets the value of the incomplete property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getIncomplete() {
        return incomplete;
    }

    /**
     * Sets the value of the incomplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncomplete(long value) {
        this.incomplete = value;
    }

    public boolean isSetIncomplete() {
        return (this.incomplete!= null);
    }

    public void unsetIncomplete() {
        this.incomplete = null;
    }

}
