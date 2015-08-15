package de.kisner.xbtjl.factory.protocol;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.data.DataMessage;

public class BtMessageControlFactory
{
	public static BitTorrentMessage build(MsgType type)
	   {
		   DataMessage message = new DataMessage();
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
}