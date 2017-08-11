package trees;
/*
 	Given a binary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	
	  public int maxDepth(TreeNode n) {
		  if (n == null) return 0;
		  
		  int l = 1 + maxDepth(n.left);
		  int r = 1 + maxDepth(n.right);
		  
		  return Math.max(l,  r);
	   }
	  
	  public static void main(String[] args) {
		  MaximumDepthOfBinaryTree ins = new MaximumDepthOfBinaryTree();
		  
		  TreeNode root = ins.new TreeNode(1);
		  root.left = ins.new TreeNode(2);
		  root.right = ins.new TreeNode(3);
		  
		  root.right.left = ins.new TreeNode(4);
		  root.right.right = ins.new TreeNode(5);
		  
		  root.right.left.right = ins.new TreeNode(6);
		  
		  System.out.println(ins.maxDepth(root));
	  }
}
