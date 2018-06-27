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
					if (line.charAt(i) == '<' && line.charAt(i + 1) != '/') {
						i++;
						StringBuilder sb = new StringBuilder();
						while (i < n) {
							if (line.charAt(i) != '>') {
								sb.append(String.valueOf(line.charAt(i)));
							} else {
								st.push(sb.toString());
								i++;
								break;

							}
							i++;
						}
					} else if ((line.charAt(i) != '<') && (line.charAt(i + 1) != '/')) {
						break;
					}
				}

				StringBuilder sbtag = new StringBuilder();
				String tag = "";
				while (i < n) {
					if (line.charAt(i) != '<' && line.charAt(i + 1) != '/') {
						sbtag.append(String.valueOf(line.charAt(i)));
					} else if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
						tag = sbtag.toString();
						break;
					}
					i++;
				}

				boolean match = false;
				while (i < n) {
					if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
						i += 2;
						StringBuilder sbendtag = new StringBuilder();
						while (i < n) {
							if (line.charAt(i) != '>') {
								sbendtag.append(String.valueOf(line.charAt(i)));
							} else {
								i++;
								if (!sbendtag.toString().equals(st.pop())) {
									match = false;
									break;
								} else {

									match = true;
									break;

								}
							}
							i++;
						}
					} else {
						break;
					}
				}
				if (match) {
					System.out.println(tag);
				} else {
                    System.out.println("None");
				}

				// Write your code he
				--testCases;
			}
			
		}
	
}
