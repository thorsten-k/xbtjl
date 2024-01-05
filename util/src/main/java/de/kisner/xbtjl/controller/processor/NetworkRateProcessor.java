package de.kisner.xbtjl.controller.processor;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.Peer;

public class NetworkRateProcessor
{
	final static Logger logger = LoggerFactory.getLogger(NetworkRateProcessor.class);
	
	public static double calculateDownloadRate(Collection<Peer> peers)
	{
		try
        {
            double rate = 0;
            for (Peer p : peers)
            {
                if (p.getStatistic().getRateDownload()>0)
                {
                    rate = rate + p.getStatistic().getRateDownload();
                    p.getStatistic().setRateDownload(0d);
                }
            }
            return rate / (1024*10);
        }
        catch (Exception e) { return 0;}
	}
	
	public static double calculatUploadRate(Collection<Peer> peers)
	{
		try
        {
            double rate = 0;
            for (Peer p : peers)
            {
                if (p.getStatistic().getRateUpload()>0)
                {
                    rate = rate + p.getStatistic().getRateUpload();
                    p.getStatistic().setRateUpload(0d);
                }
            }
            return rate / (1024*10);
        }
        catch (Exception e) {return 0; }
	}
	
}