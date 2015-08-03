package de.kisner.xbtjl.factory.bt.protocol;

import de.kisner.xbtjl.interfaces.protocol.BtPeerProtocol.MsgType;

public class BtMessageTypeFactory
{
    public static int toId(MsgType type)
    {
    	int id = type.ordinal()-2;
    	if(id<0 || id>9){throw new RuntimeException("id of "+id+" is undefined");}
    	return id;
    }
    
    public static MsgType toEnum(int id)
    {
    	if(id<0 || id>9){throw new RuntimeException("id of "+id+" is undefined");}
    	return MsgType.values()[id+2];
    }
}