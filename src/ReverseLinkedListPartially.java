import utils.ListNode;
import java.util.*;

public class ReverseLinkedListPartially {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m < 1 || n < 1 || n < m || head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        Stack<ListNode> s = new Stack<ListNode>();
        int mm = m;
        int dif = n - m + 1;
        ListNode lm = dummy, after = null, before = null, ret = dummy, cur = dummy;
        if (mm == 1) lm = dummy.next;
        while (mm > 1) {
            //before = lm;
        	if (lm == null) return head;
            lm = lm.next;
            mm--;
        }
        while (dif > 0) {
        	if (lm == null) return head;
            s.push(lm);
            lm = lm.next;
            dif--;
        }
        after = lm;
        while (cur != null) {  
            if (m - 1 <= 1) {
                break;
            }
            cur = cur.next;
        }
        if (lm == null) return head;
        while (!s.isEmpty()) {
        	if (cur == null) return head;
            cur.next = s.pop();
            cur = cur.next;
        }
        cur.next = after;
        return start.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next = new ListNode(3);
    	//l1.next.next.next = new ListNode(4);
    //	l1.next.next.next.next = new ListNode(5);
    	
    	ListNode l = reverseBetween(l1, 1, 2);
    	while(l != null) {
    		System.out.print(l.val + "  -  ");
    		l = l.next;
    	}
	}
}
