package net.cojo.framework.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.cojo.framework.network.Network;

public class ThreadedMessageReceiver extends Thread {

	public boolean isRunning = false;
	
	private BufferedReader reader;
	
	public ThreadedMessageReceiver(Network network) throws IOException {
		super ("Msg Receiver: " + network.getName());
		reader = new BufferedReader(new InputStreamReader(network.getSocketIStream()));
	}
	
	@Override
	public void run() {
		isRunning = true;
		
		while (isRunning) {
			
		}
	}

}
