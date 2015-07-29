package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.AbstractXmlTest;

public abstract class AbstractXmlBittorrentTest extends AbstractXmlTest
{
	final static Logger logger = LoggerFactory.getLogger(AbstractXmlBittorrentTest.class);
	
	protected static final String rootDir = "src/test/resources/data/xml/bittorrent";
	protected static File fXml;
}