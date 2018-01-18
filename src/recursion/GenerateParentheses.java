package recursion;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
        List<String> l = new LinkedList();
        gen(l, "", n, 0);
        return l;
	}
    private static void gen(List l, String s, int n, int m) {
        if (n == 0 && m == 0) {
        	l.add(s);
        	return;
        }
        if (n > 0) {
        	gen(l, s + "(", n-1, m+1);
        }
        if (m > 0) {
        	gen(l, s + ")", n, m-1);
        }   
    }
    public static void main(String[] args) {
    	List<String> list = generateParenthesis(2);
    	for (String word : list) {
    		System.out.println(word);
    	}
    }
}