package test;


public class Test1 {
	static  class Node {

		int data;
		Node next;
		public Node(int data) {
			this.data  = data;
		}
		
		
	}
	public static void main(String[] args) {
		 Node n = null;
		 Node n1 = new Node(1);
		 while(n1.next != n) {
			 System.out.println("a");
		 }
	}

}
