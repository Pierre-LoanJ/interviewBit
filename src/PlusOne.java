
public class PlusOne {
	public static int[] plusOne(int[] a) {
        if (a == null || a.length == 0) throw new NullPointerException();
        for (int i = a.length - 1; i >= 0; i--) {
            if (++a[i] <= 9) break;
            else {
            	a[i] = 0;  // reset digit and go next
                if (i == 0) { // first digit
                    int[] b = new int[a.length + 1];
                    for (int j = 1; j < b.length; j++) {
                        b[0] = 1;
                        b[j] = a[j - 1];
                    }
                    a = b;
                }
            }
        }
        return a;
    }
	public static void main(String[] args) {
		int[] a = {9};
		System.out.println(plusOne(a));
	}
}
