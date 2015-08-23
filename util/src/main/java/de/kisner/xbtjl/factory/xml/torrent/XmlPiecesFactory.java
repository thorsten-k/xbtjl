package de.kisner.xbtjl.factory.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Pieces;

public class XmlPiecesFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlPiecesFactory.class);
	
	public static Pieces build()
	{	
		Pieces xml = new Pieces();
		return xml;
	}
	
	public static Pieces create(int pieceLength)
	{	
		Pieces xml = build();
		xml.setLength(pieceLength);	
		return xml;
	}
}