package ovning;

import java.util.Arrays;

public class NB11 {

	public static int findMaxRec(int[] a) {
		if (a.length == 1)
			return a[0];

		return Math.max(findMaxRec(Arrays.copyOfRange(a, 0, a.length / 2)),
				findMaxRec(Arrays.copyOfRange(a, a.length / 2, a.length)));
	}

	public static void main(String[] args) {
		int[] a = {88, 2, 5, 3, 23, -2, 9, 46 };
		System.out.println("Max :" + findMaxRec(a));
	}

}
