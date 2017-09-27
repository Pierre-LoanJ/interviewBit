package strings;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. 
 */
public class LenghtOfLastWord {
	public static int lenghtOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean start = true;
        int j = - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (start && s.charAt(i) != ' ') {
                j = i;
                start = false;
            }
            if (!start && s.charAt(i) == ' ') {
                return j - i;
            }
        }
        if (j == -1) return 0;
        else        return j + 1;
    }
	public static void main(String[] args) {
		String s = "a";
		System.out.print(lenghtOfLastWord(s));
	}
}
