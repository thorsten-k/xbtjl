package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlHash extends AbstractXmlBittorrentTest<Hash>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlHash.class);
	
	public TestXmlHash(){super(Hash.class);}
	public static Hash create(boolean withChildren){return (new TestXmlHash()).build(withChildren);}
    
    public Hash build(boolean withChilds)
    {
    	Hash xml = new Hash();
    	xml.setValue("myHash");
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlHash test = new TestXmlHash();
		test.saveReferenceXml();
    }
}