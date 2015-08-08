package de.kisner.xbtjl.factory.xml.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.tracker.Tracker;

public class XmlTrackerFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlTrackerFactory.class);
	
	public static Tracker build(String url)
	{
		Tracker xml = new Tracker();
		xml.setAnnounce(url);
		return xml;
	}
}