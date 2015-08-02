package de.kisner.xbtjl.controller.processor;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Bitfield;

public class BitfieldProcessor
{
	final static Logger logger = LoggerFactory.getLogger(BitfieldProcessor.class);
	
	public static synchronized void set(Bitfield bitfield, int index, boolean value)
	{
		synchronized(bitfield)
		{
			char[] a = bitfield.getValue().toCharArray();
			if(value){a[index]='1';}
			else{a[index]='0';}
			bitfield.setValue(new String(a));
		}
	}
	
	public static synchronized boolean isSet(Bitfield bitfield, int index)
	{
		synchronized(bitfield)
		{
			char[] a = bitfield.getValue().toCharArray();
			if(a[index]=='1'){return true;}
			else{return false;}
		}
	}
	
	public static synchronized BitSet toBitSet(Bitfield bitfield)
	{
		BitSet bitSet = new BitSet();
		synchronized(bitfield)
		{
			char[] a = bitfield.getValue().toCharArray();
			for(int i=0;i<a.length;i++)
			{
				if(a[i]=='1'){bitSet.set(i);}
			}
		}
		return bitSet;
	} 
	
}
