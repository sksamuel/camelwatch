package com.sksamuel.camelwatch;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
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

/**
 * @author Stephen K Samuel samspade79@gmail.com 28 Jun 2012 23:59:35
 * 
 */
public class Connector {

	public static void main(String[] args) throws IOException, InstanceNotFoundException, IntrospectionException, ReflectionException,
			MalformedObjectNameException, NullPointerException {

		Map<String, String[]> env = new HashMap<String, String[]>();
		env.put(JMXConnector.CREDENTIALS, new String[] { "user", "pass" });

		JMXServiceURL address = new JMXServiceURL(
				"service:jmx:rmi://opta-ecb.otherhosting.net:10002/jndi/rmi://opta-ecb.otherhosting.net:10001/jmxrmi");
		JMXConnector connector = JMXConnectorFactory.connect(address, env);
		MBeanServerConnection conn = connector.getMBeanServerConnection();

		Set<ObjectInstance> beans = conn.queryMBeans(new ObjectName("org.apache.camel:type=routes,*"), null);
		System.out.println(beans.size() + " beans");

		for (ObjectInstance instance : beans) {
			System.out.println(instance.getObjectName());
			MBeanInfo info = conn.getMBeanInfo(instance.getObjectName());
			System.out.println(Arrays.toString(info.getAttributes()));
			System.out.println(Arrays.toString(info.getOperations()));
			break;
		}
	}
}
