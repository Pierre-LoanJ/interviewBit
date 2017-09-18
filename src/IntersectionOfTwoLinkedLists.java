import utils.ListNode;
import java.util.*;

/*
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:

A:          a1 → a2
                   	↘
                     c1 → c2 → c3
                   	↗            
B:     	b1 → b2 → b3

begin to intersect at node c1.

Notes:
- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> h = new HashSet();
        while (headA != null) {
            h.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (h.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
