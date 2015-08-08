package de.kisner.xbtjl.interfaces.listener;

import java.util.EventListener;
import java.net.Socket;

public interface ConnectionListener extends EventListener
{
    public void connectionAccepted(Socket s);
}
