package de.kisner.xbtjl.factory.txt;

import java.util.Objects;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.xml.torrent.XmlHashFactory;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.peer.Statistic;
import de.kisner.xbtjl.model.xml.torrent.Hash;
import de.kisner.xbtjl.model.xml.torrent.Torrent;
import de.kisner.xbtjl.model.xml.tracker.Tracker;
import de.kisner.xbtjl.model.xml.tracker.TrackerRequest;

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
	
	public static synchronized String create(TrackerRequest xml) throws XbtjlException
	{
		checkXml(xml);
		
		URLCodec urlCodec = new URLCodec("UTF-8");
		
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append(xml.getTorrent().getTracker().getUrl());
			sb.append("?");
			sb.append(urlHash).append("="+XmlHashFactory.toUrl(xml.getTorrent().getHash()));
			sb.append("&").append(urlPeerId).append("=").append(urlCodec.encode(xml.getPeer().getPeerId()));
			sb.append("&").append(urlPort).append("=").append(xml.getPeer().getListeningPort());
			sb.append("&").append(urlUploaded).append("=").append(xml.getPeer().getStatistic().getBytesUploaded());
			sb.append("&").append(urlDownloaded).append("=").append(xml.getPeer().getStatistic().getBytesDownloaded());
			sb.append("&").append(urlLeft).append("=").append(xml.getPeer().getStatistic().getLeft());
			if(Objects.nonNull(xml.getNumWant())) {sb.append("&").append(urlNumWant).append("=").append(xml.getNumWant());}
			return sb.toString();
		}
		catch (EncoderException e) {throw new XbtjlException(e.getMessage());}
		
	}
	
	private static void checkXml(TrackerRequest xml) throws XbtjlException
	{
		if(Objects.isNull(xml.getTorrent())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+" does not has a "+Torrent.class.getSimpleName());}
		
		if(Objects.isNull(xml.getTorrent().getTracker())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+" does not has a "+Tracker.class.getSimpleName());}
		if(Objects.isNull(xml.getTorrent().getTracker().getUrl())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+"."+Tracker.class.getSimpleName()+" does not has a @annoucne");}
		
		if(Objects.isNull(xml.getTorrent().getHash())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+" does not has a "+Hash.class.getSimpleName());}
		if(Objects.isNull(xml.getTorrent().getHash().getValue())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+"."+Torrent.class.getSimpleName()+"."+Hash.class.getSimpleName()+" does not has a value");}
		
		if(Objects.isNull(xml.getPeer())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+" does not has a "+Peer.class.getSimpleName());}
		if(Objects.isNull(xml.getPeer().getPeerId())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+"."+Peer.class.getSimpleName()+" does not has a @peerId");}
		if(Objects.isNull(xml.getPeer().getListeningPort())) {throw new XbtjlException(TrackerRequest.class.getSimpleName()+"."+Peer.class.getSimpleName()+" does not has a @listeningPort");}
		
		if(Objects.isNull(xml.getPeer().getStatistic())) {throw new XbtjlException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" is not set");}
		if(Objects.isNull(xml.getPeer().getStatistic().getBytesDownloaded())) {throw new XbtjlException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" does not has a @sumDl");}
		if(Objects.isNull(xml.getPeer().getStatistic().getBytesUploaded())) {throw new XbtjlException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" does not has a @sumUl");}
		if(Objects.isNull(xml.getPeer().getStatistic().getLeft())) {throw new XbtjlException(Peer.class.getSimpleName()+"."+Statistic.class.getSimpleName()+" does not has a @left");}
	}
}