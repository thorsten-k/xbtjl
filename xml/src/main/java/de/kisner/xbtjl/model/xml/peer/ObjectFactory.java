
package de.kisner.xbtjl.model.xml.peer;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.kisner.xbtjl.model.xml.peer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.kisner.xbtjl.model.xml.peer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Peer }
     * 
     */
    public Peer createPeer() {
        return new Peer();
    }

    /**
     * Create an instance of {@link Statistic }
     * 
     */
    public Statistic createStatistic() {
        return new Statistic();
    }

    /**
     * Create an instance of {@link Info }
     * 
     */
    public Info createInfo() {
        return new Info();
    }

}
