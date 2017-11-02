package arrays;

public class SearchRange {
	public static int[] searchRange(int[] a, int target) {
		if (a == null || a.length == 0) return new int[]{-1, -1};
		
        int l = 0, r = a.length - 1;
        int ind = binarySearch(a, target, l, r);
        
        int[] aRes = new int[2];
        if (ind != -1) {
            int i = ind, j = ind;
            while (i-1 >= 0 && a[i] == a[i-1]) {
            	i--;
            }
            if (i == 1 && a[0] == a[1]) i--; // edge case to handle comparison with first element
            while (j+1 < a.length && a[j] == a[j+1]) {
            	j++;
            }
            if (j == a.length-2 && a[j] == a[a.length-1]) j++; // edge case to handle comparison with last element
            aRes[0] = i;
            aRes[1] = j;
        }
        else {
            aRes[0] = -1;
            aRes[1] = -1;
        }
        return aRes;
    }
    private static int binarySearch(int[] a, int target, int left, int right) {
        if (a == null || a.length == 0) return -1;
        if (a[left] > target || a[right] < target) return -1;
        
        int mid = (left + right) / 2;
        if (a[mid] == target) return mid;
        else if (a[mid] > target) {
            return binarySearch(a, target, left, mid-1);
        }
        else {
            return binarySearch(a, target, mid+1, right);
        }
    }
    public static void main(String[] args) {
    	int[] a = { 1, 4 };
    	int[] res = searchRange(a, 4);
    	System.out.println(res[0] + " - " + res[1]);
    }
}
