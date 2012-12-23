package org.camelwatch

import scala.Predef.String
import com.sksamuel.jmxc.MBean

/**
 * A wrapper for a jmcx.MBean that gives strongly typed methods for all camel Route attributes
 *
 * @author Stephen Samuel
 *
 **/
class ComponentMBean(bean: MBean) {
    val componentName: String = bean.attributeValue("componentName").toString
    val state        : String = bean.attributeValue("state").toString
    val camelId      : String = bean.attributeValue("camelId").toString

}
