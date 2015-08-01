package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Pieces;

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
		xml.setPieceLength(pieceLength);	
		return xml;
	}
}