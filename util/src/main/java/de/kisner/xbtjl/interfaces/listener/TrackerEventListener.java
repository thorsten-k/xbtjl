package de.kisner.xbtjl.interfaces.listener;

import java.util.LinkedHashMap;

import de.kisner.xbtjl.model.xml.peer.Peer;

import java.util.EventListener;

public interface TrackerEventListener extends EventListener
{
	public static enum TrackerResponseError{TRACKER,INVALIDURL,TRACKER_UNKNOWN,TRACKER_NOT_AVAILABLE,GENERAL}
	
    public void updatePeerList(LinkedHashMap<String,Peer> mapPeers);
    public void failure(TrackerResponseError error, String errorMessage);
}
