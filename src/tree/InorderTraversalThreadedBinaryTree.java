package tree;

class tNode {
	int data;
	tNode left, right;

	tNode(int item) {
		data = item;
		left = right = null;
	}
}

public class InorderTraversalThreadedBinaryTree {

	tNode root;

	void traversal(tNode root) {
		tNode current, pre;
		if (root == null)
			return;
		current = root;
		while (current != null) {

			if (current.left == null) {
				System.out.println("Current Data " + current.data);
				current = current.right;
			} else {
				/*
				 * Find inorder ancestor of current left subtree right most mode
				 */
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}

				/*
				 * Make current as right child of its inorder predecssor
				 */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.println("Current Data " + "" + current.data);
					current = current.right;
				}
			}

		}
	}

	public static void main(String args[]) {
		/*
		 * Constructed binary tree is 1 / \ 2 3 / \ 4 5
		 */
		InorderTraversalThreadedBinaryTree tree = new InorderTraversalThreadedBinaryTree();
		tree.root = new tNode(1);
		tree.root.left = new tNode(2);
		tree.root.right = new tNode(3);
		tree.root.left.left = new tNode(4);
		tree.root.left.right = new tNode(5);

		tree.traversal(tree.root);
	}

}
