package com.sksamuel.camelwatch.endpoint;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:19:17
 * 
 */
public class EndpointOperationsJmxImpl implements EndpointOperations {

	private final MBeanServerConnection	conn;
	private final ObjectInstance		instance;
	private final MBeanInfo			info;

	public EndpointOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String consumerId,
			MBeanInfo info) {
		this.conn = conn;
		this.instance = instance;
		this.info = info;
	}

	@Override
	public long queueSize() throws Exception {
		try {
			Object result = conn.invoke(instance.getObjectName(), "queueSize", new Object[0], new String[0]);
			return (Long) result;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public String browseExchange(int offset) throws Exception {
		Object result = conn.invoke(instance.getObjectName(),
				"browseExchange",
				new Object[] { offset },
				new String[] { "java.lang.Integer" });
		return (String) result;
	}

	@Override
	public String browseMessageBody(int offset) throws Exception {
		Object result = conn.invoke(instance.getObjectName(),
				"browseMessageBody",
				new Object[] { offset },
				new String[] { "java.lang.Integer" });
		return (String) result;
	}

	@Override
	public String browseMessageAsXml(int offset) throws Exception {
		Object result = conn.invoke(instance.getObjectName(),
				"browseMessageAsXml",
				new Object[] { offset },
				new String[] { "java.lang.Integer" });
		return (String) result;
	}

}
