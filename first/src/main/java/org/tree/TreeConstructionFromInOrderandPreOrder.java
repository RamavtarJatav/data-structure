package org.tree;

public class TreeConstructionFromInOrderandPreOrder {
	static class Node {
		char data;
		Node left;
		Node right;

		Node(char data) {
			this.data = data;
		}
	}

	Node root;
	static int preind = 0;;

	Node buildTree(char[] ino, char[] pre, int stind, int endind) {
		if (stind > endind) {
			return null;
		}
		Node node = new Node(pre[preind++]);
		if (stind == endind)
			return node;

		int i = 0;
		for (i = stind; i <= endind; i++) {
			if (node.data == ino[i]) {
				break;
			}
		}

		node.left = buildTree(ino, pre, stind, i - 1);
		node.right = buildTree(ino, pre, i + 1, endind);
		return node;

	}

	void printInoder() {
		if (root != null)
			printInoder(root);
		System.out.println();
	}

	void printInoder(Node node) {

		if (node.left != null) {
			printInoder(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			printInoder(node.right);
		}

	}

	public static void main(String[] args) {
		char[] ino = {'H','D','I','B','J','E','K','A','L','F','M','C','N','G','O'};
		char[] pre = {'A','B','D','H','I','E','J','K','C','F','L','M','G','N','O'};

		TreeConstructionFromInOrderandPreOrder bt = new TreeConstructionFromInOrderandPreOrder();
		bt.root = bt.buildTree(ino, pre, 0, ino.length - 1);
		bt.printInoder();
	}

}
