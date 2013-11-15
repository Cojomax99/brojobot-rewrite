package net.cojo.framework.user;

/**
 * Simple class to store and retrieve user data using Gson
 * @author Cojo
 *
 */
public class UserData {

	/** Name used to identify this user in the map */
	private String localName;
	
	/** Username associated with user */
	private String userName;
	
	/** Real name of the user */
	private String realName;
	
	/** Nick the user goes by */
	private String nickName;
	
	/** Version */
	private String version;
	
	/** Hostname of the server to connect to */	
	private String hostname;
	
	/** Port number to connect to on the network */
	private int port;
	
	public UserData() {
		
	}

	/**
	 * @return the localName
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * @param localName the localName to set
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

}
