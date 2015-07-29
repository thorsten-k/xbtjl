package de.kisner.xbtjl.test;

import net.sf.exlp.util.io.LoggerInit;
import net.sf.exlp.util.xml.JaxbUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.XbtjlNsPrefixMapper;

public class XbtjlXmlTestBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(XbtjlXmlTestBootstrap.class);
		
	public static void init()
	{
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
		loggerInit.addAltPath("config.xbtjl-xml.test");
		loggerInit.init();
		JaxbUtil.setNsPrefixMapper(new XbtjlNsPrefixMapper());
	}
}