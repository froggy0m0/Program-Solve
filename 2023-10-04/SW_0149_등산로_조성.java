import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_0149_등산로_조성 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, K;
	static int[][] board;
	static int maxValue;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			maxValue = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][N];

			int topValue = 0;
			ArrayList<Pos> topList = new ArrayList<>();
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 0; y < N; y++) {
					int val = Integer.parseInt(st.nextToken());
					board[x][y] = val;
					if (topValue <= val) {
						if (topValue < val) {
							topList.clear();
							topValue = val;
						}
						topList.add(new Pos(x, y));
					}
				}
			}

			for (Pos pos : topList) {
				visited = new boolean[N][N];
				dfs(pos, 1, true);
			}

			System.out.println("#" + tc + " " + maxValue);
		}
	}

	private static void dfs(Pos pos, int depth, boolean isAvailable) {
		maxValue = Math.max(maxValue, depth);
		visited[pos.x][pos.y] = true;
		int curVal = board[pos.x][pos.y];

		for (int d = 0; d < delta.length; d++) {
			int nx = pos.x + delta[d][0];
			int ny = pos.y + delta[d][1];

			if ((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
				if (visited[nx][ny])
					continue;

				int nextVal = board[nx][ny];
				Pos nextPos = new Pos(nx, ny);

				if (nextVal < curVal) {
					dfs(nextPos, depth + 1, isAvailable);
					visited[nextPos.x][nextPos.y] = false;
				} else if (isAvailable == true) {
					for (int k = 1; k <= K; k++) {
						if (nextVal - k < curVal) {
							board[nx][ny] -= k;
							dfs(nextPos, depth + 1, false);
							board[nx][ny] += k;
							visited[nextPos.x][nextPos.y] = false;
						}
					}
				}
			}
		}

	}
}
