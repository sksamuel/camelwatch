package com.sksamuel.camelwatch.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author amir
 * 
 */
@Service
public class GlobalModelAttributesInterceptor extends HandlerInterceptorAdapter {

	private static final Logger	logger	= LoggerFactory.getLogger(GlobalModelAttributesInterceptor.class);

	@Autowired
	private UrlResolver		urlResolver;

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception {
		modelAndView.getModel().put("urlResolver", urlResolver);
	}

}
