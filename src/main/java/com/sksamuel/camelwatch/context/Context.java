package com.sksamuel.camelwatch.context;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 17:14:58
 * 
 */
public class Context {

	private String	camelId;
	private String	camelVersion;
	private String	load01;
	private String	load05;
	private String	load15;
	private long	inflightExchanges;
	private String	uptime;
	private long	timeout;
	private String	timeUnit;
	private String	state;
	private String	name;
	private String	description;

	public String getCamelId() {
		return camelId;
	}

	public String getCamelVersion() {
		return camelVersion;
	}

	public String getDescription() {
		return description;
	}

	public long getInflightExchanges() {
		return inflightExchanges;
	}

	public String getLoad01() {
		return load01;
	}

	public String getLoad05() {
		return load05;
	}

	public String getLoad15() {
		return load15;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public long getTimeout() {
		return timeout;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public String getUptime() {
		return uptime;
	}

	public void setCamelId(String camelId) {
		this.camelId = camelId;
	}

	public void setCamelVersion(String camelVersion) {
		this.camelVersion = camelVersion;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInflightExchanges(long inflightExchanges) {
		this.inflightExchanges = inflightExchanges;
	}

	public void setLoad01(String load01) {
		this.load01 = load01;
	}

	public void setLoad05(String load05) {
		this.load05 = load05;
	}

	public void setLoad15(String load15) {
		this.load15 = load15;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}


	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

}
