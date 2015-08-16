package de.kisner.xbtjl.processor.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.interfaces.listener.ConnectionListener;

public class SocketConnectionListener extends Thread
{
	final static Logger logger = LoggerFactory.getLogger(SocketConnectionListener.class);
	
    private ServerSocket serverSocket;
    private boolean acceptConnections;
    private List<ConnectionListener> listeners;

    public SocketConnectionListener()
    {        
    	acceptConnections = true;
        listeners = new ArrayList<ConnectionListener>();
    }

    public void run()
    {
        try
        {
            while (true)
            {
                if(acceptConnections)
                {
                    this.fireConnectionAccepted(serverSocket.accept());
                    sleep(1000);
                }
                else
                {
                	synchronized(this)
                    {
                        logger.info("New connections are currently not allowed ... Waiting");
                        this.wait();
                    }
                }
            }
        }
        catch (IOException e) {logger.error("Error in connection listener: "+e.getMessage());}
        catch(InterruptedException ie){}
    }
    
    public boolean connect(int minPort, int maxPort)
    {
        for(int port=minPort; port<=maxPort; port++)
        {
            try
            {
                serverSocket = new ServerSocket(port);
                setDaemon(true);
                start();
                return true;
            }
            catch (IOException ioe) {}
        }
        return false;
    }
    
    public int getConnectedPort() {return serverSocket.getLocalPort();}
    
    public synchronized void allowIncomingConnections(boolean acceptConnections)
    {
        this.acceptConnections = acceptConnections;
        this.notifyAll();
    }

    public void addConListenerInterface(ConnectionListener listener) {listeners.add(listener);}
    public void removeConListenerInterface(ConnectionListener listener) {listeners.remove(listener);}

    protected void fireConnectionAccepted(Socket s)
    {
        for (ConnectionListener listener : listeners)
        {
            listener.connectionAccepted(s);
        }
    }
}