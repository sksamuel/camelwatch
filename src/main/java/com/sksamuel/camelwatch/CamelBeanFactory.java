package com.sksamuel.camelwatch;

import java.util.List;

import javax.management.Attribute;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

import com.google.common.collect.Lists;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 23:51:26
 * 
 */
public class CamelBeanFactory {

	public CamelBean build(ObjectInstance instance, MBeanServerConnection conn, MBeanInfo info) throws Exception {

		CamelBean c = new CamelBean();
		String name = instance.getObjectName().getKeyProperty("name");
		if (name.endsWith("\""))
			name = name.substring(0, name.length() - 1);
		if (name.startsWith("\""))
			name = name.substring(1);

		c.setName(name);
		c.setDescription(info.getDescription());

		MBeanAttributeInfo[] attributes = info.getAttributes();
		List<String> attributeNames = Lists.newArrayList();
		for (MBeanAttributeInfo attribute : attributes) {
			attributeNames.add(attribute.getName());
		}

		List attributeList = conn.getAttributes(instance.getObjectName(), attributeNames.toArray(new String[0]));
		List<Attribute> list = attributeList;
		for (Attribute attribute : list) {
			c.getProperties().put(attribute.getName(), attribute.getValue());
		}

		return c;
	}

}
