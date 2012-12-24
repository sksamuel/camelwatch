package org.camelwatch

import java.util.Date
import com.sksamuel.jmxc.MBean
import sun.nio.cs.US_ASCII
import java.text.SimpleDateFormat

/**
 * A wrapper for a jmcx.MBean that gives strongly typed methods for all camel Route attributes
 *
 * @author Stephen Samuel
 *
 **/
class RouteMBean(bean: MBean) {

    def camelId = bean.attributeValue("CamelId").toString
    def routeId = bean.attributeValue("RouteId").toString
    def load15 = bean.attributeValue("Load15").toString
    def load05 = bean.attributeValue("Load05").toString
    def load01 = bean.attributeValue("Load01").toString

    def lastProcessingTime = bean.attributeValue("LastProcessingTime").toString.toLong
    def totalProcessingTime = bean.attributeValue("TotalProcessingTime").toString.toLong
    def maxProcessingTime = bean.attributeValue("MaxProcessingTime").toString.toLong
    def meanProcessingTime = bean.attributeValue("MeanProcessingTime").toString.toLong
    def minProcessingTime = bean.attributeValue("MinProcessingTime").toString.toLong

    def externalRedeliveries = bean.attributeValue("ExternalRedeliveries").toString.toLong
    def redeliveries = bean.attributeValue("Redeliveries").toString.toLong

    def inflightExchanges = bean.attributeValue("InflightExchanges").toString.toLong
    def exchangesTotal = bean.attributeValue("ExchangesTotal").toString.toLong
    def exchangesFailedPercent: Int = (if (exchangesTotal == 0) 0 else exchangesFailed / exchangesTotal.toDouble).toInt
    def exchangesFailed = bean.attributeValue("ExchangesFailed").toString.toLong
    def exchangesCompleted = bean.attributeValue("ExchangesCompleted").toString.toLong
    def exchangesCompletedPercent: Int = (if (exchangesTotal == 0) 100 else exchangesCompleted / exchangesTotal.toDouble).toInt
    def failuresHandled = bean.attributeValue("FailuresHandled").toString.toLong
    def failuresHandledPercent: Int = (if (exchangesTotal == 0) 0 else failuresHandled / exchangesTotal.toDouble).toInt

    def state = bean.attributeValue("State").toString
    def endpointUri = bean.attributeValue("EndpointUri").toString
    def description = bean.attributeValue("Description").toString
    def isStatisticsEnabled = bean.attributeValue("IsStatisticsEnabled") == "true"

    def firstExchangeFailureExchangeId: Option[String] = Option(bean.attributeValue("FirstExchangeFailureExchangeId")).map(_.toString)
    def firstExchangeFailureTimestamp: Option[String] = Option(bean.attributeValue("FirstExchangeFailureTimestamp"))
                                                        .map(arg => _format(arg.asInstanceOf[Date]))
    def lastExchangeFailureExchangeId: Option[String] = Option(bean.attributeValue("LastExchangeFailureExchangeId")).map(_.toString)
    def lastExchangeFailureTimestamp: Option[String] = Option(bean.attributeValue("LastExchangeFailureTimestamp"))
                                                       .map(arg => _format(arg.asInstanceOf[Date]))
    def firstExchangeCompletedExchangeId: Option[String] = Option(bean.attributeValue("FirstExchangeCompletedExchangeId")).map(_.toString)
    def firstExchangeCompletedTimestamp: Option[String] = Option(bean.attributeValue("FirstExchangeCompletedTimestamp"))
                                                          .map(arg => _format(arg.asInstanceOf[Date]))
    def lastExchangeCompletedExchangeId: Option[String] = Option(bean.attributeValue("LastExchangeCompletedExchangeId")).map(_.toString)
    def lastExchangeCompletedTimestamp: Option[String] = Option(bean.attributeValue("LastExchangeCompletedTimestamp"))
                                                         .map(arg => _format(arg.asInstanceOf[Date]))

    private def _format(date: Date) = new SimpleDateFormat("HH:mm:ss EEE dd MMM").format(date)
}
