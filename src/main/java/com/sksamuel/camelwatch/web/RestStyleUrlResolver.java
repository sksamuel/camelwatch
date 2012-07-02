package com.sksamuel.camelwatch.web;

import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.sksamuel.camelwatch.CamelBean;

/**
 * @author Stephen K Samuel samspade79@gmail.com 2 Jul 2012 12:08:39
 * 
 */
@Service
public class RestStyleUrlResolver implements UrlResolver, ServletContextAware {

	private ServletContext	servletContext;

	@Override
	public String getEndpointUrl(CamelBean bean) {
		return servletContext.getContextPath() + "/endpoint/" + URLEncoder.encode(bean.getName());
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
