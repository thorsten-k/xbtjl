package de.kisner.xbtjl.factory.protocol;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.model.protocol.HandshakeMessage;
import de.kisner.xbtjl.model.protocol.MalformedMessage;
import net.sf.exlp.util.io.ByteUtil;

/**
 * +-------------+---------------+----------+-----------+---------+
 * | Name Length | Protocol Name | Reserved | Info Hash | Peer ID |
 * +-------------+---------------+----------+-----------+---------+
 */
public class BtMessageHandshakeFactory
{   
	final static Logger logger = LoggerFactory.getLogger(BtMessageHandshakeFactory.class);
	
	public static BitTorrentMessage build(InputStream is)
	{
        try
        {
        	HandshakeMessage msg = new HandshakeMessage();
        	
        	byte[] length = IOUtils.toByteArray(is, 1);
        	msg.setLength(length);
        	
        	msg.setProtocol(new String(IOUtils.toByteArray(is, 19)));	
        	msg.setReserved(IOUtils.toByteArray(is, 8));
        	msg.setFileId(IOUtils.toByteArray(is, 20));
        	msg.setPeerId(IOUtils.toByteArray(is, 20));

            return msg;
		}
        catch (IOException e)
        {
			return new MalformedMessage(e.getMessage());
		}
	}
	
	public static HandshakeMessage build(byte[] infoHash, byte[] peerID)
	{
		HandshakeMessage msg = new HandshakeMessage();
        msg.setLength(new byte[]{19});
        msg.setProtocol("BitTorrent protocol");
        msg.setReserved(new byte[]{0,0,0,0,0,0,0,0});
		msg.setFileId(infoHash);
		msg.setPeerId(peerID);
		return msg;
	}
	
	public static byte[] build(HandshakeMessage m)
	{
		return ByteUtil.concat(m.getLength(),m.getProtocol().getBytes(), m.getReserved(), m.getFileId(), m.getPeerId());
	}
}