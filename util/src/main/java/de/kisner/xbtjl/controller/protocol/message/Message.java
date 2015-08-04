package de.kisner.xbtjl.controller.protocol.message;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

abstract public class Message implements BtProtocolMessage
{
    protected MsgType type;

    public Message(){}

    public Message(MsgType type)
    {
        this.type = type;
    }

    public MsgType getType(){return this.type;}

    @Override abstract public byte[] build();
}
