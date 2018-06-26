package org.tree;

import java.util.Stack;

public class InOrderTraversalWithoutRecursion {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	// inorder traversal without recursion
	void InorderTraversal() {
		if (root == null)
			return;

		Stack<Node> st = new Stack<Node>();
		Node node = root;

		while (node != null) {
			st.push(node);
			node = node.left;
		}

		while (!st.isEmpty()) {
			node = st.pop();
			System.out.print(node.data + " ");

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					st.push(node);
					node = node.left;
				}
			}

		}

	}

	public static void main(String[] args) {
		InOrderTraversalWithoutRecursion bt = new InOrderTraversalWithoutRecursion();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.InorderTraversal();

	}

}
