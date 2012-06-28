package com.sksamuel.camelwatch;

import java.io.IOException;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:49
 * 
 */
public interface CamelConnection {

	List<Route> getRoutes() throws IOException, InstanceNotFoundException, IntrospectionException, ReflectionException,
			MalformedObjectNameException, NullPointerException, MBeanException;

	List<Endpoint> getEndpoints() throws IOException, InstanceNotFoundException, IntrospectionException, ReflectionException,
			MalformedObjectNameException, NullPointerException, MBeanException;

}
