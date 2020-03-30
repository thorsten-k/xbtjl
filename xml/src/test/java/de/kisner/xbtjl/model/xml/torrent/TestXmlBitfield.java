package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlBitfield extends AbstractXmlBittorrentTest<Bitfield>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlBitfield.class);
	
	public TestXmlBitfield(){super(Bitfield.class);}
	public static Bitfield create(boolean withChildren){return (new TestXmlBitfield()).build(withChildren);}
    
    public Bitfield build(boolean withChilds)
    {
    	Bitfield xml = new Bitfield();
    	xml.setValue("110111000111");
    	return xml;
    }
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlBitfield test = new TestXmlBitfield();
		test.saveReferenceXml();
    }
}