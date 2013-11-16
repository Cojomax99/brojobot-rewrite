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
		writer = new BufferedWriter(new OutputStreamWriter(network.getSocketOStream(), "UTF8"));
	}

	@Override
	public void run() {
		try {
			isRunning = true;

			while (isRunning) {
				Thread.sleep(5L);
				while (network.hasMessageToSend()) {
					writer.write(network.poll(EnumMessageType.SEND).toString());
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
