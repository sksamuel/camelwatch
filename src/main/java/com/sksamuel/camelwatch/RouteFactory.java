package com.sksamuel.camelwatch;

import java.io.IOException;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ReflectionException;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:44:41
 * 
 */
public class RouteFactory {

	public static Route buildRoute(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws InstanceNotFoundException,
			MBeanException, ReflectionException, IOException {
		Route route = new Route();
		route.setName(info.getDescription());
		route.setSize(getSize(instance, conn));
		return route;
	}

	static Long getSize(ObjectInstance instance, MBeanServerConnection conn) throws InstanceNotFoundException, MBeanException,
			ReflectionException, IOException {
		return (Long) conn.invoke(instance.getObjectName(), "queueSize", null, null);
	}
}
