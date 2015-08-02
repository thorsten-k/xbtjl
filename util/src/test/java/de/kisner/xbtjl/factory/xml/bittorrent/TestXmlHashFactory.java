package de.kisner.xbtjl.factory.xml.bittorrent;

import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.xml.bittorrent.XmlHashFactory;
import de.kisner.xbtjl.model.xml.bittorrent.Hash;
import de.kisner.xbtjl.test.AbstractUtilTest;
import net.sf.exlp.util.io.HashUtil;

public class TestXmlHashFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlHashFactory.class);
	
	private Random rnd;
	
	@Before
	public void init()
	{
		rnd = new Random();	
	}
	
	private Hash createRnd()
	{
		byte[] b = new byte[100];
		rnd.nextBytes(b);
		return  XmlHashFactory.create(Hex.encodeHexString(HashUtil.sha1Byte(b)));
	}
	
    @Test
    public void ok() throws XbtjlException 
    {
    	for(int i=0;i<100;i++)
    	{
	    	Hash expected = createRnd();
	    	String urlHash = XmlHashFactory.toUrl(expected);
	    	Hash actual = XmlHashFactory.createFromUrl(urlHash);
	    	
	    	logger.debug(expected.getValue());
	    	logger.debug(urlHash);
	    	logger.debug(actual.getValue());
	    	
	    	Assert.assertEquals(expected.getValue(), actual.getValue());
    	}
    }
}