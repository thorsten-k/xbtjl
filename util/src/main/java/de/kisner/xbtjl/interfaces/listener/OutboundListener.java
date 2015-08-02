package de.kisner.xbtjl.interfaces.listener;

import java.util.EventListener;

public interface OutboundListener extends EventListener
{
	/**
	 * Connection to remote peer has been closed
     */
    public void connectionClosed();

    /**
     * Keep-alive message to remote peer has been sent
     */
    public void keepAliveSent();
}