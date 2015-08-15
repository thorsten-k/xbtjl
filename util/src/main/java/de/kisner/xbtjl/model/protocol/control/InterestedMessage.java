package de.kisner.xbtjl.model.protocol.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class InterestedMessage extends ControlMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(InterestedMessage.class);
	
	public InterestedMessage()
	{
		this.setType(MsgType.INTERESTED);
		this.setLength(new byte[] {0, 0, 0, 1});
		this.setID(2);
	}
}