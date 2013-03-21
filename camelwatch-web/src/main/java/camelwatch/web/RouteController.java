package camelwatch.web;


import org.camelwatch.api.CamelBean;
import org.camelwatch.api.CamelConnection;
import org.camelwatch.api.CamelConnectionFactory;
import org.camelwatch.api.route.RouteOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 19:02:59
 */
@Controller
@RequestMapping("route/{routeId}")
public class RouteController {

    @Autowired
    private CamelConnectionFactory connectionFactory;

    @RequestMapping(value = "dump", produces = MediaType.TEXT_XML_VALUE)
    @ResponseBody
    public String dump(@PathVariable("routeId") String routeId) throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        RouteOperations routeOps = conn.getRouteOperations(routeId);
        String xml = routeOps.dumpRouteAsXml();
        return xml;
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
        RouteOperations ops = conn.getRouteOperations(routeId);
        CamelBean route = conn.getRoute(routeId);
        map.put("route", route);
        map.put("message", message);
        map.put("processors", conn.getProcessors(routeId));
        map.put("xml", ops.dumpRouteAsXml());
        return "route";
    }

    @RequestMapping("start")
    public String start(@PathVariable("routeId") String routeId, ModelMap map) throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        RouteOperations routeOps = conn.getRouteOperations(routeId);
        routeOps.start();
        map.put("message", "ErrorHandler '" + routeId + "' started");
        return getRedirect(routeId);
    }

    @RequestMapping("stop")
    public String stop(@PathVariable("routeId") String routeId, ModelMap map) throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        RouteOperations routeOps = conn.getRouteOperations(routeId);
        routeOps.stop();
        map.put("message", "ErrorHandler '" + routeId + "' stopped");
        return getRedirect(routeId);
    }

    @RequestMapping("suspend")
    public String suspend(@PathVariable("routeId") String routeId) throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        RouteOperations routeOps = conn.getRouteOperations(routeId);
        routeOps.suspend();
        return getRedirect(routeId);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateRouteFromXml(@PathVariable("routeId") String routeId, @RequestParam("xml") String xml)
            throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        RouteOperations routeOps = conn.getRouteOperations(routeId);
        routeOps.updateRouteFromXml(xml);
        return getRedirect(routeId);
    }
}
