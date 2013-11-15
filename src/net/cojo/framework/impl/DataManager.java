package net.cojo.framework.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;

import net.cojo.framework.user.UserData;
import net.cojo.framework.user.UserManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class DataManager {

	/** Gson instance */
	public static Gson gson;

	/** Singleton instance of DataManager */
	private static DataManager instance;

	private DataManager() {
		gson = new Gson();
	}

	/**
	 * DataManager singleton instance-getter thing
	 * @return DataManager singleton instance
	 */
	public static DataManager getInstance() {
		if (instance == null)
			instance = new DataManager();

		return instance;
	}

	/**
	 * Load the user info from the JSON file
	 * @param fileName Name of the file to load from
	 */
	public static void loadUserData (String fileName) {
		try {
			JsonReader reader = new JsonReader(new FileReader(fileName));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();

			for (JsonElement elem : array) {
				UserData info = gson.fromJson(elem, UserData.class);
				UserManager.userMap.put(info.getLocalName(), info);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Could not find or use file " + fileName + " !");
		}
	}
}
