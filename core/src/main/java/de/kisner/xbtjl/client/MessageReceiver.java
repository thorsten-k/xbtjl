package de.kisner.xbtjl.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.factory.protocol.BtMessageHandshakeFactory;
import de.kisner.xbtjl.factory.protocol.BtPeerMessageFactory;
import de.kisner.xbtjl.interfaces.listener.InboundListener;
import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.model.protocol.MalformedMessage;
import de.kisner.xbtjl.model.xml.peer.Peer;

public class MessageReceiver extends Thread
{
	final static Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
	
    private boolean threadActive;
    private boolean handshakePerformed;
    
    private InputStream is;
    private List<InboundListener> listeners;

    public MessageReceiver(Peer remotePeer, InputStream is) throws IOException
    {
    	logger.debug("Starting for remote "+remotePeer.getPeerId());
    	this.is = is;
        threadActive = true;
        handshakePerformed = false;
        listeners = new ArrayList<InboundListener>();
    }

    public void run()
    {
        BitTorrentMessage message;
        while (threadActive)
        {
            try
            {
                if (!handshakePerformed)
                {
                	message = BtMessageHandshakeFactory.build(is);
                	if(message==null){logger.warn("Should be a HandshakeMessage, but null");}
                }
                else
                {
                	message = BtPeerMessageFactory.build(is);
                	if(message==null){logger.warn("Should be a PeerMessage, but null");}
                }
            }
            catch (IOException e) {message = new MalformedMessage(e.getMessage());}
            catch (Exception e) {message = new MalformedMessage(e.getMessage());}

            if(!this.handshakePerformed){handshakePerformed = true;}
            
            for (InboundListener listener : listeners)
            {
                listener.messageReceived(message);
            }
            
            if(message instanceof MalformedMessage)
            {
            	logger.warn("Stopping "+this.getClass().getSimpleName()+" because "+message.toString());
            	return;
            }
        }
        IOUtils.closeQuietly(is);
    }

    public void addInboundListener(InboundListener listener) {listeners.add(listener);}
    public void removeInboundListener(InboundListener listener) {listeners.remove(listener);}

    public void shutdown(){this.threadActive = false;}
}