import utils.MyLinkedList;
import utils.MyLinkedList.Node;

public class RemoveDuplicatesLinkedList {
	public static Node deleteDuplicates(Node first) {
		if (first == null) return null;
		Node curNode = first, nextInsert = curNode;
		
		while (curNode != null && curNode.next != null) {
			while (curNode != null && curNode.next != null && isNextDifferent(curNode)) { 	// moves nextInsert forward
				curNode = curNode.next;
				nextInsert = curNode;
			}
			nextInsert.next = getNextdifferent(curNode); 									// deletes duplicates by skipping them
			nextInsert = nextInsert.next;
			curNode = nextInsert;
		}
		return first;
	}
	private static Node getNextdifferent(Node n) {
		while (n.next != null && n.item == n.next.item) {
			n = n.next;
		}
		return n.next;
	}
	private static boolean isNextDifferent(Node n) {
		boolean ret = false;
		ret = n.item != n.next.item;
		return ret;
	}
	
	
	public static Node deleteDuplicatesCorr(Node head) {
		/* 
		 only one pointer to go through the list and to skip duplicates
		 */
	    Node current = head;
	    while (current != null && current.next != null) {
	        if (current.next.item == current.item) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
		ll.add(1);
		ll.add(1);
		ll.add(2);
		ll.add(2);
		/*
		 * ll.add(2);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		*/
		deleteDuplicates(ll.getFirst());
		System.out.println("fin");
		
	}
} 
