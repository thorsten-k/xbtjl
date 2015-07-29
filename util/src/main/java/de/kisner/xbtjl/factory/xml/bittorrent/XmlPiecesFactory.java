package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Pieces;

public class XmlPiecesFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlPiecesFactory.class);
	
	public static synchronized Pieces create(int pieceLength)
	{	
		Pieces xml = new Pieces();
		xml.setPieceLength(pieceLength);	
		return xml;
	}
}