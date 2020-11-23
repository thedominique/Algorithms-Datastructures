package F9;

import java.util.Arrays;

public class ShellSort {
	
	public static void shellSort(int[] a) {
		int gap = a.length/2;
		
		while(gap>0) {
			for(int i=gap; i<a.length;i++) {
				int data = a[i];
				int dataIndex = i;
				while(dataIndex>gap-1 && data<a[dataIndex-gap]) {
					a[dataIndex] = a[dataIndex-gap];
					dataIndex-=gap;
				}
				a[dataIndex] = data;
			}
			if(gap==2) gap = 1;
			else gap = gap/2;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5, 2, 43, -1, 49, 0, -4, 1};
		shellSort(a);
		System.out.println(Arrays.toString(a));
	}

}
