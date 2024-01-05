
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="bytesDownloaded" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="bytesUploaded" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="left" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="rateDownload" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="rateUpload" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
    @XmlAttribute(name = "bytesDownloaded")
    protected Long bytesDownloaded;
    @XmlAttribute(name = "bytesUploaded")
    protected Long bytesUploaded;
    @XmlAttribute(name = "left")
    protected Long left;
    @XmlAttribute(name = "rateDownload")
    protected Double rateDownload;
    @XmlAttribute(name = "rateUpload")
    protected Double rateUpload;

    /**
     * Gets the value of the bytesDownloaded property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBytesDownloaded() {
        return bytesDownloaded;
    }

    /**
     * Sets the value of the bytesDownloaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBytesDownloaded(Long value) {
        this.bytesDownloaded = value;
    }

    /**
     * Gets the value of the bytesUploaded property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBytesUploaded() {
        return bytesUploaded;
    }

    /**
     * Sets the value of the bytesUploaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBytesUploaded(Long value) {
        this.bytesUploaded = value;
    }

    /**
     * Gets the value of the left property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeft() {
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
    public void setLeft(Long value) {
        this.left = value;
    }

    /**
     * Gets the value of the rateDownload property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRateDownload() {
        return rateDownload;
    }

    /**
     * Sets the value of the rateDownload property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRateDownload(Double value) {
        this.rateDownload = value;
    }

    /**
     * Gets the value of the rateUpload property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRateUpload() {
        return rateUpload;
    }

    /**
     * Sets the value of the rateUpload property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRateUpload(Double value) {
        this.rateUpload = value;
    }

}
