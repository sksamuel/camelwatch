package com.sksamuel.camelwatch;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.sksamuel.camelwatch.consumer.ConsumerOperations;
import com.sksamuel.camelwatch.consumer.ConsumerOperationsJmxImpl;
import com.sksamuel.camelwatch.endpoint.EndpointOperations;
import com.sksamuel.camelwatch.endpoint.EndpointOperationsJmxImpl;
import com.sksamuel.camelwatch.route.RouteOperations;
import com.sksamuel.camelwatch.route.RouteOperationsJmxImpl;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:26:13
 * 
 */
public class CamelJmxConnection implements CamelConnection {

	private final MBeanServerConnection		conn;
	private final Map<ObjectName, MBeanInfo>	beanInfoCache;

	public CamelJmxConnection(String url, String username, String password, Map<ObjectName, MBeanInfo> beanInfoCache) throws IOException,
			MalformedObjectNameException, NullPointerException {
		this.beanInfoCache = beanInfoCache;
		Map<String, String[]> env = new HashMap<String, String[]>();
		env.put(JMXConnector.CREDENTIALS, new String[] { username, password });

		JMXServiceURL address = new JMXServiceURL(url);
		JMXConnector connector = JMXConnectorFactory.connect(address, env);
		conn = connector.getMBeanServerConnection();

	}

	MBeanInfo getBeanInfo(ObjectInstance instance) throws InstanceNotFoundException, IntrospectionException, ReflectionException,
			IOException {
		if (beanInfoCache.containsKey(instance.getObjectName()))
			return beanInfoCache.get(instance.getObjectName());
		MBeanInfo mBeanInfo = conn.getMBeanInfo(instance.getObjectName());
		beanInfoCache.put(instance.getObjectName(), mBeanInfo);
		return mBeanInfo;
	}

	CamelBean getCamelBean(String type, String name) throws Exception {
		ObjectInstance instance = getObjectInstance(type, name);
		MBeanInfo info = getBeanInfo(instance);
		CamelBean bean = new CamelBeanFactory().build(instance, conn, info);
		return bean;
	}

	List<CamelBean> getCamelBeans(String type) throws IOException, MalformedObjectNameException, InstanceNotFoundException,
			IntrospectionException, ReflectionException, Exception {
		Set<ObjectInstance> beans = getObjectInstances(type);
		List<CamelBean> endpoints = Lists.newArrayList();
		for (ObjectInstance instance : beans) {
			MBeanInfo info = getBeanInfo(instance);
			CamelBean endpoint = new CamelBeanFactory().build(instance, conn, info);
			endpoints.add(endpoint);
		}
		return endpoints;
	}

	@Override
	public CamelBean getComponent(String componentName) throws Exception {
		return getCamelBean("components", "\"" + componentName + "\"");
	}

	@Override
	public List<CamelBean> getComponents() throws Exception {
		return getCamelBeans("components");
	}

	@Override
	public CamelBean getConsumer(String consumerName) throws Exception {
		return getCamelBean("consumers", consumerName);
	}

	@Override
	public ConsumerOperations getConsumerOperations(String consumerId) throws Exception {
		ObjectInstance instance = getObjectInstance("consumers", consumerId);
		MBeanInfo info = getBeanInfo(instance);
		return new ConsumerOperationsJmxImpl(conn, instance, consumerId, info);
	}

	@Override
	public List<CamelBean> getConsumers() throws Exception {
		return getCamelBeans("consumers");
	}

	@Override
	public CamelBean getContext(String camelId) throws Exception {
		return getCamelBean("context", camelId);
	}

	@Override
	public List<CamelBean> getContexts() throws Exception {
		return getCamelBeans("context");
	}

	@Override
	public CamelBean getEndpoint(String endpointName) throws Exception {
		return getCamelBean("endpoints", "\"" + endpointName + "\"");
	}

	@Override
	public List<CamelBean> getEndpoints() throws Exception {
		return getCamelBeans("endpoints");
	}

	@Override
	public CamelBean getErrorHandler(String errorHandlerName) throws Exception {
		return getCamelBean("errorhandlers", "\"" + errorHandlerName + "\"");
	}

	@Override
	public List<CamelBean> getErrorHandlers() throws Exception {
		return getCamelBeans("errorhandlers");
	}

	ObjectInstance getObjectInstance(String type, String name) throws MalformedObjectNameException, NullPointerException, IOException {
		Set<ObjectInstance> beans = conn.queryMBeans(new ObjectName("org.apache.camel:type=" + type + ",name=" + name + ",*"), null);
		return beans.isEmpty() ? null : beans.iterator().next();
	}

	Set<ObjectInstance> getObjectInstances(String type) throws IOException, MalformedObjectNameException {
		Set<ObjectInstance> beans = conn.queryMBeans(new ObjectName("org.apache.camel:type=" + type + ",*"), null);
		return beans;
	}

	@Override
	public CamelBean getProcessor(String processorId) throws Exception {
		return getCamelBean("processors", processorId);
	}

	@Override
	public List<CamelBean> getProcessors() throws Exception {
		return getCamelBeans("processors");
	}

	@Override
	public Collection<CamelBean> getProcessors(final String routeId) throws Exception {
		List<CamelBean> camelBeans = getCamelBeans("processors");
		return Collections2.filter(camelBeans, new Predicate<CamelBean>() {

			@Override
			public boolean apply(CamelBean input) {
				return routeId.equals(input.getProperties().get("RouteId"));
			}
		});
	}

	@Override
	public CamelBean getRoute(String routeId) throws Exception {
		return getCamelBean("routes", "\"" + routeId + "\"");
	}

	@Override
	public RouteOperations getRouteOperations(String routeId) throws Exception {
		ObjectInstance instance = getObjectInstance("routes", "\"" + routeId + "\"");
		MBeanInfo info = getBeanInfo(instance);
		return new RouteOperationsJmxImpl(conn, instance, routeId, info);
	}

	@Override
	public List<CamelBean> getRoutes() throws Exception {
		List<CamelBean> routes = getCamelBeans("routes");
		Collections.sort(routes, new Comparator<CamelBean>() {

			@Override
			public int compare(CamelBean o1, CamelBean o2) {
				String routeId1 = (String) o1.getProperties().get("RouteId");
				String routeId2 = (String) o2.getProperties().get("RouteId");
				return routeId1.compareTo(routeId2);
			}
		});
		return routes;
	}

	@Override
	public EndpointOperations getEndpointOperations(String endpointName) throws Exception {
		ObjectInstance instance = getObjectInstance("endpoints", "\"" + endpointName + "\"");
		MBeanInfo info = getBeanInfo(instance);
		return new EndpointOperationsJmxImpl(conn, instance, endpointName, info);
	}
}
