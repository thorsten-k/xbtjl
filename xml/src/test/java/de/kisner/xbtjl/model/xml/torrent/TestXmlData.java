package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlData extends AbstractXmlBittorrentTest<Data>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlData.class);
	
	public TestXmlData(){super(Data.class);}
	public static Data create(boolean withChildren){return (new TestXmlData()).build(withChildren);}
    
    public Data build(boolean withChilds)
    {
    	Data xml = new Data();
    	xml.setValue("myData".getBytes());
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlData test = new TestXmlData();
		test.saveReferenceXml();
    }
}