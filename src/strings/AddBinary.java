package strings;
/*
 * leetcode
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class AddBinary {
	    public static String addBinary(String a, String b) {
	        if (a == null || b == null || (a.length() == 0 && b.length() == 0)) return "";
	        if (a.length() == 0) return b;
	        if (b.length() == 0) return a;
	        
	        boolean isALarger =  a.length() > b.length() ? true : false;
	        
	        int left = isALarger ? a.length() - b.length() : b.length() - a.length();
	        String pref = "";
	        while (left > 0) {
	        	pref += "0";
	        	left--;
	        }
	        if (isALarger) b = pref + b;
	        else		   a = pref + a;
	        
	        String s = "";
	        int r = 0;
	        int aa = 0;
	        int bb = 0;
	        char charA = '\0';
	        char charB = '\0';
	        int sum = 0;
	        int len = isALarger ? a.length() - 1 : b.length() - 1;
	        int i = len;
	        while (i >= 0) {
	        	
	            aa = Integer.parseInt(a.charAt(i) + "");
	            bb = Integer.parseInt(b.charAt(i) + "");
	           /*
	            byte aaa = Byte.decode(a.charAt(i) + "");
	            byte bbb = Byte.decode(b.charAt(i) + "");
	            byte res = (byte) (aaa & bbb);
	            */
	            
	            sum = aa + bb + r;
	            if (sum % 2 == 1) {
	                // impair
	                if ( (aa == 1 && bb == 1 && r == 1)) { // 111
	                  // r rest à 1;
	                	r = 1;
	                }
	                else {                // 100 ou 001
	                    r = 0;
	                }
	                 s += 1 + "";
	            } 
	            else {
	                // pair
	                if ( (aa == 0 && bb == 0 && r == 0) ) {
	                    // 000
	                } 
	                else  r = 1;
	                
	                s += 0 + "";
	            }
	             
	            // ANOTHER SOLUTION WITH BYTES ??
	            /*
	            if ( (aa ^ bb ^ r) ) {                // 01 0 ou 00 1
	                s += 1 + "";
	                if (r == 1) r = 0;
	                else r = 1;                       // a = 1 et b = 1
	            }
	            else if ( !(aa ^ bb ^ r) ) {          // 000 ou 111 ou 10 1
	                if ( a & b & r) {                 // 111
	                    s += 1 + "";
	                    r = 1;                        // r reste à 1
	                }
	                else {                            // 000
	                    s += 0 + "";
	                    r = 0;                        // r reste à 0
	                }
	            }
	            */
	            i--;
	        }
	        if (r == 1) s += "1";
	        return reverse(s);
	    }
	    private static String reverse(String s) {
	    	String r = "";
	    	for (int j = s.length() - 1; j >= 0; j--) {
	    		r += s.charAt(j);
	    	}
	    	return r;
	}
	    public static void main(String[] args) {
	    	String a = "01010";
	    	String b = null;
	    	System.out.println(addBinary(a, b));
	    }
}
