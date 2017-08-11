import utils.TreeNode;

public class ConvertSortedLinkedListInBalancedBST {
	
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public TreeNode sortedListToBSTCorr(ListNode head) {
		    if(head==null) return null;
		    return toBST(head,null);
		}
		public TreeNode toBST(ListNode head, ListNode tail){
		    ListNode slow = head;
		    ListNode fast = head;
		    if(head==tail) return null;
		    
		    while(fast!=tail&&fast.next!=tail){
		        fast = fast.next.next;
		        slow = slow.next;
		    }
		    TreeNode thead = new TreeNode(slow.val);
		    thead.left = toBST(head,slow);
		    thead.right = toBST(slow.next,tail);
		    return thead;
		}
	
		// does not work! because this tree is not balanced because 
		/*				   2
		 * 				 /
		 * 			    0
		 * 			  /	  \
		 * 			-1	   1
		 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		TreeNode n = new TreeNode(head.val); // second miss!
        head = head.next;                    // third miss!
        while(head != null) {
            n = putFather(n, head.val);
            head = head.next;
            if (head == null) return n;
            n.right = new TreeNode(head.val); // put as right child
            head = head.next;                 // one miss!
        }
        return n;
        
    }
    TreeNode putFather(TreeNode old, int val) {
        TreeNode n = new TreeNode(val);
        if (old != null) n.left = old;
        return n;
    }
    
    
    
    public static void main(String[] args) {
    	ConvertSortedLinkedListInBalancedBST ins = new ConvertSortedLinkedListInBalancedBST();
    	
    	ListNode head = ins.new ListNode(1); 
    	head.next = ins.new ListNode(2); 
    	head.next.next = ins.new ListNode(3);
    	head.next.next.next = ins.new ListNode(4);
    	head.next.next.next.next = ins.new ListNode(5);
    	//head.next.next.next.next.next = ins.new ListNode(4);
    	//head.next.next.next.next.next.next = ins.new ListNode(5);
    	
    	TreeNode root = ins.sortedListToBSTCorr(head);
    	isBalancedBST isBal = new isBalancedBST();
    	
    	System.out.println(isBal.isBalanced(root));
    }
}
