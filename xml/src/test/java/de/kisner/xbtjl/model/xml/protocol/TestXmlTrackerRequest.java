package de.kisner.xbtjl.model.xml.protocol;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.TestXmlPeer;
import de.kisner.xbtjl.model.xml.torrent.TestXmlTorrent;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlTrackerRequest extends AbstractXmlProtocolTest
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