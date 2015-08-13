package de.kisner.xbtjl.factory.bencode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.controller.processor.bencode.BenDecoder;
import de.kisner.xbtjl.controller.processor.bencode.BenEncoder;
import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlFileFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlHashFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlPiecesFactory;
import de.kisner.xbtjl.factory.xml.tracker.XmlTrackerFactory;
import de.kisner.xbtjl.model.xml.torrent.Comment;
import de.kisner.xbtjl.model.xml.torrent.Files;
import de.kisner.xbtjl.model.xml.torrent.Meta;
import de.kisner.xbtjl.model.xml.torrent.Piece;
import de.kisner.xbtjl.model.xml.torrent.Pieces;
import de.kisner.xbtjl.model.xml.torrent.Torrent;
import net.sf.exlp.util.DateUtil;
import net.sf.exlp.util.io.FileIO;

public class BenTorrentFactory
{
	final static Logger logger = LoggerFactory.getLogger(BenTorrentFactory.class);

    public static Torrent create(File f) throws IOException, XbtjlException
	{
		return create(FileIO.loadByte(f));
	}
	
	public static Torrent create(byte[] bytes) throws IOException, XbtjlException
	{
		return BenTorrentFactory.create(BenDecoder.decode(bytes));
	}
	
	public static Torrent create(Map<String,?> m) throws IOException, XbtjlException
	{	
		Torrent xml = new Torrent();
		
		if(m.containsKey("announce"))
		{
			xml.setTracker(XmlTrackerFactory.build(new String((byte[]) m.get("announce"))));
		}
		else {throw new XbtjlException("No announce available");}
		
		xml.setMeta(createMeta(m));
		
		if(m.containsKey("info"))
        {
            Map<String,?> info = (Map<String,?>)m.get("info");
            xml.setHash(XmlHashFactory.createFromBenByte(BenEncoder.encode(info)));
            
            if (info.containsKey("name")) {xml.setFile(BenTorrentFactory.buildFile(info));}
            
            xml.setFiles(new Files());
            if (info.containsKey("files"))
            {            	
                List multFiles = (List) info.get("files");
                xml.setTotalLength(0);
                for (int i = 0; i < multFiles.size(); i++)
                {
                    xml.setTotalLength(xml.getTotalLength()+ ((Long) ((Map) multFiles.get(i)).get("length")).intValue());
                    
                    List path = (List) ((Map) multFiles.get(i)).get("path");
                    StringBuffer sbFileName = new StringBuffer();
                    for (int j = 0; j < path.size(); j++)
                    {
                    	sbFileName.append(new String((byte[]) path.get(j)));
                    }
                    
                    de.kisner.xbtjl.model.xml.torrent.File file = new de.kisner.xbtjl.model.xml.torrent.File();
                    file.setValue(sbFileName.toString());
                    file.setLength(((Long) ((Map) multFiles.get(i)).get("length")).intValue());
                    xml.getFiles().getFile().add(file);
                }
            }
            else
            {
                xml.setTotalLength(((Long) info.get("length")).intValue());
                de.kisner.xbtjl.model.xml.torrent.File file = new de.kisner.xbtjl.model.xml.torrent.File();
                file.setValue(new String((byte[]) info.get("name")));
                file.setLength(((Long) info.get("length")).intValue());
                xml.getFiles().getFile().add(file);
            }
            
            if (info.containsKey("piece length"))
            {
            	Pieces pieces = XmlPiecesFactory.create(((Long)info.get("piece length")).intValue());
                xml.setPieces(pieces);
            }
            else
            {	//TODO Error
            	return null;
            }
            
            if (info.containsKey("pieces"))
            {
                byte[] piecesHash2 = (byte[]) info.get("pieces");
                if(piecesHash2.length % 20 != 0)
                {
                	//TODO tk handle error
                    return null;
                }
                
                xml.getPieces().setSize(piecesHash2.length/20);
                
                for (int i=0; i<xml.getPieces().getSize(); i++)
                {
                    byte[] temp = Arrays.copyOfRange(piecesHash2, i*20, i*20+20);
                    Piece piece = new Piece();
                    piece.setIndex(i);
                    piece.setHash(XmlHashFactory.create(Hex.encodeHexString(temp)));
                    xml.getPieces().getPiece().add(piece);
                }
                for(int i=0;i<xml.getPieces().getPiece().size();i++)
                {
                	if(i != xml.getPieces().getPiece().size() - 1)
                	{
                		xml.getPieces().getPiece().get(i).setLength(xml.getPieces().getPieceLength());
                	}
                	else
                	{
                		xml.getPieces().getPiece().get(i).setLength(((Long) (xml.getTotalLength() % xml.getPieces().getPieceLength())).intValue());
                	}
                }
            }
            else{return null;}
        }

		return xml;
	}
	
	private static Meta createMeta(Map<String,?> m)
	{
		Meta xml = new Meta();
		
		 if(m.containsKey("comment"))
		 {
			 Comment comment = new Comment();
			 comment.setValue(new String((byte[]) m.get("comment")));
		 }
		 
		 if(m.containsKey("created by"))
		 {
	            xml.setCreatedBy(new String((byte[]) m.get("created by")));
		 }
		 
	     if(m.containsKey("creation date"))
	     {
	           Date d = new Date((Long)m.get("creation date")*1000);
	           xml.setCreated(DateUtil.getXmlGc4D(d));
	     }
	     
	     if(m.containsKey("encoding"))
	     {
	    	 xml.setEncoding(new String((byte[]) m.get("encoding")));
	     }
		
		return xml;
	}
	
	public static de.kisner.xbtjl.model.xml.torrent.File buildFile(Map info)
	{
    	return XmlFileFactory.build(new String((byte[]) info.get("name")));
	}
}
