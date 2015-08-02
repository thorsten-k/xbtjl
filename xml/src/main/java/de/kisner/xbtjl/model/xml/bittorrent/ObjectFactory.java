
package de.kisner.xbtjl.model.xml.bittorrent;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.kisner.xbtjl.model.xml.bittorrent package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.kisner.xbtjl.model.xml.bittorrent
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pieces }
     * 
     */
    public Pieces createPieces() {
        return new Pieces();
    }

    /**
     * Create an instance of {@link Bitfield }
     * 
     */
    public Bitfield createBitfield() {
        return new Bitfield();
    }

    /**
     * Create an instance of {@link Piece }
     * 
     */
    public Piece createPiece() {
        return new Piece();
    }

    /**
     * Create an instance of {@link Hash }
     * 
     */
    public Hash createHash() {
        return new Hash();
    }

    /**
     * Create an instance of {@link Files }
     * 
     */
    public Files createFiles() {
        return new Files();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link TrackerRequest }
     * 
     */
    public TrackerRequest createTrackerRequest() {
        return new TrackerRequest();
    }

    /**
     * Create an instance of {@link Torrent }
     * 
     */
    public Torrent createTorrent() {
        return new Torrent();
    }

    /**
     * Create an instance of {@link AnnouceUrl }
     * 
     */
    public AnnouceUrl createAnnouceUrl() {
        return new AnnouceUrl();
    }

    /**
     * Create an instance of {@link Meta }
     * 
     */
    public Meta createMeta() {
        return new Meta();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link Announce }
     * 
     */
    public Announce createAnnounce() {
        return new Announce();
    }

}
