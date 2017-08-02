import java.util.ArrayList;
import java.util.List;

public class BinaryTreeBottomUpLevelOrderTraversal {
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
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> rootList = new ArrayList<Integer>();
        if (root != null) rootList.add(root.val);
        else return all;
        all.add(rootList);
        process(root, all);
        return reverseList(all);
    }
    private static List<List<Integer>> process(TreeNode n, List<List<Integer>> all) {
        if (n == null) return null;
        List<Integer> current = new ArrayList<>();
        
        if (n.left  != null) current.add(n.left.val);
        if (n.right != null) current.add(n.right.val);
        
        if (!current.isEmpty()) all.add((List<Integer>) current);
        
        process(n.left, all);
        process(n.right, all);
        
        return all;
    }
    private static List<List<Integer>> reverseList(List<List<Integer>> all) {
        List<List<Integer>> rev = new ArrayList<>();
        int size = all.size() - 1;
        while (!all.isEmpty()) {
            rev.add(all.remove(size));
            size--;
        }
        return rev;
    }
    public static void main(String[] args) {
    	BinaryTreeBottomUpLevelOrderTraversal tree = new BinaryTreeBottomUpLevelOrderTraversal();
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
    	
    	 List<List<Integer>> result = levelOrderBottom(root);
    	System.out.println(result);
    }
}
