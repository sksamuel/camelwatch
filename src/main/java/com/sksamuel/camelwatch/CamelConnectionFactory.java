package com.sksamuel.camelwatch;

import java.io.IOException;

import javax.management.MalformedObjectNameException;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:09
 * 
 */
public class CamelConnectionFactory {

	private String	url;

	public CamelConnection getConnection() throws MalformedObjectNameException, NullPointerException, IOException {
		return new CamelJmxConnection(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
