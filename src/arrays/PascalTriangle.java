package arrays;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	 public List<List<Integer>> generate(int numRows) {
		 List<List<Integer>> all = new ArrayList<List<Integer>>();
	        if (numRows <= 0) return all;
		    ArrayList<Integer> first = new ArrayList<Integer>();
		    first.add(1);
		    all.add(first);
		        
		    List<Integer> last = null;
	        for (int i = 1; i < numRows; i++) {
	            List<Integer> a = new ArrayList<Integer>();
	            last = all.get(i-1);
	            a.add(1);
	            for (int j = 0; j < last.size() - 1; j++) {
	                    a.add(last.get(j) + last.get(j+1)); // be careful with j+1 about indexOutOfBoundException here!
	            }
	            a.add(1);
	            all.add(a);
	        }
	        return all;
	    }
	 public static void main(String[] args) {
		 
	 }
}
