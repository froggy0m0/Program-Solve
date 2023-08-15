

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_4008 {
	static int[] numArr;
	static int[] operatorArr;
	static int minValue;
	static int maxValue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			minValue = Integer.MAX_VALUE;
			maxValue = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());

			operatorArr = new int[4];
			operatorArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			numArr = new int[N];
			numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			perm(1, numArr[0]); // idx, result
			answer.append("#" + tc + " " + (maxValue - minValue) + "\n");
		}
		System.out.println(answer.toString());
	}

	private static void perm(int cnt, int result) {
		if (cnt == numArr.length) {
			minValue = (minValue > result) ? result : minValue;
			maxValue = (maxValue < result) ? result : maxValue;
			return;
		}
		for (int i = 0; i < operatorArr.length; i++) {
			if (operatorArr[i] == 0)
				continue;
			operatorArr[i]--;
			if (i == 0) {
				perm(cnt + 1, result + numArr[cnt]);
			} else if (i == 1) {
				perm(cnt + 1, result - numArr[cnt]);
			} else if (i == 2) {
				perm(cnt + 1, result * numArr[cnt]);
			} else if (i == 3) {
				perm(cnt + 1, result / numArr[cnt]);
			}
			operatorArr[i]++;
		}

	}

}
