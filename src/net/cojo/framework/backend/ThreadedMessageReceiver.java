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
		this.network = network;
		reader = new BufferedReader(new InputStreamReader(network.getSocketIStream(), "UTF8"));
	}

	@Override
	public void run() {
		isRunning = true;

		while (isRunning) {
			try {
				Thread.sleep(5L);
				StringBuilder line = null;
				while ((line = new StringBuilder(reader.readLine())) != null) {
					network.addInboundMessage(Message.createClientMessage(null, line.toString()));
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
