package com.string;

import java.util.Scanner;

public class XMLParsing1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		for (int t = 0; t < n; t++) {
			String line = in.nextLine();
			// System.out.println(line);
			int l = line.length();
			int j = 0;
			int starttagIndex = -1;
			int starttagEndIndex = -1;
			int endtagstartIndex = -1;
			int endtagendIndex = -1;
			String pr = "None";
			boolean match = true;
			boolean sucessfulEndProcess = false;
			int i = 0;
			while (i < l) {

				while (i < l) {
					if (line.charAt(i) == '<') {
						starttagIndex = i;
						i++;
						break;
					}
					i++;
				}

				while (i < l-1) {
					if(line.charAt(i) == '/') {
						i++;
					}
					else if (line.charAt(i) == '<' && line.charAt(i + 1) != '/') {
						starttagIndex = i;

					} else if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
						i += 2;

					} else if (line.charAt(i) == '>') {
						starttagEndIndex = i;

						if (starttagEndIndex - starttagIndex == 0 || starttagEndIndex - starttagIndex == 1 ) {
							starttagIndex = -1;
							starttagEndIndex = -1;
							i++;
							break;
						} else {
							i++;
							while (i < l) {
								if (line.charAt(i) == '<' && line.charAt(i + 1) != '/') {
									starttagIndex = -1;
									starttagEndIndex = -1;
									break;
								} else if (line.charAt(i) == '<' && line.charAt(i + 1) == '/') {
									endtagstartIndex = i;
									i += 2;

								} else if (line.charAt(i) == '>') {
									endtagendIndex = i;
									sucessfulEndProcess = true;
									i++;

									break;
								}
								i++;
							}

						}

						break;
					}
					i++;
				}
				if (sucessfulEndProcess) {
					int p = starttagIndex + 1;
					int q = endtagstartIndex + 2;
					while (p <= starttagEndIndex && q <= endtagendIndex) {
						if (line.charAt(p) != line.charAt(q)) {
							match = false;
							break;

						}
						p++;
						q++;
					}
					if (match) {
						int r = 0;
						StringBuilder sb = new StringBuilder();
						for (r = starttagEndIndex + 1; r < endtagstartIndex; r++) {
							sb.append(line.charAt(r));
						}
						pr = sb.toString();
						break;

					}
				}

			}
			if((pr.equals(""))) {
			  System.out.println("None");	
			}else {
			System.out.println(pr);
			}
		}
	}
}
