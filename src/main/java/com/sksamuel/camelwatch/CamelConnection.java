package com.sksamuel.camelwatch;

import java.util.List;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:49
 * 
 */
public interface CamelConnection {

	List<Route> getRoutes() throws Exception;

	List<Endpoint> getEndpoints() throws Exception;

	List<Consumer> getConsumers() throws Exception;

}
