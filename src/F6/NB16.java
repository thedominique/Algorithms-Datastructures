package F6;

import java.util.LinkedList;
import java.util.Queue;

public class NB16 {
	public static void main(String[] args) {
		int pts = 109;
		System.out.println("Poäng att uppnå: " + pts);
		System.out.println("$ to win: " + myntMaskin(pts));
	}

	public static int myntMaskin(int pts) {
		return coins(pts, 1, 0);
	}

	private static int coins(int target, int currentpts, int cash) {
		
		Queue<Tillstand> q = new LinkedList<Tillstand>();
		 Tillstand t = new Tillstand(1,0,0);
		 while(t.currentpoints!=target) {
			 System.out.println(t.toString());
			 if(t.currentpoints +4 <= target)
				 q.offer(new Tillstand(t.currentpoints + 4, t.lvlNr+1, t.cash + 5));
			 if(t.currentpoints * 3 <= target)
				 q.offer(new Tillstand(t.currentpoints*3, t.lvlNr+1, t.cash+10));
			 t = q.poll();
		 }
		return t.cash;
		

	}

	private static class Tillstand {
		public int currentpoints, lvlNr, cash;

		public Tillstand(int p, int a, int c) {
			currentpoints = p;
			lvlNr = a;
			cash = c;
		}

		@Override
		public String toString() {
			return "Tillstand [currentpoints=" + currentpoints + ", lvlNr=" + lvlNr + ", cash=" + cash + "]";
		}
		
	}

}
