package org.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeTraversal {
  static class Node{
	  int data;
	  Node left;
	  Node right;
	  
	  Node(int data){
		  this.data = data;
	  }
  }
  
  Node root;
  
  void BFStraversal() {
	  if (root == null)
		  return;
	  
	  Queue<Node> q = new LinkedList<Node>();
	  q.add(root);
	  while(!q.isEmpty()) {
		  Node node = q.remove();
		  System.out.print(node.data + " ");
		  
		  if(node.left != null) {
			  q.add(node.left);
		  }
		  
		  if (node.right != null) {
			  q.add(node.right);
		  }
			  
	  }
  }
  
  public static void main(String[] args) {
	  BFSTreeTraversal bt = new BFSTreeTraversal();
	  bt.root  = new Node(1);
	  bt.root.left = new Node(2);
	  bt.root.right = new Node(3);
	  bt.root.left.left = new Node(4);
	  bt.root.left.right = new Node(5);
	  bt.root.right.left = new Node(6);
	  bt.root.right.right = new Node(7);
	  bt.BFStraversal();
}
  
}
