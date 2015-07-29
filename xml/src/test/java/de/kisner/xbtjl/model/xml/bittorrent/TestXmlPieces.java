package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Pieces;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlPieces extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlPieces.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"pieces.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Pieces actual = create(true);
    	Pieces expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Pieces.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Pieces create(boolean withChilds)
    {
    	Pieces xml = new Pieces();
    	xml.setPieceLength(12);
    	
    	if(withChilds)
    	{
    		xml.getPiece().add(TestXmlPiece.create(false));
    		xml.getPiece().add(TestXmlPiece.create(false));
    		xml.setBitfield(TestXmlBitfield.create());
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlPieces.initFiles();	
		TestXmlPieces test = new TestXmlPieces();
		test.save();
    }
}