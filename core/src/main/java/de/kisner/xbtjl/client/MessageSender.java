package de.kisner.xbtjl.client;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.listener.OutboundListener;
import de.kisner.xbtjl.interfaces.protocol.BitTorrentMessage;
import de.kisner.xbtjl.model.protocol.control.KeepAliveMessage;

public class MessageSender extends Thread
{
	final static Logger logger = LoggerFactory.getLogger(MessageSender.class);
	
    private boolean threadActive;
    private OutputStream os = null;
    private LinkedBlockingQueue<BitTorrentMessage> outboundQueue;
    
    private List<OutboundListener> listeners;

    public MessageSender(String id, OutputStream os)
    {
        this.os = os;
        threadActive = true;
        		
        outboundQueue = new LinkedBlockingQueue<BitTorrentMessage>();
        listeners = new ArrayList<OutboundListener>();
    }
    
    public void run()
    {
        BitTorrentMessage message = null;
        try
        {
            while (threadActive)
            {
            	if(os==null)
            	{
            		fireConnectionClosed();
            		break;
            	}

            	message = outboundQueue.poll(2, TimeUnit.MINUTES);
                if(message != null)
                {
                	logger.info("Sending "+message.getClass().getSimpleName());
                    os.write(message.build());
                    message = null;
                }
                else if(threadActive)
                {
                    os.write(new KeepAliveMessage().build());
                    this.fireKeepAliveSent();
                }
            }
        }
        catch (InterruptedException ie) {}
        catch(IOException ioe){this.fireConnectionClosed();}
        catch(Exception e){this.fireConnectionClosed();}

        outboundQueue.clear();
        outboundQueue = null;
        try
        {
            this.os.close();
            this.os = null;
            this.notify();
        }
        catch(Exception e){}
    }
    
    public void shutdown(){threadActive=false;}

    public void addOutboundListener(OutboundListener listener){listeners.add(listener);}
    public void removeOutboundListener(OutboundListener listener){listeners.remove(listener);}

    public synchronized void addMessageToQueue(BitTorrentMessage m) {if(outboundQueue!=null){outboundQueue.add(m);}}
    
    protected void fireConnectionClosed()
    {
        for (OutboundListener listener : listeners)
        {
            listener.connectionClosed();
        }
    }

    protected void fireKeepAliveSent()
    {
        for (OutboundListener listener : listeners)
        {
            listener.keepAliveSent();
        }
    }
}