package de.kisner.xbtjl.factory.txt;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
import de.kisner.xbtjl.model.protocol.control.AbstractControlMessage;
import de.kisner.xbtjl.model.protocol.data.AbstractDataMessage;
import net.sf.exlp.util.io.BitUtil;
import net.sf.exlp.util.io.ByteUtil;

public class TxtPeerMessageFactory 
{
	final static Logger logger = LoggerFactory.getLogger(AbstractControlMessage.class);
	
	public static String build(AbstractDataMessage message)
    {
        StringBuffer sb = new StringBuffer();

        int length = ByteUtil.toInt(message.getLength());
        sb.append("<length=" + length + ">");
        if (length > 0)
        {
        	sb.append("<id=" + message.getId() + ">");
            if (length > 1)
            {
                switch(message.getId()+1)
                {
	                case BtProtocolMessage._HAVE:
	                	sb.append("<index=").append(ByteUtil.toInt(message.getPayload())).append(">");
	                    break;
	                case BtProtocolMessage._BITFIELD:
	                	sb.append("<bitfield=").append(BitUtil.toString(message.getPayload())).append(">");
	                    break;
	                case BtProtocolMessage._REQUEST:
	                	sb.append("<index=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),0,4))).append(">");
	                	sb.append("<begin=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),4,8))).append(">");
	                	sb.append("<length=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),8,12))).append(">");
	                    break;
	                case BtProtocolMessage._PIECE:
	                	sb.append("<index=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),0,4))).append(">");
	                	sb.append("<begin=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),4,8))).append(">");
	                	sb.append("<block=").append((message.getPayload().length-8)+"bytes>");
	                    break;
	                case BtProtocolMessage._CANCEL:
	                	sb.append("<index=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),0,4))).append(">");
	                	sb.append("<begin=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),4,8))).append(">");
	                	sb.append("<length=").append(ByteUtil.toInt(Arrays.copyOfRange(message.getPayload(),8,12))).append(">");
	                    break;
	                case BtProtocolMessage._PORT:
                    break;
                }
            }
        }
        return sb.toString();
    }
	
	public static String build(AbstractControlMessage message)
    {
        StringBuffer sb = new StringBuffer();

        int length = ByteUtil.toInt(message.getLength());
        sb.append("<length=" + length + ">");
        if (length > 0)
        {
        	sb.append("<id=" + message.getId() + ">");
            if (length > 1)
            {
                logger.warn("This should not happen");
            }
        }
        return sb.toString();
    }
}