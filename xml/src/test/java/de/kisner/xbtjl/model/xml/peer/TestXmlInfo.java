package de.kisner.xbtjl.model.xml.peer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlInfo extends AbstractXmlPeerTest<Info>
{
	final static Logger logger = LoggerFactory.getLogger(Info.class);
	
	public TestXmlInfo(){super(Info.class);}
	public static Info create(boolean withChildren){return (new TestXmlInfo()).build(withChildren);}
    
    public static Info create()
    {
    	Info xml = new Info();
    	xml.setChoked(true);
    	xml.setChoking(true);
    	xml.setConnected(true);
    	xml.setInterested(true);
    	xml.setInteresting(true);
    	return xml;
    }
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlInfo test = new TestXmlInfo();
		test.saveReferenceXml();
    }
}