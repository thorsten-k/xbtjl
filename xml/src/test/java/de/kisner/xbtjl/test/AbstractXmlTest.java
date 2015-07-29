package de.kisner.xbtjl.test;

import java.io.File;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.XbtjlNsPrefixMapper;
import net.sf.exlp.util.DateUtil;
import net.sf.exlp.util.io.LoggerInit;
import net.sf.exlp.util.xml.JaxbUtil;
import net.sf.exlp.xml.ns.NsPrefixMapperInterface;

public abstract class AbstractXmlTest
{
	final static Logger logger = LoggerFactory.getLogger(AbstractXmlTest.class);
	
	protected static NsPrefixMapperInterface nsPrefixMapper;
		
	@BeforeClass
    public static void initLogger()
	{
		LoggerInit loggerInit = new LoggerInit("log4junit.xml");	
		loggerInit.addAltPath("src/test/resources/config");
		loggerInit.init();
		JaxbUtil.setNsPrefixMapper(new XbtjlNsPrefixMapper());
    }
	
	protected void assertJaxbEquals(Object expected, Object actual)
	{
		Assert.assertEquals(JaxbUtil.toString(expected),JaxbUtil.toString(actual));
	}
	
	protected static XMLGregorianCalendar getXmlDefaultDate()
	{
		return DateUtil.getXmlGc4D(getDefaultDate());
	}
	protected static Date getDefaultDate()
	{
		return DateUtil.getDateFromInt(2011, 11, 11, 11, 11, 11);
	}
	
	protected NsPrefixMapperInterface getPrefixMapper()
	{
		if(nsPrefixMapper==null){nsPrefixMapper = new XbtjlNsPrefixMapper();}
		return nsPrefixMapper;
	}
	
	protected void save(Object xml, File f)
	{
		logger.debug("Saving Reference XML");
		JaxbUtil.info(xml);
    	JaxbUtil.save(f,xml,true);
	}
}