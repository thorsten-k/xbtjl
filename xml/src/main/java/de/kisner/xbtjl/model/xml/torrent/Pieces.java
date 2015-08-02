
package de.kisner.xbtjl.model.xml.torrent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}bitfield"/>
 *         &lt;element ref="{http://xbtjl.kisner.de/torrent}piece" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pieceLength" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bitfield",
    "piece"
})
@XmlRootElement(name = "pieces")
public class Pieces
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected Bitfield bitfield;
    @XmlElement(required = true)
    protected List<Piece> piece;
    @XmlAttribute(name = "pieceLength")
    protected Integer pieceLength;
    @XmlAttribute(name = "size")
    protected Integer size;

    /**
     * Gets the value of the bitfield property.
     * 
     * @return
     *     possible object is
     *     {@link Bitfield }
     *     
     */
    public Bitfield getBitfield() {
        return bitfield;
    }

    /**
     * Sets the value of the bitfield property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bitfield }
     *     
     */
    public void setBitfield(Bitfield value) {
        this.bitfield = value;
    }

    public boolean isSetBitfield() {
        return (this.bitfield!= null);
    }

    /**
     * Gets the value of the piece property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the piece property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPiece().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Piece }
     * 
     * 
     */
    public List<Piece> getPiece() {
        if (piece == null) {
            piece = new ArrayList<Piece>();
        }
        return this.piece;
    }

    public boolean isSetPiece() {
        return ((this.piece!= null)&&(!this.piece.isEmpty()));
    }

    public void unsetPiece() {
        this.piece = null;
    }

    /**
     * Gets the value of the pieceLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getPieceLength() {
        return pieceLength;
    }

    /**
     * Sets the value of the pieceLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPieceLength(int value) {
        this.pieceLength = value;
    }

    public boolean isSetPieceLength() {
        return (this.pieceLength!= null);
    }

    public void unsetPieceLength() {
        this.pieceLength = null;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSize(int value) {
        this.size = value;
    }

    public boolean isSetSize() {
        return (this.size!= null);
    }

    public void unsetSize() {
        this.size = null;
    }

}
