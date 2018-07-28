package test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Test1 {
	static  class Node {

		int data;
		Node next;
		public Node(int data) {
			this.data  = data;
		}
		
		
	}
	public static void main(String args[]) {
		   Scanner scan = new Scanner(System.in);
		   Calendar c = Calendar.getInstance();
		
		   c.set(2015, 5, 8);
		   System.out.println(c.get(Calendar.DAY_OF_WEEK));
<<<<<<< Updated upstream
		   
=======
		   int y = 9;
		  // x = ++(++y);
		   System.out.println(new Test1());
		   
		   try {
			   throw new IOException();
			 //  System.out.println();
		   }catch(Exception e) {
			   
		   }
>>>>>>> Stashed changes
		 
		  
//		 Node n = null;
//		 Node n1 = new Node(1);
//		 while(n1.next != n) {
//			 System.out.println("a");
//		 }
	}

}
