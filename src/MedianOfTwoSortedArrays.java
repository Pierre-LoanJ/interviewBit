
public class MedianOfTwoSortedArrays {
	/*
	 the median of 2 arrays is not the mean of the medians of each arrays
	 the median is the median of the merged array.
	 */
	public static Double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length  == 0) return null;
        
        double m1 = computeMedian(nums1);
        double m2 = computeMedian(nums2);
        
        double m = (m1 + m2) / 2;
        return m;
    }

    private static double computeMedian(int[] a) {
        double m = 0;
        if (isEven(a.length)) {
        	//System.out.println((a.length / 2));
            m = (a[Math.round(a.length / 2) - 1] + a[Math.round(a.length / 2)]) / 2;
            //System.out.println("even m=" + m);
        }
        else {
            m = a[Math.round(a.length / 2)];
            //System.out.println("odd m=" + m);
        }
        return m;
    }
    private static boolean isEven(int length) {
        return length%2 == 0;
    }
    
    public static void main (String[] args) {
    	int[] a1 = {};
    	int[] a2 = {1};
    	int[] a3 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    	int[] a4 = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109};
    	Double r = findMedianSortedArrays(a1, a2);
    	System.out.println("r=" + r);
    }
}
