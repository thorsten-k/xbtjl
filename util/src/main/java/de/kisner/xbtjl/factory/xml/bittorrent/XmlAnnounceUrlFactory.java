package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.AnnouceUrl;

public class XmlAnnounceUrlFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlAnnounceUrlFactory.class);
	
	public static synchronized AnnouceUrl create(String url)
	{
		AnnouceUrl xml = new AnnouceUrl();
		xml.setValue(url);
		return xml;
	}
}