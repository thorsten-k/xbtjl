package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlFile extends AbstractXmlBittorrentTest<de.kisner.xbtjl.model.xml.torrent.File>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlFile.class);
	
	public TestXmlFile(){super(de.kisner.xbtjl.model.xml.torrent.File.class);}
	public static de.kisner.xbtjl.model.xml.torrent.File  create(boolean withChildren){return (new TestXmlFile()).build(withChildren);}
    
    public de.kisner.xbtjl.model.xml.torrent.File build(boolean withChilds)
    {
    	de.kisner.xbtjl.model.xml.torrent.File xml = new de.kisner.xbtjl.model.xml.torrent.File();
    	xml.setValue("myFileName");
    	xml.setLength(1234l);
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlFile test = new TestXmlFile();
		test.saveReferenceXml();
    }
}