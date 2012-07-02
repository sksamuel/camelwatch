package com.sksamuel.camelwatch.endpoint;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface EndpointOperations {

	String browseExchange(int offset) throws Exception;

	String browseMessageBody(int offset) throws Exception;

	String browseMessageAsXml(int offset) throws Exception;

	long queueSize() throws Exception;
}
