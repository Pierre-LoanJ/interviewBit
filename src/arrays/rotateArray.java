package arrays;
/*
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem
 */
public class rotateArray {
    public static void rotate(int[] nums, int k) {
    	if (nums == null || nums.length == 1 || k == 0) return;
        int l = nums.length;
        int i = k < l ? k : k % l;
        i = l - i;
        int[] aux = new int[l];
        int j = 0;
        int n = l;
        while (n > 0) {
            if (i == l) i = 0;
            if (j == l) j = 0;
            aux[j++] = nums[i++];
            n--;
        }
        for (int p = 0; p < l; p++) {
            nums[p] = aux[p];
        }
    }
    public static void rotateInPlace(int[] nums, int k) {
    	//does not work for odd values of k.
        if (nums == null || nums.length == 1 || k == 0) return;
        int l = nums.length;
        int i = k < l ? k : k % l;
        i = l - i;
        int j = 0;
        k = k % l;
        while (k > 0) {
            if (i == l) i = 0;
            //if (j == l) j = 0;
            swap(nums, i++, j++);
            k--;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    public static void main(String[] args) {
    	//int[] a = { 1, 2, 3, 4, 5, 6 };
    	int[] a = { 1, 2, 3 };
    	rotate(a, 1);
    	System.out.println("end");
    }
}
