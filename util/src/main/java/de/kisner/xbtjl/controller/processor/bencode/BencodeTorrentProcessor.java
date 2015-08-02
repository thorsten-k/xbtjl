package de.kisner.xbtjl.controller.processor.bencode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.olsson.bencoder.Bdecoder;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlAnnounceUrlFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlCommentFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlFileFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlFilesFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlHashFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlMetaFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlPieceFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlPiecesFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlTorrentFactory;
import de.kisner.xbtjl.model.xml.bittorrent.Hash;
import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import net.sf.exlp.util.DateUtil;

public class BencodeTorrentProcessor
{
	final static Logger logger = LoggerFactory.getLogger(BencodeTorrentProcessor.class);
	

	private Torrent torrent;
	
	public BencodeTorrentProcessor()
	{

	}
	
	
	public Torrent olson(File f) throws FileNotFoundException, IOException
	{
		torrent = XmlTorrentFactory.build();
		torrent.setMeta(XmlMetaFactory.build());
		torrent.setPieces(XmlPiecesFactory.build());
		torrent.setFiles(XmlFilesFactory.build());
		
		byte[] bytes = IOUtils.toByteArray(new FileInputStream(f));
		Bdecoder dec = new Bdecoder();
		Map<?,?> map =  (Map<?,?>)dec.decode(bytes);

		for(Object o : map.keySet())
		{
			String key = new String((byte[])o);
			Object value = map.get(o);
			if(key.equals("announce")){announce((byte[])value);}
			else if(key.equals("created by")){createdBy((byte[])value);}
			else if(key.equals("creation date")){creationDate((Long)value);}
			else if(key.equals("comment")){comment((byte[])value);}
			else if(key.equals("info")){info((Map<?,?>)value);}
			else {logger.info(key+" "+value.getClass().getSimpleName());}
		}
		return torrent;
	}
	
	private void info(Map<?,?> map)
	{
		for(Object o : map.keySet())
		{
			String key = new String((byte[])o);
			Object value = map.get(o);
			if(key.equals("name")){infoName((byte[])value);}
			else if(key.equals("length")){infoLength((Long)value);}
			else if(key.equals("piece length")){infoPieceLength((Long)value);}
			else if(key.equals("pieces")){infoPieces((byte[])value);}
			
			else {logger.info("info."+key+" "+value.getClass().getSimpleName());}
		}
	}
	
	private void infoPieces(byte[] bytes)
	{
		int numberOfPieces = bytes.length/20;
		for(int i=0;i<numberOfPieces;i++)
		{
			Hash hash = XmlHashFactory.hex(Arrays.copyOfRange(bytes, 20*i, (20*i)+20));
			long length = torrent.getPieces().getPieceLength();
			if(i==numberOfPieces-1)
			{
				length = torrent.getTotalLength()-((numberOfPieces-1)*length);
			}
			torrent.getPieces().getPiece().add(XmlPieceFactory.build(i, length, hash));
		}
	}
	
	public void announce(byte[] bytes){torrent.setAnnouceUrl(XmlAnnounceUrlFactory.create(new String(bytes)));}
	public void createdBy(byte[] bytes){torrent.getMeta().setCreatedBy(new String(bytes));}
	public void creationDate(Long l){torrent.getMeta().setCreated(DateUtil.toXmlGc(new Date(l*1000)));}
	public void comment(byte[] bytes){torrent.getMeta().setComment(XmlCommentFactory.build(new String(bytes)));}
	public void infoName(byte[] bytes){torrent.setFile(XmlFileFactory.build(new String(bytes)));}
	private void infoLength(Long l){torrent.setTotalLength(l);}
	private void infoPieceLength(Long l){torrent.getPieces().setPieceLength(l.intValue());}
	
	
}
