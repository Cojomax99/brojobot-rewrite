package net.cojo.framework.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import net.cojo.framework.backend.EnumMessageType;
import net.cojo.framework.backend.Message;
import net.cojo.framework.backend.MessageDispatchManager;
import net.cojo.framework.user.User;
import net.cojo.framework.user.UserData;

public class Network {

	/** User associated with this network */
	private User user;
	
	/** Socket that connects to the proper host/port */
	private Socket socket;
	
	private Network(User user) throws UnknownHostException, IOException {
		this.user = user;
		user.setNetwork(this);
		this.socket = new Socket(user.getUserData().getHostname(), user.getUserData().getPort());
	}
	
	public static Network createNetwork(User user) throws UnknownHostException, IOException {
		return new Network(user);
	}
	
	public OutputStream getSocketOStream() throws IOException {
		return socket.getOutputStream();
	}
	
	public InputStream getSocketIStream() throws IOException {
		return socket.getInputStream();
	}

	/**
	 * @return UserData instance
	 */
	public UserData getUserData() {
		return this.user.getUserData();
	}
	
	/**
	 * 
	 * @return Name of the network to display
	 */
	public String getName() {
		return this.user.getUserData().getLocalName();
	}
	
	/**
	 * Called when a message is intended to be sent to the server
	 * @param msg Message to be added to the outbound message map
	 * @return Whether the message was successfully added to the map
	 */
	public boolean addOutboundMessage(Message msg) {
		return MessageDispatchManager.outboundMessageMap.get(getName()).offer(msg);
	}
	
	/**
	 * Called when a message is received from the server
	 * @param msg Message that was received
	 * @return Whether the message was successfully added to the map
	 */
	public boolean addInboundMessage(Message msg) {
		return MessageDispatchManager.inboundMessageMap.get(getName()).offer(msg);
	}
	
	/**
	 * Are there any messages left to go outbound?
	 * @return Is there anything in the outbound message queue?
	 */
	public boolean hasMessageToSend() {
		return MessageDispatchManager.outboundMessageMap.get(getName()) != null || !MessageDispatchManager.outboundMessageMap.get(getName()).isEmpty();
	}
	
	/**
	 * Are there any messages left to be processed?
	 * @return Is there anything left in the to-be-processed message queue?
	 */
	public boolean hasMessageToProcess() {
		return MessageDispatchManager.inboundMessageMap.get(getName()) != null || !MessageDispatchManager.inboundMessageMap.get(getName()).isEmpty();
	}
	
	/**
	 * Peek at the next message to be sent
	 * @return The next message to be sent if there is one, null otherwise
	 */
	public Message peek(EnumMessageType type) {
		return hasMessageToSend() ? MessageDispatchManager.outboundMessageMap.get(getName()).peek() : null;
	}
	
	/**
	 * Poll the next message to be sent
	 * @return The next message to be sent if there is one, null otherwise
	 */
	public Message poll(EnumMessageType type) {
		switch(type) {
		case PROCESS:
			return hasMessageToProcess() ? MessageDispatchManager.inboundMessageMap.get(getName()).poll() : null;
		case SEND:
			return hasMessageToSend() ? MessageDispatchManager.outboundMessageMap.get(getName()).poll() : null;
		}
		
		return null;
	}
	
	public void processMessage(Message msg) {
		this.user.processMessage(msg);
	}
}
