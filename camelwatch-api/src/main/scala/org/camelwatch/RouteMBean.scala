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

    val exchangesTotal                   = bean.attributeValue("exchangesTotal").toString.toLong
    val camelId                          = bean.attributeValue("camelId").toString
    val routeId                          = bean.attributeValue("routeId").toString
    val load15                           = bean.attributeValue("load15").toString
    val load05                           = bean.attributeValue("load05").toString
    val load01                           = bean.attributeValue("load01").toString
    val lastExchangeCompletedExchangeId  = bean.attributeValue("lastExchangeCompletedExchangeId").toString
    val lastExchangeCompletedTimestamp   = bean.attributeValue("lastExchangeCompletedTimestamp").asInstanceOf[Date]
    val lastProcessingTime               = bean.attributeValue("lastProcessingTime").toString.toLong
    val totalProcessingTime              = bean.attributeValue("totalProcessingTime").toString.toLong
    val maxProcessingTime                = bean.attributeValue("maxProcessingTime").toString.toLong
    val meanProcessingTime               = bean.attributeValue("meanProcessingTime").toString.toLong
    val minProcessingTime                = bean.attributeValue("minProcessingTime").toString.toLong
    val externalRedeliveries             = bean.attributeValue("externalRedeliveries").toString.toLong
    val redeliveries                     = bean.attributeValue("redeliveries").toString.toLong
    val failuresHandled                  = bean.attributeValue("failuresHandled").toString.toLong
    val exchangesFailed                  = bean.attributeValue("exchangesFailed").toString.toLong
    val exchangesCompleted               = bean.attributeValue("exchangesCompleted").toString.toLong
    val inflightExchanges                = bean.attributeValue("inflightExchanges").toString.toLong
    val state                            = bean.attributeValue("state").toString
    val endpointUri                      = bean.attributeValue("endpointUri").toString
    val description                      = bean.attributeValue("description").toString
    val isStatisticsEnabled              = bean.attributeValue("isStatisticsEnabled") == "true"
    val firstExchangeFailureExchangeId   = bean.attributeValue("firstExchangeFailureExchangeId").toString
    val firstExchangeFailureTimestamp    = bean.attributeValue("firstExchangeFailureTimestamp").toString.toLong
    val lastExchangeFailureExchangeId    = bean.attributeValue("lastExchangeFailureExchangeId").toString
    val lastExchangeFailureTimestamp     = bean.attributeValue("lastExchangeFailureTimestamp").toString.toLong
    val firstExchangeCompletedExchangeId = bean.attributeValue("firstExchangeCompletedExchangeId").toString
    val firstExchangeCompletedTimestamp  = bean.attributeValue("firstExchangeCompletedTimestamp").toString.toLong

}
