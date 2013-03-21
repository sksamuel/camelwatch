package org.camelwatch.api;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.management.MBeanInfo;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.IOException;
import java.util.Map;

/**
 * @author Stephen K Samuel samspade79@gmail.com 29 Jun 2012 00:49:09
 */
@Service
public class CamelConnectionFactory {

    @Value("${jmx.endpoint.url}")
    private String url;

    @Value("${jmx.endpoint.username}")
    private String username;

    @Value("${jmx.endpoint.password}")
    private String password;

    private final Map<ObjectName, MBeanInfo> beanInfoCache = Maps.newHashMap();

    public CamelConnection getConnection() throws MalformedObjectNameException, NullPointerException, IOException {
        return new CamelJmxConnection(url, username, password, beanInfoCache);
    }

    public CamelConnection getConnection(String url, String username, String password) throws MalformedObjectNameException, NullPointerException, IOException {
        Map<ObjectName, MBeanInfo> beanInfoCache = Maps.newHashMap() ;
        return new CamelJmxConnection(url, username, password, beanInfoCache);
    }
}
