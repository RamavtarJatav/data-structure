package org.tree;



public class InOrderMorisTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;
	
	void inorderMorisTraversal() {
		
		if(root == null)
			return;
		Node node = root;
        while(node != null) {
             if(node.left != null) {
            	 if (node.left.left == null) {
            		 System.out.println(node.left.data);
            		 
            	 };
             }
		//		while(node != null) {
//			if(node.left == null) {
//			   System.out.print(node.data+ " ");
//			   node = node.right;   
//			}else {
//				
//			}
			
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		InOrderMorisTraversal bt = new InOrderMorisTraversal();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.inorderMorisTraversal();
	}

}
