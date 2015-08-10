package de.kisner.xbtjl.model.protocol;

import java.nio.ByteBuffer;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;

public class KeepAliveMessage implements BitTorrentMessage
{
    public KeepAliveMessage()
    {
        super();
        length = new byte[] {0, 0, 0, 0};
    }
    
    public MsgType getType() {return null;}

    private byte[] length = new byte[4];
    public byte[] getLength() {return this.length;}
    public void setLength(byte[] length) {this.length = length;}   

    @Override public byte[] build()
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