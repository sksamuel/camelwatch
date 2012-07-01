package com.sksamuel.camelwatch;

import java.util.List;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:49
 * 
 */
public interface CamelConnection {

	Consumer getConsumer(String consumerId) throws Exception;

	ConsumerOperations getConsumerOperations(String consumerId) throws Exception;

	List<Consumer> getConsumers() throws Exception;

	List<Endpoint> getEndpoints() throws Exception;

	Route getRoute(String routeId) throws Exception;

	RouteOperations getRouteOperations(String routeId) throws Exception;

	List<Route> getRoutes() throws Exception;

}
