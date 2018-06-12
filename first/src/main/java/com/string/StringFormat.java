package com.string;

public class StringFormat {
	public static void main(String[] args) {
		int x = 7;
		for (int i = 7; i > 0; i -= 2) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			String sbs = sb.toString();
			int adj = ((x-i)/2)+sbs.length();
			String adjs = "%"+ adj+"s";
 			String sbsf = String.format(adjs, sbs);
			System.out.println(sbsf);
			
			

		}
		
		for (int i = 3 ; i <= x ; i+=2) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			String sbs = sb.toString();
			int adj = ((x-i)/2)+sbs.length();
			String adjs = "%"+ adj+"s";
 			String sbsf = String.format(adjs, sbs);
			System.out.println(sbsf);
		}
		System.out.println("aaaa");
		
		
	}

}
