package de.kisner.xbtjl.factory.xml.bittorrent;

import org.exlp.util.jx.JaxbUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.txt.TestTxtTrackerRequestFactory;
import de.kisner.xbtjl.factory.txt.TxtTrackerRequestFactory;
import de.kisner.xbtjl.factory.xml.torrent.XmlTrackerRequestFactory;
import de.kisner.xbtjl.model.xml.tracker.TrackerRequest;
import de.kisner.xbtjl.test.AbstractUtilTest;

public class TestXmlTrackerRequestFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTrackerRequestFactory.class);
	
	private TrackerRequest expected;
	
	@Before
	public void init()
	{
		expected = TestTxtTrackerRequestFactory.createTrackerRequest();
	}
	
    @Test
    public void ok() throws XbtjlException 
    {
    	String urlParam = TxtTrackerRequestFactory.create(expected);
    	urlParam = urlParam.substring(urlParam.indexOf('?')+1);
    	TrackerRequest actual = XmlTrackerRequestFactory.create(urlParam);
    	JaxbUtil.debug(expected);
    	logger.debug(urlParam);
    	JaxbUtil.debug(actual);
    	
    	Assert.assertEquals(expected.getTorrent().getHash().getValue(), actual.getTorrent().getHash().getValue());
    	Assert.assertEquals(expected.getPeer().getPeerId(), actual.getPeer().getPeerId());
    	Assert.assertEquals(expected.getPeer().getListeningPort(), actual.getPeer().getListeningPort());
    	Assert.assertEquals(expected.getPeer().getStatistic().getBytesUploaded(), actual.getPeer().getStatistic().getBytesUploaded());
    	Assert.assertEquals(expected.getPeer().getStatistic().getBytesDownloaded(), actual.getPeer().getStatistic().getBytesDownloaded());
    	Assert.assertEquals(expected.getPeer().getStatistic().getLeft(), actual.getPeer().getStatistic().getLeft());
    	Assert.assertEquals(expected.getNumWant(), actual.getNumWant());
    }
}