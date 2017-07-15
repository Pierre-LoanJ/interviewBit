import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseInteger {
	public static int reverse(int x) {
        float f = (float) x;
        float d = 0;
        int n = 0;
        
        Queue<Integer> st = new LinkedList<Integer>();
        while(f >= 1) {
            f = f / 10;
            d = f % 1;
            st.add((int) (d * 10));
            n++;
            f = f - d;
        }
        
        int digit = 0;
        int result = 0;
        int t = (int) Math.pow(10,  n) / 10;
        for (int i = 0; i < n; i++) {
            digit = st.remove();
            result += digit * t;
            t /= 10;
        }
        return result;
    }
	public static void main(String[] args) {
		int a = 123;
		System.out.println(4212/10);
		//System.out.println(reverse(a));
		String s = "abc";
		char e = s.charAt(4);
		int d = s.length();
		int [] b = { 1, 2 };
		int c = b.length;
	}
}
