package de.kisner.xbtjl.factory.xml.bittorrent;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.model.xml.torrent.Hash;
import net.sf.exlp.util.io.ByteUtil;
import net.sf.exlp.util.io.HashUtil;

public class XmlHashFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlHashFactory.class);
	
	public static synchronized Hash create(String hash)
	{
		Hash xml = new Hash();
		xml.setValue(hash);
		return xml;
	}
	
	public static Hash hex(byte[] b)
	{
		return create(Hex.encodeHexString(b));
	}
	
	@Deprecated
	public static synchronized Hash createFromBenByte(byte[] b)
	{
		return create(Hex.encodeHexString(HashUtil.sha1Byte(b)));
	}
	
	public static synchronized Hash createFromUrl(String urlHash) throws XbtjlException
	{
		try
		{
			byte[] b = URLCodec.decodeUrl(urlHash.getBytes());
			return create(Hex.encodeHexString(b));
		}
		catch (DecoderException e) {e.printStackTrace();throw new XbtjlException(e.getMessage());}
	}
	
	public static byte[] toBinary(Hash hash)
	{
		try
		{
			return Hex.decodeHex(hash.getValue().toCharArray());
		}
		catch (DecoderException e) {e.printStackTrace();}
		return null;
	}
	
	public static String toUrl(Hash hash)
	{		
		return ByteUtil.toUrlString(toBinary(hash));
	}
}