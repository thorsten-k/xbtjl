package de.kisner.xbtjl;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.exlp.util.io.LoggerInit;

public class XbtjlBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(XbtjlBootstrap.class);
	public final static String xmlConfig = "config.xbtjl-client/xbtjl.xml";
	
	public static Configuration init()
	{
		return init(xmlConfig);
	}
	
	public static Configuration init(String configFile)
	{
		LoggerInit.instance().path("xbtjl/system/io/log").init();
			
		return null;
	}
}