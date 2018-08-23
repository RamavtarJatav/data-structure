package com.string;

public class KthOcurance {
	public static void main(String[] args) {
		String s  = "abcddeeffeeffffgggghhhhhhiii";
		int[] count = new int[26];
		char[] ch = new char[26];
		int n = s.length();
		for(int i = 0 ; i < n ; i++ ) {
			int chint = (int)s.charAt(i) - 96;
			ch[chint] = s.charAt(i);
			count[chint] = count[chint]+1;
		}
		
		for(int i = 0 ; i < 26 ; i++) {
		   for(int j = 0 ; j < 26 -i-1 ; j++ ) {
			 if(count[j] < count[j+1]) {
				 int temp = count[j];
				 count[j] = count[j+1];
				 count[j+1] = temp;
				 
				 char temp1 = ch[j];
				 ch[j] = ch[j+1];
				 ch[j+1] = temp1;
			 }
		   }
		}
		
		for(int i = 0 ; i < 26 ; i++) {
			System.out.print(count[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i < 26 ; i++) {
			System.out.print(ch[i]+ " ");
		}
		
		
	}

}
