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

	public String getExchangeId() {
		return exchangeId;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}
}
