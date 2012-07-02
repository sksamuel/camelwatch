package com.sksamuel.camelwatch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sksamuel.camelwatch.CamelBean;
import com.sksamuel.camelwatch.CamelConnection;
import com.sksamuel.camelwatch.CamelConnectionFactory;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 19:02:59
 * 
 */
@Controller
@RequestMapping("endpoint")
public class EndpointController {

	@Autowired
	private CamelConnectionFactory	connectionFactory;

	@RequestMapping(method = RequestMethod.POST)
	public String show(@RequestParam("endpointName") String endpointName, ModelMap map) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		CamelBean endpoint = conn.getEndpoint(endpointName);
		map.put("endpoint", endpoint);
		return "endpoint";
	}
}
