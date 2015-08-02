package de.kisner.xbtjl.controller.processor.bencode;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.exception.XbtjlException;
import de.kisner.xbtjl.model.xml.bittorrent.Torrent;
import de.kisner.xbtjl.test.AbstractUtilTest;
import de.kisner.xbtjl.test.XbtjlUtilTestBootstrap;
import de.kisner.xbtjl.util.XmlDebugger;

public class TestBencodeTorrentProcessor extends AbstractUtilTest
{
	final static Logger logger = LoggerFactory.getLogger(TestBencodeTorrentProcessor.class);
	    
    public Torrent jbencode(boolean debug,File f) throws XbtjlException, IOException
    {
    	BencodeTorrentProcessor tp = new BencodeTorrentProcessor();
    	Torrent xml = tp.olson(f);
    	
    	if(debug){XmlDebugger.info(xml,false);}
    	
    	return xml;
    }
	
	public static void main(String[] args) throws XbtjlException, IOException
    {
		XbtjlUtilTestBootstrap.init();
			
		File f = new File("/Users/thorsten/Dropbox/dev/xbtjl/torrent/LibreOffice_4.3.7_MacOS_x86-64_sdk.dmg.torrent");
		
		TestBencodeTorrentProcessor test = new TestBencodeTorrentProcessor();
		test.jbencode(true,f);
		
    }
}