package elevator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Logger;

public class Connector {

	public final static Logger LOGGER = Logger.getLogger(Connector.class.getName());
	private class Receiver extends NetworkStageThread {
		
		private int receiverPacketSize = 2048;
		private DatagramSocket socket;
		private DatagramPacket datagram;
		private int size;

		private Receiver(String name) {
			super(name);
			this.size = receiverPacketSize;
			this.datagram = new DatagramPacket(new byte[size], size);
		}

		protected void work() throws IOException {
			datagram.setLength(size);
			socket.receive(datagram);
			if (LOGGER.isLoggable(Level.FINER)) {
				LOGGER.log(Level.FINER, "UDPConnector ({0}) received {1} bytes from {2}:{3}",
						new Object[] { socket.getLocalSocketAddress(), datagram.getLength(), datagram.getAddress(),
								datagram.getPort() });
			}
			byte[] bytes = Arrays.copyOfRange(datagram.getData(), datagram.getOffset(), datagram.getLength());
			RawData msg = new RawData(bytes, datagram.getAddress(), datagram.getPort());

			receiver.receiveData(msg);
		}

	}

	static final ThreadGroup ELEMENTS_THREAD_GROUP = new ThreadGroup("Californium/Elements"); //$NON-NLS-1$

	private abstract class NetworkStageThread extends Thread {

		/**
		 * Instantiates a new worker.
		 *
		 * @param name
		 *            the name
		 */
		protected NetworkStageThread(String name) {
			super(ELEMENTS_THREAD_GROUP, name);
			setDaemon(true);
		}

		public void run() {

			while (true) {
				try {
					work();
				} catch (Throwable t) {

				}
			}
		}

		/**
		 * @throws Exception
		 *             the exception to be properly logged
		 */
		protected abstract void work() throws Exception;
	}

}
