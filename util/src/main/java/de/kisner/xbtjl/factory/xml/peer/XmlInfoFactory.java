package de.kisner.xbtjl.factory.xml.peer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.Info;

public class XmlInfoFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlInfoFactory.class);
	
	public static Info create()
	{
		Info xml = new Info();
		
    	xml.setChoked(true);
    	xml.setChoking(true);
    	xml.setConnected(false);
    	xml.setInterested(false);
    	xml.setInteresting(false);
		
		return xml;
	}
}