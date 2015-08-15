package de.kisner.xbtjl.factory.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.commons.io.IOUtils;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.MalformedMessage;
import de.kisner.xbtjl.model.protocol.control.KeepAliveMessage;

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
            	   message = BtMessageControlFactory.build(type);
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
}