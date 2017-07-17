
public class CountAndSay {
	public static String count(int n) {
		String s = "1";
		int len ;
		int nb;
		int  j;
		while (n > 1) {
			j = 0;
			nb = 0;
			len = s.length();
			for (int i = 0; i < len; i++) {
				if (s.charAt(i) != s.charAt(j)) {
					nb = i - j;
					s += nb + "" + s.charAt(j);
					j = 0;
					i = -1;
					s = s.substring(nb);
					len = len - nb;
					nb = 0;
				}
			}
			nb = len;
			s += nb + "" + s.charAt(j);
			s = s.substring(nb);
			n--;
		}
		return s;
	}
	public static void main(String[] args) {
    //ok
		// sth else 5
		System.out.println(count(5));
	}
}
