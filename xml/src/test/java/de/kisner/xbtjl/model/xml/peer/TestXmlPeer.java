package de.kisner.xbtjl.model.xml.peer;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.AbstractXmlBittorrentTest;
import de.kisner.xbtjl.model.xml.bittorrent.TestXmlPieces;
import de.kisner.xbtjl.model.xml.peer.Peer;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlPeer extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlPeer.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"peer.xml");
	}
    
    @Test
    public void xmlTest() throws FileNotFoundException
    {
    	Peer actual = create(true);
    	Peer expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Peer.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Peer create(boolean withChilds)
    {
    	Peer xml = new Peer();
    	xml.setPeerId("myId");
    	xml.setListeningIp("127.0.0.1");
    	xml.setListeningPort(123);
    	if(withChilds)
    	{
    		xml.setStatistic(TestXmlStatistic.create());
    		xml.setInfo(TestXmlInfo.create());
    		xml.setPieces(TestXmlPieces.create(false));
    	}
    	return xml;
    }
    
    public void save() {save(create(true),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlPeer.initFiles();	
		TestXmlPeer test = new TestXmlPeer();
		test.save();
    }
}