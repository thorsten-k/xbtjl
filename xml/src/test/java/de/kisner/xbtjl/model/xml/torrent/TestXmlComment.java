package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlComment extends AbstractXmlBittorrentTest<Comment>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlComment.class);
	
	public TestXmlComment(){super(Comment.class);}
	public static Comment create(boolean withChildren){return (new TestXmlComment()).build(withChildren);}

    public Comment build(boolean withChilds)
    {
    	Comment xml = new Comment();
    	xml.setValue("myComment");
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlBitfield test = new TestXmlBitfield();
		test.saveReferenceXml();
    }
}