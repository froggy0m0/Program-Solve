import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_14888 {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] numArr;
	static int[] OperatorCountArr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		OperatorCountArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // + - * /
		perm(0, numArr[0]);

		System.out.println(max + "\n" + min);
	}

	private static void perm(int cnt, int result) {
		if (cnt == N - 1) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < OperatorCountArr.length; i++) {
			if (OperatorCountArr[i] == 0)
				continue;
			int loop = OperatorCountArr[i];
			for (int j = 0; j < loop; j++) {
				if (i == 0) {
					OperatorCountArr[i]--;
					perm(cnt + 1, result + numArr[cnt + 1]);
					OperatorCountArr[i]++;
				} else if (i == 1) {
					OperatorCountArr[i]--;
					perm(cnt + 1, result - numArr[cnt + 1]);
					OperatorCountArr[i]++;
				} else if (i == 2) {
					OperatorCountArr[i]--;
					perm(cnt + 1, result * numArr[cnt + 1]);
					OperatorCountArr[i]++;
				} else {
					OperatorCountArr[i]--;
					if (i == 3)
						perm(cnt + 1, result / numArr[cnt + 1]);
					OperatorCountArr[i]++;
				}
			}

		}

	}

}
