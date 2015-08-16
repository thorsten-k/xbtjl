package de.kisner.xbtjl.factory.protocol;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.model.protocol.control.ChokeMessage;
import de.kisner.xbtjl.model.protocol.control.AbstractControlMessage;
import de.kisner.xbtjl.model.protocol.control.InterestedMessage;
import de.kisner.xbtjl.model.protocol.control.NotInterestedMessage;
import de.kisner.xbtjl.model.protocol.control.UnChokeMessage;

public class BtMessageControlFactory
{
	public static BitTorrentMessage build(MsgType type)
	{
		AbstractControlMessage message = new AbstractControlMessage();
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
	
	public static BitTorrentMessage choke()
	{
		ChokeMessage msg = new ChokeMessage();
		msg.setType(MsgType.CHOKE);
		msg.setLength(new byte[] {0, 0, 0, 1});
		msg.setID(0);
		return msg;
	}
	
	public static BitTorrentMessage unChoke()
	{
		UnChokeMessage msg = new UnChokeMessage();
		msg.setType(MsgType.UNCHOKE);
		msg.setLength(new byte[] {0, 0, 0, 1});
		msg.setID(1);
		return msg;
	}
	
	public static BitTorrentMessage interested()
	{
		InterestedMessage msg = new InterestedMessage();
		msg.setType(MsgType.INTERESTED);
		msg.setLength(new byte[] {0, 0, 0, 1});
		msg.setID(2);
		return msg;
	}
	
	public static BitTorrentMessage notInterested()
	{
		NotInterestedMessage msg = new NotInterestedMessage();
		msg.setType(MsgType.NOT_INTERESTED);
		msg.setLength(new byte[] {0, 0, 0, 1});
		msg.setID(3);
		return msg;
	}
}