import utils.TreeNode;

public class isBalancedBST {
	/*
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
		 */
	public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = depth(root.left);
        int r = depth(root.right);
        
        int d = l > r ? l - r : r - l;
        return d <= 1 && isBalanced(root.left) && isBalanced(root.right) ? true : false;
    }
    private int depth(TreeNode n) {
        if (n == null) return 0;
        int l = 0, r = 0;
        //if (n.left  != null)
            l = 1 + depth(n.left);
        //if (n.right != null)
            r = 1 + depth(n.right);

        return l > r ? l : r;
    }
}
