package de.kisner.xbtjl.interfaces.protocol;

public interface BtProtocolMessage
{
	int getType();
    byte[] build();
}
