
public class SymmetricTree {
	public class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int v, TreeNode left, TreeNode right) {
			this.val = v;
			this.left = left;
			this.right = right;
		}
	}
	public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null && root.right != null ||
                 root.left != null && root.right == null) return false;
        else {
        	TreeNode noeud = root.right;
        	TreeNode revTree = reverse(noeud);
        	return isSameTree(root.left, revTree);
        }
    }
    private static TreeNode reverse(TreeNode n) {
        if (n == null) return null;
        TreeNode saveLeft = n.left;
        n.left = reverse(n.right);
        n.right = reverse(saveLeft);
        return n;
    }
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        return visit(p, q);
    }
    private static boolean visit(TreeNode p, TreeNode q) {
        boolean r = true;
        if (p == null && q == null) return true;
        else if (p == null && q != null || p != null && q == null) return false;
        else if (p.val != q.val) return false;
        else {
            r = visit(p.left, q.left);
            if (r == false) return false;
            return visit(p.right, q.right);
        }
    }
    
    public static void main(String[] args) {
    	SymmetricTree tree = new SymmetricTree();
    	TreeNode root = tree.new TreeNode(2, null, null);
    	
    	root.left = tree.new TreeNode(3, null, null);
    	root.right = tree.new TreeNode(3, null, null);
    	
    	root.left.left = tree.new TreeNode(4, null, null);
    	root.left.right = tree.new TreeNode(5, null, null);
    	root.right.left = tree.new TreeNode(5, null, null);
    	root.right.right = tree.new TreeNode(4, null, null);
    	
    	root.left.right.left = tree.new TreeNode(8, null, null);
    	root.left.right.right = tree.new TreeNode(9, null, null);
    	root.right.left.left = tree.new TreeNode(9, null, null);
    	root.right.left.right = tree.new TreeNode(8, null, null);
    	
    	boolean result = isSymmetric(root);
    	System.out.println(result);
    }
}
