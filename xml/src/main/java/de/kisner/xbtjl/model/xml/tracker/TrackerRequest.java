
package de.kisner.xbtjl.model.xml.tracker;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.torrent.Torrent;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}torrent"/&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/peer}peer"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="numWant" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "torrent",
    "peer"
})
@XmlRootElement(name = "trackerRequest")
public class TrackerRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://xbtjl.kisner.de/torrent", required = true)
    protected Torrent torrent;
    @XmlElement(namespace = "http://xbtjl.kisner.de/peer", required = true)
    protected Peer peer;
    @XmlAttribute(name = "numWant")
    protected Integer numWant;

    /**
     * Gets the value of the torrent property.
     * 
     * @return
     *     possible object is
     *     {@link Torrent }
     *     
     */
    public Torrent getTorrent() {
        return torrent;
    }

    /**
     * Sets the value of the torrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Torrent }
     *     
     */
    public void setTorrent(Torrent value) {
        this.torrent = value;
    }

    /**
     * Gets the value of the peer property.
     * 
     * @return
     *     possible object is
     *     {@link Peer }
     *     
     */
    public Peer getPeer() {
        return peer;
    }

    /**
     * Sets the value of the peer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Peer }
     *     
     */
    public void setPeer(Peer value) {
        this.peer = value;
    }

    /**
     * Gets the value of the numWant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumWant() {
        return numWant;
    }

    /**
     * Sets the value of the numWant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumWant(Integer value) {
        this.numWant = value;
    }

}
