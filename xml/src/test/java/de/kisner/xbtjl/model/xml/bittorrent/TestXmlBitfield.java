package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Bitfield;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlBitfield extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlBitfield.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"bitfield.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Bitfield actual = create();
    	Bitfield expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Bitfield.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Bitfield create()
    {
    	Bitfield xml = new Bitfield();
    	xml.setValue("110111000111");
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlBitfield.initFiles();	
		TestXmlBitfield test = new TestXmlBitfield();
		test.save();
    }
}