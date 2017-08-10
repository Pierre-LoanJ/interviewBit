import utils.TreeNode;

public class ConvertSortedLinkedListInBalancedBST {
	
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
		TreeNode n = new TreeNode(head.val);
		head = head.next;
        while(head != null) {
            n = putFather(n, head.val);
            head = head.next;
            if (head == null) return n;
            n.right = new TreeNode(head.val); // put as right child
            head = head.next; // one miss
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
    	
    	ListNode head = ins.new ListNode(-1); 
    	head.next = ins.new ListNode(0); 
    	head.next.next = ins.new ListNode(1);
    	head.next.next.next = ins.new ListNode(2);
    	
    	TreeNode root = ins.sortedListToBST(head);
    	isBalancedBST isBal = new isBalancedBST();
    	
    	System.out.println(isBal.isBalanced(root));
    }
}
