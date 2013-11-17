package net.cojo.framework.brojo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import net.cojo.framework.backend.ThreadedMessageProcessor;
import net.cojo.framework.backend.ThreadedMessageReceiver;
import net.cojo.framework.backend.ThreadedMessageSender;
import net.cojo.framework.impl.DataManager;
import net.cojo.framework.user.UserManager;

public class BrojoBot {

	private ThreadedMessageReceiver receiver;
	
	private ThreadedMessageSender sender;
	
	private ThreadedMessageProcessor processor;
	
	public BrojoBot() throws IOException {
		receiver = new ThreadedMessageReceiver(UserManager.networkMap.get(UserManager.userMap.get("brojo")));
		sender = new ThreadedMessageSender(UserManager.networkMap.get(UserManager.userMap.get("brojo")));
		processor = new ThreadedMessageProcessor(UserManager.networkMap.get(UserManager.userMap.get("brojo")));
		
		receiver.start();
		processor.start();
		sender.start();
	}

	public static void main(String[] args) throws IOException {
		DataManager.getInstance().loadUserData("brojo.json");
		
		BrojoBot brojo = new BrojoBot();
		
		
	}

}
