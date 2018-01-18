package integers;

public class Sqrt {
	public static int mySqrt(int x) {
		int a = 46341 * 46341;  // = -2,147,479,015 !! needs long !! this is the trap
        if (x < 0)  return -1;  // or throw an error
        if (x == 0) return 0;
        long i = 1;
        while (i * i <= x) {
            i++;
        }
        return (int) (i - 1);
    }
	public static long binarySqrt(int x) {
		/* with binary search
		Let  's' be the answer. We know that 0 <=  s <= x

		Consider any random number r
    		If r*r <= x, s >= r
    		If r*r >  x, s <  r 
		*/
		if (x < 0)  return -1; // or throw an error
		if (x == 0) return 0;
		if (x == 1) return 1;
		
		long start = 0, end = x, mid = 0;
		while (start < end) {
			 mid = (end + start) / 2;
			 
			 if (mid * mid < x) {
				 start = mid;
			 }
			 else if (mid * mid > x) {
				 end = mid;
			 }
			 else return mid;
		}
		return mid;
	}
	public static void main(String[] args) {
		System.out.println(binarySqrt(25));
	}
}
