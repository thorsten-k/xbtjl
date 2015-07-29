package de.kisner.xbtjl.model.xml.peer;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.AbstractXmlTest;

public abstract class AbstractXmlPeerTest extends AbstractXmlTest
{
	final static Logger logger = LoggerFactory.getLogger(AbstractXmlPeerTest.class);
	
	protected static final String rootDir = "src/test/resources/data/xml/peer";
	protected static File fXml;
}