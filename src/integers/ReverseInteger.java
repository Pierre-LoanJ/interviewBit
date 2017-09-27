package integers;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
	public static int reverse(int x) {
		boolean neg = false;
		if (x < 0) {
			x = -x;
			neg = true;
		}
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
        if (neg) return -result;
        else return result;
    }
	public static void main(String[] args) {
		int a = 901000;
		System.out.println(reverse(a));
	}
}
