package de.kisner.xbtjl.model.xml.peer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;

public class TestXmlStatistic extends AbstractXmlPeerTest<Statistic>
{
	final static Logger logger = LoggerFactory.getLogger(Info.class);
	
	public TestXmlStatistic(){super(Statistic.class);}
	public static Statistic create(boolean withChildren){return (new TestXmlStatistic()).build(withChildren);}
    
    public static Statistic create()
    {
    	Statistic xml = new Statistic();
    	xml.setBytesDownloaded(1);
    	xml.setBytesUploaded(2);
    	xml.setRateDownload(2.3);
    	xml.setRateUpload(4.3);
    	xml.setLeft(3);
    	return xml;
    }
	
	public static void main(String[] args)
    {
		XbtjlXmlTestBootstrap.init();	
		TestXmlStatistic test = new TestXmlStatistic();
		test.saveReferenceXml();
    }
}