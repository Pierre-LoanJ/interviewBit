/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
    703 -> AAA
    728 -> AAZ
    729 -> ABA
 */

public class ExcelSheetColumnTitle {
	public static String convertToTitleRecursive(int n) {
		String s  = "";
    	if (n > 26) {
            s += convertToTitleRecursive((n-1)/26);
    	}
		int r = (n-1) % 26;
        int d = r + 65;
    	s += (char) d;
        return s;
   	}
	public static String convertToTitleIterative(int n) {
		String s  = "";
    	while (n > 0) {
    		int r = (n-1) % 26;
        	int d = r + Character.valueOf('A');
        	s = (char) d + s;
            n = (n-1) / 26;
    	}
        return s;
	}
	/*  Three things to remember here:
		1- the pace n = n / 26 and not n = n - 26
		2- the edge case (26 % 26) so we take n-1
		3- how we build s either we add new char in front (iterative) or in tail (recurisve)
	*/


	
    	// Here is opposite problem. You are given a String representing a column title
        // and you have to figure out the corresponding integer.
  	public static int titleToNumber(String s) {
		int sum = 0;
        for (int i = 0; i < s.length(); i++) {
        	sum = (s.charAt(i) - 64) + (sum * 26);
        }
	    return sum;
    }
	
	public static void main(String[] args) {
		int n = 18304;
		String s = convertToTitleRecursive(n);
		System.out.println(s);
		
		int res = titleToNumber("AAAB");
		System.out.println(res);
	}
}
