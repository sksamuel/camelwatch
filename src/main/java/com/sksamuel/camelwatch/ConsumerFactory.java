package com.sksamuel.camelwatch;

import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:44:41
 * 
 */
public class ConsumerFactory {

	private static final Logger	logger	= LoggerFactory.getLogger(ConsumerFactory.class);

	public Consumer buildConsumer(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws Exception {

		MBeanAttributeInfo[] attributes = info.getAttributes();
		Consumer c = new Consumer();
		MBeanUtils.populateAttributesOnFields(conn, instance, attributes, c);
		return c;
	}
}
