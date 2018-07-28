package connectionpool;

public class Test {

	static class Producer implements Runnable {
		private Resource res = null;

		public Producer(final Resource res) {
			this.res = res;
		}

		public void run() {
			while (true) {
				try {

					res.add();
					Thread.sleep(6000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	static class Consumer implements Runnable {
		private Resource res = null;

		public Consumer(final Resource res) {
			this.res = res;
		}

		public void run() {
			while (true) {
				try {
					res.remove();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		Resource res = new Resource();
		Producer pro = new Producer(res);
		Consumer con = new Consumer(res);
		new Thread(pro, "Producer").start();
		;
		new Thread(con, "Consumer").start();
		;

	}

}
