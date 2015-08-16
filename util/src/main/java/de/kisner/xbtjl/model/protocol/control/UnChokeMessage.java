package de.kisner.xbtjl.model.protocol.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class UnChokeMessage extends AbstractControlMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(UnChokeMessage.class);
	
	public UnChokeMessage()
	{
		this.setID(1);
	}
}