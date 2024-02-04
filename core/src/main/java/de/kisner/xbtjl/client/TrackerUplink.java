package de.kisner.xbtjl.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.exlp.util.jx.JaxbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.factory.xml.peer.XmlStatisticFactory;
import de.kisner.xbtjl.interfaces.listener.TrackerEventListener;
import de.kisner.xbtjl.interfaces.listener.TrackerEventListener.TrackerResponseError;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.peer.Statistic;
import de.kisner.xbtjl.model.xml.torrent.Torrent;
import de.kisner.xbtjl.model.xml.tracker.TrackerResponse;
import de.kisner.xbtjl.processor.net.client.ClientTrackerRequest;

public class TrackerUplink extends Thread
{
	final static Logger logger = LoggerFactory.getLogger(TrackerUplink.class);
	
    private Statistic statistic; public Statistic getStatistic() {return statistic;}

    private int trackerUpdateInterval;
    private boolean end = false;

    private List<TrackerEventListener> listeners;
    
    private ClientTrackerRequest trackerRequest;

    public TrackerUplink(Peer localPeer, Torrent xmlTorrent)
    {
    	listeners = new ArrayList<TrackerEventListener>();
    	trackerUpdateInterval = 300;
    	
    	logger.warn("Listening Port hardcoded");
    	localPeer.setListeningPort(6881);
    	JaxbUtil.info(localPeer);
    	statistic = XmlStatisticFactory.build();
    	trackerRequest = new ClientTrackerRequest(localPeer,xmlTorrent,this);
        
        statistic.setLeft(xmlTorrent.getTotalLength());
        this.setDaemon(true);
    }

    public void updateStatistic(int bytesDownloaded, int bytesUploaded)
    {
        synchronized (statistic)
        {
        	statistic.setBytesDownloaded(statistic.getBytesDownloaded()+bytesDownloaded);
        	statistic.setBytesUploaded(statistic.getBytesUploaded()+bytesUploaded);
            statistic.setLeft(statistic.getLeft()-bytesDownloaded);
        }
    }

    public void run()
    {
    	TrackerResponse response = null;
        while (!end)
        {
        	if(response==null){response = trackerRequest.hello(statistic);}
        	else{response = trackerRequest.ongoing(statistic);}

        	if (trackerUpdateInterval > response.getInterval()){trackerUpdateInterval = response.getInterval();}
            else {trackerUpdateInterval = trackerUpdateInterval*2;}
        	
        	LinkedHashMap<String,Peer> peerList = new LinkedHashMap<String, Peer>();
        	for(Peer peer : response.getPeer())
        	{
        		peerList.put(peer.getPeerId(), peer);
        	}
        	
        	this.fireUpdatePeerList(peerList);
            
            try {Thread.sleep(trackerUpdateInterval*1000);} catch (InterruptedException e) {e.printStackTrace();}
        }
    }

    public void shutdown()
    {
        end = true;
        trackerRequest.goodbye(statistic);
    }

    public void addTrackerEventListener(TrackerEventListener listener) {listeners.add(listener);}
    public void removeTrackerEventListener(TrackerEventListener listener) {listeners.remove(listener);}

    public void fireUpdatePeerList(LinkedHashMap<String,Peer> l)
    {
        for (TrackerEventListener listener : listeners)
        {
            listener.updatePeerList(l);
        }
    }

    public void fireUpdateFailed(TrackerResponseError error, String message)
    {
        for (TrackerEventListener listener : listeners)
        {
            listener.failure(error,message);
        }
    }
}