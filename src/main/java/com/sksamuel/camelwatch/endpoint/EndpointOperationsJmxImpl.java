package com.sksamuel.camelwatch.endpoint;

import java.io.StringReader;
import java.util.Collections;
import java.util.List;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.sksamuel.camelwatch.Message;
import com.sksamuel.camelwatch.MessageFactory;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 21:19:17
 * 
 */
public class EndpointOperationsJmxImpl implements EndpointOperations {

	private final MBeanServerConnection	conn;
	private final ObjectInstance		instance;
	private final MBeanInfo			info;

	public EndpointOperationsJmxImpl(MBeanServerConnection conn, ObjectInstance instance, String consumerId,
			MBeanInfo info) {
		this.conn = conn;
		this.instance = instance;
		this.info = info;
	}

	@Override
	public String browseExchange(int offset) throws Exception {
		Object result = conn.invoke(instance.getObjectName(),
				"browseExchange",
				new Object[] { offset },
				new String[] { "java.lang.Integer" });
		return (String) result;
	}

	@Override
	public Message browseMessageAsXml(int offset, boolean includeBody) throws Exception {
		String result = (String) conn.invoke(instance.getObjectName(),
				"browseMessageAsXml",
				new Object[] { offset },
				new String[] { "java.lang.Integer" });
		if (result == null)
			return null;
		Document doc = new SAXBuilder().build(new StringReader(result));
		Element root = doc.getRootElement();
		return new MessageFactory().build(root);
	}

	@Override
	public String browseMessageBody(int offset) throws Exception {
		Object result = conn.invoke(instance.getObjectName(),
				"browseMessageBody",
				new Object[] { offset },
				new String[] { "java.lang.Integer" });
		return (String) result;
	}

	@Override
	public List<Message> browseRangeMessagesAsXml(int offset, int end, boolean includeBody) throws Exception {

		String result = (String) conn.invoke(instance.getObjectName(), "browseRangeMessagesAsXml", new Object[] {
				offset, end, includeBody }, new String[] { "java.lang.Integer", "java.lang.Integer",
				"java.lang.Boolean" });
		if (result == null)
			return Collections.EMPTY_LIST;
		Document doc = new SAXBuilder().build(new StringReader(result));
		List<Message> results = new MessageFactory().buildList(doc);
		return results;
	}

	@Override
	public long queueSize() throws Exception {
		try {
			Object result = conn.invoke(instance.getObjectName(), "queueSize", new Object[0], new String[0]);
			return (Long) result;
		} catch (Exception e) {
			return 0;
		}
	}

}
