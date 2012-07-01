package com.sksamuel.camelwatch;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface ConsumerOperations {

	void setStatisticsEnabled(boolean enabled);

	void start();

	void stop();

	void reset();

	void remove();

	void shutdown();

	void resume();

	void suspend();
}
