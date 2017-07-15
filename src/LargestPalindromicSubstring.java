import java.util.LinkedList;
import java.util.List;

public class LargestPalindromicSubstring {
	public static String largestPalindromicSusbstring(String s) {
		List<Integer> pos = new LinkedList<Integer>();
		String pal = "";
		int largest = 0;
		for (int i = 0; i < s.length(); i++) {
			pos = getSameLetters(s.charAt(i), i, s);
			if (pos.isEmpty()) {
				continue;
			}
			else {
				int k = i;
				int count = 0;
				int p = 0;
				String pa = "";
				while (pos.iterator().hasNext()) {
					p = pos.iterator().next();
					pa = s.charAt(k) + ""; 
					boolean bContinue = true;
					while (k < p && k != p) {
						bContinue = AreNextLettersSame(++k, --p, s);
						if (bContinue) {
							count++;
							pa += s.charAt(k);
						}
						else {
							break;
						}
					}
					pos.clear();
					if (k == p || p > k) {
						if (count > largest) {
							largest = count;
						}
					}
					count = 0;
					k = i + 1;
				}
			}
		}
		return pal + reverse(pal);
	}
	private static String reverse(String s) {
		String r = s;
		for (int i = s.length() - 2; i <= 0; i--) {
			r += s.charAt(i);
		}
		return r;
	}
	private static List<Integer> getSameLetters(char c, int start, String s) {
		List<Integer> l = new LinkedList<Integer>();
		for (int i = start + 1; i < s.length(); i++) {
			if (c == s.charAt(i)) {
				l.add(i);
			}
		}
		return l;
		
	}
	private static boolean AreNextLettersSame(int i, int j, String s) {
		return s.charAt(i) == s.charAt(j);
	}
	
	private static int lo, maxLen;
	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}	
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	public static void main(String[] args) {
		double f = 22.5;
		System.out.println(f%1);
		String s = "azbezezkayak";
		//String r = longestPalindrome(s);
		//System.out.println(r);
	}
}
