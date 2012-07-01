package com.sksamuel.camelwatch;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import javax.management.Attribute;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ReflectionException;

import com.google.common.collect.Lists;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 17:17:16
 * 
 */
public class MBeanUtils {

	public static void populateAttributesOnFields(MBeanServerConnection conn,
			ObjectInstance instance,
			MBeanAttributeInfo[] attributes,
			Object target) throws InstanceNotFoundException, ReflectionException, IOException {

		List<String> attributeNames = Lists.newArrayList();
		for (MBeanAttributeInfo attribute : attributes) {
			attributeNames.add(attribute.getName());
		}

		List attributeList = conn.getAttributes(instance.getObjectName(), attributeNames.toArray(new String[0]));
		List<Attribute> list = attributeList;

		for (Attribute attribute : list) {

			try {

				Field field = target.getClass().getDeclaredField(attribute.getName().substring(0, 1).toLowerCase()
						+ attribute.getName().substring(1));
				field.setAccessible(true);
				field.set(target, attribute.getValue());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
