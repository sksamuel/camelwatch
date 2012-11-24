package org.camelwatch.api.consumer;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface ConsumerOperations {

	void setInitialDelay(long initialDelay);

	Object start() throws Exception;

	Object stop() throws Exception;

	Object resume() throws Exception;

	Object suspend() throws Exception;
}
