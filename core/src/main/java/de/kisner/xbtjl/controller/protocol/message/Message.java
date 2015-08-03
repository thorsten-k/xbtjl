package de.kisner.xbtjl.controller.protocol.message;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

abstract public class Message implements BtProtocolMessage
{
	protected MsgType type2;
    protected int type;

    public Message(){}

    public Message(MsgType type2, int type)
    {
    	this.type2=type2;
        this.type = type;
    }

    @Override public MsgType getType2(){return type2;}
}