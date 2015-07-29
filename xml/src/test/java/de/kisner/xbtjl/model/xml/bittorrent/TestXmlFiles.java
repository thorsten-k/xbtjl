package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Files;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlFiles extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlFiles.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"files.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Files actual = create(true);
    	Files expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Files.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Files create(boolean withChilds)
    {
    	Files xml = new Files();
    	if(withChilds)
    	{
    		xml.getFile().add(TestXmlFile.create());
    		xml.getFile().add(TestXmlFile.create());
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlFiles.initFiles();	
		TestXmlFiles test = new TestXmlFiles();
		test.save();
    }
}