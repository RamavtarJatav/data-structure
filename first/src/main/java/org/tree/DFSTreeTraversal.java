package org.tree;

/* DFS Traversal
 * 
 */

public class DFSTreeTraversal {
	static class Node{
		int data ;
		Node left ;
		Node right ;
		Node(int data){
			this.data = data;
			
		}
	}
	
	
	Node root;
	
	void inorderTraversal() {
		if (root == null)
		    return;
		
		inorderTraversal(root);
		System.out.println();
		
	}
	
	void inorderTraversal(Node node) {
		if (node.left != null ) {
			inorderTraversal(node.left);
			
		}
		System.out.print(node.data + " ");
		if (node.right != null ) {
			inorderTraversal(node.right);
			
		}
		
		
		
	}
	
	void preOrderTraversal() {
		if (root == null)
		    return;
		
		preOrderTraversal(root);
		
		System.out.println();
		
	}
	void preOrderTraversal(Node node) {
		System.out.print(node.data + " ");
		if (node.left != null ) {
			preOrderTraversal(node.left);
			
		}
		
		if (node.right != null ) {
			preOrderTraversal(node.right);
			
		}
		
	}
	
	void postOrderTraversal() {
		if (root == null)
		    return;
		
		postOrderTraversal(root);
		System.out.println();
		
	}
	
	void postOrderTraversal(Node node) {
		
		if (node.left != null ) {
			postOrderTraversal(node.left);
			
		}
		
		if (node.right != null ) {
			postOrderTraversal(node.right);
			
		}
		
		System.out.print(node.data + " ");
		
	}
	
	public static void main(String[] args) {
		//          1
		//         / \
		//        2   3  
		//       /\   /\
		//      4  5  6 7
		DFSTreeTraversal bt = new DFSTreeTraversal();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.inorderTraversal();
		bt.preOrderTraversal();
		bt.postOrderTraversal();
		
		
	}
	

}
