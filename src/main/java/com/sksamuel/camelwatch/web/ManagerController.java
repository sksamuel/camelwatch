package com.sksamuel.camelwatch.web;

import java.io.IOException;
import java.util.List;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sksamuel.camelwatch.CamelConnection;
import com.sksamuel.camelwatch.CamelConnectionFactory;
import com.sksamuel.camelwatch.Endpoint;
import com.sksamuel.camelwatch.Route;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:47:18
 * 
 */
@Controller
public class ManagerController {

	@Autowired
	private CamelConnectionFactory	connector;

	@RequestMapping("manager")
	public String list(ModelMap map) throws InstanceNotFoundException, IntrospectionException, MalformedObjectNameException,
			ReflectionException, NullPointerException, MBeanException, IOException {

		CamelConnection conn = connector.getConnection();

		List<Route> routes = conn.getRoutes();
		map.put("routes", routes);

		List<Endpoint> endpoints = conn.getEndpoints();
		map.put("endpoints", endpoints);

		return "views/manager";
	}
}
