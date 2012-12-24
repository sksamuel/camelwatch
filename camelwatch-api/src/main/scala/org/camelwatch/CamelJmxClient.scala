package org.camelwatch

import com.sksamuel.jmxc.JmxClient

/**
 * Wrapper for jmxc.JmxClient that provides camel specific methods
 *
 * @author Stephen Samuel
 *
 **/
class CamelJmxClient(client: JmxClient) {
    def domain = client.domain("org.apache.camel").getOrElse(throw new RuntimeException("Error locating camel jxm domain"))
    def routes: Array[RouteMBean] = domain.beans("routes").map(new RouteMBean(_)).sortBy(_.routeId)
    def components: Array[ComponentMBean] = domain.beans("components").map(new ComponentMBean(_))
}
