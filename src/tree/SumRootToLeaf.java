package tree;

public class SumRootToLeaf {

	Node root;

	// Returns sum of all root to leaf paths. The first parameter is
	// root of current subtree, the second parameter is value of the
	// number formed by nodes from root to this node
	int treePathsSumUtil(Node node, int val) {
		if (node == null) {
			return 0;
		}
		val = val * 10 + node.data;

		if (node.left == null && node.right == null)
			return val;

		return treePathsSumUtil(node.left, val) + treePathsSumUtil(node.right, val);
	}

	// A wrapper function over treePathsSumUtil()
	int treePathsSum(Node node) {
		// Pass the initial value as 0 as there is nothing above root
		return treePathsSumUtil(node, 0);
	}

	public static void main(String args[]) {
		SumRootToLeaf tree = new SumRootToLeaf();
		tree.root = new Node(6);
		tree.root.left = new Node(3);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(4);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(4);
		tree.root.left.right.left = new Node(7);

		System.out.print("Sum of all paths is " + tree.treePathsSum(tree.root));
	}
}
