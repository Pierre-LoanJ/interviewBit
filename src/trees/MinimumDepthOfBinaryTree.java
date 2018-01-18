package trees;

public class MinimumDepthOfBinaryTree {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
		}
	    public int minDepth(TreeNode root) {
	        if (root == null) return 0;
	        int l = 1 + minDepth(root.left);
	        int r = 1 + minDepth(root.right);
	        if      (root.left  == null && root.right != null) return r;
	        else if (root.right == null && root.left != null) return l;
	        else return l > r ? r : l; // returns min
	    }
}
