package lists;
import utils.ListNode;

public class MergeTwoOrderedLists {
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    if (l1 == null) return l2;
	    if (l2 == null) return l1;

	    ListNode r = new ListNode(0);
     	ListNode c = r;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                r.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                r.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 == null) r.next = l2;
        else r.next = l1;
        return c.next;
    }
	  public static ListNode otherway(ListNode l1, ListNode l2) {
		    ListNode l = new ListNode(0);
	     	ListNode start = l;
	     	while (l1 != null || l2 != null) {
	     		int p = l1 == null ? Integer.MAX_VALUE : l1.val;
	     		int q = l2 == null ? Integer.MAX_VALUE : l2.val;
	     		if (l1 == null && l2 == null) break;
	     		if (p < q) {
	     			l.next = new ListNode(p);
	     			l1 = l1.next;
	     		}
	     		else {
	     			l.next = new ListNode(q);
	     			l2 =l2.next;	     			
	     		}
	     		l = l.next;
	     	}
	     	return start.next;
	  }
	  public static void main(String[] args) {
		  ListNode l1 = new ListNode(2);
	    	l1.next = new ListNode(4);
	    	l1.next.next = new ListNode(7);
	    	
	    	ListNode l2 = new ListNode(1);
	    	l2.next = new ListNode(2);
	    	l2.next.next = new ListNode(2147483647);
	    
	    	ListNode l = otherway(l1, l2);
	    	while(l != null) {
	    		System.out.print(l.val + "  -  ");
	    		l = l.next;
	    	}
	  }
}
