import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_9229 {
	static int N, M;
	static int[] arr;
	static int result;
	static int[] numbers;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
			numbers = new int[2];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			result = 0;

//			func(0, 0, 0);
			func(0, 0);

			System.out.println("#" + tc + " " + ((result != 0) ? result : -1));
		}
	}

	private static void func(int cnt, int start) {
		if (cnt == 2) {
			int sum = numbers[0] + numbers[1];
			if (sum <= M) {
				result = Math.max(result, sum);
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			numbers[cnt] = arr[i];
			func(cnt + 1, i + 1);
		}

	}

}