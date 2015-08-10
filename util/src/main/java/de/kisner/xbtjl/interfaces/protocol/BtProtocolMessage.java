package de.kisner.xbtjl.interfaces.protocol;

public interface BtProtocolMessage extends BitTorrentMessage
{
	public static final int _KEEP_ALIVE = 0;
	public static final int _CHOKE = 1;
    public static final int _UNCHOKE = 2;
    public static final int _INTERESTED = 3;
    public static final int _NOT_INTERESTED = 4;
    public static final int _HAVE = 5;
    public static final int _BITFIELD = 6;
    public static final int _REQUEST = 7;
    public static final int _PIECE = 8;
    public static final int _CANCEL = 9;
    public static final int _PORT = 10;
    public static final String[] TYPE = {"Keep_Alive", "Choke", "Unchoke","Interested", "Not_Interested", "Have","Bitfield", "Request", "Piece","Cancel", "Port"};
    
    public static enum OtherType {HANDSHAKE,KEEP_ALIVE}
    public static enum MsgType {HANDSHAKE,KEEP_ALIVE,CHOKE,UNCHOKE,INTERESTED,NOT_INTERESTED,HAVE,BITFIELD,REQUEST,PIECE,CANCEL,PORT}
	    
    MsgType getType();
}
