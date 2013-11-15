package net.cojo.framework.backend;

import java.io.BufferedWriter;

import net.cojo.framework.network.Network;

public class ThreadedMessageSender extends Thread {

	public boolean isRunning = false;
	
	private BufferedWriter writer;
	
	public ThreadedMessageSender(Network network) {
		super ("Msg Sender: " + network.getName());
	}
	
	@Override
	public void run() {
		isRunning = true;
		
		while (isRunning) {
			
		}
	}

}
