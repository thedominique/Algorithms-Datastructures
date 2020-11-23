package F5;

public class NB12 {
	
	public static int calcPow(int x, int n) {
		return calc(x, n);
	}
	
	public static int calc(int x, int n) {
		if(n==0)
			return 1;
		return x * calc(x,n-1);
	}
	
	/*
	 * int tmp = calc(x, n/2);
		if (n % 2 == 0) 
            return tmp*tmp; 
        else
            return x * tmp * tmp
	 */
	
	public static int calcPowIntr(int x, int n) {
		int ans = x;
		while(n-1>0) {
			ans = ans * x;
			n--;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("Ans: " + calcPow(2,5));
		System.out.println("Intr: "+calcPowIntr(2,5));
	}
	
}
