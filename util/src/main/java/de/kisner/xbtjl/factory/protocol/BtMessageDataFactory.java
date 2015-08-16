package de.kisner.xbtjl.factory.protocol;

import java.nio.ByteBuffer;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
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
	        case 5: msg = have(payload);break;
	        case 6: msg = bitfield(payload);break;
	        case 7: msg = request(payload);break;
	        case 8: msg = piece(payload);break;
	        case 9: msg = cancel(type, payload);break;
	        case 10:msg = port(type, payload);break;
       }
	   if(msg!=null){return msg;}
	   return message;
	}
	   
	public static HaveMessage have(byte[] payload)
	{
		HaveMessage message = new HaveMessage();
	   	message.setLength(new byte[] {0, 0, 0, 5});
	   	message.setPayload(payload);
	   	message.setType(BtMessageTypeFactory.toEnum(BtProtocolMessage._HAVE));
	   	return message;
	}
	   
	public static BitfieldMessage bitfield(byte[] payload)
	{
	   	BitfieldMessage message = new BitfieldMessage();
	   	message.setLength(ByteBuffer.allocate(4).putInt((1 + payload.length)).array());
	   	
	   	message.setPayload(payload);
	   	message.setType(BtMessageTypeFactory.toEnum(BtProtocolMessage._BITFIELD));
	   	return message;
	}
	
	public static RequestMessage request(byte[] payload)
	{
		RequestMessage message = new RequestMessage();
    	message.setLength(new byte[] {0, 0, 0, 13});
    	message.setPayload(payload);
	   	message.setType(BtMessageTypeFactory.toEnum(BtProtocolMessage._REQUEST));
	   	return message;
	}
	
	public static PieceMessage piece(byte[] payload)
	{
		PieceMessage message = new PieceMessage();
    	message.setLength(ByteBuffer.allocate(4).putInt((1 + payload.length)).array());
    	
    	message.setPayload(payload);
	   	message.setType(BtMessageTypeFactory.toEnum(BtProtocolMessage._PIECE));
	   	return message;
	}
	
	public static CancelMessage cancel(MsgType type, byte[] payload)
	{
		CancelMessage message = new CancelMessage();
    	message.setLength(new byte[] {0, 0, 0, 13});
    	
    	message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
	
	public static PortMessage port(MsgType type, byte[] payload)
	{
		PortMessage message = new PortMessage();
		message.setLength(new byte[] {0, 0, 0, 3});
    	
    	message.setPayload(payload);
	   	message.setType(type);
	   	return message;
	}
}