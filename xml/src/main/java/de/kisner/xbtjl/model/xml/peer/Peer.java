
package de.kisner.xbtjl.model.xml.peer;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.kisner.xbtjl.model.xml.torrent.Pieces;


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
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}pieces"/>
 *         &lt;element ref="{http://xbtjl.kisner.de/peer}statistic"/>
 *         &lt;element ref="{http://xbtjl.kisner.de/peer}info"/>
 *       &lt;/sequence>
 *       &lt;attribute name="peerId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="listeningPort" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="listeningIp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pieces",
    "statistic",
    "info"
})
@XmlRootElement(name = "peer")
public class Peer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://xbtjl.kisner.de/torrent", required = true)
    protected Pieces pieces;
    @XmlElement(required = true)
    protected Statistic statistic;
    @XmlElement(required = true)
    protected Info info;
    @XmlAttribute(name = "peerId")
    protected String peerId;
    @XmlAttribute(name = "listeningPort")
    protected Integer listeningPort;
    @XmlAttribute(name = "listeningIp")
    protected String listeningIp;

    /**
     * Gets the value of the pieces property.
     * 
     * @return
     *     possible object is
     *     {@link Pieces }
     *     
     */
    public Pieces getPieces() {
        return pieces;
    }

    /**
     * Sets the value of the pieces property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pieces }
     *     
     */
    public void setPieces(Pieces value) {
        this.pieces = value;
    }

    public boolean isSetPieces() {
        return (this.pieces!= null);
    }

    /**
     * Gets the value of the statistic property.
     * 
     * @return
     *     possible object is
     *     {@link Statistic }
     *     
     */
    public Statistic getStatistic() {
        return statistic;
    }

    /**
     * Sets the value of the statistic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statistic }
     *     
     */
    public void setStatistic(Statistic value) {
        this.statistic = value;
    }

    public boolean isSetStatistic() {
        return (this.statistic!= null);
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link Info }
     *     
     */
    public Info getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link Info }
     *     
     */
    public void setInfo(Info value) {
        this.info = value;
    }

    public boolean isSetInfo() {
        return (this.info!= null);
    }

    /**
     * Gets the value of the peerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeerId() {
        return peerId;
    }

    /**
     * Sets the value of the peerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeerId(String value) {
        this.peerId = value;
    }

    public boolean isSetPeerId() {
        return (this.peerId!= null);
    }

    /**
     * Gets the value of the listeningPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getListeningPort() {
        return listeningPort;
    }

    /**
     * Sets the value of the listeningPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setListeningPort(int value) {
        this.listeningPort = value;
    }

    public boolean isSetListeningPort() {
        return (this.listeningPort!= null);
    }

    public void unsetListeningPort() {
        this.listeningPort = null;
    }

    /**
     * Gets the value of the listeningIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListeningIp() {
        return listeningIp;
    }

    /**
     * Sets the value of the listeningIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListeningIp(String value) {
        this.listeningIp = value;
    }

    public boolean isSetListeningIp() {
        return (this.listeningIp!= null);
    }

}
