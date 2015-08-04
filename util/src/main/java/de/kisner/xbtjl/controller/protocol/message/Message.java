package de.kisner.xbtjl.controller.protocol.message;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

abstract public class Message implements BtProtocolMessage
{
    protected MsgType type;
    public MsgType getType(){return this.type;}
 //   public void setType(MsgType type) {this.type = type;}

	public Message(){}

    public Message(MsgType type)
    {
        this.type = type;
    }

   

    @Override abstract public byte[] build();
}
