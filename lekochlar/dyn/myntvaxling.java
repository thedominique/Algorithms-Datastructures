package dyn;

public class myntvaxling {
	
	static int[] tab;
	static int[] c = {1, 5, 10};

	public static int vaxlröv(int belopp) {
		bajs(belopp);
		return vaxl(belopp);                                                                                                                                                                                                                             
	}
	private static int vaxl(int belopp) {
		if(tab[belopp]!=0)
			return tab[belopp];
		int v = belopp;
		
		for(int i = 1; i<belopp/2;i++)
			v = Math.min(v, vaxl(i)+vaxl(belopp-i));
		tab[belopp] = v;
		
		return tab[belopp];
	}
	
	private static void bajs(int belopp) {
		tab = new int[belopp+1];
		for(int i = 0; i<c.length;i++)
			tab[c[i]] = 1; 
	}
	
	public static void main(String[] args) {
		System.out.println(vaxlröv(20));
		System.out.println("get fucked");
	}
}
