package de.kisner.xbtjl.factory.bencode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.controller.processor.bencode.BenDecoder;
import de.kisner.xbtjl.factory.txt.TxtBenocdeFactory;
import de.kisner.xbtjl.factory.xml.tracker.XmlTrackerResponseFactory;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.tracker.TrackerResponse;

public class BenTrackerResponseFactory
{
	final static Logger logger = LoggerFactory.getLogger(BenTrackerResponseFactory.class);
	
	public static Map<String,?> toMap(InputStream is) throws IOException
	{
		BufferedInputStream bis = new BufferedInputStream(is);
		Map<String,?> map = BenDecoder.decode(bis);
        bis.close();
        is.close();
        return map;
	}
	
	public static TrackerResponse build(InputStream is) throws IOException
	{
		Map<String,?> map = toMap(is);
		TxtBenocdeFactory.print(map);
		
		TrackerResponse xml = XmlTrackerResponseFactory.build();
		if(map.containsKey("interval"))
		{
			xml.setInterval(((Long)map.get("interval")).intValue());
		}
		
		if(map.containsKey("peers"))
		{
			 Object peers = map.get("peers");
			 logger.info(peers.getClass().getSimpleName());
             
             if (peers instanceof List)
             {
            	 ArrayList peerList = new ArrayList();
                 peerList.addAll((List) peers);
                 if (peerList != null && peerList.size() > 0)
                 {
                     for (int i = 0; i < peerList.size(); i++)
                     {
                     	Peer peer = BenPeerFactory.buildPeer((Map<String,?>)(peerList.get(i)));
                        xml.getPeer().add(peer);
                     }
                 }
             }
             else if (peers instanceof byte[])
             {
                 byte[] p = ((byte[]) peers);
                 for (int i = 0; i < p.length; i += 6)
                 {
                 	Peer peer = BenPeerFactory.build(Arrays.copyOfRange(p, i, i+6));
                 	xml.getPeer().add(peer);
                 }
             }
		}
		
		return xml;
	}
}
