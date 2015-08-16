package de.kisner.xbtjl.model.protocol.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class PieceMessage extends AbstractDataMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(PieceMessage.class);
	
	/**
	 * +--------------+--------+-------------+--------------+----------------------------------+
	 * | Length: 9+x  | ID: 7  | Piece Index | Block Offset |             Block Data           |
	 * +--------------+--------+-------------+--------------+----------------------------------+
	 */
	
	public PieceMessage()
	{
		this.setId(7);
	}
	
	private int pieceIndex;	
	public int getPieceIndex() {return pieceIndex;}
	public void setPieceIndex(int blockIndex) {this.pieceIndex = blockIndex;}

	private int blockOffset;
	public int getBlockOffset() {return blockOffset;}
	public void setBlockOffset(int blockOffset) {this.blockOffset = blockOffset;}
	
    private byte[] data;
	public byte[] getData() {return data;}
	public void setData(byte[] data) {this.data = data;}
}