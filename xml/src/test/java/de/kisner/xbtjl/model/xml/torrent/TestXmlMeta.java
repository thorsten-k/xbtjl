package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Meta;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlMeta extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlMeta.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Meta.class);}
    
    @Test
    public void xml() throws FileNotFoundException
    {
    	Meta actual = create(true);
    	Meta expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Meta.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Meta create(boolean withChilds)
    {
    	Meta xml = new Meta();
    	xml.setCreatedBy("myName");
    	xml.setEncoding("myEncoding");
    	xml.setCreated(AbstractXmlBittorrentTest.getDefaultXmlDate());
    	
    	
    	if(withChilds)
    	{
    		xml.setComment(TestXmlComment.create());
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlMeta.initFiles();	
		TestXmlMeta test = new TestXmlMeta();
		test.save();
    }
}