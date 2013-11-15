package net.cojo.framework.backend;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageManager {

	/**
	 * Concurrent data structure to map a network id to a queue of messages associated with it, not sure whether this is
	 * more memory efficient than having a unique ConcurrentLinkedQueue in every network class...this may come in handy though!
	 */
	public static ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> outboundMessageMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>>();
	
	public static ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> inboundMessageMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>>();
}
