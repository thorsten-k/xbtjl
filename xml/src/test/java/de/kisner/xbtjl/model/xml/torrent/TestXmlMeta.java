package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlMeta extends AbstractXmlBittorrentTest<Meta>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlMeta.class);
	
	public TestXmlMeta(){super(Meta.class);}
	public static Meta create(boolean withChildren){return (new TestXmlMeta()).build(withChildren);}
    
    public Meta build(boolean withChilds)
    {
    	Meta xml = new Meta();
    	xml.setCreatedBy("myName");
    	xml.setEncoding("myEncoding");
    	xml.setCreated(AbstractXmlBittorrentTest.getDefaultXmlDate());
    	
    	if(withChilds)
    	{
    		xml.setComment(TestXmlComment.create(false));
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlMeta test = new TestXmlMeta();
		test.saveReferenceXml();
    }
}