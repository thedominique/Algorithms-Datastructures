package F5;

import java.util.Arrays;

public class NB11 {
	
	public static int findLargestNum(int a[]) {
		return findmax(a, a.length-1);
	}
	private static int findmax(int a[], int index) {
		if(index==1) 
			return a[0];
		else 
			return Math.max(a[index-1], findmax(a, index-1));
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,-1,0,9,4,1,-10,2};
		System.out.println("Largest in array: "+findLargestNum(a));
	}

}
