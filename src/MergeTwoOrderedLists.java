
public class MergeTwoOrderedLists {
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
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
}
