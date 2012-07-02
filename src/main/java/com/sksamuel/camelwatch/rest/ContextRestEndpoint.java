package com.sksamuel.camelwatch.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sksamuel.camelwatch.CamelBean;
import com.sksamuel.camelwatch.CamelConnectionFactory;

/**
 * @author Stephen K Samuel samspade79@gmail.com 2 Jul 2012 10:09:57
 * 
 */
@Controller
public class ContextRestEndpoint {

	@Autowired
	private CamelConnectionFactory	connectionFactory;

	@RequestMapping(value = "/rest/context", method = RequestMethod.GET)
	@ResponseBody
	public List<CamelBean> getConsumer() throws Exception {
		return connectionFactory.getConnection().getContexts();
	}

	@RequestMapping(value = "/rest/context/{camelId}", method = RequestMethod.GET)
	@ResponseBody
	public CamelBean getConsumer(@PathVariable("camelId") String camelId) throws Exception {
		return connectionFactory.getConnection().getContext(camelId);
	}
}
