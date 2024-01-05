package de.kisner.xbtjl.model.xml.torrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.tracker.TestXmlTracker;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlTorrent extends AbstractXmlBittorrentTest<Torrent>
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlTorrent.class);
	
	public TestXmlTorrent(){super(Torrent.class);}
	public static Torrent create(boolean withChildren){return (new TestXmlTorrent()).build(withChildren);}
    
    public Torrent build(boolean withChilds)
    {
    	Torrent xml = new Torrent();
    	xml.setTotalLength(123l);
    	
    	if(withChilds)
    	{
    		xml.setTracker(TestXmlTracker.create(false));
    		xml.setHash(TestXmlHash.create(false));
    		xml.setMeta(TestXmlMeta.create(false));
    		xml.setFile(TestXmlFile.create(false));
    		xml.setFiles(TestXmlFiles.create(false));
    		xml.setPieces(TestXmlPieces.create(false));
    	}
    	return xml;
    }
    
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlTorrent test = new TestXmlTorrent();
		test.saveReferenceXml();
    }
}