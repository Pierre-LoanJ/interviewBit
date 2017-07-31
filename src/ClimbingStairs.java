
public class ClimbingStairs {

	public static int numberOfWays(int n) {
		if (n > 1) {
			return numberOfWays(n - 1) + numberOfWays(n - 2);
		}
		else if (n == 2) return 2;
		else  return 1;
		
	}
	public static void main(String[] args) {
		int steps =  6;
		System.out.println(numberOfWays(steps));
	}
}
