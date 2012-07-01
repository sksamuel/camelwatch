package com.sksamuel.camelwatch.context;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:19:17
 * 
 */
public class ContextOperationsJmxImpl implements ContextOperations {

	public ContextOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String consumerId, MBeanInfo info) {
	}

	@Override
	public void createEndpoint(String xml) {
	}

	@Override
	public String dumpRoutesAsXml() {
		return null;
	}

	@Override
	public void resume() {
	}

	@Override
	public void sendMessage(String msg) {
	}

	@Override
	public void setTimeout(int timeout) {
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}

	@Override
	public void suspend() {
	}

}
