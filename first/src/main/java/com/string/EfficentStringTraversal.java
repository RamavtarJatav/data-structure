package com.string;

import java.lang.reflect.Field;

public class EfficentStringTraversal {
	static void efficentTraversal(String str ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
                Field field = String.class.getDeclaredField("value");
                field.setAccessible(true);
                char[] chars = (char[]) field.get(str);
                for (int i = 0, n = chars.length; i < n; i++)
                    System.out.print(chars[i]);
	}
           	
      public static void main(String[] args) {
	      String  str =  "ramavtar is good boy";
	      try {
			efficentTraversal(str);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
}
