package F9;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 1, 3, 7, 2, -7, -2, 47, -9 };
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	// sorterar partitions
	private static void quickSort(int[] a, int low, int high) {
		if (low < high + 1) { // more than one left to sort?
			int p = partition(a, low, high);
			quickSort(a, low, p - 1); // sort left
			quickSort(a, p + 1, high); // sort right
		}
	}

	private static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	// returns random pivot index within range low-high >> O(nlogn)
	private static int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}

	// jämför med pivotvärdet, flyttar element vänster om pivot till vänster och höger om piv till höger
	// returns pivot index.
	private static int partition(int[] a, int low, int high) {
		swap(a, low, getPivot(low, high));
		int border = low + 1; // vänster pointer till höger om pivot
		for (int i = border; i <= high; i++) { // iterera över element i denna partition och jämför med a[low] som är pivot
			if (a[i] < a[low]) {
				swap(a, i, border++);
			}
		}
		swap(a, low, border - 1); // swappar in pivot på rätt plats i array 
		return border - 1;
	}

}
