package com.sksamuel.camelwatch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sksamuel.camelwatch.CamelConnection;
import com.sksamuel.camelwatch.CamelConnectionFactory;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:47:18
 * 
 */
@Controller
public class ManagerController {

	@Autowired
	private CamelConnectionFactory	connectionFactory;

	@RequestMapping("/")
	public String list(ModelMap map) throws Exception {

		CamelConnection conn = connectionFactory.getConnection();

		map.put("routes", conn.getRoutes());
		map.put("consumers", conn.getConsumers());
		map.put("contexts", conn.getContexts());
		map.put("endpoints", conn.getEndpoints());
		map.put("errorhandlers", conn.getErrorHandlers());

		return "manager";
	}
}
