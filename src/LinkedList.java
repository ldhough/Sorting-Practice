public class LinkedList {
	Node head;
	
	static class Node {
		double data;
		Node next;
		Node (double d) {
			data = d;
			next = null;
		}
	}
	
	/* Finds length of linked list */
	public static int findLengthLL(LinkedList list) {
		int counter = 0;
		if (list.head == null) {
			return counter;
		}
		Node findLength = list.head;
		while (findLength.next != null) {
			counter++;
			findLength = findLength.next;
		}
		counter++;
		return counter;
	}
	
	/* Finds length of linked list with node passed in */
	public static int findLengthLL2(Node node) {
		int counter = 0;
		if (node == null) {
			return counter;
		}
		Node findLength = node;
		while (findLength.next != null) {
			counter++;
			findLength = findLength.next;
		}
		if (counter != 1)
			counter++;
		return counter;
	}
	
	/* Inserts nodes into the linked list */
	public static LinkedList insert(LinkedList list, double data) {
		Node toInsert = new Node(data);
		toInsert.next = null;
		
		if (list.head == null) { //If list is empty, make new list/head
			list.head = toInsert;
		} else {
			Node findLast = list.head;
			while (findLast.next != null) { //Loop through nodes until finding a node with a null next pointer.  This is last node...
				findLast = findLast.next;
			}
			findLast.next = toInsert; //Inserts node with given value at last position...
		}
		
		return list;
	}
	
	/* Deletes by value */
	public static LinkedList deleteValue(LinkedList list, double data) {
		if (list.head.data == data) {
			if (list.head.next == null) { //Return unedited list if no node after head
				list = new LinkedList(); //Starts new empty list, only node has been effectively deleted
				return list;
			}
			list.head = list.head.next; //statement to delete head if something exists after head
		} else {
			Node findDelete = list.head;
			while (findDelete.next.data != data) { //Breaks upon finding correct node to delete.
				if (findDelete.next.next == null) { //If gone through entire list w/o finding correct node, return unedited list
					return list;
				}
				findDelete = findDelete.next;
			}
			//Reaching here means a node with data = data has been found at findDelete.next
			findDelete.next = findDelete.next.next; //Assigns next pointer on current node to the node after the next node (the node to delete)
		}
		return list;
	}
	
	/* Deletes by index */
	public static LinkedList deleteIndex(LinkedList list, int index) {
		if (index == 0) {
			if (list.head.next == null) { //head only element
				list = new LinkedList(); //Starts new empty list effectively removing head.
				return list;
			}
			list.head = list.head.next; //removes head
			return list;
		}
		Node findDelete = list.head;
		for (int i = 0; i < index-1; i++) {
			findDelete = findDelete.next;
		}
		findDelete.next = findDelete.next.next;
		
		return list;
	}
	
	/* Prints list */
	public static void printList(LinkedList list) {
		Node printThis = list.head;
		if (printThis.next == null) { //If only head exists
			System.out.println(printThis.data);
			return;
		}
		while (printThis.next != null) {
			System.out.print(printThis.data + " ");
			printThis = printThis.next;
			if (printThis.next == null) { //if next node is last node
				System.out.print(printThis.data + " ");
				System.out.println();
			}
		}
		return;
	}
	
	/* Prints list given node parameter */
	public static void printListNode(Node node) {
		if (node.next == null) {
			System.out.println(node.data);
			return;
		}
		while (node.next != null) {
			System.out.print(node.data + " ");
			node = node.next;
			if (node.next == null) {
				System.out.print(node.data + " ");
				System.out.println();
			}
		}
		return;
	}
}
