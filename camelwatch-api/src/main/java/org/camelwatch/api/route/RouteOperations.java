package org.camelwatch.api.route;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface RouteOperations {

	String dumpRouteAsXml() throws Exception;

	void remove();

	void reset();

	void resume() throws Exception;

	void setStatisticsEnabled(boolean enabled);

	void start() throws Exception;

	void stop() throws Exception;

	void suspend() throws Exception;

	void updateRouteFromXml(String xml) throws Exception;

    void setTracing(boolean enable) throws Exception;
}
