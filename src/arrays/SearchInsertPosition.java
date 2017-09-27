package arrays;
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0 
 */
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) return i;
		}
		return nums.length; // here is the trap! what if whe have { 1, 2, 4 } and target = 5 ? 
    }
	public static void main(String[] args) {
		int[] a = { 1, 2, 4 };
		System.out.println(searchInsert(a, 3));
	}
}
