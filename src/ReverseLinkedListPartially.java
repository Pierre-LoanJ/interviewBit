import utils.ListNode;
import java.util.*;
/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

public class ReverseLinkedListPartially {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m < 1 || n < 1 || n < m || head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int deb = m+1, dif = n+1 - m;
        ListNode l = dummy, after = null, before = null;
        while (deb > 1) {
        	before = l;
            l = l.next;
            deb--;
        }
        Stack<Integer> s = new Stack<Integer>();
        while (dif > 0) {
            s.push(l.val);
            l = l.next;
            dif--;
        }
        after = l;
        while (!s.isEmpty()) {
        	before.next = new ListNode(s.pop());
            before = before.next;
        }
        before.next = after;
        return dummy.next;
    }
	/* Be very careful with edge cases like following ones:
		m = 1 
		n = list.size()
		m = n
	*/
		
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next = new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	l1.next.next.next.next = new ListNode(5);
    	
    	ListNode l = reverseBetween(l1, 5, 5);
    	while(l != null) {
    		System.out.print(l.val + "  -  ");
    		l = l.next;
    	}
	}
}
