package net.cojo.framework.user;

import net.cojo.framework.backend.Message;
import net.cojo.framework.network.Network;

public class User {

	/** UserData instance */
	private UserData userData;
	
	/** Network this user belongs to */
	private Network network;
	
	public User(UserData data) {
		this.userData = data;
		network = UserManager.networkMap.get(this);
	}
	
	public void processMessage(Message msg) {
		if (msg.getContents().startsWith("PING :")) {
			network.addOutboundMessage(Message.createClientMessage(null, String.format("PONG %s", msg.getContents().substring(6))));
		} else
			if (msg.getContents().startsWith("376")) {
				network.addOutboundMessage(Message.createClientMessage(null, "PRIVMSG nickserv :identify BrojoBot doop"));
			}
	}
	
	public UserData getUserData() {
		return this.userData;
	}

}
