import java.util.*;
import utils.ListNode;

public class ListCycle {
	public boolean hasCycle(ListNode head) {
      if (head == null) return false;
      ListNode s = head, f = head.next;
      while (f != null && f.next != null && f.next.next != null) {
          if (s == f) {
              return true;
          }
          s = s.next;
          f = f.next.next;
      }
      return false;
  }
    public static void main(String[] args) {
    	ListCycle lc = new ListCycle();
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	//head.next.next.next = head;
    	//head.next.next.next.next = new ListNode(5);
    	//head.next.next.next.next.next = head.next;
    	System.out.println(lc.hasCycle(head));
    }
}
