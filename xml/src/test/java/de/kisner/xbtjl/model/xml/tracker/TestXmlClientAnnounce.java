package de.kisner.xbtjl.model.xml.tracker;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlClientAnnounce extends AbstractXmlTrackerTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlClientAnnounce.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, ClientAnnounce.class);}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	ClientAnnounce actual = create(true);
    	ClientAnnounce expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), ClientAnnounce.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static ClientAnnounce create(boolean withChilds)
    {
    	ClientAnnounce xml = new ClientAnnounce();
    	
    	if(withChilds)
    	{
    		xml.setComplete(1);
    		xml.setIncomplete(2);
    		xml.setInterval(12);
    		xml.setMinInterval(123);
    		xml.setPrivate(9);
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlClientAnnounce.initFiles();	
		TestXmlClientAnnounce test = new TestXmlClientAnnounce();
		test.save();
    }
}