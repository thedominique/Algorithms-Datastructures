package ovning;

import java.util.Arrays;

public class sortering {

	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length);
	}

	private static void mergeSort(int[] a, int start, int stop) {
		if (a.length == 1)
			return;

		int[] b = Arrays.copyOfRange(a, 0, stop / 2);
		int[] c = Arrays.copyOfRange(a, stop / 2, stop);
		mergeSort(b);
		mergeSort(c);

		merge(a, b, c);

	}

	private static void merge(int[] o, int[] b, int[] c) {
		int og_index = 0, b_index = 0, c_index = 0;

		while (b_index < b.length && c_index < c.length) {
			if (b_index < b.length && b[b_index] <= c[c_index])
				o[og_index++] = b[b_index++];
			else if (c_index < c.length && c[c_index] <= b[b_index])
				o[og_index++] = c[c_index++];

		}

		while (c_index < c.length) {
			o[og_index++] = c[c_index++];
		}

		while (b_index < b.length) {
			o[og_index++] = b[b_index++];
		}

	}
	

	public static void main(String[] args) {
		int[] a = { 5, 2, 9, 5, 10, 93, -2 };

		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

}
