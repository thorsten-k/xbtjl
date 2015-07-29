package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.TrackerRequest;
import de.kisner.xbtjl.model.xml.peer.TestXmlPeer;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlTrackerRequest extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTrackerRequest.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"trackerRequest.xml");
	}
    
    @Test
    public void xmlTest() throws FileNotFoundException
    {
    	TrackerRequest actual = create(true);
    	TrackerRequest expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), TrackerRequest.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static TrackerRequest create(boolean withChilds)
    {
    	TrackerRequest xml = new TrackerRequest();
    	xml.setNumWant(123);
    	
    	if(withChilds)
    	{
    		xml.setTorrent(TestXmlTorrent.create(false));
    		xml.setPeer(TestXmlPeer.create(false));
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlTrackerRequest.initFiles();	
		TestXmlTrackerRequest test = new TestXmlTrackerRequest();
		test.save();
    }
}