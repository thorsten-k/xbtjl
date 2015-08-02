package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Files;

public class XmlFilesFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlFilesFactory.class);
		
	public static Files build()
	{
		Files xml = new Files();
		return xml;
	}
}
