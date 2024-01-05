package de.kisner.xbtjl.test;

import net.sf.exlp.util.io.LoggerInit;
import net.sf.exlp.util.xml.JaxbUtil;

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