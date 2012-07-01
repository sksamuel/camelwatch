package com.sksamuel.camelwatch;

import java.util.Date;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:29:10
 * 
 */
public class Route {

	private String	routeId;
	private String	camelId;
	private String	description;
	private String	endpointUri;
	private long	exchangesCompleted;
	private Integer	exchangedFailed;
	private Integer	inflightExchanges;
	private long	maxProcessingTime;
	private long	minProcessingTime;
	private String	state;
	private String	name;
	private long	lastProcessingTime;
	private long	totalProcessingTime;
	private boolean	statisticsEnabled;
	private long	failuresHandled;
	private long	meanProcessingTime;
	private String	load05;
	private String	load15;
	private String	load01;
	private long	exchangesTotal;
	private long	redeliveries;
	private String	routePolicyList;
	private long	exchangesFailed;
	private long	externalRedeliveries;
	private Date	lastExchangeFailureTimestamp;
	private String	lastExchangeCompletedExchangeId;
	private Date	firstExchangeFailureTimestamp;
	private String	lastExchangeFailureExchangeId;
	private String	firstExchangeFailureExchangeId;
	private Date	firstExchangeCompletedTimestamp;
	private Date	lastExchangeCompletedTimestamp;
	private String	firstExchangeCompletedExchangeId;
	private boolean	tracing;

	public String getCamelId() {
		return camelId;
	}

	public String getDescription() {
		return description;
	}

	public String getEndpointUri() {
		return endpointUri;
	}

	public Integer getExchangedFailed() {
		return exchangedFailed;
	}

	public long getExchangesCompleted() {
		return exchangesCompleted;
	}

	public long getExchangesFailed() {
		return exchangesFailed;
	}

	public long getExchangesTotal() {
		return exchangesTotal;
	}

	public long getExternalRedeliveries() {
		return externalRedeliveries;
	}

	public long getFailuresHandled() {
		return failuresHandled;
	}

	public String getFirstExchangeCompletedExchangeId() {
		return firstExchangeCompletedExchangeId;
	}

	public Date getFirstExchangeCompletedTimestamp() {
		return firstExchangeCompletedTimestamp;
	}

	public String getFirstExchangeFailureExchangeId() {
		return firstExchangeFailureExchangeId;
	}

	public Date getFirstExchangeFailureTimestamp() {
		return firstExchangeFailureTimestamp;
	}

	public Integer getInflightExchanges() {
		return inflightExchanges;
	}

	public String getLastExchangeCompletedExchangeId() {
		return lastExchangeCompletedExchangeId;
	}

	public Date getLastExchangeCompletedTimestamp() {
		return lastExchangeCompletedTimestamp;
	}

	public String getLastExchangeFailureExchangeId() {
		return lastExchangeFailureExchangeId;
	}

	public Date getLastExchangeFailureTimestamp() {
		return lastExchangeFailureTimestamp;
	}

	public long getLastProcessingTime() {
		return lastProcessingTime;
	}

	public String getLoad05() {
		return load05;
	}

	public String getLoad15() {
		return load15;
	}

	public long getMaxProcessingTime() {
		return maxProcessingTime;
	}

	public long getMeanProcessingTime() {
		return meanProcessingTime;
	}

	public long getMinProcessingTime() {
		return minProcessingTime;
	}

	public String getName() {
		return name;
	}

	public long getRedeliveries() {
		return redeliveries;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getRoutePolicyList() {
		return routePolicyList;
	}

	public String getState() {
		return state;
	}

	public long getTotalProcessingTime() {
		return totalProcessingTime;
	}

	public boolean isStatisticsEnabled() {
		return statisticsEnabled;
	}

	public boolean isTracing() {
		return tracing;
	}

	public void setCamelId(String camelId) {
		this.camelId = camelId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
	}

	public void setExchangedFailed(Integer exchangedFailed) {
		this.exchangedFailed = exchangedFailed;
	}

	public void setExchangesCompleted(long exchangesCompleted) {
		this.exchangesCompleted = exchangesCompleted;
	}

	public void setExchangesFailed(long exchangesFailed) {
		this.exchangesFailed = exchangesFailed;
	}

	public void setExchangesTotal(long exchangesTotal) {
		this.exchangesTotal = exchangesTotal;
	}

	public void setExternalRedeliveries(long externalRedeliveries) {
		this.externalRedeliveries = externalRedeliveries;
	}

	public void setFailuresHandled(long failuresHandled) {
		this.failuresHandled = failuresHandled;
	}

	public void setFirstExchangeCompletedExchangeId(String firstExchangeCompletedExchangeId) {
		this.firstExchangeCompletedExchangeId = firstExchangeCompletedExchangeId;
	}

	public void setFirstExchangeCompletedTimestamp(Date firstExchangeCompletedTimestamp) {
		this.firstExchangeCompletedTimestamp = firstExchangeCompletedTimestamp;
	}

	public void setFirstExchangeFailureExchangeId(String firstExchangeFailureExchangeId) {
		this.firstExchangeFailureExchangeId = firstExchangeFailureExchangeId;
	}

	public void setFirstExchangeFailureTimestamp(Date firstExchangeFailureTimestamp) {
		this.firstExchangeFailureTimestamp = firstExchangeFailureTimestamp;
	}

	public void setInflightExchanges(Integer inflightExchanges) {
		this.inflightExchanges = inflightExchanges;
	}

	public void setLastExchangeCompletedExchangeId(String lastExchangeCompletedExchangeId) {
		this.lastExchangeCompletedExchangeId = lastExchangeCompletedExchangeId;
	}

	public void setLastExchangeCompletedTimestamp(Date lastExchangeCompletedTimestamp) {
		this.lastExchangeCompletedTimestamp = lastExchangeCompletedTimestamp;
	}

	public void setLastExchangeFailureExchangeId(String lastExchangeFailureExchangeId) {
		this.lastExchangeFailureExchangeId = lastExchangeFailureExchangeId;
	}

	public void setLastExchangeFailureTimestamp(Date lastExchangeFailureTimestamp) {
		this.lastExchangeFailureTimestamp = lastExchangeFailureTimestamp;
	}

	public void setLastProcessingTime(long lastProcessingTime) {
		this.lastProcessingTime = lastProcessingTime;
	}

	public void setLoad05(String load05) {
		this.load05 = load05;
	}

	public void setLoad15(String load15) {
		this.load15 = load15;
	}

	public void setMaxProcessingTime(long maxProcessingTime) {
		this.maxProcessingTime = maxProcessingTime;
	}

	public void setMeanProcessingTime(long meanProcessingTime) {
		this.meanProcessingTime = meanProcessingTime;
	}

	public void setMinProcessingTime(long minProcessingTime) {
		this.minProcessingTime = minProcessingTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRedeliveries(long redeliveries) {
		this.redeliveries = redeliveries;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public void setRoutePolicyList(String routePolicyList) {
		this.routePolicyList = routePolicyList;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStatisticsEnabled(boolean statisticsEnabled) {
		this.statisticsEnabled = statisticsEnabled;
	}

	public void setTotalProcessingTime(long totalProcessingTime) {
		this.totalProcessingTime = totalProcessingTime;
	}

	public void setTracing(boolean tracing) {
		this.tracing = tracing;
	}

}
