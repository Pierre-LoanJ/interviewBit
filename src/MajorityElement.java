import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MajorityElement {
	 public static int majorityElement(int[] a) {
	        HashMap<Integer, Integer> h = new HashMap(); // v, freq
	        for (int i = 0; i < a.length; i++) {
	            Integer v = h.get(a[i]);
	            if (v != null) h.put(a[i], ++v);
	            else h.put(a[i], 1);
	        }
	        Set<Entry<Integer, Integer>> s = h.entrySet();
	        int val = 0, freqMax = 0;
	        for (Entry e : s) {
	        	if ((int) e.getValue() > freqMax) {
	        		freqMax = (int) e.getValue();
	        		val = (int) e.getKey();
	        	}
	        }
	        return val;
	    }
	 // another solution (the clever one) is to use the Boyer-Moore voting algorithm.
	 public static void main(String[] args) {
		 int[] a = { 1, 3, 7, 5, 8, 4, 5, 7, 6, 5, 8, 7, 9, 8, 7, 4, 5, 3, 4, 5, 7, 6 };
		 System.out.println(majorityElement(a));
	 }
	}