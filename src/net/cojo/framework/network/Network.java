package net.cojo.framework.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import net.cojo.framework.backend.Message;
import net.cojo.framework.backend.MessageDispatcher;
import net.cojo.framework.user.UserData;

public class Network {

	/** User data instance */
	private UserData userData;
	
	/** Socket that connects to the proper host/port */
	private Socket socket;
	
	public Network(UserData userData) throws UnknownHostException, IOException {
		this.userData = userData;
		this.socket = new Socket(userData.getHostname(), userData.getPort());
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
		return this.userData;
	}
	
	/**
	 * 
	 * @return Name of the network to display
	 */
	public String getName() {
		return this.userData.getLocalName();
	}
	
	/**
	 * Called when a message is intended to be sent to the server
	 * @param msg Message to be added to the outbound message map
	 * @return Whether the message was successfully added to the map
	 */
	public boolean addOutboundMessage(Message msg) {
		return MessageDispatcher.outboundMessageMap.get(getName()).offer(msg);
	}
	
	/**
	 * Called when a message is received from the server
	 * @param msg Message that was received
	 * @return Whether the message was successfully added to the map
	 */
	public boolean addInboundMessage(Message msg) {
		return MessageDispatcher.inboundMessageMap.get(getName()).offer(msg);
	}
	
	/**
	 * Are there any messages left to go outbound?
	 * @return Is there anything in the outbound message queue?
	 */
	public boolean hasMessage() {
		return !MessageDispatcher.outboundMessageMap.get(getName()).isEmpty();
	}
	
	/**
	 * Peek at the next message to be sent
	 * @return The next message to be sent if there is one, null otherwise
	 */
	public Message peek() {
		return hasMessage() ? MessageDispatcher.outboundMessageMap.get(getName()).peek() : null;
	}
	
	/**
	 * Poll the next message to be sent
	 * @return The next message to be sent if there is one, null otherwise
	 */
	public Message sendMessage() {
		return hasMessage() ? MessageDispatcher.outboundMessageMap.get(getName()).poll() : null;
	}
}
