package com.string;

import java.util.HashMap;
import java.util.Scanner;

public class CheckSubstring {
	static void checkSubString(String str1, String str2) {
		int i = 0;
        int j = 0 ;
        int count= 0;
       
		while (i < str2.length() && j < str1.length()) {
			if (str2.charAt(i) == str1.charAt(j)) {
				System.out.print(str1.charAt(j));
				i++;
                j++;
			}else {
				j++;
			}
			

		}
        
	     
	}

	public static void main(String[] args) {
		String str1 = "ramavtar";
		String str2 = "tar";
		checkSubString(str1, str2);
	}

}
