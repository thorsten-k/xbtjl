package de.kisner.xbtjl.factory.bencode;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.factory.xml.peer.XmlPeerFactory;
import de.kisner.xbtjl.model.xml.peer.Peer;
import net.sf.exlp.util.io.ByteUtil;

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
	
	public static Peer build(byte[] bytes)
	{
		Peer peer = null;
		try
    	{
			InetAddress ia = InetAddress.getByAddress(Arrays.copyOfRange(bytes, 0, 4));
        	int port = ByteUtil.toUnsignedInt(Arrays.copyOfRange(bytes,4,6));
        	peer = XmlPeerFactory.create(ia.getHostAddress(),port);
		}
    	catch (UnknownHostException e) {e.printStackTrace();}
		return peer;
	}
}
