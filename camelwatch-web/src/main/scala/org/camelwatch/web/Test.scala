package org.camelwatch.web

import com.sksamuel.jmxc.JmxClientFactory

/** @author Stephen Samuel */
object Test extends App {

    println(JmxClientFactory.localAttachables)
}
