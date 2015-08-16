package de.kisner.xbtjl.factory.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.commons.io.IOUtils;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.MalformedMessage;
import de.kisner.xbtjl.model.protocol.control.AbstractControlMessage;
import de.kisner.xbtjl.model.protocol.control.ChokeMessage;
import de.kisner.xbtjl.model.protocol.control.InterestedMessage;
import de.kisner.xbtjl.model.protocol.control.KeepAliveMessage;
import de.kisner.xbtjl.model.protocol.control.NotInterestedMessage;
import de.kisner.xbtjl.model.protocol.control.UnChokeMessage;

public class BtMessageFactory 
{
   public static BitTorrentMessage build(InputStream is) throws IOException
   {
	   BitTorrentMessage message = null;
	   
	   int length = ByteBuffer.wrap(IOUtils.toByteArray(is, 4)).getInt();
       
       if (length == 0) {message = new KeepAliveMessage();}
       else
       {
    	   int id = is.read();
           if(id == -1) {message = new MalformedMessage("Cannot read the msgId");}
           else
           {
        	   MsgType type = BtMessageTypeFactory.toEnumPlus1(id);
               if (length == 1)
               {
            	   message = BtMessageFactory.build(type);
               }
               else
               {
                   byte[] payload = IOUtils.toByteArray(is, length-1);
                   message = BtMessageDataFactory.build(type,payload);
               }
           }
       }
       return message;
	}
   
	public static BitTorrentMessage build(MsgType type)
	{
		AbstractControlMessage message = new AbstractControlMessage();
		message.setType(type);
		   
		switch (BtMessageTypeFactory.toId(type))
		{            
			case 1: message = new ChokeMessage(); break;
			case 2: message = new UnChokeMessage(); break;
			case 3: message = new InterestedMessage(); break;
			case 4: message = new NotInterestedMessage(); break;
		}
		   
		return message;
	}
	
	public static BitTorrentMessage choke() {return new ChokeMessage();}
	public static BitTorrentMessage unChoke() {return new UnChokeMessage();}
	public static BitTorrentMessage interested() {return new InterestedMessage();}
	public static BitTorrentMessage notInterested() {return new NotInterestedMessage();}
   
   public static byte[] toId(int id)
   {
	   byte[] b = new byte[1];
	   b[0] = (byte) id;
	   return b;
   }
}