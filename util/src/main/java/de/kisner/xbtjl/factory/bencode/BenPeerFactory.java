package de.kisner.xbtjl.factory.bencode;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.factory.xml.peer.XmlPeerFactory;
import de.kisner.xbtjl.model.xml.peer.Peer;

public class BenPeerFactory
{
	final static Logger logger = LoggerFactory.getLogger(BenPeerFactory.class);
	
	public static Peer buildPeer(Map<String,?> benMap)
	{
		String id = new String((byte[])benMap.get("peer_id"));
		String ip = new String((byte[])benMap.get("ip"));
		int port = ((Long)benMap.get("port")).intValue();
		
		Peer xml = XmlPeerFactory.create(id,ip,port);
		
		return xml;
	}
}
