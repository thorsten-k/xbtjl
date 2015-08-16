package de.kisner.xbtjl.factory.protocol;

import java.nio.ByteBuffer;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.data.AbstractDataMessage;
import de.kisner.xbtjl.model.protocol.data.BitfieldMessage;
import de.kisner.xbtjl.model.protocol.data.CancelMessage;
import de.kisner.xbtjl.model.protocol.data.HaveMessage;
import de.kisner.xbtjl.model.protocol.data.PieceMessage;
import de.kisner.xbtjl.model.protocol.data.PortMessage;
import de.kisner.xbtjl.model.protocol.data.RequestMessage;

public class BtMessageDataFactory
{
	   public static BitTorrentMessage build(MsgType type, byte[] payload)
	   {
	   	BitTorrentMessage msg = null;
		   AbstractDataMessage message = new AbstractDataMessage();
		   message.setType(type);
		   
		   switch (BtMessageTypeFactory.toId(type))
	       {
		        case 5: msg = have(type, payload);break;
		        case 6: msg = bitfield(type, payload);break;
		        case 7: msg = request(type, payload);break;
		        case 8: msg = piece(type, payload);break;
		        case 9: msg = cancel(type, payload);break;
		        case 10:msg = port(type, payload);break;
	       }
		   if(msg!=null){return msg;}
		   return message;
	   }
	   
	public static HaveMessage have(MsgType type, byte[] payload)
	{
		HaveMessage message = new HaveMessage();
	   	message.setLength(new byte[] {0, 0, 0, 5});
	   	message.setID(4);
	   	message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
	   
	public static BitfieldMessage bitfield(MsgType type, byte[] payload)
	{
	   	BitfieldMessage message = new BitfieldMessage();
	   	message.setLength(ByteBuffer.allocate(4).putInt((1 + payload.length)).array());
	   	message.setID(5);
	   	message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
	
	public static RequestMessage request(MsgType type, byte[] payload)
	{
		RequestMessage message = new RequestMessage();
    	message.setLength(new byte[] {0, 0, 0, 13});
    	message.setID(6);
    	message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
	
	public static PieceMessage piece(MsgType type, byte[] payload)
	{
		PieceMessage message = new PieceMessage();
    	message.setLength(ByteBuffer.allocate(4).putInt((1 + payload.length)).array());
    	message.setID(7);
    	message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
	
	public static CancelMessage cancel(MsgType type, byte[] payload)
	{
		CancelMessage message = new CancelMessage();
    	message.setLength(new byte[] {0, 0, 0, 13});
    	message.setID(8);
    	 message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
	
	public static PortMessage port(MsgType type, byte[] payload)
	{
		PortMessage message = new PortMessage();
		message.setLength(new byte[] {0, 0, 0, 3});
    	message.setID(9);
    	 message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
}