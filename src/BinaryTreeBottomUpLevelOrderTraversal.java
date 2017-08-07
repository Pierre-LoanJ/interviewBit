import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

!! All the leafs are in the same array, as all nodes from the same level !!
 */
public class BinaryTreeBottomUpLevelOrderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
	
		     public TreeNode(int val, TreeNode left, TreeNode right) {
		    	 this.val = val;
		    	 this.left = left;
		    	 this.right = right;
		     }
	}
    public static List<List<Integer>> levelOrderBottomCorr(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
       List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
       
       if(root == null) return wrapList;
       
       queue.offer(root);
       while(!queue.isEmpty()){
           int levelNum = queue.size();
           List<Integer> subList = new LinkedList<Integer>();
           for(int i=0; i<levelNum; i++) {
               if(queue.peek().left != null) queue.offer(queue.peek().left);
               if(queue.peek().right != null) queue.offer(queue.peek().right);
               subList.add(queue.poll().val);
           }
           wrapList.add(0, subList);
       }
       return wrapList;
   }
   public static List<List<Integer>> levelOrderBottom(TreeNode root) {
           List<List<Integer>> all = new ArrayList<List<Integer>>();
           Queue<TreeNode> q = new LinkedList<TreeNode>();
       
           if (root == null) return all;
	        q.offer(root);
       
           int size = 0;
           TreeNode n = null;
           while(!q.isEmpty()) {
               List<Integer> sub = new LinkedList<Integer>();
               size = q.size();
               
               
               for (int i = 0; i < size; i++) {
                   n = q.peek();
                   if (n.left  != null) q.offer(n.left);
                   if (n.right != null) q.offer(n.right);
                   Integer v = q.poll().val;
                   if (v != null) sub.add(v);
               }
               all.add(0, sub); // ajoute en tête et non à la suite
           }
       return all;
	}
	
    public static void main(String[] args) {
    	BinaryTreeBottomUpLevelOrderTraversal tree = new BinaryTreeBottomUpLevelOrderTraversal();
    	TreeNode root = tree.new TreeNode(2, null, null);
    	
    	root.left = tree.new TreeNode(3, null, null);
    	root.right = tree.new TreeNode(3, null, null);
    	
    	/*
    	root.left.left = tree.new TreeNode(4, null, null);
    	root.left.right = tree.new TreeNode(5, null, null);
    	root.right.left = tree.new TreeNode(5, null, null);
    	root.right.right = tree.new TreeNode(4, null, null);
    	
    	root.left.right.left = tree.new TreeNode(8, null, null);
    	root.left.right.right = tree.new TreeNode(9, null, null);
    	root.right.left.left = tree.new TreeNode(9, null, null);
    	root.right.left.right = tree.new TreeNode(8, null, null);
    	*/
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	 List<List<Integer>> all = new ArrayList<List<Integer>>();
    	 Queue<TreeNode> q = new LinkedList<TreeNode>();
    	queue.offer(null);
    	queue.add(0, root);
    	queue.peek();
    	queue.remove();
    	queue.poll();
    	List<List<Integer>> result = levelOrderBottom(root);
    	System.out.println(result);
    }
}
