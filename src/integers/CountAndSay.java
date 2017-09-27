package integers;

public class CountAndSay {
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/
	public static String count(int n) {
		String s = "1";
		int len ;
		int nb;
		int  j;
		while (n > 1) {
			j = 0;
			nb = 0;
			len = s.length();
			for (int i = 0; i < len; i++) {
				if (s.charAt(i) != s.charAt(j)) {
					nb = i - j;
					s += nb + "" + s.charAt(j);
					j = 0;
					i = -1;
					s = s.substring(nb);
					len = len - nb;
					nb = 0;
				}
			}
			nb = len;
			s += nb + "" + s.charAt(j);
			s = s.substring(nb);
			n--;
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println(count(5));
	}
}
