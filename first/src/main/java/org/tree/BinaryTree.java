package org.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	Node root;

	// BinaryTree(){
	// root=null;
	// }

	public void printInorder() {
		if (root == null) {
			System.out.println("empty  binary tree");
			return;
		}
		System.out.print("[ ");
		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
		System.out.println("]");
	}

	public void printInorder(Node node) {
		if (node == null) {
			return;
		}

		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public void printPreorder() {
		if (root == null) {
			return;
		}
		System.out.print("");
		;
		System.out.print("[ ");
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
		System.out.print("]");
	}

	public void printPreorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public void printPostorder() {
		if (root == null) {
			return;
		}
		System.out.println();
		;
		System.out.print("[ ");

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
		System.out.print("]");
	}

	public void printPostorder(Node node) {
		if (node == null) {
			return;
		}

		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}

	// Level order traversal
	public void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null) {
			return;
		}

		q.add(root);
		System.out.println();
		System.out.print("[ ");

		while (true) {

			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			System.out.println();
			while (nodeCount > 0) {
				Node node = q.poll();

				if (node == null) {
					System.out.println("]");
					return;
				}
				System.out.print(node.data + " ");
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					;
				q.add(node.right);
				nodeCount--;
			}
		}

	}

	public int height() {
		return height(root);
	}

	public int height(Node node) {
		if (node == null)
			return 0;
		int leftheight = height(node.left);
		int rightheight = height(node.right);

		if (leftheight > rightheight)
			return 1 + leftheight;
		else
			return 1 + rightheight;

	}

	public void printGivenLevelOrder() {
		int h = height();
		for (int i = 1; i <= h; i++) {
			System.out.println();
			printGivenLevelOrder(root, i);
		}
	}

	public void printGivenLevelOrder(Node node, int level) {
		if (node == null) {
			return;
		}

		if (level == 1) {
			System.out.print(node.data + " ");
		} else {
			printGivenLevelOrder(node.left, level - 1);
			printGivenLevelOrder(node.right, level - 1);

		}

	}

	public void inorderWithoutRecursion() {
		Stack<Node> st = new Stack<Node>();
		if (root == null) {
			return;
		}
		System.out.print("[ ");
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
				st.push(node);

				while (node.left != null) {
					node = node.left;
					st.push(node);
				}
			}
		}
		System.out.print("]");

	}

	public void morrisTraversal() {
		Node current, prev = null;
		if (root == null)
			return;
		System.out.println();
		current = root;
		while (current != null) {

			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;

			} else {

				prev = current.left;
				while (prev.right != null && prev.right != current) {
					prev = prev.right;
				}

				if (prev.right == null) {
					// System.out.print(current.data + " "); //for preorder
					prev.right = current;
					current = current.left;
				} else {
					prev.right = null;
					System.out.print(current.data + " "); // for inorder
					current = current.right;

				}

			}
		}
	}

	public void iterativePreorder() {
		if (root == null)
			return;
		System.out.println();
		Stack<Node> st = new Stack<Node>();
		st.push(root);
		while (!st.isEmpty()) {
			Node node = st.pop();
			System.out.print(node.data + " ");
			if (node.right != null)
				st.push(node.right);
			if (node.left != null)
				st.push(node.left);
		}

	}

	public void morrisPreorder() {
		if (root == null)
			return;
		Node node = root;
		System.out.println();
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.data + " ");
				node = node.right;

			} else {
				Node current = node.left;
				while (current.right != null && current.right != node)
					current = current.right;

				if (current.right == null) {
					System.out.print(node.data + " ");
					current.right = node;
					node = node.left;
				} else {
					current.right = null;
					node = node.right;
				}

			}

		}

	}

	public void iterativePostOrder() {
		if (root == null)
			return;

		System.out.println();
		Stack<Node> st1 = new Stack<Node>();
		Stack<Node> st2 = new Stack<Node>();

		
		st1.push(root);	
		while (!st1.isEmpty()) {

			Node temp = st1.pop();
			st2.push(temp);
			if (temp.left != null)
				st1.push(temp.left);
			if (temp.right != null)
				st1.push(temp.right);

		}
		System.out.println();
		while (!st2.isEmpty()) {
			System.out.print(st2.pop().data + " ");
		}

	}

	public void iterativePostOrderSingleStack() {
		
	}

	public static void main(String[] args) {
		// 1
		// / \
		// 2 3
		// / \ / \
		// 4 5 6 7
		/// \ /\
		// 8 9 10 11
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);

		tree.root.right.right.left = new Node(10);
		tree.root.right.right.right = new Node(11);
		// tree.printInorder();
		// tree.printPreorder();
		// tree.printPostorder();
		// tree.bfs();
		// System.out.println(tree.height());
		// tree.printGivenLevelOrder();
		// tree.inorderWithoutRecursion();
		// tree.morrisTraversal();
		// tree.iterativePreorder();
		tree.morrisPreorder();
		tree.iterativePostOrder();
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