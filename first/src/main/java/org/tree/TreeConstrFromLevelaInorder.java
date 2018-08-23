package org.tree;

public class TreeConstrFromLevelaInorder {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;
	static int leInd = 0;

	Node buildTreefromLevelaInoder(int[] level, int[] ino, int stInd, int edInd) {
		Node node = null;

		if (stInd > edInd) {
			return null;
		}
		node = new Node(level[leInd]);
		if (stInd == edInd) {
			return node;
		}
		leInd++;
		int i = 0;
		for (i = stInd; i <= edInd; i++) {
			if (node.data == ino[i]) {
				break;
			}
		}
		node.left = buildTreefromLevelaInoder(level, ino, stInd, i - 1);
		node.right = buildTreefromLevelaInoder(level, ino, i + 1, edInd);

		return node;

	}

	void inoderTr() {
		if (root == null)
			return;

		inoderTr(root);
	}

	void inoderTr(Node node) {
		if (node.left != null) {
			inoderTr(node.left);
		}
		System.out.print(node.data + " ");

		if (node.right != null) {
			inoderTr(node.right);
		}
	}

	static void InoderTr(Node node) {

	}

	public static void main(String[] args) {
		int in[] = { 4, 8, 10, 12, 14, 20, 22 };
		int level[] = { 20, 8, 22, 4, 12, 10, 14 };
		TreeConstrFromLevelaInorder bt = new TreeConstrFromLevelaInorder();
		bt.root = bt.buildTreefromLevelaInoder(level, in, 0, in.length - 1);
		bt.inoderTr();
	}

}
