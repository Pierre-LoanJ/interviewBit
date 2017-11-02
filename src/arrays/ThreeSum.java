package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] a) {
		ArrayList<ArrayList<Integer>> allSolutions = new ArrayList<ArrayList<Integer>>();
		Map<Integer, Integer> done = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			int cur = a[i];
			if (!done.containsKey(cur)) {
				done.put(cur,  cur);
				try {
					ArrayList<Integer[]> ts = twoSum(a, i+1, -cur); // todo return a list of all solutions without duplicates
					
					for (int j = 0; j < ts.size(); j++) {
						ArrayList<Integer> res = new ArrayList<Integer>();
						res.add(a[i]);
						res.add(ts.get(j)[0]);
						res.add(ts.get(j)[1]);
						if (!isDuplicate(allSolutions, res))
							allSolutions.add(res);
					}
					
				} catch (Exception e) {
					  // continue;
				}
			}
			else {
				continue;
			}
		}
		return allSolutions;
	}
	private static boolean isDuplicate(ArrayList<ArrayList<Integer>> allLists, ArrayList<Integer> curList) {
		for (int i = 0; i < allLists.size(); i++) {
			ArrayList<Integer> cur = allLists.get(i);
			if (areEqual(cur, curList)) return true;
		}
		return false;
	}
	private static boolean areEqual(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int nbDuplicates = 0;
		Map<Integer, Integer> done = new HashMap<Integer, Integer>();
		for (int j = 0; j < list1.size(); j++) {
			int e1 = list1.get(j);
			if (done.containsKey(e1)) done.put(e1, done.get(e1)+1);
			else done.put(e1, 1);
		}
		for (int k = 0; k < list2.size(); k++) {
			int e2 = list2.get(k);
			if (done.containsKey(e2) && done.get(e2) != 0) {
				done.put(e2, done.get(e2)-1);
				nbDuplicates++;
			}
		}
		if (nbDuplicates == 3) return true;
		else return false;
	}
	private static ArrayList<Integer[]> twoSum(int[] nums, int startInd, int target) {
		ArrayList<Integer[]> all = new ArrayList<>();
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    Map<Integer, Integer> done = new HashMap<Integer, Integer>();
	    for (int i = startInd; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && !done.containsKey(complement) && !done.containsKey(nums[i])) {								// si complement présent dans le look up
	            all.add(new Integer[] { map.get(complement), nums[i] });    // on renvoie les valeurs 
	            done.put(complement, complement);
	            done.put(nums[i], nums[i]);
	        }
	        map.put(nums[i], nums[i]);										// la map sert de look up 
	    }
	    return all;
	}
	public static void main(String[] args) {
	//	int[] a = {-1,0,1,2,-1,-4};
	int[] a = { -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6 };	
		ArrayList<ArrayList<Integer>> sol = threeSum(a);
		System.out.println(sol);
	}
}
