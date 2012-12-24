import com.sksamuel.jmxc.JmxClientFactory
import javax.servlet.ServletContext
import org.camelwatch.CamelJmxClient
import org.camelwatch.web.{JmxClientHolder, RouteMonitor}
import org.scalatra.LifeCycle

/** @author Stephen Samuel */
class Scalatra extends LifeCycle {

    override def init(context: ServletContext) {

        println(JmxClientFactory.localClients)

        //        val client = JmxClientFactory
        //                   .fromDomainName("org.apache.camel")
        //                 .getOrElse(throw new RuntimeException("Could not locate camel domain"))
        val client = JmxClientFactory
                     .newClient(
            "service:jmx:rmi://127.0.0.1/stub/rO0ABXNyAC5qYXZheC5tYW5hZ2VtZW50LnJlbW90ZS5ybWkuUk1JU2VydmVySW1wbF9TdHViAAAAAAAAAAICAAB4cgAaamF2YS5ybWkuc2VydmVyLlJlbW90ZVN0dWLp/tzJi+FlGgIAAHhyABxqYXZhLnJtaS5zZXJ2ZXIuUmVtb3RlT2JqZWN002G0kQxhMx4DAAB4cHc0AAtVbmljYXN0UmVmMgAACTEyNy4wLjEuMQAA6Np9dnMf3jmLuMpu0LIAAAE7yCCBWIAGAHg=")
        JmxClientHolder.client = new CamelJmxClient(client)

        context mount(new RouteMonitor, "/route/*")

        // set init params like this:
        // org.scalatra.cors.allowedOrigins = "http://example.com"

    }

}
