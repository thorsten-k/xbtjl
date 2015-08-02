package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Comment;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlComment extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlComment.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Comment.class);}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Comment actual = create();
    	Comment expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Comment.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Comment create()
    {
    	Comment xml = new Comment();
    	xml.setValue("myComment");
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlComment.initFiles();	
		TestXmlComment test = new TestXmlComment();
		test.save();
    }
}