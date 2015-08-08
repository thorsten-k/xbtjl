package de.kisner.xbtjl.factory.bencode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
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
		
		boolean iOfList = map.get("peers") instanceof List;
		
		
		if(map.containsKey("peers"))
		{
			Object o = map.get("peers");
			logger.info(o.getClass().getSimpleName());
			List peers = (List)o;
			
			
			if (peers != null && peers.size()>0)
            {
                for (int i = 0; i < peers.size(); i++)
                {
                	Peer peer = BenPeerFactory.buildPeer((Map<String,?>)(peers.get(i)));
                    xml.getPeer().add(peer);
                }
            }
		}
		
		return xml;
	}
}
