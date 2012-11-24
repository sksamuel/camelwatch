package camelwatch.web;


import org.camelwatch.api.CamelBean;
import org.camelwatch.api.CamelConnection;
import org.camelwatch.api.CamelConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 19:02:59
 */
@Controller
@RequestMapping("errorHandler/{errorHandlerName}")
public class ErrorHandlerController {

    @Autowired
    private CamelConnectionFactory connectionFactory;

    @RequestMapping
    public String show(@PathVariable("errorHandlerName") String errorHandlerName, ModelMap map) throws Exception {
        CamelConnection conn = connectionFactory.getConnection();
        CamelBean errorHandler = conn.getErrorHandler(errorHandlerName);
        map.put("errorHandler", errorHandler);
        return "errorHandler";
    }
}
