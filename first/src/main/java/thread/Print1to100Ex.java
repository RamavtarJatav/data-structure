package thread;

public class Print1to100Ex {
	static int at = 1;

	static abstract class Thr implements Runnable {

		public void run() {

			// synchronized (this) {
			work();

			// }

		}

		public abstract void work();

	}

	static class Thr1 extends Thr {

		@Override
		public void work() {
			while (at <= 100) {
				if (at % 3 == 0) {
					System.out.println(at);
					at++;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	static class Thr2 extends Thr {

		@Override
		public void work() {
			while (at <= 100) {

				if (at % 3 == 1) {
					System.out.println(at);
					at++;
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	static class Thr3 extends Thr {

		@Override
		public void work() {
			while (at <= 100) {

				if (at % 3 == 2) {
					System.out.println(at);
					at++;
				}
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	public static void main(String[] args) {
		int at = 1;
		Thr t1 = new Thr1();
		Thr t2 = new Thr2();
		Thr t3 = new Thr3();
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();

	}

	// static abstract class Thr implements Runnable {
	// AtomicInteger at;
	//
	// Thr(AtomicInteger at) {
	// this.at = at;
	// }
	//
	// public void run() {
	//
	// synchronized (this) {
	// work();
	//
	// }
	//
	// }
	//
	// public abstract void work();
	//
	// }
	//
	// static class Thr1 extends Thr {
	//
	// Thr1(AtomicInteger at) {
	// super(at);
	// // TODO Auto-generated constructor stub
	// }
	//
	// @Override
	// public void work() {
	// while (at.get() <= 100) {
	// if (at.get() % 3 == 0) {
	// System.out.println(at.get());
	// at.incrementAndGet();
	// }
	//
	// }
	//
	// }
	//
	// }
	//
	// static class Thr2 extends Thr {
	//
	// Thr2(AtomicInteger at) {
	// super(at);
	// // TODO Auto-generated constructor stub
	// }
	//
	// @Override
	// public void work() {
	// while (at.get() < 100) {
	//
	// if (at.get() % 3 == 1) {
	// System.out.println(at.get());
	// at.incrementAndGet();
	// }
	//
	// }
	// }
	//
	// }
	//
	//
	// static class Thr3 extends Thr {
	//
	// Thr3(AtomicInteger at) {
	// super(at);
	// // TODO Auto-generated constructor stub
	// }
	//
	// @Override
	// public void work() {
	// while (at.get() < 100) {
	//
	// if (at.get() % 3 == 2) {
	// System.out.println(at.get());
	// at.incrementAndGet();
	// }
	//
	// }
	// }
	//
	// }
	//
	//
	//
	// public static void main(String[] args) {
	// AtomicInteger at = new AtomicInteger(1);
	// Thr t1 = new Thr1(at);
	// Thr t2 = new Thr2(at);
	// Thr t3 = new Thr3(at);
	// new Thread(t1).start();
	// new Thread(t2).start();
	// new Thread(t3).start();
	//
	// }

	// ExecutorService executor;
	//
	// public void print(Runnable run) {
	// executor.execute(run);
	//
	// }
	//
	// Print1to100Ex(ExecutorService executor) {
	// this.executor = executor;
	// }
	//
	// public static void main(String[] args) {
	// ExecutorService executor = Executors.newSingleThreadExecutor();
	// Print1to100Ex pr = new Print1to100Ex(executor);
	//
	// for (int i = 0; i <= 100; i++) {
	//
	// pr.print(new Thr(i));
	//
	// }
	// }
	//
	// static class Thr implements Runnable {
	// int i = 0;
	//
	// Thr(int i) {
	// this.i = i;
	// }
	//
	// public void run() {
	// // TODO Auto-generated method stub
	// System.out.println(i);
	//
	// }
	//
	// }

}
