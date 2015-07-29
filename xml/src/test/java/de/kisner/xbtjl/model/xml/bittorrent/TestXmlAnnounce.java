package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Announce;
import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlAnnounce extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlAnnounce.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"announce.xml");
	}
    
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
		JbtlXmlTstBootstrap.init();
			
		TestXmlAnnounce.initFiles();	
		TestXmlAnnounce test = new TestXmlAnnounce();
		test.save();
    }
}