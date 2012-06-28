package com.sksamuel.camelwatch;

import java.io.IOException;

import javax.management.MalformedObjectNameException;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:09
 * 
 */
public class CamelJmxConnectionFactory {

	@Autowired
	private String	url;

	public CamelConnection getConnection(String url) throws MalformedObjectNameException, NullPointerException, IOException {
		return new CamelJmxConnection(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
