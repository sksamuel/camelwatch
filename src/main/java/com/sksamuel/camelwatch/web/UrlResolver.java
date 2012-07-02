package com.sksamuel.camelwatch.web;

import com.sksamuel.camelwatch.CamelBean;

/**
 * @author Stephen K Samuel samspade79@gmail.com 2 Jul 2012 12:08:18
 * 
 */
public interface UrlResolver {

	String getEndpointUrl(CamelBean bean);
}
