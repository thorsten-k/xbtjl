package de.kisner.xbtjl.model.xml.peer;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.AbstractXmlBittorrentTest;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlInfo extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlInfo.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Info.class);}
    
    @Test
    public void xmlTest() throws FileNotFoundException
    {
    	Info actual = create();
    	Info expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Info.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Info create()
    {
    	Info xml = new Info();
    	xml.setChoked(true);
    	xml.setChoking(true);
    	xml.setConnected(true);
    	xml.setInterested(true);
    	xml.setInteresting(true);
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlInfo.initFiles();	
		TestXmlInfo test = new TestXmlInfo();
		test.save();
    }
}