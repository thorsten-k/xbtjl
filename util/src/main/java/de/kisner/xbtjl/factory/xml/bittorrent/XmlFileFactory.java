package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.File;

public class XmlFileFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlFileFactory.class);
		
	public static File build(String saveAs)
	{
		File xml = new File();
    	xml.setValue(saveAs);
		return xml;
	}
	
	public static File build(String saveAs, long length)
	{
		File xml = build(saveAs);
    	xml.setLength(length);
		return xml;
	}
}
