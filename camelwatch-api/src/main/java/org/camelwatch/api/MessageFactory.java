package org.camelwatch.api;

import com.google.common.collect.Lists;
import org.jdom2.Document;
import org.jdom2.Element;

import java.util.List;

/**
 * @author Stephen K Samuel samspade79@gmail.com 3 Jul 2012 14:51:01
 * 
 */
public class MessageFactory {

	public Message build(Element e) {
		Message m = new Message();
		m.setExchangeId(e.getAttributeValue("exchangeId"));
		Element headers = e.getChild("headers");
		if (headers != null) {
			for (Element header : headers.getChildren("header")) {
				m.getHeaders().put(header.getAttributeValue("key"), header.getTextTrim());
			}
		}
		Element body = e.getChild("body");
		if (body != null) {
			m.setBody(body.getTextTrim());
			m.setBodyType(body.getAttributeValue("type"));
		}
		return m;
	}

	public List<Message> buildList(Document doc) {
		List<Message> results = Lists.newArrayList();
		for (Element messageElement : doc.getRootElement().getChildren("message")) {
			results.add(build(messageElement));
		}
		return results;
	}

}
