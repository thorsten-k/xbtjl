package de.kisner.xbtjl.factory.protocol;

import java.nio.ByteBuffer;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.data.DataMessage;

public class BtMessageDataFactory
{
	   public static DataMessage build(MsgType type, byte[] payload)
	   {
		   DataMessage message = new DataMessage();
		   message.setType(type);
		   
		   switch (BtMessageTypeFactory.toId(type))
	       {
		        case 5:
		        	message.setLength(new byte[] {0, 0, 0, 5});
		        	message.setID(4);
		            message.setPayload(payload);
		            break;
		        case 6:
		        	message.setLength(ByteBuffer.allocate(4).putInt((1 + payload.length)).array());
		        	message.setID(5);
		        	message.setPayload(payload);
		            break;
		        case 7:
		        	message.setLength(new byte[] {0, 0, 0, 13});
		        	message.setID(6);
		        	message.setPayload(payload);
		            break;
		        case 8:
		        	message.setLength(ByteBuffer.allocate(4).putInt((1 + payload.length)).array());
		        	message.setID(7);
		        	message.setPayload(payload);
		            break;
		        case 9:
		        	message.setLength(new byte[] {0, 0, 0, 13});
		        	message.setID(8);
		        	 message.setPayload(payload);
		            break;
		        case 10:
		        	message.setLength(new byte[] {0, 0, 0, 3});
		        	message.setID(9);
		        	 message.setPayload(payload);
		            break;
	       }
		   
		   return message;
	   }
}