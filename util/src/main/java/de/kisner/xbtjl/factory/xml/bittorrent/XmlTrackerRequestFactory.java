package de.kisner.xbtjl.factory.xml.bittorrent;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.txt.TxtTrackerRequestFactory;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.peer.Statistic;
import de.kisner.xbtjl.model.xml.protocol.TrackerRequest;
import de.kisner.xbtjl.model.xml.torrent.Torrent;

public class XmlTrackerRequestFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlTrackerRequestFactory.class);
	
	public static synchronized TrackerRequest create(String urlParameter) throws XbtjlException
	{
		TrackerRequest xml = new TrackerRequest();
		xml.setTorrent(new Torrent());
		xml.setPeer(new Peer());
		xml.getPeer().setStatistic(new Statistic());
		
		String[] kvs = urlParameter.split("&");
		logger.debug("KV.length="+kvs.length);
		
		URLCodec urlCodec = new URLCodec("UTF-8");
		
		for(String kv : kvs)
		{
			String[] s = kv.split("=");
			add(urlCodec, xml, s[0], s[1]);
		}
		
		return xml;
	}
	
	private static void add(URLCodec urlCodec, TrackerRequest xml, String key, String value) throws XbtjlException
	{
		logger.debug(key+":"+value);
		try
		{
			if(key.equals(TxtTrackerRequestFactory.urlHash)){xml.getTorrent().setHash(XmlHashFactory.createFromUrl(value));}
			if(key.equals(TxtTrackerRequestFactory.urlPort)){xml.getPeer().setListeningPort(new Integer(value));}
			if(key.equals(TxtTrackerRequestFactory.urlPeerId)){xml.getPeer().setPeerId(urlCodec.decode(value));}
			if(key.equals(TxtTrackerRequestFactory.urlUploaded)){xml.getPeer().getStatistic().setSumUl(new Integer(value));}
			if(key.equals(TxtTrackerRequestFactory.urlDownloaded)){xml.getPeer().getStatistic().setSumDl(new Integer(value));}
			if(key.equals(TxtTrackerRequestFactory.urlLeft)){xml.getPeer().getStatistic().setLeft(new Long(value));}
			if(key.equals(TxtTrackerRequestFactory.urlNumWant)){xml.setNumWant(new Integer(value));}
		}
		catch (DecoderException e) {e.printStackTrace();throw new XbtjlException(e.getMessage());}
	}
}
