package com.sksamuel.camelwatch.endpoint;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:19:17
 * 
 */
public class EndpointOperationsJmxImpl implements EndpointOperations {

	public EndpointOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String consumerId, MBeanInfo info) {
	}

}
