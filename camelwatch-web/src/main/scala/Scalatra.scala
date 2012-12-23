import com.sksamuel.jmxc.JmxClientFactory
import javax.servlet.ServletContext
import org.camelwatch.CamelJmxClient
import org.camelwatch.web.{JmxClientHolder, RouteMonitor}
import org.scalatra.LifeCycle

/** @author Stephen Samuel */
class Scalatra extends LifeCycle {

    override def init(context: ServletContext) {

        val client = JmxClientFactory.newLocalClient(21765)
        JmxClientHolder.client = new CamelJmxClient(client)

        context mount(new RouteMonitor, "/route/*")

        // set init params like this:
        // org.scalatra.cors.allowedOrigins = "http://example.com"

    }

}
