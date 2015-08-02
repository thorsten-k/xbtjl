package de.kisner.xbtjl.factory.xml.peer;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.test.AbstractUtilTest;

public class TestXmlPeerFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlPeerFactory.class);
	
    @Test
    public void id() throws XbtjlException 
    {
    	for(int i=0;i<10;i++)
    	{
    		byte[] bytes = XmlPeerFactory.generateID();
    		Peer peer = XmlPeerFactory.build(bytes);    		
    		Assert.assertArrayEquals(bytes,DatatypeConverter.parseHexBinary(peer.getPeerId()));
    		Assert.assertEquals(Hex.encodeHexString(bytes), DatatypeConverter.printHexBinary(bytes).toLowerCase());
    	} 
    }
}