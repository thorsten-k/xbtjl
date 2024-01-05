package de.kisner.xbtjl.factory.xml.peer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.Statistic;

public class XmlStatisticFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlStatisticFactory.class);
	
	public static Statistic build()
	{
		Statistic xml = new Statistic();
		
		xml.setRateDownload(0d);
		xml.setRateUpload(0d);;
		
		xml.setBytesDownloaded(0l);
		xml.setBytesUploaded(0l);
		
		return xml;
	}
}