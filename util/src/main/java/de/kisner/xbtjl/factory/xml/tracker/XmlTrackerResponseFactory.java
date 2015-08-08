package de.kisner.xbtjl.factory.xml.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.tracker.TrackerResponse;

public class XmlTrackerResponseFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlTrackerResponseFactory.class);
	
	public static TrackerResponse build()
	{
		TrackerResponse xml = new TrackerResponse();
		return xml;
	}
}