package com.sksamuel.camelwatch.route;

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
	public void remove() {
	}

	@Override
	public void reset() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void setStatisticsEnabled(boolean enabled) {
	}

	@Override
	public void shutdown() {
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
	public void suspend() {
	}

}
