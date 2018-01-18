package arrays;

public class MergeTwoSortedArraysInPlace {
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 int i = m - 1, j = n - 1, k = m + n - 1;
	        while (i >= 0 && j >= 0) {
	            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
	            else                     nums1[k--] = nums2[j--];
	        }
	        boolean isNum1Empty = i <= 0 ? true : false;
	        if (isNum1Empty) {
	            while (j >= 0) {
	                nums1[k--] = nums2[j--];
	            }
	        }
	        else {
	            while (i >= 0) {
	                 nums1[k--] = nums1[i--];
	            }
	        }
	 }
	 public static void main(String[] args) {
		int[] a1 = {1, 0};
		int[] a2 = {2};
		merge(a1, 1, a2, 1);
		System.out.println("fin");
	 }
}
