package de.kisner.xbtjl.factory.xml.peer;

import java.util.Random;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.torrent.Pieces;

public class XmlPeerFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlPeerFactory.class);
	
	public static Peer create(String listeningIp, int listeningPort)
	{
		Peer xml = new Peer();
		
		xml.setListeningIp(listeningIp);
		xml.setListeningPort(listeningPort);
		xml.setPeerId(listeningIp+":"+listeningPort);
		
		xml.setStatistic(XmlStatisticFactory.create());
		xml.setInfo(XmlInfoFactory.create());
		xml.setPieces(new Pieces());
		
		return xml;
	}
	
	public static Peer create(String peerId, String listeningIp, int listeningPort)
	{
		Peer xml = create(listeningIp,listeningPort);
		xml.setPeerId(peerId);
		return xml;
	}
	
	public static Peer build(byte[] id)
	{
		Peer xml = new Peer();
		xml.setPeerId(Hex.encodeHexString(id));
		return xml;
	}
	
	public static byte[] toPeerId(Peer peer)
	{
		byte[] b = null;
		try {
			b = Hex.decodeHex(peer.getPeerId().toCharArray());
		} catch (DecoderException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public static byte[] generateID()
    {
        byte[] id = new byte[12];

        Random r = new Random(System.currentTimeMillis());
        r.nextBytes(id);
        return ArrayUtils.addAll("-XJ0001-".getBytes(),id);
    }
}