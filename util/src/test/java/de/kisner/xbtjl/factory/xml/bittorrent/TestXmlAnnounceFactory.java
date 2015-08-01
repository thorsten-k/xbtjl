package de.kisner.xbtjl.factory.xml.bittorrent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.AbstractUtilTest;
import de.kisner.xbtjl.test.XbtjlUtilTestBootstrap;
import net.sf.exlp.exception.ExlpConfigurationException;

public class TestXmlAnnounceFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlAnnounceFactory.class);
	
	private static byte[] bytes;
	
	@BeforeClass
	public static void initFiles() throws IOException
	{
		File fData = new File("src/test/resources/data/bin/announce.data");
		InputStream is = new FileInputStream(fData);
		bytes = IOUtils.toByteArray(is);
        is.close();
	}
    
    @Test
    public void size()
    {
    	Assert.assertEquals("Length differs: ",691, bytes.length);
    }
	
	public static void main(String[] args) throws ExlpConfigurationException, IOException
    {
		XbtjlUtilTestBootstrap.init();
			
		TestXmlAnnounceFactory.initFiles();	
		TestXmlAnnounceFactory test = new TestXmlAnnounceFactory();
		test.size();
    }
}