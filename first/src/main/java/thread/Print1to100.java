package thread;

public class Print1to100 {
	static boolean flag = true;

	static class odd implements Runnable {

		public void run() {
			for (int i = 1; i <= 99; i++) {
				if (flag) {
					System.out.print(i + " ");
					flag = false;
				}

			}
			// TODO Auto-generated method stub
		}
	}

	static class even implements Runnable {

		public void run() {
			for (int i = 1; i <= 100; i++) {
				if (!flag) {
					System.out.print(i + " ");
					flag = true;
				}

			}
		}

	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new odd());
		Thread t2 = new Thread(new even());
		t1.start();
		t2.start();
	}
}
