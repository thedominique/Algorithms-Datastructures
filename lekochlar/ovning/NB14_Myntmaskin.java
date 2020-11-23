package ovning;

import java.util.LinkedList;
import java.util.Queue;

public class NB14_Myntmaskin {
	
	public static int deep(int target) {
		return deep(1, target, 0);
	}
	
	public static int deep(int pts, int target, int coins) {
		if(pts>=target)
			return coins;
		
		int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
		if(pts*3<=target)
			c1 = deep(pts*3, target, coins+10);
		if(pts+4<=target)
			c2 = deep(pts+4, target, coins +5);
		return Math.min(c1, c2);
		
	}
	
	
	public static int wide(int target) {
		return wide(1, target, 0);
	}
	
	public static int wide(int pts, int target, int coins) {
		Queue<state> q = new LinkedList<state>();
		state s = new state(pts,coins);
		while(s.p<target) {
			if(s.p*3<=target)
				q.offer(new state(s.p*3, s.c+10));
			if(s.p+4<=target)
				q.offer(new state(s.p+4,s.c+5));
			s = q.poll();
		}
		return s.c;
	}
	
	
	private static class state {
		public int p, c;
		public state(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
	
	
	public static int backtrack(int target) {
		return backtrack(target, 0, 1);
	}
	
	private static int backtrack(int target, int coins, int pts) {
		
		while(pts<=target) {
			if(pts>=target)
				return coins;
			
			if(pts*3<=target){
				System.out.print("10 ->");
				backtrack(target, coins+10, pts*3);
				coins = coins-10;
				pts = pts/3;
				}
				
			else if(pts+4<=target){
				System.out.print("5 ->");
				backtrack(target, coins+5, pts+4);
				coins-=5;
				pts-=4;
				}
			
		}
		return coins;
	}
	
	
	public static void main(String[] args) {
		System.out.println(deep(109));
		System.out.println(wide(109));
		System.out.println(backtrack(109));
	}

}
