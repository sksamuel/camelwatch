package com.sksamuel.camelwatch;

import java.io.IOException;
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
import com.sksamuel.camelwatch.consumer.Consumer;
import com.sksamuel.camelwatch.consumer.ConsumerFactory;
import com.sksamuel.camelwatch.consumer.ConsumerOperations;
import com.sksamuel.camelwatch.consumer.ConsumerOperationsJmxImpl;
import com.sksamuel.camelwatch.context.Context;
import com.sksamuel.camelwatch.context.ContextFactory;
import com.sksamuel.camelwatch.route.Route;
import com.sksamuel.camelwatch.route.RouteFactory;
import com.sksamuel.camelwatch.route.RouteOperations;
import com.sksamuel.camelwatch.route.RouteOperationsJmxImpl;

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

	Set<ObjectInstance> getBeansOfType(String type) throws IOException, MalformedObjectNameException {
		Set<ObjectInstance> beans = conn.queryMBeans(new ObjectName("org.apache.camel:type=" + type + ",*"), null);
		return beans;
	}

	@Override
	public Consumer getConsumer(String consumerName) throws Exception {
		ObjectInstance instance = getInstance("consumers", consumerName);
		MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
		return new ConsumerFactory().buildConsumer(instance, conn, info);
	}

	@Override
	public ConsumerOperations getConsumerOperations(String consumerId) throws Exception {
		ObjectInstance instance = getInstance("consumers", consumerId);
		MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
		return new ConsumerOperationsJmxImpl(conn, instance, consumerId, info);
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
	public List<Context> getContexts() throws Exception {
		Set<ObjectInstance> beans = getBeansOfType("context");
		List<Context> contexts = Lists.newArrayList();
		for (ObjectInstance instance : beans) {
			MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
			Context context = new ContextFactory().build(instance, conn, info);
			contexts.add(context);
		}
		return contexts;
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

	ObjectInstance getInstance(String type, String name) throws MalformedObjectNameException, NullPointerException, IOException {
		Set<ObjectInstance> beans = conn.queryMBeans(new ObjectName("org.apache.camel:type=" + type + ",name=" + name + ",*"), null);
		return beans.isEmpty() ? null : beans.iterator().next();
	}

	@Override
	public Route getRoute(String routeId) throws Exception {
		ObjectInstance instance = getInstance("routes", "\"" + routeId + "\"");
		MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
		return new RouteFactory().buildRoute(instance, conn, info);
	}

	@Override
	public RouteOperations getRouteOperations(String routeId) throws Exception {
		ObjectInstance instance = getInstance("routes", "\"" + routeId + "\"");
		MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
		return new RouteOperationsJmxImpl(conn, instance, routeId, info);
	}

	@Override
	public List<Route> getRoutes() throws Exception {

		Set<ObjectInstance> beans = getBeansOfType("routes");

		List<Route> routes = Lists.newArrayList();
		for (ObjectInstance instance : beans) {
			MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
			Route route = new RouteFactory().buildRoute(instance, conn, info);
			routes.add(route);
		}

		return routes;
	}

}
