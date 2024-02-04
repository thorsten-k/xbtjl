package de.kisner.xbtjl.model.xml.tracker;

import java.io.FileNotFoundException;

import org.exlp.util.jx.JaxbUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlTracker extends AbstractXmlTrackerTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTracker.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Tracker.class);}
    
    @Test
    public void xmlTest() throws FileNotFoundException
    {
    	Tracker actual = create(true);
    	Tracker expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Tracker.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Tracker create(boolean withChilds)
    {
    	Tracker xml = new Tracker();
    	xml.setUrl("myAnnounce");
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlTracker.initFiles();	
		TestXmlTracker test = new TestXmlTracker();
		test.save();
    }
}