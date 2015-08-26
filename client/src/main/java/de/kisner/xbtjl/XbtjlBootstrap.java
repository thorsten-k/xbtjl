package de.kisner.xbtjl;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.exlp.util.io.LoggerInit;

public class XbtjlBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(XbtjlBootstrap.class);
	public final static String xmlConfig = "config.xbtjl-core.test/xbtjl.xml";
	
	public static Configuration init()
	{
		return init(xmlConfig);
	}
	
	public static Configuration init(String configFile)
	{
		LoggerInit loggerInit = new LoggerInit("log4j.xml");
			loggerInit.addAltPath("config.xbtjl-core.test");
			loggerInit.init();
			
		return null;
	}
}