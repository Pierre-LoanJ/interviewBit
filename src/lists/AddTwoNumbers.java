package lists;
import utils.ListNode;

public class AddTwoNumbers {
	/*
	FROM LEETCODE
	You are given two non-empty linked lists representing two non-negative integers. 
	The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	 */
	 
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode l = new ListNode(0);
	        ListNode start = l;
	        int ret = 0, sum = 0, p = 0, q = 0;
	        while (l1 !=null || l2 != null) {
	        	p = l1 != null ? l1.val: 0;
	        	q = l2 != null ? l2.val: 0;
	            sum = p + q + ret;
	            if (sum >= 10) {
	                ret = 1;
	                sum -= 10;
	            }
	            else ret = 0;
	            l.next = new ListNode(sum);
	            l = l.next;
	            if (l1 != null) l1 = l1.next;
	            if (l2 != null) l2 = l2.next;
	        }
	        if (ret > 0) l.next = new ListNode(1);

	        return start.next;
	    }
	    public static void main(String[] args) {
	    	ListNode l1 = new ListNode(2);
	    	l1.next = new ListNode(4);
	    	l1.next.next = new ListNode(3);
	    	
	    	ListNode l2 = new ListNode(5);
	    	l2.next = new ListNode(6);
	    	l2.next.next = new ListNode(4);
	    
	    	ListNode l = addTwoNumbers(l1, l2);
	    	while(l != null) {
	    		System.out.print(l.val + "  -  ");
	    		l = l.next;
	    	}
	    }
}

