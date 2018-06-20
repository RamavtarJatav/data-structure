package permutation;

public class AllCombination {
	static void permutation(String data) {
		char[] cA = data.toCharArray();
		int cAl = cA.length;
		for (int j = 0; j < cAl; j++) {
			int i = 0;
			while( i  < cAl-1) {
				if (cA[i] != cA[i + 1]) {
					char temp = cA[i];
					cA[i] = cA[i + 1];
					cA[i + 1] = temp;
					System.out.print(String.valueOf(cA) + " ");
				}
				i++;
			}
		}

	}

	public static void main(String[] args) {
		String data = "DDDA";
		permutation(data);
	}

}
