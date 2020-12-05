package tree;
public class Node {
	int data;
	Node left, right;
	public int size;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}