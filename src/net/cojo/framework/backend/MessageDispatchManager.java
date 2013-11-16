package net.cojo.framework.backend;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageDispatchManager {

	/**
	 * Concurrent data structure to map a network id to a queue of messages associated with it, not sure whether this is
	 * more memory efficient than having a unique ConcurrentLinkedQueue in every network class...this may come in handy though!
	 */
	public static ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> outboundMessageMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>>();
	
	/**
	 * Map containing network mapped to the messages that are coming in from the server
	 */
	public static ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> inboundMessageMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>>();
	
	/**
	 * Map containing network mapped to the messages that are queued to be processed
	 */
//	public static ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>> toBeProcessedMessageMap = new ConcurrentHashMap<String, ConcurrentLinkedQueue<Message>>();
}
