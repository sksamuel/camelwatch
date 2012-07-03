package com.sksamuel.camelwatch;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Stephen K Samuel samspade79@gmail.com 3 Jul 2012 07:50:24
 * 
 */
public class Message {

	private String				exchangeId;

	private final Map<String, String>	headers	= Maps.newHashMap();

	private String				body;

	private String				bodyType;

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
}
