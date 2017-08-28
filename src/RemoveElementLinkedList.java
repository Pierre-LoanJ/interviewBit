import utils.ListNode;

public class RemoveElementLinkedList {
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum, cur = head;
        while (cur != null) {
            while (cur != null && cur.val == val) {
                cur = cur.next; 
            }
            prev.next = cur;
            prev = prev.next;
            if (cur != null) cur = cur.next;
        }
        return dum.next;
    }
	public static void main(String[] args) {
    	ListNode l1 = new ListNode(2);
    	l1.next = new ListNode(4);
    	l1.next.next = new ListNode(2);
    
    	ListNode l = removeElements(l1, 2);
    	while(l != null) {
    		System.out.print(l.val + "  -  ");
    		l = l.next;
    	}
    }
}
