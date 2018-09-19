package org.tree;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeOperation {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	void insert(int data) {
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node.left == null) {
				node.left = new Node(data);
				break;
			} else {
				queue.add(node.left);
			}

			if (node.right == null) {
				node.right = new Node(data);
				break;
			} else {
				queue.add(node.right);
			}
		}

	}

	void remove(int data) {
		Queue<Node> queue = new LinkedList<Node>();
		Node parentNode = null;
		Node foundNode = null;
		queue.add(root);

		if (root == null) {
			System.out.print("Tree is empty");
			return;
		}

		if (root.data == data) {
			foundNode = root;
		} else {
			while (!queue.isEmpty()) {
				Node node = queue.remove();
				if (node.left != null) {
					if (node.left.data == data) {
						parentNode = node;
						foundNode = node.left;
						queue.add(node.left);
						queue.add(node.right);
						break;
					}else {
						queue.add(node.left);
					}
				}
				
				if (node.right != null) {
					if (node.right.data == data) {
						parentNode = node;
						foundNode = node.right;
						queue.add(node.right);
						break;
					}else {
						queue.add(node.right);
					}
						
				}
				
			}

		}
		
		
		
	}

	public static void main(String[] args) {
		BinaryTreeOperation bt = new BinaryTreeOperation();

		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);

	}

}
