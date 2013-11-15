package net.cojo.framework.backend;

import java.io.BufferedReader;

import net.cojo.framework.network.Network;

public class ThreadedMessageReceiver extends Thread {

	public boolean isRunning = false;
	
	private BufferedReader reader;
	
	public ThreadedMessageReceiver(Network network) {
		super ("Msg Receiver: " + network.getName());
	}
	
	@Override
	public void run() {
		isRunning = true;
		
		while (isRunning) {
			
		}
	}

}
