package dynamicProgramming;

public class UglyNumber {

	public static void main(String[] args) {
		int n = 10;
		int i = 2;
		int c = 1;
		System.out.print(1 + " ");
		while (c < 2) {
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
				c++;
				System.out.print( i + " ");
			}
			i++;

		}
	}
}
