package de.kisner.xbtjl.processor.protocol.message;

import de.kisner.xbtjl.controller.protocol.message.Message;
import de.kisner.xbtjl.factory.bt.protocol.BtMessageHandshakeFactory;
import de.kisner.xbtjl.factory.bt.protocol.BtMessageTypeFactory;

public class HandshakeMessage extends Message
{    
    public HandshakeMessage()
    {
        super(BtMessageTypeFactory.toEnum(-1));
    }

    private byte[] length = new byte[1];
	public byte[] getLength(){return length;}
	public void setLength(byte[] length) {this.length = length;}
    
	private String protocol;
    public String getProtocol(){ return protocol;}
    public void setProtocol(String protocol) {this.protocol = protocol;}
    
    private byte[] reserved = new byte[8];
    public byte[] getReserved(){return this.reserved;}
    public void setReserved(byte[] reserved) {this.reserved = reserved;}
    
    private byte[] fileID = new byte[20];
    public byte[] getFileId(){return this.fileID;}
    public void setFileId(byte[] fileID) {this.fileID = fileID;}
    
    private byte[] peerID = new byte[20];
    public byte[] getPeerId(){return this.peerID;}
    public void setPeerId(byte[] peerID) {this.peerID = peerID;}

    
    public byte[] build()
    {
        return BtMessageHandshakeFactory.build(this);
    }
    
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(length);
        sb.append("+").append(protocol);
        sb.append("+").append(this.reserved);
        sb.append("+").append(this.fileID);
        sb.append("+").append(this.peerID);
        return sb.toString();
    }
}