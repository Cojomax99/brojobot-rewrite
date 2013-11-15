package net.cojo.framework.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.cojo.framework.network.Network;

public class ThreadedMessageReceiver extends Thread {

	public boolean isRunning = false;

	private BufferedReader reader;

	/** Network associated with this message receiver */
	private Network network;

	public ThreadedMessageReceiver(Network network) throws IOException {
		super ("Msg Receiver: " + network.getName());
		reader = new BufferedReader(new InputStreamReader(network.getSocketIStream()));
	}

	@Override
	public void run() {
		isRunning = true;

		while (isRunning) {
			try {
				StringBuilder line = null;
				while ((line = new StringBuilder(reader.readLine())) != null) {
					//TODO make new Message() actually do something, just a placeholder right now
					network.addInboundMessage(new Message(line.toString()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
