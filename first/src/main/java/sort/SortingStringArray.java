package sort;

import java.util.List;

public class SortingStringArray {
	static void sort(String a[] , int n){
		for(int i = 0 ; i < n ; i++) {
			for(int j = i ; j < n ; j++ ) {
				int k = 0 ;
				int l = 0 ;
				String s1 = a[i];
				String s2 = a[j];
				int s1l = a[i].length();
				int s2l = a[j].length();
				while(k < s1l && k < s2l) {
					if(s1.charAt(k) > s2.charAt(l)) {
						a[i] = s2;
						a[j] = s1;
					}else if (s1.charAt(k) < s2.charAt(l)) {
						break;
					}
					k++;
					l++;
				}
				
				if(k < s1l && l == s2l) {
					a[i] = s2;
					a[j] = s1;
				}
			}
		}
		
	}
	
	static void getSubstring(String s ,int k) {
		if(k > s.length())
			return ;
		int CAPACITY = 2 << 1;
		String[] sbl = new String[CAPACITY];
	    int count  = 0;
		
		for(int i = 0 ; i < s.length()-k+1 ; i++) {
			int j = 0;
			StringBuilder sb = new StringBuilder();
			for(j = i ; j < k+i ; j++) {
				sb.append(s.charAt(j));
			}
			if(count == CAPACITY) {
				CAPACITY = CAPACITY << 1;
				String[] temp = new String[CAPACITY];
				for(int m = 0; m < count ; m++) {
					temp[m] = sbl[m];
					
				}
				sbl = temp;
				
			}
			
			
		    sbl[count] = sb.toString();
			count++;
			
		    
		}
//		print(sbl, count);
//		sort(sbl , count);
//		
//		
//	
//		print(sbl, count);
		
		
	}
	
      static void print(String a[] , int  n) {
		for(int i = 0 ; i < n ;i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.println();
				
	}
      
      static void print(List<String> a) {
    	  for(int i = 0 ; i < a.size();i++) {
  			System.out.print( a.get(i)+ " ");
  		}
  		System.out.println();
      }
      
	public static void main(String[] args) {
	String s = "thehindustan";
	getSubstring(s ,3);
	
	}
}
