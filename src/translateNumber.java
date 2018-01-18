
public class translateNumber {
	public static String translate(int n) {
		String unit = "", dizaine = "", hundred = "";
		int i = 0, d = 0;
		while(n > 0) {
			d = n % 10;
			if (i == 0) {
				unit =  getUnite(d);
			}
			else if (i == 1) {
				dizaine = getDizaine(d, unit);
				unit  = control(unit, dizaine);
			}
			else hundred = getHundred(d);
			i++;
			n /= 10;
		}
		return hundred + dizaine + " " + unit;
	}
	private static String getUnite(int d) {
		String s = "";
		switch (d) {
		case 0: s = ""; break;
		case 1: s = "one"; break;
		case 2: s = "two"; break;
		case 3: s = "three"; break;
		case 4: s = "four"; break;
		case 5: s = "five"; break;
		case 6: s = "six"; break;
		case 7: s = "seven"; break;
		case 8: s = "eight"; break;
		case 9: s = "nine"; break;
		}
		return s;
	}
	private static String getDizaine(int d, String unit) {
		String s = "";
		switch (d) {
		case 1: s = getSpecialCase(unit); break;
		case 2: s = "twenty"; break;
		case 3: s = "thirty"; break;
		case 4: s = "fourty"; break;
		case 5: s = "fifty"; break;
		case 6: s = "sixty"; break;
		case 7: s = "seventy"; break;
		case 8: s = "eighty"; break;
		case 9: s = "ninety"; break;
		}
		return s;
	}
	private static String getHundred(int d) {
		String s = getUnite(d);
		return s + " hundred ";
	}
	private static String getSpecialCase(String u) {
		String s = "";
		if (u.equals("")) s = "ten";
		if (u.equals("one")) s = "eleven";
		if (u.equals("two")) s = "twelve";
		if (u.equals("three")) s = "thirteen";
		if (u.equals("four")) s = "fourteen";
		if (u.equals("five")) s = "fifteen";
		if (u.equals("six")) s = "sixteen";
		if (u.equals("seven")) s = "seventeen";
		if (u.equals("eight")) s = "eighteen";
		if (u.equals("nine")) s = "nineteen";
		return s;
	}
	private static String control(String unit, String diz) {
		if (diz.equals("ten")) return "";
		if (diz.equals("eleven")) return "";
		if (diz.equals("twelve")) return "";
		if (diz.equals("thirteen")) return "";
		if (diz.equals("fourteen")) return "";
		if (diz.equals("fifteen")) return "";
		if (diz.equals("sixteen")) return "";
		if (diz.equals("seventeen")) return "";
		if (diz.equals("eighteen")) return "";
		if (diz.equals("nineteen")) return "";
		else return unit;
	}
	public static void main(String[] args) {
		for (int i = 1; i <= 999; i++) {
			System.out.println(i + "  " + translate(i));
		}
	}
}

