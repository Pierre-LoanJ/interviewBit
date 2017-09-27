package arrays;
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
then you should return 6.



More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubArray {
	public int maxSubArray(int[] a) {
	       /*
	       first attemp ===> bad idea
	       
	       int leftBound = 0, rightBound = 0;
	        int maxSum = a[0], current = a[0];
	        
	        for (int i = 0; i < a.length; i++) {
	            current += a[i];
	            if (current >= maxSum) {
	                rightBound = i;
	                maxSum = current;
	            }
	        }
	        current = maxSum;
	        for (int j = rightBound; j >= 0; j--) {
	            if (a[j] > 0) {
	                current -= a[j];
	            }
	            else {
	                current += a[j];    
	            }
	            if (current >= maxSum) {
	                leftBound = j+1;
	                maxSum = current;
	            }
	        }
	        return maxSum;
	    */
	        int before = a[0];
	        int max = a[0]; // and not int max = 0 !!!!! -> test it with a = { -1 }
	        for (int i = 1; i < a.length; i++) {
	            if (before > max) max = before;
	            before = before + a[i] > a[i] ? before + a[i] : a[i];
	        }
	        if (before > max) max = before;
	        return max;
	}
}
