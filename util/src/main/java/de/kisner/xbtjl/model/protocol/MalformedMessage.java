package de.kisner.xbtjl.model.protocol;

import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;

public class MalformedMessage implements BitTorrentMessage
{
	private String error;
	
    public MalformedMessage(String error)
    {
        super();
        this.error=error;
    }

    @Override public byte[] build()
    {
    	return new byte[0];
    }

    public String toString()
    {
    	StringBuffer sb = new StringBuffer();
    	sb.append("error: "+error);
        return sb.toString();
    }
}