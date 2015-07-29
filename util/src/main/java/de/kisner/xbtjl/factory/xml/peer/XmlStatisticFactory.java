package de.kisner.xbtjl.factory.xml.peer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.Statistic;

public class XmlStatisticFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlStatisticFactory.class);
	
	public static Statistic create()
	{
		Statistic xml = new Statistic();
		
		xml.setRateDl(0);
		xml.setSumDl(0);
		
		xml.setRateUl(0);
		xml.setSumUl(0);
		
		return xml;
	}
}