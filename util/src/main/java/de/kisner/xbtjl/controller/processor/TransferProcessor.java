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
		xml.setRateDownload(xml.getRateDownload()+length);
		xml.setRateDownload(xml.getRateDownload()+length);
	}
	
	public static void addUploaded(Peer xml, int length){addUploaded(xml.getStatistic(), length);}
	public static void addUploaded(Statistic xml, int length)
	{
		xml.setRateUpload(xml.getRateUpload()+length);
		xml.setRateUpload(0d+xml.getBytesUploaded()+length);
	}
}
