package com.string;

public class Trim {
	static String trim(String str) {
		int l =str.length()-1;
		while(l >= 0 ) {
			if(str.charAt(l) != ' ') {
				break;
			}
			l--;
		}
		int f = 0;
		while( f < l) {
			if(str.charAt(f) != ' '){
				break;
			}
			f++;
		}
		StringBuilder stb = new StringBuilder();
		while(f <= l) {
			stb.append(str.charAt(f));
			f++;	
		}
		return stb.toString();
	}
	
	
	
	
	
	public static void main(String[] args) {
	   String str = "   xxxx xx x xx xxxxxxx   ";
	   System.out.println("f" + str + "l");
	   System.out.println("f"+ trim(str) + "l");
	   System.out.println("All\u00F4 monde!");
	 
//	   char ch = ' ' ;
//	   System.out.println(Character.isAlphabetic(ch));
//	   System.out.println(Character.isDigit(ch));
//	   System.out.println(Character.isWhitespace(ch));
//	   System.out.println(' ' == ch);
	}  

}
