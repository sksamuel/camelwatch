package com.sksamuel.camelwatch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("browseExchange")
	@ResponseBody
	public String
			browseExchange(@RequestParam("endpointName") String endpointName, @RequestParam("offset") int offset)
					throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		String exchange = conn.getEndpointOperations(endpointName).browseExchange(offset);
		return exchange;
	}

	@RequestMapping("browseMessageAsXml")
	@ResponseBody
	public String browseMessageAsXml(@RequestParam("endpointName") String endpointName,
			@RequestParam("offset") int offset) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		String exchange = conn.getEndpointOperations(endpointName).browseMessageAsXml(offset);
		return exchange;
	}

	@RequestMapping("browseMessageBody")
	@ResponseBody
	public String browseMessageBody(@RequestParam("endpointName") String endpointName,
			@RequestParam("offset") int offset) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		String exchange = conn.getEndpointOperations(endpointName).browseMessageBody(offset);
		return exchange;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String show(@RequestParam("endpointName") String endpointName, ModelMap map) throws Exception {

		CamelConnection conn = connectionFactory.getConnection();

		CamelBean endpoint = conn.getEndpoint(endpointName);
		long queueSize = conn.getEndpointOperations(endpointName).queueSize();
		endpoint.getProperties().put("queueSize()", queueSize);

		map.put("endpoint", endpoint);
		return "endpoint";
	}
}
