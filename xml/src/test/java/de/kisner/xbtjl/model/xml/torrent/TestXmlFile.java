package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlFile extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlFile.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, de.kisner.xbtjl.model.xml.torrent.File.class);}
    
    @Test
    public void xml() throws FileNotFoundException
    {
    	de.kisner.xbtjl.model.xml.torrent.File actual = create();
    	de.kisner.xbtjl.model.xml.torrent.File expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), de.kisner.xbtjl.model.xml.torrent.File.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static de.kisner.xbtjl.model.xml.torrent.File create()
    {
    	de.kisner.xbtjl.model.xml.torrent.File xml = new de.kisner.xbtjl.model.xml.torrent.File();
    	xml.setValue("myFileName");
    	xml.setLength(1234);
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlFile.initFiles();	
		TestXmlFile test = new TestXmlFile();
		test.save();
    }
}