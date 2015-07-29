package de.kisner.xbtjl.test;

import net.sf.exlp.util.io.LoggerInit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JbtlXmlTstBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(JbtlXmlTstBootstrap.class);
		
	public static void init()
	{
		LoggerInit loggerInit = new LoggerInit("log4j.xml");	
		loggerInit.addAltPath("config.jbtl-xml.test");
		loggerInit.init();		
	}
}