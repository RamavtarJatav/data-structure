package org.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DiagonalVerticalPrint {
	
	
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}
	
	static void printdiagonally(Node node) {
		if(node == null) 
			return;
		
		Map<Integer, Vector<Integer>> digmap = new HashMap<Integer, Vector<Integer>>();
		printdiagonally(node , 0, digmap );
		
		for(Map.Entry<Integer, Vector<Integer>> entry: digmap.entrySet()){
			 System.out.print(entry.getKey()+ "\t");
			 Vector<Integer> v = entry.getValue();
			 for(int val: v) {
				 System.out.print(val + " ");
			 }
			 System.out.println();
		}
	}
	
	static void printdiagonally(Node node ,int slope, Map<Integer, Vector<Integer>> digmap) {
		if(node == null)
			return ;
		
		Vector<Integer> digArray = digmap.get(slope);
		if(digArray == null ) {
			digArray = new Vector<Integer>();
			
		}
		digArray.add(node.data);
		digmap.put(slope, digArray);
		printdiagonally(node.left, slope+1 ,digmap);
		printdiagonally(node.right, slope ,digmap);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		printdiagonally(root);

	}
	
	
	

}


