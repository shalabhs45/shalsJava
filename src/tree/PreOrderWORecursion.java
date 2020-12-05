package tree;

import java.util.Stack;

public class PreOrderWORecursion {

	Node root;

	private void preOrder() {
		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		// Node curr = root;

		s.push(root);
		/*
		 * Pop all items one by one. Do following for every popped item a) print it
		 * b)push its right child c) push its left child Note that right child is pushed
		 * first so that left is processed first
		 */
		while (s.isEmpty() == false) {
			Node curr = s.peek();
			System.out.println("Pre Order Data " + curr.data);
			s.pop();
			if (curr.right != null) {
				s.push(curr.right);
			}
			if (curr.left != null) {
				s.push(curr.left);
			}		

		}

	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		PreOrderWORecursion tree = new PreOrderWORecursion();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.preOrder();
	}

}
