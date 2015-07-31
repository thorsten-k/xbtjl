package de.kisner.xbtjl.factory.txt;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlInternalErrorException;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlHashFactory;
import de.kisner.xbtjl.model.xml.bittorrent.AnnouceUrl;
import de.kisner.xbtjl.model.xml.bittorrent.Hash;
import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import de.kisner.xbtjl.model.xml.bittorrent.TrackerRequest;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.peer.Statistic;

public class TxtTrackerRequestFactory
{
	final static Logger logger = LoggerFactory.getLogger(TxtTrackerRequestFactory.class);
	
	public static final String urlHash = "info_hash";
	public static final String urlPeerId = "peer_id";
	public static final String urlPort = "port";
	public static final String urlUploaded = "uploaded";
	public static final String urlDownloaded = "downloaded";
	public static final String urlLeft = "left";
	public static final String urlNumWant = "numwant";
	
	public static synchronized String create(TrackerRequest xml) throws XbtjlInternalErrorException
	{
		checkXml(xml);
		
		URLCodec urlCodec = new URLCodec("UTF-8");
		
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append(xml.getTorrent().getAnnouceUrl().getValue());
			sb.append("?");
			sb.append(urlHash).append("="+XmlHashFactory.toUrl(xml.getTorrent().getHash()));
			sb.append("&").append(urlPeerId).append("=").append(urlCodec.encode(xml.getPeer().getPeerId()));
			sb.append("&").append(urlPort).append("=").append(xml.getPeer().getListeningPort());
			sb.append("&").append(urlUploaded).append("=").append(xml.getPeer().getStatistic().getSumUl());
			sb.append("&").append(urlDownloaded).append("=").append(xml.getPeer().getStatistic().getSumDl());
			sb.append("&").append(urlLeft).append("=").append(xml.getPeer().getStatistic().getLeft());
			if(xml.isSetNumWant()){sb.append("&").append(urlNumWant).append("=").append(xml.getNumWant());}
			return sb.toString();
		}
		catch (EncoderException e) {throw new XbtjlInternalErrorException(e.getMessage());}
		
	}
	
	private static void checkXml(TrackerRequest xml) throws XbtjlInternalErrorException
	{
		if(!xml.isSetTorrent()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+" does not has a "+Torrent.class.getSimpleName());}
		
		if(!xml.getTorrent().isSetAnnouceUrl()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+" does not has a "+AnnouceUrl.class.getSimpleName());}
		if(!xml.getTorrent().getAnnouceUrl().isSetValue()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+"."+AnnouceUrl.class.getSimpleName()+" does not has a value");}
		
		if(!xml.getTorrent().isSetHash()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+" does not has a "+Hash.class.getSimpleName());}
		if(!xml.getTorrent().getHash().isSetValue()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+"."+Hash.class.getSimpleName()+" does not has a value");}
		
		if(!xml.isSetPeer()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+" does not has a "+Peer.class.getSimpleName());}
		if(!xml.getPeer().isSetPeerId()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+"."+Peer.class.getSimpleName()+" does not has a @peerId");}
		if(!xml.getPeer().isSetListeningPort()){throw new XbtjlInternalErrorException(TrackerRequest.class.getSimpleName()+"."+Peer.class.getSimpleName()+" does not has a @listeningPort");}
		
		if(!xml.getPeer().isSetStatistic()){throw new XbtjlInternalErrorException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" is not set");}
		if(!xml.getPeer().getStatistic().isSetSumDl()){throw new XbtjlInternalErrorException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" does not has a @sumDl");}
		if(!xml.getPeer().getStatistic().isSetSumUl()){throw new XbtjlInternalErrorException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" does not has a @sumUl");}
		if(!xml.getPeer().getStatistic().isSetLeft()){throw new XbtjlInternalErrorException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" does not has a @left");}
	}
}