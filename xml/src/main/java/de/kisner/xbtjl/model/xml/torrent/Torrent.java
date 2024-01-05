
package de.kisner.xbtjl.model.xml.torrent;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import de.kisner.xbtjl.model.xml.tracker.Tracker;


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
 *         &lt;element ref="{http://xbtjl.kisner.de/tracker}tracker"/&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}hash"/&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}file"/&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}files"/&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}meta"/&gt;
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}pieces"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="totalLength" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tracker",
    "hash",
    "file",
    "files",
    "meta",
    "pieces"
})
@XmlRootElement(name = "torrent")
public class Torrent
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://xbtjl.kisner.de/tracker", required = true)
    protected Tracker tracker;
    @XmlElement(required = true)
    protected Hash hash;
    @XmlElement(required = true)
    protected File file;
    @XmlElement(required = true)
    protected Files files;
    @XmlElement(required = true)
    protected Meta meta;
    @XmlElement(required = true)
    protected Pieces pieces;
    @XmlAttribute(name = "totalLength")
    protected Long totalLength;

    /**
     * Gets the value of the tracker property.
     * 
     * @return
     *     possible object is
     *     {@link Tracker }
     *     
     */
    public Tracker getTracker() {
        return tracker;
    }

    /**
     * Sets the value of the tracker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tracker }
     *     
     */
    public void setTracker(Tracker value) {
        this.tracker = value;
    }

    /**
     * Gets the value of the hash property.
     * 
     * @return
     *     possible object is
     *     {@link Hash }
     *     
     */
    public Hash getHash() {
        return hash;
    }

    /**
     * Sets the value of the hash property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hash }
     *     
     */
    public void setHash(Hash value) {
        this.hash = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link File }
     *     
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link File }
     *     
     */
    public void setFile(File value) {
        this.file = value;
    }

    /**
     * Gets the value of the files property.
     * 
     * @return
     *     possible object is
     *     {@link Files }
     *     
     */
    public Files getFiles() {
        return files;
    }

    /**
     * Sets the value of the files property.
     * 
     * @param value
     *     allowed object is
     *     {@link Files }
     *     
     */
    public void setFiles(Files value) {
        this.files = value;
    }

    /**
     * Gets the value of the meta property.
     * 
     * @return
     *     possible object is
     *     {@link Meta }
     *     
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meta }
     *     
     */
    public void setMeta(Meta value) {
        this.meta = value;
    }

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

    /**
     * Gets the value of the totalLength property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalLength() {
        return totalLength;
    }

    /**
     * Sets the value of the totalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalLength(Long value) {
        this.totalLength = value;
    }

}
