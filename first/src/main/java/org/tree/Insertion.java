package org.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Insertion {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

	}

	Node root;
	

	void BFSTraversal() {
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(root);
		while (!qu.isEmpty()) {
			Node node = qu.remove();
			System.out.print(node.data + " ");
			if (node.left != null) {
				qu.add(node.left);

			}
			if (node.right != null) {
				qu.add(node.right);

			}
		}
		System.out.println();

	}

	// level order addition
	void add(int data) {
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(root);
		while (!qu.isEmpty()) {
			Node node = qu.remove();
		
			if (node.left != null) {
				qu.add(node.left);

			} else {
				node.left = new Node(data);
				break;
			}
			if (node.right != null) {
				qu.add(node.right);

			} else {
				node.right = new Node(data);
				break;
			}
		}
	}
    void remove(int data) {
    	if(root == null)
    		return;
    	
    	Node loc = findNode(root , data);
    	if (loc != null) {
    		System.out.println( "found"  +loc.data);
    	}
    	
    	
    }
    
    Node findNode(Node node , int data ) {
    	Node temp = null;
    	if(node.data == data) {
    		return  node ;
    	}else {
    		if (node.left != null) {
    		     temp = findNode(node.left , data); 
    		}
    		
    		if(node.right != null) {
    			if (temp == null) {
    			return findNode(node.right , data);
    			}else {
    				return temp;
    			}
    		}
    		
    	}
		return null;
    	
    }
    
	public static void main(String[] args) {
		Insertion bt = new Insertion();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.right.right = new Node(5);
		bt.BFSTraversal();
		bt.add(6);
		bt.BFSTraversal();
		bt.add(7);
		bt.BFSTraversal();
		bt.remove(4);
		
		

	}

}
