package de.kisner.xbtjl.model.protocol.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage;

public class RequestMessage extends AbstractDataMessage implements BtProtocolMessage
{
	final static Logger logger = LoggerFactory.getLogger(RequestMessage.class);
	
	/**
	 * +-------------+--------+-------------+--------------+--------------+
	 * | Length: 13  | ID: 6  | Piece Index | Block Offset | Block Length |
	 * +-------------+--------+-------------+--------------+--------------+
	 */
	
	public RequestMessage()
	{
		this.setId(6);
		this.setLength(new byte[] {0, 0, 0, 13});
	}
	
	private int pieceIndex;	
	public int getPieceIndex() {return pieceIndex;}
	public void setPieceIndex(int blockIndex) {this.pieceIndex = blockIndex;}

	private int blockOffset;
	public int getBlockOffset() {return blockOffset;}
	public void setBlockOffset(int blockOffset) {this.blockOffset = blockOffset;}
	
	private int blockLength;
	public int getBlockLength() {return blockLength;}
	public void setBlockLength(int blockLength) {this.blockLength = blockLength;}
}