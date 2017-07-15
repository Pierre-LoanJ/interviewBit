import java.util.HashMap;

public class LargestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
	        if (strs.length == 0) return "";
	        boolean bSame = true;
	        boolean bNext = true;
	        int j = 0;
	        char current = '\0';
	        String prefix = "";
	        while(bSame && bNext) {
	            if (strs[0] == null || j > strs[0].length() - 1) {
	                bNext = false;
	                break;
	            }
	            current = strs[0].charAt(j);
	            for (int i = 1; i < strs.length; i++) {
	                if (strs[i] == null || j > strs[i].length() - 1) {
	                    bNext = false;
	                    break;
	                }
	                if (current != strs[i].charAt(j)) {
	                    bSame = false;
	                    break;
	                }
	                else {
	                   
	                }
	            }
                if (bNext && bSame) prefix += current;
                j++;
	        }
	       return prefix;
	 }
	 public static void main(String[] args) {
		 String[] b = {"a", "b"};
		 String[] a = { "abc", "abcde", "abcefh", "ab" };
		 String prefix  = longestCommonPrefix(b);
		 System.out.println(prefix);
		 HashMap<Integer, String> m = new HashMap<Integer, String>();
		 m.put(3, "value");
	 }
	 
}
