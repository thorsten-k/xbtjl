package de.kisner.xbtjl.controller.processor.bencode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlFileFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlHashFactory;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlPiecesFactory;
import de.kisner.xbtjl.factory.xml.peer.XmlPeerFactory;
import de.kisner.xbtjl.model.xml.bittorrent.AnnouceUrl;
import de.kisner.xbtjl.model.xml.bittorrent.Comment;
import de.kisner.xbtjl.model.xml.bittorrent.Files;
import de.kisner.xbtjl.model.xml.bittorrent.Meta;
import de.kisner.xbtjl.model.xml.bittorrent.Piece;
import de.kisner.xbtjl.model.xml.bittorrent.Pieces;
import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import de.kisner.xbtjl.model.xml.peer.Peer;
import net.sf.exlp.util.DateUtil;
import net.sf.exlp.util.io.FileIO;

public class BencodeTorrentProcessor
{
	final static Logger logger = LoggerFactory.getLogger(BencodeTorrentProcessor.class);
	
	public static final String DEFAULT_ENCODING = "UTF8";
    public static final String BYTE_ENCODING = "ISO-8859-1";
    public static Charset BYTE_CHARSET;
    public static Charset DEFAULT_CHARSET;

    static
    {
        try
        {
            BYTE_CHARSET = Charset.forName(BencodeTorrentProcessor.BYTE_ENCODING);
            DEFAULT_CHARSET = Charset.forName(BencodeTorrentProcessor.DEFAULT_ENCODING);
        }
        catch (Throwable e) {e.printStackTrace();}
    }

    public static Torrent create(File f) throws IOException, XbtjlException
	{
		return create(FileIO.loadByte(f));
	}
	
	public static Torrent create(byte[] bytes) throws IOException, XbtjlException
	{
		return BencodeTorrentProcessor.create(BenDecoder.decode(bytes));
	}
	
	public static Torrent create(Map m) throws IOException, XbtjlException
	{	
		Torrent xml = new Torrent();
		
		if(m.containsKey("announce"))
		{
			xml.setAnnouceUrl(new AnnouceUrl());
			xml.getAnnouceUrl().setValue(new String((byte[]) m.get("announce")));	
		}
		else {throw new XbtjlException("No announce available");}
		
		xml.setMeta(createMeta(m));
		
		if(m.containsKey("info"))
        {
            Map info = (Map) m.get("info");
            xml.setHash(XmlHashFactory.createFromBenByte(BenEncoder.encode(info)));
            
            if (info.containsKey("name")) {xml.setFile(BencodeTorrentProcessor.buildFile(info));}
            
            xml.setFiles(new Files());
            if (info.containsKey("files"))
            {            	
                List multFiles = (List) info.get("files");
                xml.setTotalLength(0);
                for (int i = 0; i < multFiles.size(); i++)
                {
                    xml.setTotalLength(xml.getTotalLength()+ ((Long) ((Map) multFiles.get(i)).get("length")).intValue());
                    
                    List path = (List) ((Map) multFiles.get(i)).get("path");
                    String filePath = "";
                    for (int j = 0; j < path.size(); j++) {filePath += new String((byte[]) path.get(j)); }
                    de.kisner.xbtjl.model.xml.bittorrent.File file = new de.kisner.xbtjl.model.xml.bittorrent.File();
                    file.setValue(filePath);
                    file.setLength(((Long) ((Map) multFiles.get(i)).get("length")).intValue());
                   xml.getFiles().getFile().add(file);
                }
            }
            else
            {
                xml.setTotalLength(((Long) info.get("length")).intValue());
                de.kisner.xbtjl.model.xml.bittorrent.File file = new de.kisner.xbtjl.model.xml.bittorrent.File();
                file.setValue(new String((byte[]) info.get("name")));
                file.setLength(((Long) info.get("length")).intValue());
                xml.getFiles().getFile().add(file);
            }
            
            if (info.containsKey("piece length"))
            {
            	Pieces pieces = XmlPiecesFactory.create(((Long) info.get("piece length")).intValue());
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
                	//TODO Error
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
	
	private static Meta createMeta(Map m)
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
	           Date d = new Date((Long)m.get("creation date"));
	           xml.setCreated(DateUtil.getXmlGc4D(d));
	     }
	     
	     if(m.containsKey("encoding"))
	     {
	    	 xml.setEncoding(new String((byte[]) m.get("encoding")));
	     }
		
		return xml;
	}
	
	public static Peer buildPeer(Map<String,?> benMap)
	{
		String id = new String((byte[])benMap.get("peer_id"));
		String ip = new String((byte[])benMap.get("ip"));
		int port = ((Long)benMap.get("port")).intValue();
		
		Peer xml = XmlPeerFactory.create(id,ip,port);
		
		return xml;
	}
	
	public static de.kisner.xbtjl.model.xml.bittorrent.File buildFile(Map info)
	{
    	return XmlFileFactory.build(new String((byte[]) info.get("name")));
	}
}
