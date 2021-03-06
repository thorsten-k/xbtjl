package de.kisner.xbtjl.util.comparator.xml;

import java.util.Comparator;

import de.kisner.xbtjl.model.xml.peer.Peer;

public class RateDownloadComparator implements Comparator<Peer>
{
    public int compare(Peer a, Peer b)
    {
        if (a.getStatistic().getRateDownload() > b.getStatistic().getRateDownload())
        {
            return -1;
        }
        else if (a.getStatistic().getRateDownload() < b.getStatistic().getRateDownload())
        {
            return 1;
        }
        else
        {
        	return 0;
        }
    }
}