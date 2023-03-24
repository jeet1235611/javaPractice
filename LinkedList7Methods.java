package linkedList7;

public class LinkedListUse {

	public static void printLinkedList(Node head) {
		System.out.println(head + " " + head.data);
		System.out.println(head.next + " " + head.data);
		System.out.println(head.next.next + " " + head.next.data);
		System.out.println(head.next.next.next + " " + head.next.next.data);
	}

	public static Node createLinkedList() {
		Node n1 = new Node(111);
		Node n2 = new Node(112);
		Node n3 = new Node(114);
		Node n4 = new Node(115);
		
		Node head = n1;
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		
		return head;
	}
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		printLinkedList(head);

	}

}
