
public class HasPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	 public boolean hasPathSumCorr(TreeNode n, int sum) {
		 // clever solution
	        if (n == null) return false;
	        sum -= n.val;
	        if (isLeaf(n) && sum == 0) return true;
	        return hasPathSum(n.left, sum) || hasPathSum(n.right, sum);
	    }

	 
	 
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	 
	 
	 
	 
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        else if (root != null && sum == 0) return false;
        int count = process(root, sum, 0);
        return count == sum;
    }
    private int process(TreeNode n, int target, int current) {
        if (n == null) return current;
        current += n.val;
        current = process(n.left, target, current);
        
        if (current == target && isLeaf(n)) return current;
        //current -= n.val; d'abord voir à droite avant de l'enlever
        
        current = process(n.right, target, current);
        if (current == target  && isLeaf(n)) return current;

        if (current == target) return current; // biasé car suffit que la racine vale sum pour que renvoie ok
        else return current - n.val; // mais nécessaire car sinon ici soustrait le noeud courant alors que target atteinte
    }
    
    private boolean isLeaf(TreeNode n) {
        return n.left == null && n.right == null;
    }
    
    public static void main(String[] args) {
    	HasPathSum instance = new HasPathSum();
    	TreeNode n = instance.new TreeNode(1);
    	n.left = instance.new TreeNode(2);
    	
    	boolean result = instance.hasPathSum(n, 3);
    	System.out.println(result);
    }
}
