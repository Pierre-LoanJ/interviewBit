package strings;
/*
FROM LEETCODE 

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000. 

The trick is to find the middle of the palindrome and to expand both directions till it is no longer a palindrome,
then we save indices if it is the largest. when we have been through the entire string we return the substring given those saved indices.


 */
public class LongestPalindromicSusbstring {
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
	
	public static void main (String[] args) {
		String s = "kayak";
		System.out.println(longestPalindrome(s));
	}
}
