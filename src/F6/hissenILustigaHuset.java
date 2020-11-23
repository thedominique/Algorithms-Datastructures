package F6;

public class hissenILustigaHuset {
	static int antalResorHiss(int n, int upp, int ned, int position, int destination, int antalResor) {
		if(position== destination)
			return antalResor;
		else if(antalResor>30)
			return Integer.MAX_VALUE;
		else {
			int antalUpp = Integer.MAX_VALUE, antalNed = Integer.MAX_VALUE;
			if(position+upp <= n)
				antalUpp = antalResorHiss(n,upp,ned,position+upp,destination,antalResor+1);
			if(position-ned >=1)
				antalNed = antalResorHiss(n,upp,ned,position-ned,destination,antalResor+1);
			return Math.min(antalUpp, antalNed);
		}
		
	}

	static int antalResorHiss(int n, int upp, int ned, int destination) {
		return antalResorHiss(n, upp, ned, 1, destination, 0);
	}
	
	public static void main(String[] args) {
		System.out.println(antalResorHiss(75, 15, 8, 35));
	}
}
