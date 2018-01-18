/*
 Determine whether an integer is a palindrome. Do this without extra space.
 
 */

package integers;

import java.util.LinkedList;

public class PalindromeNumber {
	public static boolean isPalindromeCheat(int x) {
		// by tranforming x to a string
        String s = x + "";
        boolean isOdd = s.length() % 2 != 0;
        
        int i, j;
        if (isOdd) {
            i = s.length() / 2;
            j = i + 1;
            i--;
        }
        else {
            j = s.length() / 2;
            i = j - 1;
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i--;
            j++;
        }
        return true;
	}
	public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        LinkedList<Integer> l = new LinkedList();
        while (x > 0) {
            int d = x % 10;
            l.add(d);
            x = x / 10;
        }
        while (!l.isEmpty()) {
            int s = l.size();
            Integer tail = null;
            Integer head = l.remove(s-1);
            if (!l.isEmpty()) tail = l.remove(0);
            if (head != tail && tail != null) return false;
        }
        return true;
    }
	public static void main(String[] args) {
		int n = -2147447412;
		//n = 11;
		System.out.println(isPalindrome(n));
	}
}
