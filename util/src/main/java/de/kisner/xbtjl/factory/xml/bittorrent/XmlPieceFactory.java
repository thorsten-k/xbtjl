package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Hash;
import de.kisner.xbtjl.model.xml.torrent.Piece;

public class XmlPieceFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlPieceFactory.class);
	
	public static Piece build(int index, int length, Hash hash)
	{	
		Piece xml = new Piece();
		xml.setIndex(index);
		xml.setLength(length);
		xml.setHash(hash);
		return xml;
	}
}