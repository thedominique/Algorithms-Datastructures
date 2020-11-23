/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB33;

import java.util.Arrays;

/**
 *
 * @author bfelt
 */

public class Prim {


	
	public static void main(String[] args) {
		int X = Integer.MAX_VALUE;
		int[][] w = {	
						{	X, 2, X, X, X, 1, X, X},
						{	2, X, 2, 2, 4, X, X, X},
						{	X, 2, X, X, 3, X, X, 1},
						{	X, 2, X, X, 4, 1, X, X},
						{	X, 4, 3, 4, X, X, 7, X},
						{	1, X, X, 1, X, X, 5, X},
						{	X, X, X, X, 7, 5, X, 6},
						{	X, X, 1, X, X, X, 6, X}};
		int[] p = prim(w);
		System.out.println("Node A var startnode");
		System.out.println(Arrays.toString(p));
		for(int i=1; i<p.length;i++)
			System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(p[i]+'A'));
		int distance =0;
		for(int i=1;i<w.length;i++)
			distance+=w[i][p[i]];
		System.out.println("Totalvikt: "+distance);
	}

	public static int minSpanTree(int[][] w, int[] connections){
		int[] p = prim(w);

		System.arraycopy(p,0,connections,0,connections.length);

		int distance =0;
		for(int i=1;i<w.length;i++)
			distance+=w[i][p[i]];

		return distance;
	}
	
	private static int next(int[] d, boolean[] taken) {
		int index = Integer.MAX_VALUE;
		int minindex = 0;
		for(int i = 0; i < d.length; i++) {
			if(d[i] < index && taken[i] == false) {
				index = d[i];
				minindex = i;
			}
		}
		return minindex;
	}
	
	
	// w - förbindelsematris, prim returnerar en array p, där p[i] är den nod som noden i anslöts till (i>0)
	private static int[] prim(int[][] w){
		int[] d = new int[w.length];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[0] = 0;
		boolean[] taken = new boolean[w.length];
		int[] p = new int[w.length];
		Arrays.fill(p, 0);
		for(int i = 0; i < d.length; i++) {
			int u = next(d, taken);
			taken[u] = true;
			for(int v = 0; v < w[u].length; v++) {
				if(w[u][v] < d[v] && taken[v] == false && w[u][v] < Integer.MAX_VALUE) {
					d[v] = w[u][v];
					p[v] = u; // närmsta anslutning?
				}
			}
		}
		return p;
	}
}
