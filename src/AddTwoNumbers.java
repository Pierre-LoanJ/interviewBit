
public class AddTwoNumbers {
	/*
	FROM LEETCODE
	You are given two non-empty linked lists representing two non-negative integers. 
	The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	 */
	
	
	 //Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	            ListNode l = new ListNode(0);
	            int s = 0;
	            boolean ret = false;
	            while (l1 !=null && l2 != null) {
	                s = l1.val + l2.val;
	                if (ret) {
	                    s += 1;
	                    ret = false;
	                }
	                if (s > 9) {
	                    ret  = true;
	                    s -= 10;
	                }
	                l.val = s;
	                l.next = new ListNode(0);
	                l = l.next;
	                l1 = l1.next;
	                l2 = l2.next;
	            }
	        return l;
	    }
}

