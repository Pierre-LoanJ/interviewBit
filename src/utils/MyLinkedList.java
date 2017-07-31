package utils;

public class MyLinkedList<Type> {
	
	private Node first = null;
	private Node nextIn = null;
	
	public class Node {   // inner class defined by "class" attribute 
		public Type item;
		public Node next;
	}
	
	public MyLinkedList() {
	}
	public void add(Type v) {
		Node n = new Node();
		n.item = v;
		n.next = null;
		
		if (first == null) {
			first = n;
			nextIn = first;
		}
		else {
			nextIn.next = n; 
			nextIn = nextIn.next;
		}
	}
	public Node getFirst() {
		return this.first;
	}
	public boolean bEmpty() {
		return this.first.item == null;
	}
}
