package de.kisner.xbtjl.client;

import java.net.InetAddress;

import org.bitlet.weupnp.GatewayDevice;
import org.bitlet.weupnp.GatewayDiscover;
import org.bitlet.weupnp.PortMappingEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.kisner.xbtjl.XbtjlBootstrap;

public class TestUpnp 
{
	final static Logger logger = LoggerFactory.getLogger(TestUpnp.class);
	
	public static void main(String args[]) throws Exception
	{		
		XbtjlBootstrap.init();
		GatewayDiscover discover = new GatewayDiscover();
		logger.info("Looking for Gateway Devices");
		discover.discover();
		
		GatewayDevice d = discover.getValidGateway();
		if (d != null)
		{
		    logger.info("Found gateway device "+d.getModelName()+ " ("+d.getModelDescription()+")");
		    
		    InetAddress localAddress = d.getLocalAddress();
		    logger.info("Using local address: "+localAddress.getHostAddress());
		    String externalIPAddress = d.getExternalIPAddress();
		    logger.info("External address: "+ externalIPAddress);
		    
		    int port = 8188;
		    
		    PortMappingEntry portMapping = new PortMappingEntry();
		    boolean x = d.getSpecificPortMappingEntry(port, "TCP", portMapping);
		    logger.info("Active?"+x);
		    logger.info(portMapping.getEnabled());
		    logger.info(portMapping.getInternalClient());
		    logger.info(portMapping.getPortMappingDescription());
		    logger.info(portMapping.getProtocol());
		    logger.info(portMapping.getRemoteHost());
		    
		    boolean map = d.addPortMapping(port, port,localAddress.getHostAddress(),"TCP","XBTJL");
		    logger.info("Attempting to map port "+port+" success?"+map);	
		}
		else {logger.info("No valid gateway device found.");return;}
	}
}