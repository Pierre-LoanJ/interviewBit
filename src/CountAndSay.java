
public class CountAndSay {
	public static String count(int n) {
		String s = "1";
		int j, k, nb;
		int nbTot;
		int len = 0;
		while (n - 1 > 0) {
			j = 0;
			nb = 0;
			k = 0;
			
			len = s.length();
			nbTot = 0;
			for (int i = 0; i < len; i++) {
				if (len == 1 || i + 1 < len && s.charAt(i) != s.charAt(i + 1)) {			
					nb = i - j + 1;
					//s += "" + nb + s.charAt(j);
					nbTot += nb + 1;
					nb = 0;
				}
			}
			s += "" + nb + s.charAt(j);
			//s += "" + len + s.charAt(len - 1);
			nbTot += len + 1;
			s = s.substring(nbTot - 1);
			n--;
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(count(3));
	}
}
