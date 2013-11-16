package net.cojo.framework.backend;

public class Message {

	/** Raw string */
	private String raw;

	/** Server, Client, or Channel sending the message */
	private String sender;

	/** Channel, or Client receiving the message */
	private String recipient;

	/** The message delimited on a certain char */
	private String params;

	/** Contents of the message the the channel/client sees */
	private String contents;
	
	/** Signify that this message should be sent directly to the server */
	private static final String SERVER = null;
	
	public static Message createClientMessage(String recipient, String contents) {
		return new Message(SERVER, recipient, contents);
	}
	
	public static Message createServerMessage(String sender, String recipient, String contents) {
		return new Message(sender, recipient, contents);
	}
	
	private Message (String raw, String sender, String recipient, String contents) {
		this (sender, recipient, contents);
		this.raw = raw;
	}

	private Message(String sender, String recipient, String contents) {
		this.sender = sender;
		this.recipient = recipient;
		this.contents = contents;
	}
		
	private Message(String recipient, String contents) {
		this.recipient = recipient;
		this.contents = contents;
	}

	public static Message createMessageFromRaw(String serverMsg) {
		return new Message(serverMsg.split("PRIVMSG")[0].split("!")[0].substring(1), 
				serverMsg.split("PRIVMSG")[1].split(" :")[0].substring(1), 
				serverMsg.split(serverMsg.split("PRIVMSG")[1].split(" :")[0].substring(1) + " :", 2)[1]);
	}

	@Override
	public String toString() {
		StringBuilder command = new StringBuilder();
		if (sender != null) {
			command.append(":").append(sender).append(" ");
		}

		if (recipient != null) {
			command.append("PRIVMSG ");
			command.append(recipient).append(" ");
			command.append(":").append(contents).append("\n");
		} else {
			command.append(contents).append("\n");
		}			

		return command.toString();
	}
	
	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}
}
