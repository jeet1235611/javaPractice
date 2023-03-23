package linkedlist2;

public class LinkedListUse {

	public static void main(String[] args) {
		Node n1 = new Node(45);
		Node n2 = new Node(81);
		Node n3 = new Node(99);
		Node n4 = new Node(100);
		
		//Linking of the Linked List now.
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		
		System.out.println(n1.data);
		System.out.println(n1.next);
		
		System.out.println(n2.data);
		System.out.println(n2.next);
		
		System.out.println(n3.data);
		System.out.println(n3.next);
		
		System.out.println(n4.data);
		System.out.println(n4.next);
		
		

	}

}
