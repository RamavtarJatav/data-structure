package com.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindPhoneNumber {

	static String find_phone_number1(String text) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < text.length()) {
			if (text.charAt(i) == '(') {
				System.out.println("dd");
			}
			if (Character.isDigit(text.charAt(i)) || text.charAt(i) == '(') {
				if (Character.isDigit(text.charAt(i))) {
					if ((text.length() - i) < 12) {
						return "NONE";
					} else {
						int j = 1;
						while (j <= 12) {
							if (j == 4 || j == 8) {
								if (text.charAt(i) == '-') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									return "NONE";
								}
							} else {
								if (Character.isDigit(text.charAt(i))) {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;

								} else {
									return "NONE";
								}
							}

						}
					}
				}

				else if (text.charAt(i) == '(') {
					if ((text.length() - i) < 14) {
						return "NONE";
					} else {
						int j = 1;
						while (j <= 14) {
							if (j == 1) {
								if (text.charAt(i) == '(') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									return "NONE";
								}
							} else if (j == 5) {
								if (text.charAt(i) == ')') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									return "NONE";
								}
							} else if (j == 6) {
								if (text.charAt(i) == ' ') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									return "NONE";
								}
							} else if (j == 10) {
								if (text.charAt(i) == '-') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									return "NONE";
								}
							} else {
								if (Character.isDigit(text.charAt(i))) {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;

								} else {
									return "NONE";
								}
							}

						}
					}

				} else {
					i++;
				}
			}
		}
		return sb.toString();
		/*
		 * Write your code here.
		 */

	}

	/*
	 * Complete the find_phone_number function below.
	 */
	static String find_phone_number(String text) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < text.length()) {
				if (Character.isDigit(text.charAt(i))) {
					if ((text.length() - i) < 12) {
						return "NONE";
					} else {
						int j = 1;
						while (j <= 12) {
							if (j == 4 || j == 8) {
								if (text.charAt(i) == '-') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									break;
								}
							} else {
								if (Character.isDigit(text.charAt(i))) {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;

								} else {
									break;
								}
							}

						}
					}
				}

				else if (text.charAt(i) == '(') {
					if ((text.length() - i - 1) <= 14) {
						return "NONE";
					} else {
						int j = 1;
						while (j <= 14) {
							if (j == 1) {
								if (text.charAt(i) == '(') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
						          break;
								}
							} else if (j == 5) {
								if (text.charAt(i) == ')') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									break;
								}
							} else if (j == 6) {
								if (text.charAt(i) == ' ') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									break;
								}
							} else if (j == 10) {
								if (text.charAt(i) == '-') {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;
								} else {
									break;
								}
							} else {
								if (Character.isDigit(text.charAt(i))) {
									sb.append(String.valueOf(text.charAt(i)));
									i++;
									j++;

								} else {
									break;
								}
							}
							

						}
						if(j == 15 ) {
							return sb.toString();
						}
					}
				}
				i++;
			} 
			
		

		return sb.toString();
		/*
		 * Write your code here.
		 */

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("/home/ramavtar/OUTPUT_PATH")));

		// String text = scanner.nextLine();
		/// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		String res = find_phone_number("123-456-7890");
		String res1 = find_phone_number("1234567890");
		String res2 = find_phone_number("xxx999-999-9999");
		String res3 = find_phone_number("xxx999-999-9999llll");
		String res4 = find_phone_number("(000) 000-0000111");
		System.out.println(res + res1 + res2 + res3+res4);

		// bufferedWriter.write(res);
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
