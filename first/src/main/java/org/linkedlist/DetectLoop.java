package org.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectLoop {
	static class Node{
		int data ;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
    
	Node head;
	
	DetectLoop(){
		head = null;
	}
	
	
	void add(int data) {
		if( head == null) {
			head = new Node(data);
			
		}else {
			add(head , data);
		}
	}
	
	void add(Node node , int data) {
		if(node.next == null) {
			node.next = new Node(data);
		}else {
			add(node.next, data);
		}
	}
	
	
	void print() {
		if(head == null) {
			return;
		}
		
		System.out.print("[ ");
		print(head);
		System.out.print("]");
		
	}
	
	void print(Node node) {
		 if(node.next == null) {
			 return;
		 }else {
			 System.out.print(node.data + " ");
			 print(node.next);
		 }
	}
	
	void createLoop(){
		if (head == null ) {
			return;
		}
		
		traverse(head);
	}
	
	void traverse(Node node) {
		if (node.next == null ) {
			node.next = head.next;
		}else {
			traverse(node.next);
		}
	}
	
	void detectLoop() {
		Map<Node, String> map =  new HashMap<Node,String>();
		Node node = head;
		while(node != null) {
			if(map.containsKey(node)) {
				System.out.println("loop at" +node.data);
				break;
			}else {
			map.put(node, null);
		}
			node = node.next;
		}
		
		
	}
	public static void main(String[] args) {
		DetectLoop ls = new DetectLoop();
		 for(int i = 0 ; i <  5 ; i++) {
			 ls.add(i);
		 }
		 
		 
		 
		 ls.print();
		 ls.createLoop();
		 ls.detectLoop();
		// ls.print();
	}
}
