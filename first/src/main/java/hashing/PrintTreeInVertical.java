package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintTreeInVertical {
	static Map<Integer, List<Integer>> map = new TreeMap<Integer , List<Integer>>();
	static void printTreeVertical(Node root) {
		if(root == null) {
			System.out.print("tree is empty");
			return ;
			
		}
		List<Integer> hdArray = new ArrayList<Integer>();
		hdArray.add(root.data);
		int hd = 0;
		inorderTraversal(root, hd);
	}
	
	static void inorderTraversal(Node node,  int hd) {
	  if(node == null) {
		  return;
	  }
		    
			inorderTraversal(node.left, hd-1);
			List<Integer> hdArray = map.get(hd);
			if(hdArray != null) {
				hdArray.add(node.data);
				map.put(hd, hdArray);
			}else {
				hdArray = new ArrayList<Integer>();
				hdArray.add(node.data);
				map.put(hd, hdArray);
				
				
			}
			System.out.print(node.data + " ");
			inorderTraversal(node.right, hd+1);
			
	
	}
	public static void main(String[] args) {
		/*
		 *      1
		 *     / \ 
		 *    2   3
		 *   /\   /\
		 *  4 5  6  7
		 * 
		 * 
		 */
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		printTreeVertical(root);
		System.out.println();
		for(Map.Entry<Integer, List<Integer>>  entry : map.entrySet()) {
			int hd = entry.getKey();
			List<Integer> hdArray = entry.getValue();
			System.out.print(hd + "\t");
			for(int v: hdArray) {
				System.out.print(v + " ");
			}
			
			System.out.println();
		}
		
	}

}

class Node {
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
	}
}
