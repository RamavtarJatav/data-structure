package hash;

import java.util.HashMap;
import java.util.Map;

public class HashExample {
	;
	
	public static void main(String[] args) {
		 Map<String ,String >  map = new HashMap<String ,String>();
		String s = new String("ram");
		char[] value = s.toCharArray();
		int h = 0;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
           
        }
        System.out.println(20 & 15);
        
	    int hash = s.hashCode();
		map.put("1", "1");
//		map.put("2", "2");
//		map.put("3", "3");
//		map.put("4", "4");
	}
	

}
