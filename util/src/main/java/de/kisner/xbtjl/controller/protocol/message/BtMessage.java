package de.kisner.xbtjl.controller.protocol.message;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public abstract class BtMessage implements BtProtocolMessage
{
    protected MsgType type;
    public MsgType getType(){return this.type;}
 //   public void setType(MsgType type) {this.type = type;}

	public BtMessage(){}

    public BtMessage(MsgType type)
    {
        this.type = type;
    }

   

    @Override public abstract byte[] build();
}
