package F5;

public class NB14 {
	public static void main(String[] args) {
		int pts = 109;
		System.out.println("Poäng att uppnå: " + pts);
		System.out.println("$ to win: " + myntMaskin(pts));
	}

	public static int myntMaskin(int pts) {
		return coins(pts, 1, 0);
	}

	private static int coins(int max, int currentpts, int cash) {
		int cost1, cost2;
		if (currentpts > max) {
			return Integer.MAX_VALUE;
		}
		else if(currentpts >= max) 
			return cash;
		
		else {
			cost1 = coins(max, currentpts * 3, cash + 10);

			cost2 = coins(max, currentpts + 4, cash + 5);
			return Math.min(cost1, cost2);
		}
		
	}

}
