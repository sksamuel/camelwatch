Camelwatch
==========

** Not maintained **

Camelwatch is an open source project that provides a fully featured web console for the <a href="http://camel.apache.org/">Apache Camel</a> project. Camelwatch can monitor any remote camel instance by using the JMX hooks that camel provides.


Features
========

* Browsable context, endpoints, consumers, producers, routes, error handlers.
* Viewable statistics on each of the above beans
* Deploy as WAR in an existing tomcat, or incorporate into your own deployable as a set of spring beans
* Accesses any camel instance remotely using JMX

Installation
============

Installation is extremely simple. Download the <a href="https://github.com/downloads/sksamuel/camelwatch/camelwatch-0.4.war">latest war</a> and deploy into any running tomcat container. After tomcat deploys the application edit the /<warname>/WEB-INF/classes/camelwatch.properties file. Replace the jmx.endpoint property with the URL of the JMX endpoint for the camel instance you want to monitor. Restart tomcat and then browse to /<warname> and you should be good to go.

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

Releases
========
0.4 Added route editing via XML. Added browsing of messages directly in endpoints.
0.3 Added rest services


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
 
Screenshots
===========

<img src="https://github.com/downloads/sksamuel/camelwatch/ss1.png"/> <img src="https://github.com/downloads/sksamuel/camelwatch/ss2.png"/>


## License
```
This software is licensed under the Apache 2 license, quoted below.

Copyright 2013 Stephen Samuel

Licensed under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```
