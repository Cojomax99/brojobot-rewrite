package net.cojo.framework.network;

import net.cojo.framework.user.UserData;

public class Network {

	/** User data instance */
	private UserData userData;
	
	public Network(UserData userData) {
		this.userData = userData;
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
