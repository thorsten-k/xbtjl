package de.kisner.xbtjl.util.comparator.xml;

import java.util.Comparator;

import de.kisner.xbtjl.model.xml.peer.Peer;

public class RateUploadComparator implements Comparator<Peer>
{
    public int compare(Peer a, Peer b)
    {
        if (a.getStatistic().getRateUl() > b.getStatistic().getRateUl())
        {
            return -1;
        }
        else if (a.getStatistic().getRateUl() < b.getStatistic().getRateUl())
        {
            return 1;
        }
        else
        {
        	return 0;
        }
    }
}