package de.kisner.xbtjl.model.xml.tracker;

import java.io.FileNotFoundException;

import org.exlp.util.jx.JaxbUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.peer.TestXmlPeer;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlTrackerResponse extends AbstractXmlTrackerTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTrackerResponse.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, TrackerResponse.class);}
    
    @Test
    public void xmlTest() throws FileNotFoundException
    {
    	TrackerResponse actual = create(true);
    	TrackerResponse expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), TrackerResponse.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static TrackerResponse create(boolean withChilds)
    {
    	TrackerResponse xml = new TrackerResponse();
    	xml.setInterval(123);
    	
    	if(withChilds)
    	{
    		xml.getPeer().add(TestXmlPeer.create(false));
    		xml.getPeer().add(TestXmlPeer.create(false));
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlTrackerResponse.initFiles();	
		TestXmlTrackerResponse test = new TestXmlTrackerResponse();
		test.save();
    }
}