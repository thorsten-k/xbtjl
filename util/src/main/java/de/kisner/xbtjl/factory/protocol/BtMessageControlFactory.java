package de.kisner.xbtjl.factory.protocol;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.control.ChokeMessage;
import de.kisner.xbtjl.model.protocol.control.ControlMessage;

public class BtMessageControlFactory
{
	public static BitTorrentMessage build(MsgType type)
	   {
			ControlMessage message = new ControlMessage();
		   message.setType(type);
		   
	       switch (BtMessageTypeFactory.toId(type))
	       {
		        case 0:
		        	message.setLength(new byte[] {0, 0, 0, 0});
		            break;
		            
		        case 1: message = new ChokeMessage(); break;
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