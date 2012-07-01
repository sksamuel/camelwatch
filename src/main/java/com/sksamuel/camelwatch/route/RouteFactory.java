package com.sksamuel.camelwatch.route;

import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sksamuel.camelwatch.MBeanUtils;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:44:41
 * 
 */
public class RouteFactory {

	private static final Logger	logger	= LoggerFactory.getLogger(RouteFactory.class);

	public Route buildRoute(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws Exception {

		MBeanAttributeInfo[] attributes = info.getAttributes();
		Route route = new Route();
		MBeanUtils.populateAttributesOnFields(conn, instance, attributes, route);
		return route;
	}
}
