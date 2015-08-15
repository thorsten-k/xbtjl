package de.kisner.xbtjl.factory.protocol;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.exception.XbtjlProtocolException;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;
import de.kisner.xbtjl.test.AbstractUtilTest;

public class TestBtMessageTypeFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestBtMessageTypeFactory.class);
	
	//https://wiki.theory.org/BitTorrentSpecification#Messages
	
    @Test
    public void enum2Id() throws XbtjlException 
    {	
    	Assert.assertEquals(0, BtMessageTypeFactory.toId(MsgType.CHOKE));
    	Assert.assertEquals(1, BtMessageTypeFactory.toId(MsgType.UNCHOKE));
    	Assert.assertEquals(2, BtMessageTypeFactory.toId(MsgType.INTERESTED));
    	Assert.assertEquals(3, BtMessageTypeFactory.toId(MsgType.NOT_INTERESTED));
    	Assert.assertEquals(4, BtMessageTypeFactory.toId(MsgType.HAVE));
    	Assert.assertEquals(5, BtMessageTypeFactory.toId(MsgType.BITFIELD));
    	Assert.assertEquals(6, BtMessageTypeFactory.toId(MsgType.REQUEST));
    	Assert.assertEquals(7, BtMessageTypeFactory.toId(MsgType.PIECE));
    	Assert.assertEquals(8, BtMessageTypeFactory.toId(MsgType.CANCEL));
    	Assert.assertEquals(9, BtMessageTypeFactory.toId(MsgType.PORT));
    }
    
    @Test
    public void enum2Field() throws XbtjlException 
    {	
    	Assert.assertEquals(BtProtocolMessage._CHOKE, BtMessageTypeFactory.toId(MsgType.CHOKE));
/*    	Assert.assertEquals(BtProtocolMessage._UNCHOKE, BtMessageTypeFactory.toId(MsgType.UNCHOKE));
    	Assert.assertEquals(BtProtocolMessage._INTERESTED, BtMessageTypeFactory.toId(MsgType.INTERESTED));
    	Assert.assertEquals(3, BtMessageTypeFactory.toId(MsgType.NOT_INTERESTED));
    	Assert.assertEquals(4, BtMessageTypeFactory.toId(MsgType.HAVE));
    	Assert.assertEquals(5, BtMessageTypeFactory.toId(MsgType.BITFIELD));
    	Assert.assertEquals(6, BtMessageTypeFactory.toId(MsgType.REQUEST));
    	Assert.assertEquals(7, BtMessageTypeFactory.toId(MsgType.PIECE));
    	Assert.assertEquals(8, BtMessageTypeFactory.toId(MsgType.CANCEL));
    	Assert.assertEquals(9, BtMessageTypeFactory.toId(MsgType.PORT));
*/    }
    
    @Test(expected=XbtjlProtocolException.class) @Ignore
    public void enum2IdInvalidKeepAlive() throws XbtjlException 
    {	
    	BtMessageTypeFactory.toId(MsgType.KEEP_ALIVE);
    }
    
    @Test
    public void id2Enum() throws XbtjlException, XbtjlProtocolException 
    {	//https://wiki.theory.org/BitTorrentSpecification#Messages
    	Assert.assertEquals(MsgType.CHOKE, BtMessageTypeFactory.toEnum(0));
    	Assert.assertEquals(MsgType.UNCHOKE, BtMessageTypeFactory.toEnum(1));
    	Assert.assertEquals(MsgType.INTERESTED, BtMessageTypeFactory.toEnum(2));
    	Assert.assertEquals(MsgType.NOT_INTERESTED, BtMessageTypeFactory.toEnum(3));
    	Assert.assertEquals(MsgType.HAVE, BtMessageTypeFactory.toEnum(4));
    	Assert.assertEquals(MsgType.BITFIELD, BtMessageTypeFactory.toEnum(5));
    	Assert.assertEquals(MsgType.REQUEST, BtMessageTypeFactory.toEnum(6));
    	Assert.assertEquals(MsgType.PIECE, BtMessageTypeFactory.toEnum(7));
    	Assert.assertEquals(MsgType.CANCEL, BtMessageTypeFactory.toEnum(8));
    	Assert.assertEquals(MsgType.PORT, BtMessageTypeFactory.toEnum(9));
    }
    
    @Test(expected=XbtjlProtocolException.class) @Ignore
    public void idBelow0() throws XbtjlException, XbtjlProtocolException 
    {	
    	BtMessageTypeFactory.toEnum(-1);
    }
    
    @Test(expected=XbtjlProtocolException.class) @Ignore
    public void idAbove9() throws XbtjlException, XbtjlProtocolException 
    {	
    	BtMessageTypeFactory.toEnum(10);
    }
    
    @Test(expected=XbtjlProtocolException.class) @Ignore
    public void outofRange() throws XbtjlException, XbtjlProtocolException 
    {	
    	BtMessageTypeFactory.toEnum(100);
    }
}