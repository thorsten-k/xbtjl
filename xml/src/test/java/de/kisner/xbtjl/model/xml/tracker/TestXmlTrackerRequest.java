package de.kisner.xbtjl.model.xml.tracker;

import java.io.FileNotFoundException;

import org.exlp.util.jx.JaxbUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.TestXmlPeer;
import de.kisner.xbtjl.model.xml.torrent.TestXmlTorrent;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlTrackerRequest extends AbstractXmlTrackerTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTrackerRequest.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, TrackerRequest.class);}
    
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
		XbtjlXmlTestBootstrap.init();
			
		TestXmlTrackerRequest.initFiles();	
		TestXmlTrackerRequest test = new TestXmlTrackerRequest();
		test.save();
    }
}