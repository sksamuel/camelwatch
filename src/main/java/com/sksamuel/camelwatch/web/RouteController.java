package com.sksamuel.camelwatch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sksamuel.camelwatch.CamelConnection;
import com.sksamuel.camelwatch.CamelConnectionFactory;
import com.sksamuel.camelwatch.Route;
import com.sksamuel.camelwatch.RouteOperations;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 19:02:59
 * 
 */
@Controller
@RequestMapping("route/{routeId}")
public class RouteController {

	@Autowired
	private CamelConnectionFactory	connectionFactory;

	String getRedirect(Route route) {
		return getRedirect(route.getRouteId());
	}

	String getRedirect(String routeId) {
		return "redirect:/";
	}

	@RequestMapping("remove")
	public String remove(@PathVariable("routeId") String routeId) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.remove();
		return getRedirect(routeId);
	}

	@RequestMapping("reset")
	public String reset(@PathVariable("routeId") String routeId) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.reset();
		return getRedirect(routeId);
	}

	@RequestMapping("resume")
	public String resume(@PathVariable("routeId") String routeId) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.resume();
		return getRedirect(routeId);
	}

	@RequestMapping
	public String show(@PathVariable("routeId") String routeId,
			ModelMap map,
			@RequestParam(value = "message", required = false) String message) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		Route route = conn.getRoute(routeId);
		map.put("route", route);
		map.put("message", message);
		return "route";
	}

	@RequestMapping("shutdown")
	public String shutdown(@PathVariable("routeId") String routeId) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.shutdown();
		return getRedirect(routeId);
	}

	@RequestMapping("start")
	public String start(@PathVariable("routeId") String routeId, ModelMap map) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.start();
		map.put("message", "Route '" + routeId + "' started");
		return getRedirect(routeId);
	}

	@RequestMapping("stop")
	public String stop(@PathVariable("routeId") String routeId, ModelMap map) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.stop();
		map.put("message", "Route '" + routeId + "' stopped");
		return getRedirect(routeId);
	}

	@RequestMapping("suspend")
	public String suspend(@PathVariable("routeId") String routeId) throws Exception {
		CamelConnection conn = connectionFactory.getConnection();
		RouteOperations routeOps = conn.getRouteOperations(routeId);
		routeOps.suspend();
		return getRedirect(routeId);
	}
}
