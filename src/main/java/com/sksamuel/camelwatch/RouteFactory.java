package com.sksamuel.camelwatch;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.management.Attribute;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:44:41
 * 
 */
public class RouteFactory {

	private static final Logger	logger	= LoggerFactory.getLogger(RouteFactory.class);

	public Route buildRoute(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws Exception {

		MBeanOperationInfo[] operations = info.getOperations();
		logger.debug(Arrays.toString(operations));

		MBeanAttributeInfo[] attributes = info.getAttributes();
		logger.debug(Arrays.toString(attributes));

		Route route = new Route();

		List<String> attributeNames = Lists.newArrayList();
		for (MBeanAttributeInfo attribute : attributes) {
			attributeNames.add(attribute.getName());
		}

		List attributeList = conn.getAttributes(instance.getObjectName(), attributeNames.toArray(new String[0]));
		List<Attribute> list = attributeList;

		for (Attribute attribute : list) {

			try {

				Field field = Route.class.getDeclaredField(attribute.getName().substring(0, 1).toLowerCase()
						+ attribute.getName().substring(1));
				field.setAccessible(true);
				field.set(route, attribute.getValue());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return route;
	}
}
