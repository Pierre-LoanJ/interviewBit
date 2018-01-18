package lists;
import utils.ListNode;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */

public class RotateLinkedList {
	
	
	// there are still some bugs
	public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode oldEnd = null, newEnd = head;
        ListNode oldStart = head, newStart = head;
        
        int size = 1, i = k;
        ListNode[] a = new ListNode[200];
        a[0] = head;
        while (head.next != null) {
            a[size-1] = head;
            a[size] = head.next;
            size++;
            newEnd = head;
            head = head.next;
            i--;
            if (i == 0) newStart = head;
        }
        oldEnd = head;
        
        boolean kBig = false;
        if (k > size) kBig = true;
        else if (k < size) kBig = false;
        else return oldStart;
        
        k = kBig ? k % size : k;
        if (k == 0) return oldStart;
        if (kBig) {
            newStart = a[k];
            //if (k == 0) newEnd = newStart;
            //else 
            newEnd = a[k-1];
        }
        // else deja fait dans la boucle
        
        newEnd.next = null;
        oldEnd.next = oldStart;
        
        return newStart;
    }
	public static void main(String[] args) {
		ListNode l = new ListNode(1);
    	l.next = new ListNode(2);
    	l.next.next = new ListNode(3);
    	l.next.next.next = new ListNode(4);
    	l.next.next.next.next = new ListNode(5);
    	
    	ListNode r = rotateRight(l, 2);
    	while(r != null) {
    		System.out.print(r.val + "  -  ");
    		r = r.next;
    	}
	}
}
