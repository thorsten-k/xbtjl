package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlAnnounce extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlAnnounce.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Announce.class);}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Announce actual = create(true);
    	Announce expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Announce.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Announce create(boolean withChilds)
    {
    	Announce xml = new Announce();
    	
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
			
		TestXmlAnnounce.initFiles();	
		TestXmlAnnounce test = new TestXmlAnnounce();
		test.save();
    }
}