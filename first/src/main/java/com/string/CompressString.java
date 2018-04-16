package com.string;

public class CompressString {
	static String compress(String str) {
		int i = 1;
		int count = 1;
		StringBuilder stb = new StringBuilder();
		while (i < str.length()) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				count++;

			} else {
				if (count == 1) {
					stb.append(str.charAt(i - 1));
				} else {
					stb.append(str.charAt(i - 1)).append(count);
				}

				count = 1;

			}
			i++;
		}
		if (count != 1) {
			stb.append(str.charAt(i - 1)).append(count);
		} else {
			stb.append(str.charAt(i - 1));
		}

		return stb.toString();
	}

	static void uncompress(String str) {
		int i = 0;
		StringBuilder stb = new StringBuilder();
		while (i < str.length()) {
			char ch = str.charAt(i);
			if(!Character.isDigit(ch)) {
				
				System.out.print(ch);
			}else {
				
			}
           i++;
		}
	}

	public static void main(String[] args) {
		String str = "abbbbbbbbbbbbbbbbbbbcdeee ddee fdeff";
		System.out.println(compress(str));
		uncompress(compress(str));
//		char ch = '2';
//	
//       
//		
//		if (Character.isDigit(ch)) {
//			//System.out.println(ch);
//			System.out.println("sach");
//
//		}
	}

}
