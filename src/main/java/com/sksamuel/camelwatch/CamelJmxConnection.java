package com.sksamuel.camelwatch;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.google.common.collect.Lists;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:26:13
 * 
 */
public class CamelJmxConnection implements CamelConnection {

	private final MBeanServerConnection	conn;

	public CamelJmxConnection(String url) throws IOException, MalformedObjectNameException, NullPointerException {
		Map<String, String[]> env = new HashMap<String, String[]>();
		env.put(JMXConnector.CREDENTIALS, new String[] { "user", "pass" });

		JMXServiceURL address = new JMXServiceURL(url);
		JMXConnector connector = JMXConnectorFactory.connect(address, env);
		conn = connector.getMBeanServerConnection();

	}

	@Override
	public List<Consumer> getConsumers() throws Exception {

		Set<ObjectInstance> beans = getBeansOfType("consumers");

		List<Consumer> consumers = Lists.newArrayList();
		for (ObjectInstance instance : beans) {
			MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
			Consumer consumer = new ConsumerFactory().buildConsumer(instance, conn, info);
			consumers.add(consumer);
		}

		return consumers;
	}

	@Override
	public List<Endpoint> getEndpoints() throws Exception {

		Set<ObjectInstance> beans = getBeansOfType("endpoints");

		List<Endpoint> endpoints = Lists.newArrayList();
		for (ObjectInstance instance : beans) {
			MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
			Endpoint endpoint = EndpointFactory.buildEndpoint(instance, conn, info);
			endpoints.add(endpoint);
		}
		return endpoints;
	}

	@Override
	public List<Route> getRoutes() throws Exception {

		Set<ObjectInstance> beans = getBeansOfType("routes");

		List<Route> routes = Lists.newArrayList();
		for (ObjectInstance instance : beans) {

			System.out.println(instance.getObjectName());
			MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
			System.out.println(Arrays.toString(info.getAttributes()));

			Route route = new RouteFactory().buildRoute(instance, conn, info);
			routes.add(route);
		}

		return routes;
	}

	Set<ObjectInstance> getBeansOfType(String type) throws IOException, MalformedObjectNameException {
		Set<ObjectInstance> beans = conn.queryMBeans(new ObjectName("org.apache.camel:type=" + type + ",*"), null);
		System.out.println(beans.size() + " beans");
		return beans;
	}

}
