package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Torrent;

public class XmlTorrentFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlTorrentFactory.class);
		
	public static Torrent build()
	{
		Torrent xml = new Torrent();
		return xml;
	}
}
