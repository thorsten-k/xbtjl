package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlPiece extends AbstractXmlBittorrentTest<Piece>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlPiece.class);
	
	public TestXmlPiece(){super(Piece.class);}
	public static Piece create(boolean withChildren){return (new TestXmlPiece()).build(withChildren);}
    
    public Piece build(boolean withChilds)
    {
    	Piece xml = new Piece();
    	xml.setIndex(123);
    	xml.setLength(123);
    	
    	if(withChilds)
    	{
    		xml.setHash(TestXmlHash.create(false));
    		xml.getBlock().add(TestXmlBlock.create(false));xml.getBlock().add(TestXmlBlock.create(false));
    	}
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlPiece test = new TestXmlPiece();
		test.saveReferenceXml();
    }
}