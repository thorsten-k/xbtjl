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
		
		xml.setRateDownload(0);
		xml.setRateUpload(0);;
		
		xml.setBytesDownloaded(0);
		xml.setBytesUploaded(0);
		
		return xml;
	}
}