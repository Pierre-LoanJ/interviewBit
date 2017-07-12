import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
        int size = nums.length;
        int cur = 0;
        Map<Integer, Boolean> m = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; ++i) {
        	cur = nums[i];
            if (m.get(cur) == null) {
                m.put(cur, true);
            }
            else {
            	// in place swap
            	if (i < nums.length - 1) {
            		nums[i] = nums[i + 1];
            		nums[i + 1] = cur;
            	}
            	size--;
            }
        }
        return size;
    }
	public static void main(String[] args) {
		int[] a =  { 1, 1, 2 };
		System.out.println(removeDuplicates(a));
	}
}
