package org.camelwatch

import java.util.Date
import com.sksamuel.jmxc.MBean

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
    def lastExchangeCompletedExchangeId = bean.attributeValue("LastExchangeCompletedExchangeId").toString
    def lastExchangeCompletedTimestamp = bean.attributeValue("LastExchangeCompletedTimestamp").asInstanceOf[Date]
    def lastProcessingTime = bean.attributeValue("LastProcessingTime").toString.toLong
    def totalProcessingTime = bean.attributeValue("TotalProcessingTime").toString.toLong
    def maxProcessingTime = bean.attributeValue("MaxProcessingTime").toString.toLong
    def meanProcessingTime = bean.attributeValue("MeanProcessingTime").toString.toLong
    def minProcessingTime = bean.attributeValue("MinProcessingTime").toString.toLong
    def externalRedeliveries = bean.attributeValue("ExternalRedeliveries").toString.toLong
    def redeliveries = bean.attributeValue("Redeliveries").toString.toLong
    def failuresHandled = bean.attributeValue("FailuresHandled").toString.toLong

    def exchangesTotal = bean.attributeValue("ExchangesTotal").toString.toLong
    def exchangesFailedPercent = if (exchangesTotal == 0) 0 else exchangesFailed / exchangesTotal
    def exchangesFailed = bean.attributeValue("ExchangesFailed").toString.toLong
    def exchangesCompleted = bean.attributeValue("ExchangesCompleted").toString.toLong
    def exchangesCompletedPercent = if (exchangesTotal == 0) 0 else exchangesCompleted / exchangesTotal

    def inflightExchanges = bean.attributeValue("InflightExchanges").toString.toLong
    def state = bean.attributeValue("State").toString
    def endpointUri = bean.attributeValue("EndpointUri").toString
    def description = bean.attributeValue("Description").toString
    def isStatisticsEnabled = bean.attributeValue("IsStatisticsEnabled") == "true"
    def firstExchangeFailureExchangeId = bean.attributeValue("FirstExchangeFailureExchangeId").toString
    def firstExchangeFailureTimestamp = bean.attributeValue("FirstExchangeFailureTimestamp").toString.toLong
    def lastExchangeFailureExchangeId = bean.attributeValue("LastExchangeFailureExchangeId").toString
    def lastExchangeFailureTimestamp = bean.attributeValue("LastExchangeFailureTimestamp").toString.toLong
    def firstExchangeCompletedExchangeId = bean.attributeValue("FirstExchangeCompletedExchangeId").toString
    def firstExchangeCompletedTimestamp = bean.attributeValue("FirstExchangeCompletedTimestamp").toString.toLong

}
