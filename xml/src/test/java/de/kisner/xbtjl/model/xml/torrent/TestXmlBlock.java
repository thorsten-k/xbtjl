package de.kisner.xbtjl.model.xml.torrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlBlock extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlBlock.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Block.class);}
    
    @Test
    public void xml() throws FileNotFoundException
    {
    	Block actual = create(true);
    	Block expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Block.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Block create(boolean withChilds)
    {
    	Block xml = new Block();
    	xml.setFile(1);
    	xml.setOffset(3);
    	
    	if(withChilds)
    	{
    		xml.setData(TestXmlData.create());
    	}
    	
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlBlock.initFiles();	
		TestXmlBlock test = new TestXmlBlock();
		test.save();
    }
}