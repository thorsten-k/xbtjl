package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.AnnouceUrl;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlAnnouceUrl extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlAnnouceUrl.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"annouceUrl.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	AnnouceUrl actual = create();
    	AnnouceUrl expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), AnnouceUrl.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static AnnouceUrl create()
    {
    	AnnouceUrl xml = new AnnouceUrl();
    	xml.setValue("myUrl");
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlAnnouceUrl.initFiles();	
		TestXmlAnnouceUrl test = new TestXmlAnnouceUrl();
		test.save();
    }
}