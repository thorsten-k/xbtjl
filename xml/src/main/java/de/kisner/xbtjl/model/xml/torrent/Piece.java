
package de.kisner.xbtjl.model.xml.torrent;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}hash"/>
 *       &lt;/sequence>
 *       &lt;attribute name="index" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hash"
})
@XmlRootElement(name = "piece")
public class Piece
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected Hash hash;
    @XmlAttribute(name = "index")
    protected Integer index;
    @XmlAttribute(name = "length")
    protected Integer length;

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

    public boolean isSetHash() {
        return (this.hash!= null);
    }

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIndex(int value) {
        this.index = value;
    }

    public boolean isSetIndex() {
        return (this.index!= null);
    }

    public void unsetIndex() {
        this.index = null;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLength(int value) {
        this.length = value;
    }

    public boolean isSetLength() {
        return (this.length!= null);
    }

    public void unsetLength() {
        this.length = null;
    }

}
