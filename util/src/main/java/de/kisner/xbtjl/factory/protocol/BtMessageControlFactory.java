package de.kisner.xbtjl.factory.protocol;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.control.ChokeMessage;
import de.kisner.xbtjl.model.protocol.control.ControlMessage;
import de.kisner.xbtjl.model.protocol.control.InterestedMessage;
import de.kisner.xbtjl.model.protocol.control.NotInterestedMessage;
import de.kisner.xbtjl.model.protocol.control.UnChokeMessage;

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
}