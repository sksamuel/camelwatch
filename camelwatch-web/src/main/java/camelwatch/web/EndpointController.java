package camelwatch.web;

import org.camelwatch.api.CamelBean;
import org.camelwatch.api.CamelConnection;
import org.camelwatch.api.CamelConnectionFactory;
import org.camelwatch.api.Message;
import org.camelwatch.api.endpoint.EndpointOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 19:02:59
 */
@Controller
@RequestMapping("endpoint")
public class EndpointController {

    private static final int MAX_OVERVIEW_MESSAGES = 15;
    @Autowired
    private CamelConnectionFactory connectionFactory;

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
    public Message browseMessageAsXml(@RequestParam("endpointName") String endpointName,
                                      @RequestParam("offset") int offset) throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        Message exchange = conn.getEndpointOperations(endpointName).browseMessageAsXml(offset, true);
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

    @RequestMapping(value = "message/{index}", method = RequestMethod.POST)
    public String message(@RequestParam("endpointName") String endpointName,
                          @PathVariable("index") int index,
                          ModelMap map) throws Exception {

        CamelConnection conn = connectionFactory.getConnection();
        EndpointOperations ops = conn.getEndpointOperations(endpointName);

        Message message = ops.browseMessageAsXml(index, true);
        map.put("message", message);

        return "message";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String show(@RequestParam("endpointName") String endpointName, ModelMap map) throws Exception {

        CamelConnection conn = connectionFactory.getConnection();
        EndpointOperations ops = conn.getEndpointOperations(endpointName);

        CamelBean endpoint = conn.getEndpoint(endpointName);
        long queueSize = ops.queueSize();
        endpoint.getProperties().put("queueSize()", queueSize);

        map.put("endpoint", endpoint);

        try {
            List<Message> messages = ops.browseRangeMessagesAsXml(0,
                    Math.min((int) queueSize, MAX_OVERVIEW_MESSAGES),
                    false);
            map.put("messages", messages);
        } catch (Exception e) {
        }

        return "endpoint";
    }
}
