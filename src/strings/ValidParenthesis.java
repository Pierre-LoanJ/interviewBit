package strings;
import java.util.Stack;

public class ValidParenthesis {
	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 * ')' should return false.
	 * '(' should return false also.
	 */
	public static boolean isValid(String s) {
		if (s != null) {		
			Stack<Character> st = new Stack<Character>();
			
			char c = '\0';
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c == '(' || c == '[' || c == '{') {
					st.push(c);
				}
				else {
					if (!st.isEmpty()) {
						char out = st.pop();
						if (out == '(' && c != ')') return false;
						if (out == '[' && c != ']') return false;
						if (out == '{' && c != '}') return false;
					}
					else return false;		// we find a closing bracket without no previous an opening one. 
				}
			}
			if (!st.isEmpty()) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "{}";
		System.out.println(isValid(s));
	}
}

