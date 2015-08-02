package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Hash;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlHash extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlHash.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Hash.class);}
    
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
		XbtjlXmlTestBootstrap.init();
			
		TestXmlHash.initFiles();	
		TestXmlHash test = new TestXmlHash();
		test.save();
    }
}