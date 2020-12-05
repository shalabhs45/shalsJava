package tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderWORecursion {

	Node root;
	ArrayList<Integer> list = new ArrayList<Integer>();

	// An iterative function to do postorder traversal
	// of a given binary tree

	// An iterative function to do postorder traversal
	// of a given binary tree
	/**
	 * Push directly root node two times while traversing to the left. While poping
	 * if you find stack top() is same as root then go for root->right else print
	 * root.
	 * 
	 * @param root
	 */
	private void postOrderIterative1(Node root) {
		Stack<Node> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				stack.push(root);
				root = root.left;
			}

			// Check for empty stack
			if (stack.empty())
				return;
			root = stack.pop();

			if (!stack.empty() && stack.peek() == root)
				root = root.right;

			else {

				System.out.print(root.data + " ");
				root = null;
			}
		}
	}

	ArrayList<Integer> postOrderIterative(Node node) {
		Stack<Node> S = new Stack<Node>();

		// Check for empty tree
		if (node == null)
			return list;
		S.push(node);
		Node prev = null;
		while (!S.isEmpty()) {
			Node current = S.peek();

			/*
			 * go down the tree in search of a leaf an if so process it and pop stack
			 * otherwise move down
			 */
			if (prev == null || prev.left == current || prev.right == current) {
				// System.out.println("Main If " + prev.data + prev.left.data +
				// prev.right.data);
				if (current.left != null) {
					System.out.println("Cutrrent Left " + current.left.data);
					S.push(current.left);
				} else if (current.right != null) {
					S.push(current.right);
					System.out.println("Cutrrent right " + current.right.data);
				}
				else {
					System.out.println("Adding to list " + current.data);

					S.pop();
					list.add(current.data);
				}

				/*
				 * go up the tree from left node, if the child is right push it onto stack
				 * otherwise process parent and pop stack
				 */
			} else if (current.left == prev) {
				System.out.println("Frist else if" + current.left.data + prev.data + current.data);

				if (current.right != null) {
					S.push(current.right);
					System.out.println("Frist else if -current right " + current.right.data);

				}
				else {
					S.pop();
					System.out.println("Frist else if else -current right " + current.data);

					list.add(current.data);
				}

				/*
				 * go up the tree from right node and after coming back from right node process
				 * parent and pop stack
				 */
			} else if (current.right == prev) {
				System.out.println("Last else if " + current.data);

				S.pop();
				list.add(current.data);
			}

			prev = current;

			System.out.println("Current Data  & Prev data" + current.data + "" + prev.data);
		}

		return list;
	}

	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the nodes
		 */
		PostOrderWORecursion tree = new PostOrderWORecursion();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);

		System.out.println("Post order traversal of binary tree is :");
		System.out.println(mylist);
	}

}
