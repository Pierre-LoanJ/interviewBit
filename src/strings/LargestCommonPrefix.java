package strings;
import java.util.HashMap;

public class LargestCommonPrefix {
	 public static String longestCommonPrefix(String[] a) {
		 if (a == null || a.length == 0) return "";
		 String prefix = "";
		 int i = 0, j = 0;
		 
		 while (i < a[j].length()) {
			 char prev = a[0].charAt(i);
			 char curChar = prev;
			 
			 while (j < a.length && i < a[j].length()) {
				 if (j > 0) prev = a[j-1].charAt(i);
				 			curChar = a[j].charAt(i);
				 if (curChar != prev) break;
				 j++;
			 }
			 if (j == a.length) prefix += curChar;
			 else break;
			 i++;
			 j = 0;
		 }
		 return prefix;
 	 }
	 public static void main(String[] args) {
		 String[] b = {"a", "b"};
		 String[] a = { "abc", "ab", "abcefh", "abc" };
		 String prefix  = longestCommonPrefix(a);
		 System.out.println(prefix);
		 HashMap<Integer, String> m = new HashMap<Integer, String>();
		 m.put(3, "value");
	 }
	 
}
