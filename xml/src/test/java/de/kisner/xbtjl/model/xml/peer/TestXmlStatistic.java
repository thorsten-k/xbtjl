package de.kisner.xbtjl.model.xml.peer;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.AbstractXmlBittorrentTest;
import de.kisner.xbtjl.test.XbtjlXmlTestBootstrap;
import net.sf.exlp.util.xml.JaxbUtil;

public class TestXmlStatistic extends AbstractXmlBittorrentTest
{
	final static Logger logger = LoggerFactory.getLogger(TestXmlStatistic.class);
	
	@BeforeClass public static void initFiles(){setXmlFile(dirSuffix, Statistic.class);}
    
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
		XbtjlXmlTestBootstrap.init();
			
		TestXmlStatistic.initFiles();	
		TestXmlStatistic test = new TestXmlStatistic();
		test.save();
    }
}