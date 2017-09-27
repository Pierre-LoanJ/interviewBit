package arrays;
/*
Given an array and a value, remove all instances of that value in place and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Example:
Given input array nums = [3,2,2,3], val = 3
Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {
	public static int removeElementCorr(int[] A, int elem) {
		   int j = 0;    
		   for(int i = 0; i < A.length; i++){
		       if(A[i] != elem){
		           A[j++] = A[i];
		       }
		   }
		   
		   return j;
		}
	
	// The trick is to overwrite values that == elem with others values by not incrementing j in case of A[i] = elem
	
	/*
	 * 
	 * 
	 */
	
	public static int removeElement(int[] a, int v) {
		if (a == null || a.length == 0) return 0;
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == v) {
				while (i < a.length && a[i] == v) {
					i++;
				}
				a[j] = a[i];
				j++;
			}
			else {
				j++;
			}
		}
		return ++j;
	}
	public static void main(String[] args) {
		int i = 0;
		int[] a = { 2, 4, 1, 3, 1};
		a[++i] = 5;
		int r = removeElement(a, 1);
		System.out.println(r);
	}
}
