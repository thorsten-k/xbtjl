package de.kisner.xbtjl.controller.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.model.xml.peer.Statistic;

public class TransferProcessor
{
	final static Logger logger = LoggerFactory.getLogger(TransferProcessor.class);
	
	public static void addDownloaded(Peer xml, int length){addDownloaded(xml.getStatistic(), length);}
	public static void addDownloaded(Statistic xml, int length)
	{
		xml.setRateDl(xml.getRateDl()+length);
		xml.setSumDl(xml.getSumDl()+length);
	}
	
	public static void addUploaded(Peer xml, int length){addUploaded(xml.getStatistic(), length);}
	public static void addUploaded(Statistic xml, int length)
	{
		xml.setRateUl(xml.getRateUl()+length);
		xml.setSumUl(xml.getSumUl()+length);
	}
}
