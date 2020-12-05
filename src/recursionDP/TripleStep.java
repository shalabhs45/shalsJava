package recursionDP;

import java.util.Arrays;

public class TripleStep {

	static int stepCount(int n, int memo[]) {
		if (n < 0)
			return 0;
		if (n == 0 || n == 1)
			return 1;
		else if (memo[n] > -1)
			return memo[n];
		else {
			memo[n] = stepCount(n - 1, memo) + stepCount(n - 2, memo) + stepCount(n - 3, memo);
		}
		return memo[n];
	}

	static int countWays(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}

	static void initializeArray(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		System.out.println(stepCount(n, memo));
	}

	public static void main(String ar[]) {
		int step = 4;

		System.out.println(countWays(4));

		initializeArray(4);

	}
}
