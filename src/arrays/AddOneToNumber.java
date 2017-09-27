package arrays;
import java.util.ArrayList;
// car counter
public class AddOneToNumber {
		public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		    int currentDigit = 0;
		    for (int i = a.size() - 1; i >= 0; i--) {
		    	currentDigit = a.get(i);
		        if (currentDigit != 9) {
		            a.set(i, a.get(i) + 1 );
		            break;
		        }
		        else {
		        	a.set(i, 0 );
		        	if (i == 0) { // for instance [ -> 9 <- , 0, 0]
		        		a.add(0, 1);
		        	}
		            continue;
		        }
		    }
		    currentDigit = 0;
		    for (int j = 0; j < a.size(); j++) {
		    	currentDigit = a.get(j);
		    	if (currentDigit == 0) {
		    		a.remove(j);
		    		j--;
		    	}
		    	else {
		    		break;
		    	}
		    }
		    return a;
		}

	public static void main(String[] args) {
		int[] t = {9, 9, 9, 9 };
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (int j = 0; j < t.length; j++) {
			input.add(j, t[j]);
		}
		ArrayList<Integer> r = new ArrayList<Integer>();
		r = plusOne(input);
		System.out.println(r);
	}
}
