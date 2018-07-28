package com.string;

import java.util.Scanner;
import java.util.Stack;

public class XmlParsing {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {

			String line = in.nextLine();
			Stack<String> st = new Stack<String>();
			if (line.charAt(0) != '<') {
				return;
			}
			int i = 0;
			int n = line.length();
			while (i < n) {
				String tag = null;
				boolean found = false;
				
				if (line.charAt(i) == '<' && line.charAt(i + 1) == '>') {
					i += 2;
				}
				
				while (i < n) {

					while (line.charAt(i) != '<' ) {
						i++;			
					}

					if(line.charAt(i) == '<' && line.charAt(i+1) == '/') {
						i+= 2;
						
					}
					if (line.charAt(i) == '<' && line.charAt(i + 1) != '/') {
						i++;
						StringBuilder sb = new StringBuilder();
						while (i < n) {
							if (line.charAt(i) != '>') {
								sb.append(String.valueOf(line.charAt(i)));
							} else {
								if (!sb.toString().isEmpty()) {
									st.push(sb.toString());
									i++;
									break;
								}

							}
							i++;
						}
					} else if (line.charAt(i) != '<') {
						break;
					} else if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
						i = n;
					}
				}

				StringBuilder sbtag = new StringBuilder();
				// String tag = null;
				while (i < n) {
					if (line.charAt(i) != '<' && line.charAt(i + 1) != '/') {
						sbtag.append(String.valueOf(line.charAt(i)));
					} else if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
						tag = sbtag.toString();
						i += 2;
						StringBuilder sbendtag = new StringBuilder();
						while (i < n) {
							if (line.charAt(i) == '>') {
								i++;
								break;
							} else {
								sbendtag.append(String.valueOf(line.charAt(i)));

							}
							i++;
						}
						if (!st.isEmpty()) {
							if (sbendtag.toString().equals(st.pop())) {
								System.out.println(tag);
								found = true;
							} else {
								System.out.println("NONE");
							}
						}
						{

						}

						break;

					} else {
						break;
					}

					i++;

				}
				if (!found) {
					System.out.println("NONE");
				}
				// Write your code he

			}
			--testCases;

		}
	}

}
