package de.kisner.xbtjl.factory.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Comment;

public class XmlCommentFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlCommentFactory.class);
	
	public static Comment build(String comment)
	{
		Comment xml = new Comment();
		xml.setValue(comment);
		return xml;
	}
}