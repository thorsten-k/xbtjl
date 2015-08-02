package de.kisner.xbtjl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import net.sf.exlp.util.xml.JDomUtil;
import net.sf.exlp.util.xml.JaxbUtil;

public class XmlDebugger
{
	final static Logger logger = LoggerFactory.getLogger(XmlDebugger.class);
	
    public static void info(Torrent torrent, boolean withPieces)
    {
    	Torrent xml = JDomUtil.toJaxb(JaxbUtil.toDocument(torrent),Torrent.class);
    	if(!withPieces && torrent.isSetPieces()) {xml.getPieces().unsetPiece();}
    	JaxbUtil.info(xml);
    }
}