package F13;

public class MyntVaxling {
	
	public static int[] change = {1, 2, 5, 10};
	
	public static int change(int amount) {
		for(int i = 0; i<change.length-1; i++) {
			if(change[i] == amount)
				return 1;
		}
		int v = amount;
		for(int i = 1; i< amount/2; i++) {
			v = Math.min(v, change(i) + change(amount-i));
		}
		return v;
	}
	
	public static void main(String[] args) {
		
		System.out.println("change 10 = " + change(10));
		
		
	}

}
