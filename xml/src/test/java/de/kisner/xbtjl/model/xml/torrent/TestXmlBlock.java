package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlBlock extends AbstractXmlBittorrentTest<Block>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlBlock.class);
	
	public TestXmlBlock(){super(Block.class);}
	public static Block create(boolean withChildren){return (new TestXmlBlock()).build(withChildren);}
    
    public Block build(boolean withChilds)
    {
    	Block xml = new Block();
    	xml.setFile(1);
    	xml.setOffset(3);
    	
    	if(withChilds)
    	{
    		xml.setData(TestXmlData.create(false));
    	}
    	
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlBlock test = new TestXmlBlock();
		test.saveReferenceXml();
    }
}