package trees;
/*
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class Sametree {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		  //??    TreeNode(int x) { val = x; }
		  }

	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        return visit(p, q);
	    }
	    private boolean visit(TreeNode p, TreeNode q) {
	        boolean r = true;
	        if (p == null && q == null) return true;
	        else if (p == null && q != null || p != null && q == null) return false;
	        else if (p.val != q.val) return false;
	        else {
	            r = visit(p.left, q.left);
	            if (r == false) return false;
	            r = visit(p.right, q.right);
	            if (r == false) return false;
	            return true;
	        }
	    }
}
