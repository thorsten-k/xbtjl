
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="interval" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="complete" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="minInterval" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="private" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="incomplete" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "clientAnnounce")
public class ClientAnnounce
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
    public Long getInterval() {
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
    public void setInterval(Long value) {
        this.interval = value;
    }

    /**
     * Gets the value of the complete property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getComplete() {
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
    public void setComplete(Long value) {
        this.complete = value;
    }

    /**
     * Gets the value of the minInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinInterval() {
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
    public void setMinInterval(Long value) {
        this.minInterval = value;
    }

    /**
     * Gets the value of the private property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrivate() {
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
    public void setPrivate(Long value) {
        this._private = value;
    }

    /**
     * Gets the value of the incomplete property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncomplete() {
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
    public void setIncomplete(Long value) {
        this.incomplete = value;
    }

}
