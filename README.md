Camelwatch
==========

Camelwatch is an open source project that provides a fully featured web console for the <a href="http://camel.apache.org/">Apache Camel</a> project. Camelwatch can monitor any remote camel instance by using the JMX hooks that camel provides.


Features
========

* Browsable context, endpoints, consumers, producers, routes, error handlers.
* Viewable statistics on each of the above beans
* Deploy as WAR in an existing tomcat, or incorporate into your own deployable as a set of spring beans
* Accesses any camel instance remotely using JMX

Installation
============

Installation is extremely simple. Download the <a href="https://github.com/downloads/sksamuel/camelwatch/camelwatch-0.3.war">latest war</a> and deploy into any running tomcat container. After tomcat deploys the application edit the /<warname>/WEB-INF/classes/camelwatch.properties file. Replace the jmx.endpoint property with the URL of the JMX endpoint for the camel instance you want to monitor. Restart tomcat and then browse to /<warname> and you should be good to go.

Rest
====

Camelwatch includes a set of REST services. These are accessible at the following URLs, where contextPath should be replaced with your deployed app name (usually camelwatch)

* /contextPath/rest/consumer
* /contextPath/rest/consumer/{consumerName}
* /contextPath/rest/context
* /contextPath/rest/context/{contextName}
* /contextPath/rest/endpoint
* /contextPath/rest/endpoint/{endpointName}
* /contextPath/rest/route
* /contextPath/rest/route/{routeName}
* /contextPath/rest/errorHandler
* /contextPath/rest/errorHandler/{errorHandlerName}
* /contextPath/rest/processor
* /contextPath/rest/processor/{processorName}

Roadmap
=======

* Add ability to upload a message for processing through a route
* Add tracing outputs
* Graph visualizations of camel routes
* Speed optimisations
* Thread pool views
* Service bean views
* Configure routes at runtime (like the camel web console)
* More... please add issues to the issue tracker
