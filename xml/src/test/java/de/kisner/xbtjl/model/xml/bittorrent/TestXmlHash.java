package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Hash;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlHash extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlHash.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"hash.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Hash actual = create();
    	Hash expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Hash.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Hash create()
    {
    	Hash xml = new Hash();
    	xml.setValue("myHash");
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlHash.initFiles();	
		TestXmlHash test = new TestXmlHash();
		test.save();
    }
}