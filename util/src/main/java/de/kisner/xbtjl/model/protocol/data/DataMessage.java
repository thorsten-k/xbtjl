package de.kisner.xbtjl.model.protocol.data;

import de.kisner.xbtjl.factory.protocol.BtMessageTypeFactory;
import de.kisner.xbtjl.factory.txt.TxtPeerMessageFactory;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
import de.kisner.xbtjl.model.protocol.control.ControlMessage;
import net.sf.exlp.util.io.ByteUtil;

public class DataMessage extends ControlMessage implements BtProtocolMessage
{
	public DataMessage()
	{
	
	}
	
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