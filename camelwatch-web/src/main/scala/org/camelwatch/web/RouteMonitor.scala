package org.camelwatch.web

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.camelwatch.RouteMBean

/* @author Stephen K Samuel */
class RouteMonitor extends ScalatraServlet with ScalateSupport {

    get("/") {
                 contentType = "text/html"
                 ssp("/routes")
             }

    get("/body") {
                     contentType = "text/html"
                     val routes: Seq[RouteMBean] = JmxClientHolder.client.routes
                     ssp("/routesbody", "routes" -> routes)
                 }
}
