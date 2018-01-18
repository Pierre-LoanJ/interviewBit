package integers;

public class HammingWeight {
	public static int hamming(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
    public static int hammingWeight(int n) {
    	if (n > Integer.MAX_VALUE) return 1;
        int c = 0;
        while (n > 0) {
            if (n % 2 == 1) c++;
            n = n/2;
        }
        return c;
    }
    public static void main(String[] args) {
    	int n = 87;
    	System.out.println(hamming(n));
    }
}
