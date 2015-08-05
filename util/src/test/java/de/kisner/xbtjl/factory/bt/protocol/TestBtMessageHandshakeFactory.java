package de.kisner.xbtjl.factory.bt.protocol;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.test.AbstractUtilTest;

public class TestBtMessageHandshakeFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestBtMessageHandshakeFactory.class);
	
	//https://wiki.theory.org/BitTorrentSpecification#Messages
	
    @Test
    public void test() throws XbtjlException 
    {	
    	byte[] bytes = new byte[]{19};
    	Assert.assertEquals((new Integer(bytes[0])).intValue(), 19);
    }
}