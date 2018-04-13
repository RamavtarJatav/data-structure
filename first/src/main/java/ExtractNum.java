
public class ExtractNum {
	static String unzip(String str) {
		int i = 0;
		int num = 0;
		boolean first = true;
		char prev = 0;
		StringBuilder stb = new StringBuilder();
		while (i < str.length()) {
			if (Character.isDigit(str.charAt(i))) {
				num = Character.getNumericValue((str.charAt(i))) + num * 10;
			} else {
				//System.out.println(num);
				int j = 0;
				if (!first) {
					if(num != 0)
					while (j < num ) {
						stb.append(prev);
						j++;
					}else {
						stb.append(prev);
					}
				}
				first = false;
				num = 0;
				prev = str.charAt(i);
			}
			i++;
		}
		int j = 0;

		while (j < num) {
			stb.append(prev);
			j++;
		}
		return stb.toString();
	}

	public static void main(String[] args) {

		String str = "md2l2mno4";
		System.out.println(unzip(str));
	}

}
