package arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/* FROM LEETCODE
	 Given nums = [2, 7, 11, 15], target = 9
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	 */
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {					// si complement présent dans le look up
	            return new int[] { map.get(complement), i };  // on renvoie les indices 
	        }
	        map.put(nums[i], i);							// la map sert de look up 
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		int[] n = { 2, 7, 11, 15 };
		int[] res = twoSum(n, 9);
		System.out.println(res[0] + " et " + res[1]);
	}
}
