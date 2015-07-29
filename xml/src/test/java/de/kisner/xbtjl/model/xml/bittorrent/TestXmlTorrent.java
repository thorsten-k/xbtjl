package de.kisner.xbtjl.model.xml.bittorrent;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlTorrent extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTorrent.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"torrent.xml");
	}
    
    @Test
    public void testAclContainer() throws FileNotFoundException
    {
    	Torrent actual = create(true);
    	Torrent expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Torrent.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Torrent create(boolean withChilds)
    {
    	Torrent xml = new Torrent();
    	xml.setTotalLength(123);
    	
    	if(withChilds)
    	{
    		xml.setAnnouceUrl(TestXmlAnnouceUrl.create());
    		xml.setHash(TestXmlHash.create());
    		xml.setMeta(TestXmlMeta.create(false));
    		xml.setFile(TestXmlFile.create());
    		xml.setFiles(TestXmlFiles.create(false));
    		xml.setPieces(TestXmlPieces.create(false));
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlTorrent.initFiles();	
		TestXmlTorrent test = new TestXmlTorrent();
		test.save();
    }
}