
package de.kisner.xbtjl.model.xml.tracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.kisner.xbtjl.model.xml.peer.Peer;


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
 *         &lt;element ref="{http://xbtjl.kisner.de/peer}peer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="interval" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "peer"
})
@XmlRootElement(name = "trackerResponse")
public class TrackerResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://xbtjl.kisner.de/peer", required = true)
    protected List<Peer> peer;
    @XmlAttribute(name = "interval")
    protected Integer interval;

    /**
     * Gets the value of the peer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Peer }
     * 
     * 
     */
    public List<Peer> getPeer() {
        if (peer == null) {
            peer = new ArrayList<Peer>();
        }
        return this.peer;
    }

    public boolean isSetPeer() {
        return ((this.peer!= null)&&(!this.peer.isEmpty()));
    }

    public void unsetPeer() {
        this.peer = null;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInterval(int value) {
        this.interval = value;
    }

    public boolean isSetInterval() {
        return (this.interval!= null);
    }

    public void unsetInterval() {
        this.interval = null;
    }

}
