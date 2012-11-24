package camelwatch.web;

import org.camelwatch.api.CamelBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * @author Stephen K Samuel samspade79@gmail.com 2 Jul 2012 12:08:39
 */
@Service
public class RestStyleUrlResolver implements UrlResolver, ServletContextAware {

    private ServletContext servletContext;


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public String getEndpointUrl(CamelBean bean) throws UnsupportedEncodingException {
        return servletContext.getContextPath() + "/endpoint/" + URLEncoder.encode(bean.getName(), "UTF-8");
    }
}
