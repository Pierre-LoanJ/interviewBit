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
            n -= 26;
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
	public static void main(String[] args) {
		int n = 730;
		String s = convertToTitleIterative(n);
		System.out.println(s);
	}
}
