package org.camelwatch

import api.CamelJmxConnection
import org.apache.camel.api.management.mbean.ManagedRouteMBean
import java.lang
import java.util.Date
import javax.management.{ObjectInstance, MBeanServerConnection}

/** @author Stephen Samuel */
class RouteMBean(obj: ObjectInstance, conn: MBeanServerConnection) extends ManagedRouteMBean {

    val exchangesTotal = getAttribute("exchangesTotal").toLong
    val camelId = getAttribute("camelId").toString
    val routeId = getAttribute("routeId").toString

    def getAttribute(attributeName: String): String = conn.getAttribute(obj.getObjectName, attributeName)

    def getExchangesTotal: Long = exchangesTotal

    def reset() {}
    def dumpRouteStatsAsXml(fullStats: Boolean, includeProcessors: Boolean): String = ""
    def updateRouteFromXml(xml: String) {}
    def dumpRouteAsXml(): String = ""
    def remove() = false
    def shutdown(timeout: Long) {}
    def shutdown() {}
    def stop(timeout: lang.Long, abortAfterTimeout: lang.Boolean): Boolean = false
    def stop(timeout: Long) {}
    def stop() {}
    def start() {}

    lazy val load15 = getAttribute("load15").toString
    def getLoad15: String = load15

    lazy val load05 = getAttribute("load05").toString
    def getLoad05: String = load05

    lazy val load01 = getAttribute("load01").toString
    def getLoad01: String = load01

    def getRoutePolicyList: String = ""
    def setTracing(tracing: lang.Boolean) {}
    def getTracing: java.lang.Boolean = false
    def getCamelId: String = camelId
    def getInflightExchanges: java.lang.Integer = 0
    def getState: String = ""
    def getEndpointUri: String = ""
    def getDescription: String = ""

    def getRouteId: String = routeId

    def dumpStatsAsXml(fullStats: Boolean): String = ""
    def setStatisticsEnabled(statisticsEnabled: Boolean) {}
    def isStatisticsEnabled: Boolean = false
    def getFirstExchangeFailureExchangeId = ""
    def getFirstExchangeFailureTimestamp: Date = null
    def getLastExchangeFailureExchangeId = ""
    def getLastExchangeFailureTimestamp: Date = null
    def getFirstExchangeCompletedExchangeId = ""
    def getFirstExchangeCompletedTimestamp: Date = null
    def getLastExchangeCompletedExchangeId = ""
    def getLastExchangeCompletedTimestamp: Date = null

    lazy val lastProcessingTime = getAttribute("lastProcessingTime").toLong
    def getLastProcessingTime: Long = 0

    lazy val totalProcessingTime = getAttribute("totalProcessingTime").toLong
    def getTotalProcessingTime: Long = 0

    lazy val maxProcessingTime = getAttribute("totalProcessingTime").toLong
    def getMaxProcessingTime: Long = 0


    def getMeanProcessingTime: Long = 0
    def getMinProcessingTime: Long = 0
    def getExternalRedeliveries: Long = 0

    lazy val redeliveries = getAttribute("redeliveries").toLong
    def getRedeliveries: Long = redeliveries

    lazy val failuresHandled = getAttribute("failuresHandled").toLong
    def getFailuresHandled: Long = 0

    lazy val exchangesFailed = getAttribute("exchangesFailed").toLong
    def getExchangesFailed: Long = 0

    lazy val exchangesCompleted = getAttribute("exchangesCompleted").toLong
    def getExchangesCompleted: Long = 0

}
