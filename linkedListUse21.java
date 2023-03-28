package linkedlist21;

public class LinkedListUse {
	
	public static void printLinkedList(Node Head1) {
		Node temp = Head1;
		while(temp != null) {
			System.out.println("The data of the node is " + temp.data);
			temp = temp.next;
		}
	}
	
	public static Node constructLinkedList() {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		
		//Now linking the list.
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		Node Head = n1;
		
		return Head;
	}

	public static void main(String[] args) {
		Node Head1 = constructLinkedList();//I wasn't using Head.
		printLinkedList(Head1);

	}

}
