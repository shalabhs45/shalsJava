package tree;

import java.util.HashMap;

public class PathWithSumI {

	private static int res;

	// Function to backtrack the tree path and
	// add each path sum in the unordered map
	static void k_paths(Node root, int k, HashMap<Integer, Integer> p, int sum) {
		// If root value and previous sum equal
		// to k then increase the count
		if (root != null) {
			if (root.data + sum == k) {
				res++;
			}
			// Add those values also which differs
			// by the current sum and root data by k
			res += p.get(sum + root.data - k) == null ? 0 : p.get(sum + root.data - k);

			// Insert the sum + root value in the map
			if (!p.containsKey(sum + root.data)) {
				p.put(sum + root.data, 0);
			}
			p.put(sum + root.data, p.get(sum + root.data) + 1);

			// Move to left and right trees
			k_paths(root.left, k, p, sum + root.data);
			k_paths(root.right, k, p, sum + root.data);

			// Remove the sum + root.data value
			// from the map if they are n not
			// required further or they do no
			// sum up to k in any way
			p.put(sum + root.data, p.get(sum + root.data) - 1);
		}
	}

	static int printCount(Node root, int k) {

		// To store the sum
		HashMap<Integer, Integer> p = new HashMap<>();

		// Function call
		k_paths(root, k, p, 0);

		// Return the required answer
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		res = 0;
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right = new Node(-1);
		root.right.left = new Node(3);
		root.right.left.left = new Node(2);
		root.right.left.right = new Node(5);

		int k = 3;
		System.out.printf("No of paths with sum " + "equals to %d are: %d\n", k, printCount(root, k));

	}

}
