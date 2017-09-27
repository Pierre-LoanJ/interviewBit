package strings;
/*
Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class IndexOf {
        // when working on strings be VERY careful with duplicate substrings inside string
        // have a try with "mississippi" and "issip"
        public static int strStr(String h, String n) {
            if (n == null || "".equals(n)) return 0;
            if (h == null || "".equals(h)) return -1;
            int j;
            for (int i = 0; i < h.length(); i++) {
                j = 0;
                while (i < h.length() // needle is longer than haystack 
                       && j < n.length() 
                       && h.charAt(i) == n.charAt(j)) {
                    j++;
                    i++;
                }
                if (j == n.length()) return i - j;
                else {
                    i = i - j;
                }
            }
            return -1;
        }
    public static void main(String[] args) {
    	String s = "mississippi";
    	String n = "issip";
    	int r = strStr(s, n);
    	System.out.println(r);
    }
}
