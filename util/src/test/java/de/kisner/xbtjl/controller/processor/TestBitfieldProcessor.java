package de.kisner.xbtjl.controller.processor;

import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlBitfieldFactory;
import de.kisner.xbtjl.model.xml.torrent.Bitfield;
import de.kisner.xbtjl.test.AbstractUtilTest;


public class TestBitfieldProcessor extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestBitfieldProcessor.class);
	
    @Test
    public void testSet() throws XbtjlException 
    {
    	Bitfield actual = XmlBitfieldFactory.create("0001101");
    	
    	BitfieldProcessor.set(actual, 0, true);
    	Assert.assertEquals("1001101", actual.getValue());
    	
    	BitfieldProcessor.set(actual, 2, true);
    	Assert.assertEquals("1011101", actual.getValue());
    	
    	BitfieldProcessor.set(actual, 6, false);
    	Assert.assertEquals("1011100", actual.getValue());
    }
    
    @Test
    public void isSet() throws XbtjlException 
    {
    	Bitfield actual = XmlBitfieldFactory.create("0001101");
    	
    	Assert.assertEquals(false, BitfieldProcessor.isSet(actual, 0));
    	Assert.assertEquals(false, BitfieldProcessor.isSet(actual, 1));
    	Assert.assertEquals(false, BitfieldProcessor.isSet(actual, 2));
    	Assert.assertEquals(true, BitfieldProcessor.isSet(actual, 3));
    	Assert.assertEquals(true, BitfieldProcessor.isSet(actual, 4));
    	Assert.assertEquals(false, BitfieldProcessor.isSet(actual, 5));
    	Assert.assertEquals(true, BitfieldProcessor.isSet(actual, 6));
    }
    
    @Test
    public void toBitSet() throws XbtjlException 
    {
    	Bitfield expected = XmlBitfieldFactory.create("0001101");
    	
    	BitSet actual = BitfieldProcessor.toBitSet(expected);
    	for(int i=0;i<expected.getValue().length();i++)
    	{
    		Assert.assertEquals(BitfieldProcessor.isSet(expected, i),actual.get(i));
    	}
    }
}