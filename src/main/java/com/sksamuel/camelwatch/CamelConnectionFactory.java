package com.sksamuel.camelwatch;

import java.io.IOException;
import java.util.Map;

import javax.management.MBeanInfo;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:09
 * 
 */
@Service
public class CamelConnectionFactory {

	@Value("${jmx.endpoint}")
	private String					endpoint;

	private final Map<ObjectName, MBeanInfo>	beanInfoCache	= Maps.newHashMap();

	public CamelConnection getConnection() throws MalformedObjectNameException, NullPointerException, IOException {
		return new CamelJmxConnection(endpoint, beanInfoCache);
	}

}
