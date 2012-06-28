package com.sksamuel.camelwatch;

import java.io.IOException;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ReflectionException;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:29:10
 * 
 */
public class Component {

	private MBeanServerConnection	conn;
	private MBeanInfo			info;
	private ObjectInstance		instance;

	public Long size() throws InstanceNotFoundException, MBeanException, ReflectionException, IOException {
		Object size = conn.invoke(instance.getObjectName(), "queueSize", null, null);
		return (Long) size;
	}

	public void start() {
	}

	public void stop() {
	}
}
