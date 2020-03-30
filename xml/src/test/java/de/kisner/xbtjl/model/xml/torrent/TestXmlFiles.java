package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlFiles extends AbstractXmlBittorrentTest<Files>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlFiles.class);
	
	public TestXmlFiles(){super(Files.class);}
	public static Files create(boolean withChildren){return (new TestXmlFiles()).build(withChildren);}
	
    public Files build(boolean withChilds)
    {
    	Files xml = new Files();
    	xml.setNumber(13);
    	xml.setDirectory("myDirectory");
    	
    	if(withChilds)
    	{
    		xml.getFile().add(TestXmlFile.create(false));
    		xml.getFile().add(TestXmlFile.create(false));
    	}
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlFiles test = new TestXmlFiles();
		test.saveReferenceXml();
    }
}