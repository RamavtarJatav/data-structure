package mmt;

public class LinkedList {
	Node head;
	
	class Node {
		int data;
		Node next;
		Node (int data){
			this.data= data;
			
		}
	}
	
	LinkedList(){
		head =null;
	}
	
	void add(int data){
		if (head == null) {
			head = new Node(data);
			return;
		}
		if(data < head.data) {
		    Node temp = new Node(data);
		    temp.next=head;
		    head= temp;
		    return;
		}
		Node node = head;
		
		while(node.next != null) {
			
		     if(data < node.next.data) {
		    	 Node afbr = node.next;
		         Node temp = new Node(data);
		         temp.next = afbr;
		         node.next = temp;
		         return;
		       
		     }
		     node =node.next;
		}
		
		node.next= new Node(data);
		
	}
	
	int getMinimum() {
		if(head == null) 
			return 0;
		
		return head.data;
	}
	
	void deleteMin() {
		if(head == null)
			return;
		
		head = head.next;
	}
	
	void printElements() {
		
		
	    Node node = head;
	    while(node!=null) {
	    	System.out.print(node.data + " ");
	    	node = node.next;
	    }
	   
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(9);
		linkedList.add(8);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(10);
		linkedList.add(3);
		linkedList.add(6);
		linkedList.add(11);
        

		linkedList.printElements();
		System.out.println();
		System.out.println(linkedList.getMinimum());
		linkedList.deleteMin();
		System.out.println(linkedList.getMinimum());
		linkedList.printElements();
		
		
		
	}

}
