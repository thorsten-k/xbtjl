
package de.kisner.xbtjl.model.xml.torrent;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.kisner.xbtjl.model.xml.torrent package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.kisner.xbtjl.model.xml.torrent
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Torrent }
     * 
     */
    public Torrent createTorrent() {
        return new Torrent();
    }

    /**
     * Create an instance of {@link Hash }
     * 
     */
    public Hash createHash() {
        return new Hash();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link Files }
     * 
     */
    public Files createFiles() {
        return new Files();
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
     * Create an instance of {@link Block }
     * 
     */
    public Block createBlock() {
        return new Block();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

}
