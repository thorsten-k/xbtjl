
package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.Serializable;
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
 *         &lt;element ref="{http://jbtl.sf.net/bittorrent}torrent"/>
 *         &lt;element ref="{http://jbtl.sf.net/peer}peer"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numWant" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
    @XmlElement(required = true)
    protected Torrent torrent;
    @XmlElement(namespace = "http://jbtl.sf.net/peer", required = true)
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

    public boolean isSetTorrent() {
        return (this.torrent!= null);
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

    public boolean isSetPeer() {
        return (this.peer!= null);
    }

    /**
     * Gets the value of the numWant property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getNumWant() {
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
    public void setNumWant(int value) {
        this.numWant = value;
    }

    public boolean isSetNumWant() {
        return (this.numWant!= null);
    }

    public void unsetNumWant() {
        this.numWant = null;
    }

}
