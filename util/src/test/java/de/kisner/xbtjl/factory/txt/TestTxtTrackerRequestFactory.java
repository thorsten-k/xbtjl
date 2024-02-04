package de.kisner.xbtjl.factory.txt;

import java.io.File;

import org.exlp.util.jx.JaxbUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.factory.xml.peer.XmlPeerFactory;
import de.kisner.xbtjl.factory.xml.torrent.XmlHashFactory;
import de.kisner.xbtjl.factory.xml.tracker.XmlTrackerFactory;
import de.kisner.xbtjl.model.xml.torrent.Torrent;
import de.kisner.xbtjl.model.xml.tracker.TrackerRequest;
import de.kisner.xbtjl.test.AbstractUtilTest;
import de.kisner.xbtjl.test.XbtjlUtilTestBootstrap;
import net.sf.exlp.util.io.StringIO;

public class TestTxtTrackerRequestFactory extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestTxtTrackerRequestFactory.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fString = new File(tstRsrcDir,"data/txt/annouceUrl.txt");
	}
	
	private TrackerRequest xml;
	
	@Before
	public void init()
	{	
		xml = createTrackerRequest();
	}
	
	public static TrackerRequest createTrackerRequest()
	{		
		Torrent torrent = new Torrent();
		torrent.setTracker(XmlTrackerFactory.build("http://localhost:8080/jbtl"));
		torrent.setHash(XmlHashFactory.create("abcdef"));
		
		TrackerRequest xmlTrackerRequest = new TrackerRequest();
		xmlTrackerRequest.setNumWant(123);
		xmlTrackerRequest.setTorrent(torrent);
		xmlTrackerRequest.setPeer(XmlPeerFactory.create("id-üöä","127.0.0.1",123));
		
		xmlTrackerRequest.getPeer().getStatistic().setBytesDownloaded(1234l);
		xmlTrackerRequest.getPeer().getStatistic().setBytesUploaded(56l);
		xmlTrackerRequest.getPeer().getStatistic().setLeft(78l);
		return xmlTrackerRequest;
	}
	
    @Test
    public void ok() throws XbtjlException 
    {
    	String actual = TxtTrackerRequestFactory.create(xml);
    	assertTxtFile(fString,actual);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutTorrent() throws XbtjlException 
    {
    	xml.setTorrent(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutTracker() throws XbtjlException 
    {
    	xml.getTorrent().setTracker(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutTrackerAnnounce() throws XbtjlException 
    {
    	xml.getTorrent().getTracker().setUrl(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutHash() throws XbtjlException 
    {
    	xml.getTorrent().setHash(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutHashValue() throws XbtjlException 
    {
    	xml.getTorrent().getHash().setValue(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeer() throws XbtjlException 
    {
    	xml.setPeer(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeerPeerId() throws XbtjlException 
    {
    	xml.getPeer().setPeerId(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeerListeningPort() throws XbtjlException 
    {
    	xml.getPeer().setListeningPort(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeerStatistic() throws XbtjlException 
    {
    	xml.getPeer().setStatistic(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeerStatisticSumDl() throws XbtjlException 
    {
    	xml.getPeer().getStatistic().setBytesDownloaded(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeerStatisticSumUl() throws XbtjlException 
    {
    	xml.getPeer().getStatistic().setBytesUploaded(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    @Test(expected=XbtjlException.class)
    public void withoutPeerStatisticLeft() throws XbtjlException 
    {
    	xml.getPeer().getStatistic().setLeft(null);
    	TxtTrackerRequestFactory.create(xml);
    }
    
    public void save() throws XbtjlException
    {
    	JaxbUtil.info(xml);
    	String content = TxtTrackerRequestFactory.create(xml);
    	logger.debug(content);
    	StringIO.writeTxt(fString, content);
    }
	
	public static void main(String[] args) throws XbtjlException
    {
		XbtjlUtilTestBootstrap.init();
			
		TestTxtTrackerRequestFactory.initFiles();
		TestTxtTrackerRequestFactory test = new TestTxtTrackerRequestFactory();
		test.init();
		test.save();
    }
}