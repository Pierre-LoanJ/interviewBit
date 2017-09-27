package dynamicProgramming;

public class TrailingZeros {
	public static int trailingZeroes(int n) {
		if (n <= 1) return 0;
        int tz = 0, nbFive = 0, nbTwo = 0;
        nbTwo = n / 2;
        nbFive = (n / 5);
        
        int min = Math.min(nbFive, nbTwo);
        return min + trailingZeroes(min);
    }
	public static void main(String[] args) {
		int n = 25;
		int r = trailingZeroes(n);
		System.out.println(r);
	}
}
