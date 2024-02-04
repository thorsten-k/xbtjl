package de.kisner.xbtjl.processor.net.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;
import org.exlp.util.jx.JaxbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.client.TrackerUplink;
import de.kisner.xbtjl.factory.bencode.BenTrackerResponseFactory;
import de.kisner.xbtjl.factory.xml.peer.XmlPeerFactory;
import de.kisner.xbtjl.factory.xml.torrent.XmlHashFactory;
import de.kisner.xbtjl.interfaces.listener.TrackerEventListener;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.peer.Statistic;
import de.kisner.xbtjl.model.xml.torrent.Torrent;
import de.kisner.xbtjl.model.xml.tracker.TrackerResponse;
import net.sf.exlp.util.io.ByteUtil;

public class ClientTrackerRequest
{
	final static Logger logger = LoggerFactory.getLogger(TrackerUplink.class);
	
	private Peer localPeer;
	private Torrent xmlTorrent;
	private TrackerUplink peerUpdater;
	
	public ClientTrackerRequest(Peer localPeer,Torrent xmlTorrent,TrackerUplink peerUpdater)
	{
		this.localPeer=localPeer;
		this.xmlTorrent=xmlTorrent;
		this.peerUpdater=peerUpdater;
	}

	public synchronized TrackerResponse hello(Statistic statistic){return contactTracker(statistic, "&event=started");}
	public synchronized TrackerResponse goodbye(Statistic statistic){return contactTracker(statistic, "&event=stopped");}
	public synchronized TrackerResponse ongoing(Statistic statistic){return contactTracker(statistic, "");}
	
    private synchronized TrackerResponse contactTracker(Statistic statistic, String event)
    {
        try
        {
        	StringBuffer sb = new StringBuffer();
        	sb.append(xmlTorrent.getTracker().getUrl());
        	sb.append("?info_hash=").append(XmlHashFactory.toUrl(xmlTorrent.getHash()));
        	sb.append("&peer_id=").append(ByteUtil.toUrlString(XmlPeerFactory.toPeerId(localPeer)));
        	sb.append("&port=").append(localPeer.getListeningPort());
        	sb.append("&downloaded=").append(statistic.getBytesDownloaded());
        	sb.append("&uploaded=").append(statistic.getBytesUploaded());
        	sb.append("&left=").append(statistic.getLeft());
        	sb.append("&numwant=").append("50");
        	sb.append("&compact=").append("1");
        	sb.append(event);
        	
            URL source = new URL(sb.toString());
            logger.info("Contacting Tracker at URL: "+source);
            URLConnection uc = source.openConnection();
            InputStream is = uc.getInputStream();
            
            TrackerResponse response = BenTrackerResponseFactory.build(new ByteArrayInputStream(IOUtils.toByteArray(is))); 
            JaxbUtil.info(response);
            
            return response;
        }
        catch (MalformedURLException e) {peerUpdater.fireUpdateFailed(TrackerEventListener.TrackerResponseError.INVALIDURL,"Tracker URL is not valid");}
        catch (UnknownHostException e) {peerUpdater.fireUpdateFailed(TrackerEventListener.TrackerResponseError.TRACKER_UNKNOWN,"Tracker hostname cannot be resolved");}
        catch (IOException e) {peerUpdater.fireUpdateFailed(TrackerEventListener.TrackerResponseError.TRACKER_NOT_AVAILABLE,"Tracker unreachable");}
        catch (Exception e)
        {
        	e.printStackTrace();
        	peerUpdater.fireUpdateFailed(TrackerEventListener.TrackerResponseError.GENERAL, "General Error");
        	
        }
        return null;
    }
}