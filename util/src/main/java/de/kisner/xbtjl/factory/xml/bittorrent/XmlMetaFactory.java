package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Meta;

public class XmlMetaFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlMetaFactory.class);
	
	public static Meta build()
	{
		Meta xml = new Meta();
		
		return xml;
	}
}