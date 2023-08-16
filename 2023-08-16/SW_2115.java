import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class beeInfo {
	int val;
	int x;
	int y;

	public beeInfo(int val, int x, int y) {
		this.val = val;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "val = " + val + " - (" + x + ", " + y + ")";
	}

}

public class SW_2115 {
	static int N, M, C;
	static int answer;
	static int[][] board;
	static int[] num;
	static int maxVal;
	static boolean[] isSelected;

	static PriorityQueue<beeInfo> queue = new PriorityQueue<>((o1, o2) -> {
		if (o2.val == o1.val)
			return o1.x - o2.x;

		return o2.val - o1.val;
	});

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			queue.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			answer = 0;
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
						.toArray();
			}
			for (int x = 0; x < N; x++) {
				for (int y = 0; y <= N - M; y++) {
					num = new int[M];
					int idx = 0;
					for (int m = y; m < y + M; m++) {
						num[idx++] = board[x][m];
					}
					isSelected = new boolean[M];
					maxVal = 0;
					findMaxVal(0, 0);
					queue.add(new beeInfo(maxVal, x, y));
				}
			}
			func();

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void findMaxVal(int cnt, int v) {
		if (v > C)
			return;
		if (cnt == M) {
			int curVal = 0;
			for (int i = 0; i < M; i++) {
				if (isSelected[i])
					curVal += num[i] * num[i];
			}
			maxVal = Math.max(maxVal, curVal);
			return;
		}
		isSelected[cnt] = true;
		findMaxVal(cnt + 1, v + num[cnt]);
		isSelected[cnt] = false;
		findMaxVal(cnt + 1, v);

	}

	private static void func() {
		beeInfo b1 = queue.poll();
		beeInfo b2;
		while (!queue.isEmpty()) {
			b2 = queue.poll();
			if (b1.x != b2.x) {
				answer = b1.val + b2.val;
				return;
			} else if (b1.x == b2.x) {
				if ((int) Math.abs(b1.y - b2.y) > M) {
					answer = b1.val + b2.val;
					return;
				} else {
					continue;
				}
			}

		}
	}
}