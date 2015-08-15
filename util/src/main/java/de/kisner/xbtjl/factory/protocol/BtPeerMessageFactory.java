package de.kisner.xbtjl.factory.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.commons.io.IOUtils;

import de.kisner.xbtjl.factory.protocol.BtMessageTypeFactory;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.payload.PayloadMessage;

public class BtPeerMessageFactory 
{
   public static PayloadMessage build(MsgType type)
   {
	   PayloadMessage message = new PayloadMessage();
	   message.setType(type);
	   
       switch (BtMessageTypeFactory.toId(type))
       {
	        case 0:
	        	message.setLength(new byte[] {0, 0, 0, 0});
	            break;
	        case 1:
	        	message.setLength(new byte[] {0, 0, 0, 1});
	        	message.setID(0);
	            break;
	        case 2:
	        	message.setLength(new byte[] {0, 0, 0, 1});
	        	message.setID(1);
	            break;
	        case 3:
	        	message.setLength(new byte[] {0, 0, 0, 1});
	        	message.setID(2);
	            break;
	        case 4:
	        	message.setLength(new byte[] {0, 0, 0, 1});
	        	message.setID(3);
	            break;
       }
	   
	   return message;
   }
   
   public static PayloadMessage build(MsgType type, byte[] payload)
   {
	   PayloadMessage message = new PayloadMessage();
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
   
   public static PayloadMessage build(InputStream is) throws IOException
   {
	   PayloadMessage mess = null;
	   
	   int length = ByteBuffer.wrap(IOUtils.toByteArray(is, 4)).getInt();
       
       if (length == 0) {mess = BtPeerMessageFactory.build(BtMessageTypeFactory.toEnum(BtProtocolMessage._KEEP_ALIVE));}
       else
       {
    	   int id = is.read();
           if(id == -1)
           {
               System.err.println("id");
               mess = null;
           }
           else
           {
               if (length == 1){mess = BtPeerMessageFactory.build(BtMessageTypeFactory.toEnum(id + 1));}
               else
               {
                   byte[] payload = IOUtils.toByteArray(is, length-1);
                   mess = BtPeerMessageFactory.build(BtMessageTypeFactory.toEnum(id + 1),payload);
               }
           }
       }
       return mess;
   }
}