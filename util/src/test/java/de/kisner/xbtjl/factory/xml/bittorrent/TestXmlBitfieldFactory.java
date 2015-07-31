package de.kisner.xbtjl.factory.xml.bittorrent;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlInternalErrorException;
import de.kisner.xbtjl.model.xml.bittorrent.Bitfield;
import de.kisner.xbtjl.test.AbstractUtilTest;

public class TestXmlBitfieldFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlBitfieldFactory.class);
	
    @Test
    public void ok() throws XbtjlInternalErrorException 
    {
    	Random rnd = new Random();
    	for(int i=0;i<10;i++)
    	{
    		int expected = rnd.nextInt(1000);
    		Bitfield actual = XmlBitfieldFactory.create(expected);
    		Assert.assertEquals(expected, actual.getValue().length());
    	} 
    }
}