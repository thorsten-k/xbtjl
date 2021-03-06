package de.kisner.xbtjl.model.protocol.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class BitfieldMessage extends AbstractDataMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(BitfieldMessage.class);
	
	public BitfieldMessage()
	{
		this.setId(5);
	}
}