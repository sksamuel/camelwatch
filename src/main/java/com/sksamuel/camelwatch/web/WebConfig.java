package com.sksamuel.camelwatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Stephen K Samuel samspade79@gmail.com 25 Mar 2012 20:49:26
 * 
 */

@Configuration
public class WebConfig extends WebMvcConfigurationSupport implements ApplicationListener<ContextRefreshedEvent> {

	protected static final Logger	logger	= LoggerFactory.getLogger(WebConfig.class);

	@Override
	protected void addFormatters(FormatterRegistry registry) {
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

	}

	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping rm = super.requestMappingHandlerMapping();
		rm.setUseSuffixPatternMatch(false);
		return rm;
	}

}