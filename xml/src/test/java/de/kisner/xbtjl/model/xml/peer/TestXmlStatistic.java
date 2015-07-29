package de.kisner.xbtjl.model.xml.peer;

import java.io.File;
import java.io.FileNotFoundException;

import net.sf.exlp.util.xml.JaxbUtil;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.bittorrent.AbstractXmlBittorrentTest;
import de.kisner.xbtjl.model.xml.peer.Statistic;
import de.kisner.xbtjl.test.JbtlXmlTstBootstrap;

public class TestXmlStatistic extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlStatistic.class);
	
	@BeforeClass
	public static void initFiles()
	{
		fXml = new File(rootDir,"statistic.xml");
	}
    
    @Test
    public void xmlTest() throws FileNotFoundException
    {
    	Statistic actual = create();
    	Statistic expected = JaxbUtil.loadJAXB(fXml.getAbsolutePath(), Statistic.class);
    	assertJaxbEquals(expected, actual);
    }
    
    public static Statistic create()
    {
    	Statistic xml = new Statistic();
    	xml.setSumDl(1);
    	xml.setSumUl(2);
    	xml.setRateDl(2.3);
    	xml.setRateUl(4.3);
    	xml.setLeft(3);
    	return xml;
    }
    
    public void save() {save(create(),fXml);}
	
	public static void main(String[] args)
    {
		JbtlXmlTstBootstrap.init();
			
		TestXmlStatistic.initFiles();	
		TestXmlStatistic test = new TestXmlStatistic();
		test.save();
    }
}