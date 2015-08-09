
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
 *       &lt;attribute name="bytesDownloaded" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="bytesUploaded" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="left" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="rateDownload" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rateUpload" type="{http://www.w3.org/2001/XMLSchema}double" />
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
    public long getBytesDownloaded() {
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
    public void setBytesDownloaded(long value) {
        this.bytesDownloaded = value;
    }

    public boolean isSetBytesDownloaded() {
        return (this.bytesDownloaded!= null);
    }

    public void unsetBytesDownloaded() {
        this.bytesDownloaded = null;
    }

    /**
     * Gets the value of the bytesUploaded property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getBytesUploaded() {
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
    public void setBytesUploaded(long value) {
        this.bytesUploaded = value;
    }

    public boolean isSetBytesUploaded() {
        return (this.bytesUploaded!= null);
    }

    public void unsetBytesUploaded() {
        this.bytesUploaded = null;
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
     * Gets the value of the rateDownload property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRateDownload() {
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
    public void setRateDownload(double value) {
        this.rateDownload = value;
    }

    public boolean isSetRateDownload() {
        return (this.rateDownload!= null);
    }

    public void unsetRateDownload() {
        this.rateDownload = null;
    }

    /**
     * Gets the value of the rateUpload property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRateUpload() {
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
    public void setRateUpload(double value) {
        this.rateUpload = value;
    }

    public boolean isSetRateUpload() {
        return (this.rateUpload!= null);
    }

    public void unsetRateUpload() {
        this.rateUpload = null;
    }

}
