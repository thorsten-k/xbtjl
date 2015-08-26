package de.kisner.xbtjl.tracker;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.XbtjlBootstrap;
import de.kisner.xbtjl.tracker.servlet.HelloServlet;

public class JettyServer 
{
	final static Logger logger = LoggerFactory.getLogger(JettyServer.class);
	
	public JettyServer() throws Exception
	{
		Server server = new Server(8080);
 		
		ServletContextHandler ctxServlet = new ServletContextHandler(ServletContextHandler.SESSIONS);
		ctxServlet.setContextPath("/servlet");
		ctxServlet.addServlet(new ServletHolder(new HelloServlet()),"/hello/*");
		
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] {ctxServlet});
		server.setHandler(handlers);

		server.start();
		server.join();
	}
	
	public static void main(String args[]) throws Exception
	{		
		XbtjlBootstrap.init();
		new JettyServer();
	}
}