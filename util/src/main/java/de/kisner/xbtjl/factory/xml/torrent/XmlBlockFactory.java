package de.kisner.xbtjl.factory.xml.torrent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.model.xml.torrent.Block;

public class XmlBlockFactory
{
	final static Logger logger = LoggerFactory.getLogger(XmlBlockFactory.class);
			
	public static Map<Integer,Block> toMapFile(List<Block> blocks)
	{
		Map<Integer,Block> map = new HashMap<Integer,Block>();
		for(Block block : blocks) {map.put(block.getFile(),block);}
		return map;
	}
}