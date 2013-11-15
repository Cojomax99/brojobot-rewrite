package net.cojo.framework.backend;

public class Message {

	/** Raw string */
	private String raw;
	
	/** Server, Client, or Channel sending the message */
	private String sender;
	
	/** Channel, or Client receiving the message */
	private String receiver;
	
	/** The message delimited on a certain char */
	private String params;
	
	/** Contents of the message the the channel/client sees */
	private String contents;
	
	public Message() {}
	
	public Message(String raw) {
	}

}
