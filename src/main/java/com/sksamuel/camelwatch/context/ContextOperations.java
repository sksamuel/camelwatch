package com.sksamuel.camelwatch.context;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface ContextOperations {

	void createEndpoint(String xml);

	String dumpRoutesAsXml();

	void resume();

	void sendMessage(String msg);

	void setTimeout(int timeout);

	void start();

	void stop();

	void suspend();
}
