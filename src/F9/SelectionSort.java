package F9;

import java.util.Arrays;

public class SelectionSort {
	public static int[] selectionsort(int [] a) {
		int minIndex = 0;
		for(int i = 0; i<a.length-1; i++) {
			minIndex = i;
			for(int j = i; j<a.length; j++) {
				if(a[j]<a[minIndex]) {
					minIndex = j;
				}
			}
			//byt plats på a[index] och a[minIndex] 
			int tmp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = tmp;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = {1,8,5,-2,6,10,3,2};
		System.out.println(Arrays.toString(selectionsort(a)));
		
	}
	
	
}
