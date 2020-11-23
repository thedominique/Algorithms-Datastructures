package F5;

public class NB15 {
	
	public static int strtoBinary(String s) {
		s = rev(s);
		return tobin(s, s.length()-1);
	}
	
	private static int tobin(String s, int n) {
		if(n==0) {
			if(s.charAt(n)=='1')
				return 1;
			return 0;
		}	
		if(s.charAt(n)=='1')
			return (int) Math.pow(2, n) + tobin(s, n-1);
		else
			return 0 + tobin(s, n-1);
	}
	
	private static String rev(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	public static String intToString(int a) {
		String s = "";
		return inttoS(a, s);
	}
	
	private static String inttoS(int a, String s ) {
		if(a == 0)
			return "0";
		if(a == 1)
			return "1";
		if(a % 2 == 0)
			return s += inttoS(a/2, s) + "0";
		return s += inttoS(a/2, s) + "1";
	}
	
	public static void main(String[] args) {
		String s = "1001";
		
		System.out.println("ans: "+strtoBinary(s));
		
		int x =9;
		System.out.println("int to string: " + intToString(x));
	}

}
