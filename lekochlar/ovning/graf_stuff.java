package ovning;

import java.util.Arrays;

public class graf_stuff {

	private class Node {

	}

	public static int prim(int[][] w) {

		boolean[] visited = new boolean[w.length];

		int smallest = Integer.MAX_VALUE;
		int index = 0;
		int tot_w = 0;

		int current = 0;
		int next = 0;
		visited[current] = true;

		while (next < w.length - 1) {
			smallest = Integer.MAX_VALUE;
			for (int i = 0; i < w[current].length; i++) {
				if (w[current][i] < smallest && visited[i] == false) {
					smallest = w[current][i];
					index = i;
				}

			}
			next++;
			if(smallest!=Integer.MAX_VALUE) tot_w += smallest;
			visited[index] = true;
			current = index;
			System.out.println(index + " current : " + current + " Weight: " + smallest);
		}

		System.out.println(Arrays.toString(visited));
		
		
		/*for(int i = 0; i<visited.length; i++) {
			if(visited[i]!=true) {
				tot_w+=addMissing(i, w);
				visited[i] = true;
			}
			
		}*/
		System.out.println(Arrays.toString(visited));
		return tot_w;
	}
	
	static int next(int[] d, boolean[] taken){
		int dMin=Integer.MAX_VALUE;
		int minIndex=0;
		for(int i=0;i<d.length;i++)
			if(d[i]<dMin&&!taken[i]){
				dMin = d[i];
				minIndex = i;
			}
		return minIndex;
	}
	
	private static int addMissing(int index, int[][] s) {
		int sm = Integer.MAX_VALUE;
		for(int i = 0; i<s[index].length;i++) {
			if(s[index][i] < sm)
				sm = s[index][i];
		}
		System.out.println("HEJ" + sm);
		return sm;
	}

	public static void main(String[] args) {
		int X = Integer.MAX_VALUE;
		int[][] w = { 
				{ X, 2, X, X, X, 1, X, X }, 
				{ 2, X, 2, 2, 4, X, X, X }, 
				{ X, 2, X, X, 3, X, X, 1 },
				{ X, 2, X, X, 3, 1, X, X }, 
				{ X, 4, 3, 3, X, X, 7, X }, 
				{ 1, X, X, 1, X, X, 5, X },
				{ X, X, X, X, 7, 5, X, 6 }, 
				{ X, X, 1, X, X, X, 6, X } };

		int[][] f = { 
			//   0  1  2  3  4  5
				{X, 1, X, 3, X, X}, // 0
				{1, X, 1, X, X, X},  // 1
				{X, 1, X, 2, 1, 2}, // 2
				{3, X, 2, X, X, 1}, // 3
				{X, X, 1, X, X, X}, // 4
				{X, X , 2, 1, X, X}}; // 5

		System.out.println("Totalvikt: " + prim(w) + 
				" \n\n\nAbe: tot : " );//+ prim(f));
		System.out.println(primi(f));

	}
	
	public static int primi(int[][] w){
		int d[] = new int[w.length];
		d[0]=0;
		for(int i=1;i<d.length;i++)
			d[i]=Integer.MAX_VALUE;
		int p[] = new int [w.length];
		boolean[] taken = new boolean[w.length];
		for(int i=0;i<taken.length;i++)
			taken[i] = false;

		for(int i= 0;i<d.length-1;i++){
			int u = next(d,taken);
			taken[u]=true;
			for(int v=0;v<w[u].length;v++)
				if(!taken[v] && d[v]>w[u][v]){
					d[v]=w[u][v];
					p[v] = u;
				}
		}
//		System.out.println("Node A var startnode "+d[0]);
//        for(int i=1; i<p.length;i++)
//            System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(p[i]+'A')+" med vikt:"+d[i]);
		int distance =0;
		for(int connectDistance:d)
			distance+=connectDistance;
		return distance;
	}
	
	static int X = Integer.MAX_VALUE;
	static int[][] k = { 
			{ X, 2, X, X, X, 1, X, X }, 
			{ 2, X, 2, 2, 4, X, X, X }, 
			{ X, 2, X, X, 3, X, X, 1 },
			{ X, 2, X, X, 3, 1, X, X }, 
			{ X, 4, 3, 3, X, X, 7, X }, 
			{ 1, X, X, 1, X, X, 5, X },
			{ X, X, X, X, 7, 5, X, 6 }, 
			{ X, X, 1, X, X, X, 6, X } };
	
	static boolean[] taken = new boolean[k.length];
	static int[] d = {0, X, X, X, X, X, X, X};
	static int[] p = {0, X, X, X, X, X, X, X};

	
	public static void dick() {
		for(int i = 0; i<k.length;i++) {
			int u = nextD(d, taken);
			taken[u] = true;
			for(int j = 0; j<k.length;j++) {
				if(k[u][j]< X && d[j]>d[u]+k[u][j]){
					d[j] = d[u]+k[u][j];
					p[j] = u;
					}
			}
		}
	}
	
	private static int nextD(int[] d, boolean[] taken) {
		int index = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i<d.length;i++) {
			if(d[i]<index && taken[i]==false){
				index = d[i];
				minIndex = i;
				}
		}
		return minIndex;
		
	}
	
	
	
	
	
	

}
