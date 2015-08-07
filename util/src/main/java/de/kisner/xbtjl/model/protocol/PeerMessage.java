package de.kisner.xbtjl.model.protocol;

import de.kisner.xbtjl.factory.protocol.BtMessageTypeFactory;
import de.kisner.xbtjl.factory.txt.TxtPeerMessageFactory;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
import net.sf.exlp.util.io.ByteUtil;

public class PeerMessage implements BtProtocolMessage
{
	public PeerMessage()
	{
	
	}
	
    protected MsgType type;
	@Override public MsgType getType(){return this.type;}
	public void setType(MsgType type) {this.type = type;}

    private byte[] length = new byte[4];
    public byte[] getLength() {return this.length;}
    public void setLength(byte[] length) {this.length = length;}

    private byte[] id = new byte[1];
    public byte[] getID() {return this.id;}
    public void setID(int id) {this.id[0] = (byte) id;}

    private byte[] payload;
    public byte[] getPayload() {return this.payload;}
    public void setPayload(byte[] payload) {this.payload = payload;}


    @Override public byte[] build()
    {
        if (BtMessageTypeFactory.toId(type) > 4)
        {
        	return ByteUtil.concat(this.getLength(), this.getID(),this.getPayload());
        }
        else if (BtMessageTypeFactory.toId(type) > 0)
        {
            return ByteUtil.concat(this.getLength(), this.getID());
        }
        else
        {
            return this.getLength();
        }
    }

    public String toString()
    {
        return TxtPeerMessageFactory.build(this);
    }
}