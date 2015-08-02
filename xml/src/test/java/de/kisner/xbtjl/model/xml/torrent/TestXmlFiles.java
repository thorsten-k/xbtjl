package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Files;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlFiles extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlFiles.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Files.class);}
    
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
		XbtjlXmlTestBootstrap.init();
			
		TestXmlFiles.initFiles();	
		TestXmlFiles test = new TestXmlFiles();
		test.save();
    }
}