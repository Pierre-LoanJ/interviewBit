
public class HasPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	    public boolean hasPathSum(TreeNode root, int sum) {
	        if (root == null) return false;
	        else if (root == null && sum == 0) return false;
	        int count = process(root, sum, 0);
	        return count == sum;
	    }
	    private int process(TreeNode n, int target, int current) {
	        if (n == null) return 0;
	        current += n.val + process(n.left, target, current);
	        
	        if (current == target) return current;
	        //current -= n.val; d'abord voir à droite avant de l'enlever
	        
	        current += process(n.right, target, current);
	        if (current == target) return current;
	        else return current - n.val;
	    }
}
