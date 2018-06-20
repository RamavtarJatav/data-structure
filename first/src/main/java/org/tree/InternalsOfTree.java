package org.tree;

import java.util.HashMap;
import java.util.Map;

public class InternalsOfTree {
	public static void main(String[] args) {
		Map<String , String> map = new HashMap<String ,String>();
		map.put("ab1ssssss", "qqqqssssss");
		
		Object x = "2";
		System.out.println(x.hashCode());

;
		System.out.println(map.hashCode());
	
	}
	

}
