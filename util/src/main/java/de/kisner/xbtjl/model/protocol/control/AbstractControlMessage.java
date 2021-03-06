package de.kisner.xbtjl.model.protocol.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.factory.protocol.BtMessageFactory;
import de.kisner.xbtjl.factory.protocol.BtMessageTypeFactory;
import de.kisner.xbtjl.factory.txt.TxtPeerMessageFactory;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
import net.sf.exlp.util.io.ByteUtil;

public class AbstractControlMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(AbstractControlMessage.class);
	
	public AbstractControlMessage()
	{
	
	}
	
    protected MsgType type;
	@Override public MsgType getType(){return this.type;}
	public void setType(MsgType type) {this.type = type;}

    private byte[] length = new byte[4];
    public byte[] getLength() {return this.length;}
    public void setLength(byte[] length) {this.length = length;}

    protected int id;
    public int getId() {return id;}
    protected void setId(int id){this.id=id;}

    @Override public byte[] build()
    {
        if (BtMessageTypeFactory.toId(type) > 4)
        {
        	logger.warn("This shoud not happen!");
        	return new byte[0];
        }
        else if (BtMessageTypeFactory.toId(type) > 0)
        {
            return ByteUtil.concat(this.getLength(), BtMessageFactory.toId(id));
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