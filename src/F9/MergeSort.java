package F9;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] a) {

		if (a.length == 1) {
			return;
		}
		int[] b = Arrays.copyOfRange(a, 0, a.length / 2);
		int[] c = Arrays.copyOfRange(a, a.length / 2, a.length);

		mergeSort(b);
		mergeSort(c);
		merge(b, c, a);
	}

	private static int[] merge(int[] a, int[] b, int[] c) {
		int indexa = 0, indexb = 0, indexc = 0;
		while (indexa < a.length && indexb < b.length) {
			if (a[indexa] <= b[indexb]) {
				c[indexc++] = a[indexa];
				indexa++;
			} else {
				c[indexc++] = b[indexb];
				indexb++;
			}
		}
		while (indexa < a.length) {
			c[indexc++] = a[indexa];
			indexa++;
		}
		while (indexb < b.length) {
			c[indexc++] = b[indexb];
			indexb++;
		}
		
		return c;
	}

	public static void main(String[] args) {

		int[] a = { 7, 2, 19, 762, -1, 5, 1, -8 , 9};
		System.out.println(Arrays.toString(a));
		mergeSort(a);
		System.out.println(Arrays.toString(a));

	}

}
