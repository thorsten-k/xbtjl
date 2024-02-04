package de.kisner.xbtjl.test;

import org.exlp.util.io.log.LoggerInit;
import org.exlp.util.jx.JaxbUtil;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.XbtjlNsPrefixMapper;
import net.sf.ahtutils.test.AbstractAhtUtilsXmlTest;

public abstract class AbstractXmlTest <T extends Object> extends AbstractAhtUtilsXmlTest<T>
{
	final static Logger logger = LoggerFactory.getLogger(AbstractXmlTest.class);
	
	public AbstractXmlTest(){this(null,null);}
	public AbstractXmlTest(Class<T> cXml,String xmlDirSuffix)
	{
		super(cXml,xmlDirSuffix);
	}
	
	@BeforeClass
    public static void initLogger()
	{
		LoggerInit.instance().path("xbtjl/config").init();
    }
	
	@BeforeClass
	public static void initJaxb()
	{
		JaxbUtil.setNsPrefixMapper(new XbtjlNsPrefixMapper());
//		DateUtil.ignoreTimeZone=true;
	}
}