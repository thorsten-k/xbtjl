package de.kisner.xbtjl.model.protocol.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class NotInterestedMessage extends AbstractControlMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(NotInterestedMessage.class);
	
	public NotInterestedMessage()
	{
		this.setId(3);
		this.setType(MsgType.NOT_INTERESTED);
		this.setLength(new byte[] {0, 0, 0, 1});
	}
}