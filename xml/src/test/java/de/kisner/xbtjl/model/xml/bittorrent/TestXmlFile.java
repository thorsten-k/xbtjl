package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlFile extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlFile.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"file.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	de.kisner.xbtjl.model.xml.bittorrent.File actual = create();
    	de.kisner.xbtjl.model.xml.bittorrent.File expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), de.kisner.xbtjl.model.xml.bittorrent.File.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static de.kisner.xbtjl.model.xml.bittorrent.File create()
    {
    	de.kisner.xbtjl.model.xml.bittorrent.File xml = new de.kisner.xbtjl.model.xml.bittorrent.File();
    	xml.setValue("myFileName");
    	xml.setLength(1234);
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlFile.initFiles();	
		TestXmlFile test = new TestXmlFile();
		test.save();
    }
}