package de.kisner.xbtjl.interfaces.listener;

import java.util.EventListener;

import de.kisner.xbtjl.interfaces.protocol.BtMessage;


public interface InboundListener extends EventListener
{
    /**
     * A new message from remote peer has been received
     * @param message Message
     */
    public void messageReceived(BtMessage message);
}
