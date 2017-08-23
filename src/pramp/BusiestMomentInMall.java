package pramp;

public class BusiestMomentInMall {
	static int findBusiestPeriod(int[][] data) {
	    if (data == null) return 0;
	    int maxCount = 0, timestamp = 0, currentGlobalCount = 0;
	    
	    int previousTimeStamp = data[0][0];
	    for (int i = 0; i < data.length; i++) {
	      int[] sub = data[i];
	      int timeStamp = sub[0];
	      
	      if (i > 1) previousTimeStamp = data[i-1][0];
	      
	      if (previousTimeStamp != timeStamp) currentGlobalCount = 0;
	      
	      if (sub[2] == 1) currentGlobalCount += sub[1];
	      else currentGlobalCount -= sub[1];
	      
	      if (currentGlobalCount > maxCount) { // could be optimized as we don't need to check this each time
	    	  									// but only when we've been through one timestamp
	    	  									// to do so we need to know if next timestamp is same
	    	  									// so instead of working with previous, work with next
	    	maxCount = currentGlobalCount;
	        timestamp = sub[0];
	    }
	  }
	     return timestamp;
	 }
	public static void main(String[] args) {
		int[][] data = { { 90, 2, 1 }, { 90, 2, 0 }, { 90, 5, 1 }, { 91, 4, 1 }, 
						 { 91, 2, 0 }, { 92, 8, 0 }, { 92, 4, 1 }, { 93, 1, 1 }, 
						 { 93, 108, 1 }, { 93, 6, 1 }, { 94, 0 , 1 }, { 94, 3, 0 } };
		System.out.println(findBusiestPeriod(data));
	}
}
