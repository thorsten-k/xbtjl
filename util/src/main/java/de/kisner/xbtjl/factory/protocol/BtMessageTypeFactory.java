package de.kisner.xbtjl.factory.protocol;

import de.kisner.xbtjl.exception.XbtjlProtocolException;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;

public class BtMessageTypeFactory
{
    public static int toId(MsgType type)
    {
    	int id = type.ordinal()-2;
 //   	if(id<0 || id>9){throw new RuntimeException("id of "+id+" is undefined");}
    	return id;
    }
    
    public static MsgType toEnum(int id)
    {
//    	if(id<0 || id>9){throw new RuntimeException("id of "+id+" is undefined");}
    	
    	try
    	{
    		return MsgType.values()[id+2];
    	}
    	catch (ArrayIndexOutOfBoundsException e)
    	{
    		throw new RuntimeException("Type with id="+id+" not specified");
    	}
    }
    
    public void verifyProtocolMessageId(int id) throws XbtjlProtocolException
    {
    	if(id<0 || id>9){throw new XbtjlProtocolException("Protocol Message id of "+id+" is undefined");}
    }
}