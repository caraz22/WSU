package seven;

public class LinkedList {

	private Node head;
	private Node tail;
	
	public void add(String item) {
		
		Node newItem = new Node(item);
		
		// handles the case where the new item 
		// is the only thing in the list
		if (head == null) {
			head = newItem;
			tail = newItem;
			return;
		}
		
		tail.next = newItem;
		tail = newItem;
	}
	
	
	public void print() {
		Node current = head;
		while (current != null) {
			System.out.println(current.item);
			current = current.next;
		}
	}
	
	
	public void printWithSkips() {
		Node current = head;
		int count = 0;
		int rememberCount = 0;

		try {
			while (current.next != null) {
				System.out.println(current.item);
				count++;
				rememberCount = count;
				while (count > 0) {
					current = current.next;
					count--;
				}

				count = rememberCount;
			}

			System.out.println(current.item);
		} catch (NullPointerException e) {
			System.out.println("No more items in list.");
		}
	}

	
	class Node {
		String item;
		Node next;
		
		public Node(String item) {
			this.item = item;
			this.next = null;
		}
	}
}
