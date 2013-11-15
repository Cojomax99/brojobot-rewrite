package net.cojo.framework.backend;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import net.cojo.framework.network.Network;

public class ThreadedMessageSender extends Thread {

	public boolean isRunning = false;
	
	private BufferedWriter writer;
	
	public ThreadedMessageSender(Network network) throws IOException {
		super ("Msg Sender: " + network.getName());
		writer = new BufferedWriter(new OutputStreamWriter(network.getSocketOStream()));
	}
	
	@Override
	public void run() {
		isRunning = true;
		
		while (isRunning) {
			
		}
	}

}
