package de.kisner.xbtjl.factory.xml.bittorrent;

import java.util.Random;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlPeerIdFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlPeerIdFactory.class);
	
	 /**
     * https://wiki.theory.org/BitTorrentSpecification#peer_id
     * @return byte[]
     */
    public static byte[] generateID()
    {
        byte[] id = new byte[12];

        Random r = new Random(System.currentTimeMillis());
        r.nextBytes(id);
        return ArrayUtils.addAll("-XJ0001-".getBytes(),id);
    }
}