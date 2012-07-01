package com.sksamuel.camelwatch;

import java.io.IOException;

import javax.management.MalformedObjectNameException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:09
 * 
 */
@Service
public class CamelConnectionFactory {

	@Value("${jmx.endpoint}")
	private String	endpoint;

	public CamelConnection getConnection() throws MalformedObjectNameException, NullPointerException, IOException {
		return new CamelJmxConnection(endpoint);
	}

}
