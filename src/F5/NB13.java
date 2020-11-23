package F5;

public class NB13 {
	public static double rOT(double n, double a, double e) {
		if(Math.abs(a*a-n)<e)
			return a;
		return rOT(n, (a*a+n)/(2*a), e);
	}
	
	public static void main(String[] args) {
		System.out.println(rOT(4,1,0.000001));
	}
}
