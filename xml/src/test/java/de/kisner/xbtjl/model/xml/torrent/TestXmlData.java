package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlData extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlData.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Data.class);}
    
    @Test
    public void xml() throws FileNotFoundException
    {
    	Data actual = create();
    	Data expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Data.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Data create()
    {
    	Data xml = new Data();
    	xml.setValue("myData".getBytes());
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlData.initFiles();	
		TestXmlData test = new TestXmlData();
		test.save();
    }
}