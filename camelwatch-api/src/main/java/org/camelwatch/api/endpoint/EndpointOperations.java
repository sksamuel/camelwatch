package org.camelwatch.api.endpoint;

import java.util.List;

import org.camelwatch.api.Message;

/**
 * @author Stephen K Samuel samspade79@gmail.com 1 Jul 2012 16:50:27
 * 
 */
public interface EndpointOperations {

	String browseExchange(int offset) throws Exception;

	Message browseMessageAsXml(int offset, boolean includeBody) throws Exception;

	String browseMessageBody(int offset) throws Exception;

	List<Message> browseRangeMessagesAsXml(int offset, int end, boolean includeBody) throws Exception;

	long queueSize() throws Exception;
}
