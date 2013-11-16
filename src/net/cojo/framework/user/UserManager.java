package net.cojo.framework.user;

import java.util.HashMap;
import java.util.Map;

import net.cojo.framework.network.Network;

public class UserManager {

	/** Map of users' names...to them */
	public static Map<String, User> userMap = new HashMap<String, User>();
	
	public static Map<User, Network> networkMap = new HashMap<User, Network>();

}
