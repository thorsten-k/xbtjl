package de.kisner.xbtjl.model.protocol.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class ChokeMessage extends ControlMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(ChokeMessage.class);
	
	public ChokeMessage()
	{
		this.setType(MsgType.CHOKE);
		this.setLength(new byte[] {0, 0, 0, 1});
		this.setID(0);
	}
}