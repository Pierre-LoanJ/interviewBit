package integers;

public class CountPrimes {
	public static int countPrimes(int n) {
        int cnt = 0;
        int sub = n-1;
        while (sub > 1) {
            int i = 2;
            boolean isPrime = true;
            while (i < sub) {
                if (sub % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
            if (isPrime) cnt++;
            sub--;
        }
        return cnt;
    }
	/* smarter solution
	Keep track of all multiples of i (to n-1) if i is "notPrime" 
	*/ 
	 public int countPrimesSmart(int n) {
	        boolean[] notPrime = new boolean[n];
	        int count = 0;
	        for (int i = 2; i < n; i++) {
	            if (notPrime[i] == false) {
	                count++;
	                for (int j = 2; i*j < n; j++) {
	                    notPrime[i*j] = true;
	                }
	            }
	        }
	        
	        return count;
	    }
	public static void main(String[] args) {
		int n = 499979;
		long s = System.currentTimeMillis();
		System.out.println(countPrimes(n));
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
}
