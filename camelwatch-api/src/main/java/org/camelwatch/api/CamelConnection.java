package org.camelwatch.api;

import org.camelwatch.api.consumer.ConsumerOperations;
import org.camelwatch.api.endpoint.EndpointOperations;
import org.camelwatch.api.route.RouteOperations;

import java.util.Collection;
import java.util.List;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:49
 * 
 */
public interface CamelConnection {

	CamelBean getComponent(String componentName) throws Exception;

	List<CamelBean> getComponents() throws Exception;

	CamelBean getConsumer(String consumerId) throws Exception;

	ConsumerOperations getConsumerOperations(String consumerId) throws Exception;

	List<CamelBean> getConsumers() throws Exception;

	CamelBean getContext(String camelId) throws Exception;

	List<CamelBean> getContexts() throws Exception;

	CamelBean getEndpoint(String endpointName) throws Exception;

	EndpointOperations getEndpointOperations(String endpointName) throws Exception;

	List<CamelBean> getEndpoints() throws Exception;

	CamelBean getErrorHandler(String errorHandlerName) throws Exception;

	List<CamelBean> getErrorHandlers() throws Exception;

	CamelBean getProcessor(String processorId) throws Exception;

	List<CamelBean> getProcessors() throws Exception;

	Collection<CamelBean> getProcessors(String routeId) throws Exception;

	CamelBean getRoute(String routeId) throws Exception;

	RouteOperations getRouteOperations(String routeId) throws Exception;

	List<CamelBean> getRoutes() throws Exception;

}
