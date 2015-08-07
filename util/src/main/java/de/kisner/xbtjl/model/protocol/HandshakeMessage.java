package de.kisner.xbtjl.model.protocol;

import de.kisner.xbtjl.factory.protocol.BtMessageHandshakeFactory;
import de.kisner.xbtjl.interfaces.protocol.BtMessage;
import de.kisner.xbtjl.interfaces.protocol.BtProtocolMessage.MsgType;

public class HandshakeMessage implements BtMessage
{    
    public HandshakeMessage()
    {
        super();
    }
    
    public MsgType getType() {return null;}

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

    
    @Override public byte[] build()
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