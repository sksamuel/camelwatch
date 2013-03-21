package org.camelwatch.api.consumer;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:19:17
 * 
 */
public class ConsumerOperationsJmxImpl implements ConsumerOperations {

	private final ObjectInstance		instance;
	private final MBeanServerConnection	conn;

	public ConsumerOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String consumerId,
			MBeanInfo info) {
		this.conn = conn;
		this.instance = instance;
	}

	@Override
	public void setInitialDelay(long initialDelay) {
	}

	@Override
	public Object start() throws Exception {
		Object result = conn.invoke(instance.getObjectName(), "start", new Object[0], new String[0]);
		return result;
	}

	@Override
	public Object stop() throws Exception {
		Object result = conn.invoke(instance.getObjectName(), "stop", new Object[0], new String[0]);
		return result;
	}

	@Override
	public Object resume() throws Exception {
		Object result = conn.invoke(instance.getObjectName(), "resume", new Object[0], new String[0]);
		return result;
	}

	@Override
	public Object suspend() throws Exception {
		Object result = conn.invoke(instance.getObjectName(), "suspend", new Object[0], new String[0]);
		return result;
	}

}
