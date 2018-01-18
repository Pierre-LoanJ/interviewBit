package trees;
import utils.TreeNode;

/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBST {
	/*
	public class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;
		
		public TreeNode(int v) {
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	*/
	 public TreeNode sortedArrayToBST(int[] nums) {
	        if (nums == null || nums.length == 0) return null; 
	        int i = nums.length / 2;  
	        TreeNode root = new TreeNode(nums[i]);
	        feed(nums, root, i);
	        return root;
	    }
	    private void feed(int[] a, TreeNode n, int i) {
            int j = (i / 2) - 1;
	        if (j < 0) return;
	        n.left = new TreeNode(a[j]);
            feed(a, n.left, j);
            
            i += ((a.length - i) / 2) + 1;
	        if (i > a.length - 1) return;
	        n.right = new TreeNode(a[i]);
	        feed(a, n.right, i);
	    }
	    public TreeNode sortedArrayToBSTCorr(int[] num) {
	        if (num.length == 0) {
	            return null;
	        }
	        TreeNode head = helper(num, 0, num.length - 1);
	        return head;
	    }

	    public TreeNode helper(int[] num, int low, int high) {
	        if (low > high) { // Done
	            return null;
	        }
	        int mid = (low + high) / 2;
	        TreeNode node = new TreeNode(num[mid]);
	        node.left = helper(num, low, mid - 1);
	        node.right = helper(num, mid + 1, high);
	        return node;
	    }
	    public static void main(String[] args) {
	    	int[] a = { -1, 0, 1, 2 }; //8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	    	ConvertSortedArrayToBST inst = new ConvertSortedArrayToBST();
	    	TreeNode root = inst.sortedArrayToBSTCorr(a);
	    	
	    	
	    	
	    	
	    	isBalancedBinaryTree isB = new isBalancedBinaryTree();
	    	System.out.println(isB.isBalanced(root));
	    }
}
