package org.camelwatch.api;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 23:21:11
 * 
 */
public class CamelBean {

	private final Map<String, Object>	properties	= Maps.newTreeMap();

	private String				name;

	private String				description;

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

}
