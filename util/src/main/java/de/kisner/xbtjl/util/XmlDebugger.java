package de.kisner.xbtjl.util;

import java.util.Objects;

import org.exlp.util.jx.JaxbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Torrent;
import net.sf.exlp.util.xml.JDomUtil;

public class XmlDebugger
{
	final static Logger logger = LoggerFactory.getLogger(XmlDebugger.class);
	
    public static void info(Torrent torrent, boolean withPieces)
    {
    	Torrent xml = JDomUtil.toJaxb(JaxbUtil.toDocument(torrent),Torrent.class);
    	if(!withPieces && Objects.nonNull(torrent.getPieces())) {xml.getPieces().getPiece().clear();}
    	JaxbUtil.info(xml);
    }
}