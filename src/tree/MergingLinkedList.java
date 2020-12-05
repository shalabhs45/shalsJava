package tree;
/*class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}*/

public class MergingLinkedList<T> {

	ListNode<Integer> head; // head of list

	class ListNode<T> {
		private T data;
		private ListNode<T> next;

		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}
		/* Inserts a new Node at front of the list. */
		public void push(int new_data) {
			/*
			 * 1 & 2: Allocate the Node & Put in the data
			 */
		ListNode<Integer> new_node = new ListNode<>(new_data);

			/* 3. Make next of new Node as head */
			new_node.next = head;

			/* 4. Move the head to point to new Node */
			head = new_node;
		}

		/* Inserts a new node after the given prev_node. */
		public void insertAfter(ListNode prev_node, int new_data) {
			/* 1. Check if the given Node is null */
			if (prev_node == null) {
				System.out.println("The given previous node cannot be null");
				return;
			}

			/*
			 * 2 & 3: Allocate the Node & Put in the data
			 */
			ListNode new_node = new ListNode(new_data);

			/* 4. Make next of new Node as next of prev_node */
			new_node.next = prev_node.next;

			/* 5. make next of prev_node as new_node */
			prev_node.next = new_node;
		}

		/*
		 * Appends a new node at the end. This method is defined inside LinkedList class
		 * shown above
		 */
		public void append(int new_data) {
			/*
			 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
			 */
			ListNode new_node = new ListNode(new_data);

			/*
			 * 4. If the Linked List is empty, then make the new node as head
			 */
			if (head == null) {
				head = new ListNode(new_data);
				return;
			}

			/*
		 * 5. This new node is going to be the last node, so make next of it as null
		 */
			new_node.next = null;

		/* 6. Else traverse till the last node */
			ListNode last = head;
			while (last.next != null)
				last = last.next;

		/* 7. Change the next of last node */
			last.next = new_node;
			return;
		}

		/*
		 * This function prints contents of linked list starting from the given node
		 */
		public void printList() {
			ListNode tnode = head;
			while (tnode != null) {
				System.out.print(tnode.data + " ");
				tnode = tnode.next;
			}
		}

	public ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> LI, ListNode<Integer> L2) {
		// Creates a placeholder for the result.
		ListNode<Integer> dummyHead = new ListNode<>(0);
		ListNode<Integer> current = dummyHead;
		ListNode<Integer> pi = LI, p2 = L2;
		while (pi != null && p2 != null) {
			if (pi.data <= p2.data) {
				current.next = pi;
				pi = pi.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		// Appends the remaining nodes of pi or p2.
		current.next = pi != null ? pi : p2;
		return dummyHead.next;
	}

	/*
	 * Driver program to test above functions. Ideally this function should be in a
	 * separate user class. It is kept here to keep code compact
	 */
		public static void main(String[] args) {
			/* Start with the empty list */
		MergingLinkedList<Integer> llist = new MergingLinkedList<>();

		llist.append(8);

		llist.push(4);

		llist.push(1);

		llist.append(9);

		llist.insertAfter(llist.head.next, 5);

			System.out.println("\nCreated Linked list is: ");
			llist.printList();

		llist.reverseSublist(llist, 8, 4);
	}

	public Node reverseSublist(ListNode L, int start, int finish) {
		if (start == finish) { // No need to reverse since start == finish.
			return L;
		}

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = L;
		ListNode sublistHead = dummyHead;
		int k = 1;
		while (k++ < start) {
			sublistHead = sublistHead.next;
		}
		ListNode sublistlter = sublistHead.next;
		while (start++ < finish) {
			ListNode<Integer> temp = sublistlter.next;
			sublistlter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}

		return L;
	}


}
