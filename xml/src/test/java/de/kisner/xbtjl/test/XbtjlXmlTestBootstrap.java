package de.kisner.xbtjl.test;

import org.exlp.util.io.log.LoggerInit;
import org.exlp.util.jx.JaxbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.XbtjlNsPrefixMapper;

public class XbtjlXmlTestBootstrap
{
	final static Logger logger = LoggerFactory.getLogger(XbtjlXmlTestBootstrap.class);
		
	public static void init()
	{
		LoggerInit.instance().path("xbtjl/config").init();
		JaxbUtil.setNsPrefixMapper(new XbtjlNsPrefixMapper());
	}
}