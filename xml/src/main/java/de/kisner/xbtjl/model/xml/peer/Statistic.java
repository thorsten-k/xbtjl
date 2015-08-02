
package de.kisner.xbtjl.model.xml.peer;

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
 *       &lt;attribute name="sumDl" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sumUl" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="left" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="rateDl" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rateUl" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "statistic")
public class Statistic
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "sumDl")
    protected Integer sumDl;
    @XmlAttribute(name = "sumUl")
    protected Integer sumUl;
    @XmlAttribute(name = "left")
    protected Long left;
    @XmlAttribute(name = "rateDl")
    protected Double rateDl;
    @XmlAttribute(name = "rateUl")
    protected Double rateUl;

    /**
     * Gets the value of the sumDl property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSumDl() {
        return sumDl;
    }

    /**
     * Sets the value of the sumDl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSumDl(int value) {
        this.sumDl = value;
    }

    public boolean isSetSumDl() {
        return (this.sumDl!= null);
    }

    public void unsetSumDl() {
        this.sumDl = null;
    }

    /**
     * Gets the value of the sumUl property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSumUl() {
        return sumUl;
    }

    /**
     * Sets the value of the sumUl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSumUl(int value) {
        this.sumUl = value;
    }

    public boolean isSetSumUl() {
        return (this.sumUl!= null);
    }

    public void unsetSumUl() {
        this.sumUl = null;
    }

    /**
     * Gets the value of the left property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getLeft() {
        return left;
    }

    /**
     * Sets the value of the left property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeft(long value) {
        this.left = value;
    }

    public boolean isSetLeft() {
        return (this.left!= null);
    }

    public void unsetLeft() {
        this.left = null;
    }

    /**
     * Gets the value of the rateDl property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRateDl() {
        return rateDl;
    }

    /**
     * Sets the value of the rateDl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRateDl(double value) {
        this.rateDl = value;
    }

    public boolean isSetRateDl() {
        return (this.rateDl!= null);
    }

    public void unsetRateDl() {
        this.rateDl = null;
    }

    /**
     * Gets the value of the rateUl property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRateUl() {
        return rateUl;
    }

    /**
     * Sets the value of the rateUl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRateUl(double value) {
        this.rateUl = value;
    }

    public boolean isSetRateUl() {
        return (this.rateUl!= null);
    }

    public void unsetRateUl() {
        this.rateUl = null;
    }

}
