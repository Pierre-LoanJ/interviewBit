package arrays;
/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicates {
	 public static int removeDuplicates(int[] nums) {
		 int size = nums.length;
	     int j = 0;
	     int buffer = 0;
	     for (int i = 0; i + 1 < nums.length; i++) {
	         if (nums[i] != nums[i+1]) {
	             j++;
	        	 continue;
	         }
	         else {
	             while (nums[j] ==  nums[i+1]) {
	                j++;
	             }
	             buffer = nums[i+1];
	             nums[i+1] = nums[j];
	             nums[j] = buffer;
	             i = j;
	             size--;
	         }
	    }
		return size;
    }
	 
	 
	 /*
	  * 
	  * 
	  * 
	  * 
	  */
	 
	 
	 
	 public static int removeDuplicatesCorr(int[] A) {
		    if (A.length==0) return 0;
		    int j=0;
		    for (int i=0; i<A.length; i++) {		    	
		        if (A[i]!=A[j]) {
		        	A[++j]=A[i];
		        }
		    }
		    return ++j;
		}
	 
	 //	Basically, instead of saying when I find sth wrong and I solve it, 
	 // we say we do the normal process of keeping copying the elements
	 // and I find find sth wrong I just do nothing and skip it.
	 // The trick is to skip duplicates by keeping nextCopy Index j at the same place 
	 // every time we find A[i] = A[j]
	 
	 public static void main(String[] args) {
		 int[] a = {1, 2, 2, 3, 4};
		 System.out.println(removeDuplicatesCorr(a));
		 
	 }
}
