package net.cojo.framework.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
}
