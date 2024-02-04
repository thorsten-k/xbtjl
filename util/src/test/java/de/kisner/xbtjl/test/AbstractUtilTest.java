package de.kisner.xbtjl.test;

import java.io.File;

import org.exlp.util.io.StringUtil;
import org.exlp.util.io.log.LoggerInit;
import org.exlp.util.jx.JaxbUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.XbtjlNsPrefixMapper;

public abstract class AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(AbstractUtilTest.class);
	
	protected static final String tstRsrcDir = "src/test/resources";	
	protected static File fString;
	
	@BeforeClass
	public static void initPrefixMapper()
	{
		JaxbUtil.setNsPrefixMapper(new XbtjlNsPrefixMapper());
	}
	
	@BeforeClass
    public static void initLogger()
	{
		LoggerInit.instance().path("config.xbtjl-util.test").init();
    }
	
	protected void assertTxtFile(File f, String actual)
	{
		String expected = StringUtil.readFile(f);
		Assert.assertEquals(expected, actual);
	}
}