package com.string;

public class ParseString {

	public static void main(String[] args) {
		String s = "ram  avtar    jatav  \"bhagavan singh\" abhishek kumar \"jnv manpur morena\"";
		int n = s.length();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while (i < n) {
			if (s.charAt(i) == ' ') {
				i++;
				while(i < n ) {
					if(s.charAt(i) == ' ') {
						i++;
					}else {
						break;
					}
				}
				System.out.println(sb.toString());
				sb.setLength(0);
				if (i < n && s.charAt(i) == '"') {
					sb.append(s.charAt(i));
					++i;
					while (s.charAt(i) != '"' && i < n) {
						sb.append(s.charAt(i));
						i++;
					}
				}else if(i< n &&  s.charAt(i) != '"') {
				   continue;
				}
			} else {
				sb.append(s.charAt(i));
				i++;
			}

			
		}

		System.out.println(sb.toString());

	}
}
