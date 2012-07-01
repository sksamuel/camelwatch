package com.sksamuel.camelwatch;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:19:17
 * 
 */
public class ConsumerOperationsJmxImpl implements ConsumerOperations {

	public ConsumerOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String consumerId, MBeanInfo info) {
	}

	@Override
	public void setInitialDelay(long initialDelay) {
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void suspend() {
	}

}
