package net.cojo.framework.backend;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import net.cojo.framework.network.Network;

public class ThreadedMessageSender extends Thread {

	public boolean isRunning = false;
	
	private BufferedWriter writer;
	
	private Network network;
	
	public ThreadedMessageSender(Network network) throws IOException {
		super ("Msg Sender: " + network.getName());
		this.network = network;
		writer = new BufferedWriter(new OutputStreamWriter(network.getSocketOStream()));
	}
	
	@Override
	public void run() {
		isRunning = true;
		
		while (isRunning) {
			while (network.hasMessage()) {
				try {
					writer.write(network.sendMessage().toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
