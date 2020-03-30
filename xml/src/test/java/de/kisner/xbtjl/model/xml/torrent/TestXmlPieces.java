package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlPieces extends AbstractXmlBittorrentTest<Pieces>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlPieces.class);
	
	public TestXmlPieces(){super(Pieces.class);}
	public static Pieces create(boolean withChildren){return (new TestXmlPieces()).build(withChildren);}
    
    public Pieces build(boolean withChilds)
    {
    	Pieces xml = new Pieces();
    	xml.setLength(12);
    	xml.setNumber(122);
    	
    	if(withChilds)
    	{
    		xml.getPiece().add(TestXmlPiece.create(false));
    		xml.getPiece().add(TestXmlPiece.create(false));
    		xml.setBitfield(TestXmlBitfield.create(false));
    	}
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlPieces test = new TestXmlPieces();
		test.saveReferenceXml();
    }
}