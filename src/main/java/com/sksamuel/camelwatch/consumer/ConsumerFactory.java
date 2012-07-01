package com.sksamuel.camelwatch.consumer;

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
public class ConsumerFactory {

	private static final Logger	logger	= LoggerFactory.getLogger(ConsumerFactory.class);

	public Consumer buildConsumer(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws Exception {

		MBeanAttributeInfo[] attributes = info.getAttributes();
		Consumer c = new Consumer();
		c.setName(instance.getObjectName().getKeyProperty("name"));
		c.setDescription(info.getDescription());
		MBeanUtils.populateAttributesOnFields(conn, instance, attributes, c);
		return c;
	}
}
