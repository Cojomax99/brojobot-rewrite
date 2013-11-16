package net.cojo.framework.backend;

import net.cojo.framework.network.Network;

public class ThreadedMessageProcessor extends Thread {

	/** Is this thread currently running? */
	public boolean isRunning = false;

	/** Network associated with this message processor */
	private Network network;

	public ThreadedMessageProcessor(Network network) {
		this.network = network;
	}

	@Override
	public void run() {
		isRunning = true;

		while (isRunning) {
			try {
				Thread.sleep(8L);

				if (network.hasMessageToProcess()) {
					network.processMessage(network.poll(EnumMessageType.PROCESS));
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
