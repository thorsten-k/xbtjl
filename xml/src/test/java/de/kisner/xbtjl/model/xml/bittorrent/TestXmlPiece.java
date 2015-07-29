package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlPiece extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlPiece.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Piece.class);}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Piece actual = create(true);
    	Piece expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Piece.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Piece create(boolean withChilds)
    {
    	Piece xml = new Piece();
    	xml.setIndex(123);
    	xml.setLength(123);
    	
    	if(withChilds)
    	{
    		xml.setHash(TestXmlHash.create());
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();
			
		TestXmlPiece.initFiles();	
		TestXmlPiece test = new TestXmlPiece();
		test.save();
    }
}