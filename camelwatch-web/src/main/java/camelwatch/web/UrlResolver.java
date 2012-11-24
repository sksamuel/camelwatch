package camelwatch.web;


import org.camelwatch.api.CamelBean;

import java.io.UnsupportedEncodingException;

/**
 * @author Stephen K Samuel samspade79@gmail.com 2 Jul 2012 12:08:18
 */
public interface UrlResolver {

    String getEndpointUrl(CamelBean bean) throws UnsupportedEncodingException;
}
