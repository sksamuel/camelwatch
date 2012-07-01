package com.sksamuel.camelwatch.context;

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
public class ContextFactory {

	private static final Logger	logger	= LoggerFactory.getLogger(ContextFactory.class);

	public Context build(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws Exception {

		MBeanAttributeInfo[] attributes = info.getAttributes();

		Context c = new Context();
		c.setName(instance.getObjectName().getKeyProperty("name"));
		c.setDescription(info.getDescription());
		MBeanUtils.populateAttributesOnFields(conn, instance, attributes, c);
		return c;
	}
}
