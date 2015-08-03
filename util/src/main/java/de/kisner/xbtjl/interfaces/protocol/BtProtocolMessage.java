package de.kisner.xbtjl.interfaces.protocol;

import de.kisner.xbtjl.interfaces.protocol.BtPeerProtocol.MsgType;

public interface BtProtocolMessage
{
	MsgType getType2();
    byte[] build();
}
