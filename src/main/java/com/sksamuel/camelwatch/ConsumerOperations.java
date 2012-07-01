package com.sksamuel.camelwatch;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface ConsumerOperations {

	void setInitialDelay(long initialDelay);

	void start();

	void stop();

	void resume();

	void suspend();
}
