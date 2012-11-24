package org.camelwatch.api.route;

import java.io.IOException;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ReflectionException;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:10:35
 * 
 */
public class RouteOperationsJmxImpl implements RouteOperations {

	private final MBeanServerConnection	conn;
	private final String			routeId;
	private final MBeanInfo			info;
	private final ObjectInstance		instance;

	public RouteOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String routeId, MBeanInfo info)
			throws InstanceNotFoundException, IntrospectionException, ReflectionException, IOException {
		this.conn = conn;
		this.instance = instance;
		this.routeId = routeId;
		this.info = info;
	}

	@Override
	public String dumpRouteAsXml() throws Exception {
		return (String) conn.invoke(instance.getObjectName(), "dumpRouteAsXml", new Object[0], new String[0]);
	}

	@Override
	public void remove() {
	}

	@Override
	public void reset() {
	}

	@Override
	public void resume() throws Exception {
		conn.invoke(instance.getObjectName(), "resume", new Object[0], new String[0]);
	}

	@Override
	public void setStatisticsEnabled(boolean enabled) {
	}

	@Override
	public void start() throws Exception {
		conn.invoke(instance.getObjectName(), "start", new Object[0], new String[0]);
	}

	@Override
	public void stop() throws Exception {
		conn.invoke(instance.getObjectName(), "stop", new Object[0], new String[0]);
	}

	@Override
	public void suspend() throws Exception {
		conn.invoke(instance.getObjectName(), "suspend", new Object[0], new String[0]);
	}

	@Override
	public void updateRouteFromXml(String xml) throws Exception {
		conn.invoke(instance.getObjectName(),
				"updateRouteFromXml",
				new Object[] { xml },
				new String[] { "java.lang.String" });
	}

}
