package de.kisner.xbtjl.test;

import org.exlp.util.io.log.LoggerInit;
import org.exlp.util.jx.JaxbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.XbtjlNsPrefixMapper;

public class XbtjlUtilTestBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(XbtjlUtilTestBootstrap.class);
		
	public static void init()
	{
		LoggerInit.instance().path("config.xbtjl-util.test").init();
		
		JaxbUtil.setNsPrefixMapper(new XbtjlNsPrefixMapper());
	}
}