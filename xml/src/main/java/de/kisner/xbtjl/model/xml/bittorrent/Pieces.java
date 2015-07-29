//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.2-hudson-jaxb-ri-2.2-63- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.02.16 at 08:19:25 PM MEZ 
//


package de.kisner.xbtjl.model.xml.bittorrent;

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
 *         &lt;element ref="{http://jbtl.sf.net/bittorrent}bitfield"/>
 *         &lt;element ref="{http://jbtl.sf.net/bittorrent}piece" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pieceLength" type="{http://www.w3.org/2001/XMLSchema}int" />
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

}
