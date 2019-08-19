package de.kisner.xbtjl.model.xml.peer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.TestXmlPieces;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlPeer extends AbstractXmlPeerTest<Peer>
{
	final static Logger logger = LoggerFactory.getLogger(Info.class);
	
	public TestXmlPeer(){super(Peer.class);}
	public static Peer create(boolean withChildren){return (new TestXmlPeer()).build(withChildren);}
    
    public Peer build(boolean withChilds)
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
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlPeer test = new TestXmlPeer();
		test.saveReferenceXml();
    }
}