package tree;

public class KthNodeinTree {

	static int count = 0;

	/*
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 */
	static class Node {
		int data;
		Node left;
		Node right;
	}

	/*
	 * Helper function that allocates a new node with the given data and null left
	 * and right pointers.
	 */
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;

		return (node);
	}

	static void FindKthNodeinTree(Node node, int n) {
		if (node == null)
			return;

		if (count <= n) {
			/* first recur on left child */
			FindKthNodeinTree(node.left, n);
			count++;

			// when count = n then print element
			if (count == n)
				System.out.printf("%d ", node.data);

			// now recur on right child
			FindKthNodeinTree(node.right, n);
		}
	}

	public static void main(String args[]) {
		Node root = newNode(10);
		root.left = newNode(20);
		root.right = newNode(30);
		root.left.left = newNode(40);
		root.left.right = newNode(50);

		int n = 2;

		FindKthNodeinTree(root, n);
		// System.out.println(" The 5th node is:" + nodeValue);
	}

}
