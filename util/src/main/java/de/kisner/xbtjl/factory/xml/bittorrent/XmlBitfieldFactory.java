package de.kisner.xbtjl.factory.xml.bittorrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.controller.processor.BitfieldProcessor;
import de.kisner.xbtjl.model.xml.bittorrent.Bitfield;
import net.sf.exlp.util.io.ByteUtil;

public class XmlBitfieldFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlBitfieldFactory.class);
	
	public static synchronized Bitfield create(byte[] bitfield)
	{	
		boolean[] b = ByteUtil.toBooleanArray(bitfield);
		Bitfield xml = XmlBitfieldFactory.create(b.length);
		
		for(int i = 0; i < b.length; i++)
        {
            BitfieldProcessor.set(xml, i,b[i]);
        }	
		return xml;
	}
	
	public static Bitfield create(int size)
	{	
		//TODO use StringUtils.repeat
		Bitfield xml = new Bitfield();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<size;i++){sb.append("0");}
		xml.setValue(sb.toString());	
		return xml;
	}
	
	public static Bitfield create(String value)
	{	
		Bitfield xml = new Bitfield();
		xml.setValue(value);	
		return xml;
	}
}