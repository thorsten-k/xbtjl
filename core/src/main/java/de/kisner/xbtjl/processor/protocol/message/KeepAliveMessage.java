package de.kisner.xbtjl.processor.protocol.message;

import java.nio.ByteBuffer;

import de.kisner.xbtjl.controller.protocol.message.BtMessage;

public class KeepAliveMessage extends BtMessage
{
    public KeepAliveMessage()
    {
        super();
        length = new byte[] {0, 0, 0, 0};
    }

    private byte[] length = new byte[4];
    public byte[] getLength() {return this.length;}
    public void setLength(byte[] length) {this.length = length;}   

    public byte[] build()
    {
    	return length;
    }

    public String toString()
    {
    	StringBuffer sb = new StringBuffer();
    	sb.append("<length=").append(ByteBuffer.wrap(length).getInt()).append(">");
        return sb.toString();
    }
}