package trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.TreeNode;

public class BinaryTreeTraversal {
	
	 // Recurvive Algorithms for Deep First Search
	 
	public static List<Integer> preorderRecursiveTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
	    return list;
	}
	private static void preOrder(TreeNode n, List<Integer> list) {
		if (n == null) return;
	    list.add(n.val);
	    preOrder(n.left, list);
	    preOrder(n.right, list);
    }
	
	public static List<Integer> postOrderRecursiveTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
	    return list;
	}
	private static void postOrder(TreeNode n, List<Integer> list) {
		if (n == null) return;
	    postOrder(n.left, list);
	    postOrder(n.right, list);
	    list.add(n.val);
	}
	
	public static List<Integer> InOrderRecursiveTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
        if (root == null) return list;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
	    return list;
	}
	private static void inOrder(TreeNode n, List<Integer> list) {
		if (n == null) return;
	    inOrder(n.left, list);
	    list.add(n.val);
	    inOrder(n.right, list);
	}
	
	// Iterative Algorithms for Deep First Search
	
	public static List<Integer> iterativePreOrderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> out = new LinkedList<Integer>();
		if (root == null) return out;
 		s.push(root);
 		
 		Iterator<TreeNode> i = s.iterator();
 		while (i.hasNext()) { 					// wtf only one item at the beginning ! iterator has dynamic vision on stack ? 
 			TreeNode n = s.pop();
 			if (n != null) {
 				out.add(n.val);
	 			s.push(n.right);
	 			s.push(n.left);
 			}
 		}
 		
 		// or easier way to go through
 		/*
 		while(!s.empty()) {
 			TreeNode n = s.pop();
 			if (n != null) {
 				out.add(n.val);
	 			s.push(n.right);
	 			s.push(n.left);
 			}
 		}
 		*/
 		return out;
	}
	public static List<Integer> iterativeInOrderTraversal(TreeNode root) {
		List<Integer> out = new LinkedList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        if (root == null) return out;
        TreeNode n = root;
        while (!s.isEmpty() || n != null) {
        	while (n != null) {
        		s.push(n);
        		n = n.left;
        	}
        	n = s.pop();
            out.add(n.val);
            n = n.right;
		}
        return out;
    }
	public static List<Integer> iterativePostOrderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> out = new LinkedList<Integer>();
		if (root == null) return out;
 		s.push(root);
        TreeNode n = null;
        while(!s.isEmpty()) {
 			n = s.pop();
 			if (n != null) {
                s.push(n.left);
                s.push(n.right);
                out.add(0, n.val);
 		    }
        }
 		return out;
	}
	
	
	// Algorithms for Bread First Search
	
	public static List<Integer> iterativeBreadFirstTraversal(TreeNode root) {
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> out = new LinkedList<Integer>();
		if (root == null) return out;
		/*
		 TO DO
		 */
		return out;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		  root.left = new TreeNode(2);
		  root.right = new TreeNode(3);
		  
		  root.left.left = new TreeNode(4);
		  root.left.right = new TreeNode(5);
		  
		  List<Integer> res = iterativeInOrderTraversal(root);
		  for (Integer i : res) {
			  System.out.print(i + "  -  ");
		  }
	}
}