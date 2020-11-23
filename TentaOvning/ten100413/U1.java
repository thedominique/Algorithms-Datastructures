package ten100413;

import java.util.Stack;

public class U1 {

	public static void main(String[] args) {
		System.out.println(counting(3));
		System.out.println(counting2(57));
	}

	public static int counting(int target) {
		return counting(target, 1, 0);
	}

	private static int counting(int target, int current, int stps) {
		if (current == target)
			return stps;
		else if (current > target)
			return -1;
		else {
			int a = counting(target, current * 3, stps + 1);
			int b = counting(target, current + 4, stps + 1);

			if (a == -1)
				return b;
			if (b == -1)
				return a;

			return Math.min(a, b);
		}
	}

	public static int counting2(int target) {
		return -1;
	}

}
