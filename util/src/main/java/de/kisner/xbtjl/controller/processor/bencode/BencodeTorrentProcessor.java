package de.kisner.xbtjl.controller.processor.bencode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.jbencode.Parser;
import com.googlecode.jbencode.Value;
import com.googlecode.jbencode.composite.DictionaryValue;
import com.googlecode.jbencode.composite.EntryValue;
import com.googlecode.jbencode.composite.ListValue;
import com.googlecode.jbencode.primitive.IntegerValue;
import com.googlecode.jbencode.primitive.StringValue;

import de.kisner.xbtjl.factory.xml.bittorrent.XmlAnnounceUrlFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlCommentFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlFileFactory;
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
	
	private static enum Scope{unknown,root,info}
	private Parser bencodeParser;
	private Torrent torrent;
	
	public BencodeTorrentProcessor()
	{
		bencodeParser = new Parser();
	}
	
	public Torrent build(File f) throws FileNotFoundException, IOException
	{
		torrent = XmlTorrentFactory.build();
		torrent.setMeta(XmlMetaFactory.build());
		torrent.setPieces(XmlPiecesFactory.build());
		
		Value<?> value = bencodeParser.parse(new FileInputStream(f));
    	all(Scope.root,value);
    	
		return torrent;
	}
	
	public void all(Scope scope, Value<?> root) throws IOException
	{
		logger.trace("Checking "+root.getClass().getSimpleName());
		if(root instanceof StringValue){string((StringValue)root);}
		else if(root instanceof DictionaryValue){dictionary(scope,(DictionaryValue)root);}
		else if(root instanceof ListValue){list((ListValue)root);}
		else if(root instanceof EntryValue){entry(scope,(EntryValue)root);}
		else if(root instanceof IntegerValue){integer((IntegerValue)root);}
		else
		{
			logger.info("No handling for "+root.getClass().getSimpleName());
		}
	}
	
	private String string(StringValue value) throws IOException
	{
		return new String(value.resolve());
	}
	
	private void dictionary(Scope scope,DictionaryValue root) throws IOException
	{
		logger.trace("Handle "+DictionaryValue.class.getSimpleName()+" resolved:"+root.isResolved());
		
		while(root.hasNext())
		{
			logger.trace("Next Dict");
			entry(scope,root.next());
		}
	}
	
	private Long integer(IntegerValue value) throws IOException
	{
		return value.resolve();
	}
	
	private void entry(Scope scope, EntryValue value) throws IOException
	{
		logger.trace("Handle "+EntryValue.class.getSimpleName()+" resolved?"+value.isResolved());
		if(value.getKey()!=null)
		{
			String key = string(value.getKey());
			logger.trace("\t"+scope+" key:"+key+" "+value.getValue().getClass().getSimpleName());
			if(scope.equals(Scope.root) && key.equals("announce") && (value.getValue() instanceof StringValue))
			{
				torrent.setAnnouceUrl(XmlAnnounceUrlFactory.create(string((StringValue)value.getValue())));
			}
			else if(scope.equals(Scope.root) && key.equals("created by") && (value.getValue() instanceof StringValue))
			{
				torrent.getMeta().setCreatedBy(string((StringValue)value.getValue()));
			}
			else if(scope.equals(Scope.root) && key.equals("comment") && (value.getValue() instanceof StringValue))
			{
				torrent.getMeta().setComment(XmlCommentFactory.build(string((StringValue)value.getValue())));
			}
			else if(scope.equals(Scope.root) && key.equals("creation date") && (value.getValue() instanceof IntegerValue))
			{
				Long s = integer((IntegerValue)value.getValue())*1000;
				Date date = new Date(s);
				torrent.getMeta().setCreated(DateUtil.toXmlGc(date));
			}
			else if(scope.equals(Scope.root) && key.equals("info") && (value.getValue() instanceof DictionaryValue))
			{
				all(Scope.info,value.getValue());
			}
			else if(scope.equals(Scope.info) && key.equals("length") && (value.getValue() instanceof IntegerValue))
			{
				Long s = integer((IntegerValue)value.getValue());
				torrent.setTotalLength(s);
			}
			else if(scope.equals(Scope.info) && key.equals("md5sum") && (value.getValue() instanceof StringValue))
			{
				String s = string((StringValue)value.getValue());
				torrent.setHash(XmlHashFactory.create(s));
			}
			else if(scope.equals(Scope.info) && key.equals("name") && (value.getValue() instanceof StringValue))
			{
				String s = string((StringValue)value.getValue());
				torrent.setFile(XmlFileFactory.build(s));
			}
			else if(scope.equals(Scope.info) && key.equals("piece length") && (value.getValue() instanceof IntegerValue))
			{
				Long s = integer((IntegerValue)value.getValue());
				torrent.getPieces().setPieceLength(s.intValue());
			}
			else if(scope.equals(Scope.info) && key.equals("pieces") && (value.getValue() instanceof StringValue))
			{
				logger.info("special pieces "+value.getValue().getClass().getSimpleName());
				StringValue v = (StringValue)value.getValue();
				byte[] a = v.resolve();
				int numberOfPieces = a.length/20;
				for(int i=0;i<numberOfPieces;i++)
				{
					Hash hash = XmlHashFactory.hex(Arrays.copyOfRange(a, 20*i, (20*i)+20));
					long length = torrent.getPieces().getPieceLength();
					if(i==numberOfPieces-1)
					{
						length = torrent.getTotalLength()-((numberOfPieces-1)*length);
					}
					torrent.getPieces().getPiece().add(XmlPieceFactory.build(i, length, hash));
				}
			}
			else
			{
				all(Scope.unknown,value.getValue());
			}
		}
	}
	
	private void list(ListValue root) throws IOException
	{
		for (Value<?> value : root)
		{
			all(Scope.unknown,value);
		}
	}
}
