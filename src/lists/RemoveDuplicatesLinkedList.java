package lists;
import utils.MyLinkedList;
import utils.MyLinkedList.Node;

/*
 *  Given a sorted linked list, delete all duplicates such that each element appear only once. 
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3. 
 */
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
		 only one pointer to go through the list and to short cut duplicates
		 */
	    Node current = head;
	    while (current != null && current.next != null) {
	        if (current.item == current.next.item) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
	
	// Here it is the opposite way of thinking
	// we short cut the duplicate when we find sth wrong
	
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
