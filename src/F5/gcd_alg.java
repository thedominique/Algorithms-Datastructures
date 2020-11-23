package F5;

public class gcd_alg {
	
	public static void calcGCD(int a, int b) {
		
	}
	
	private static int gcd(int a, int b) {
		if(b==0) 
			return a;
		else
			return gcd(b, a%b);
	}

}
