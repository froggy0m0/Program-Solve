import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_01600_말이_되고픈_원숭이 {
	static class Pos {
		int x, y, count, depth;

		public Pos(int x, int y, int count, int depth) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.depth = depth;
		}
	}

	static int K, X, Y;
	static int[][] board;
	static int[][][] visited;
	static int minValue = Integer.MAX_VALUE;
	static int[][] hDelta = { { -1, -2 }, { -2, -1 }, { -2, +1 }, { -1, +2 }, { +1, +2 }, { +2, +1 }, { +2, -1 },
			{ +1, -2 } };
	static int[][] dDelta = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new int[X][Y];
		visited = new int[K + 1][X][Y];

		for (int x = 0; x < X; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < Y; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}

		dfs();
		System.out.println(minValue == Integer.MAX_VALUE ? -1 : minValue);
	}

	private static void dfs() {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(0, 0, K, 0));
		for (int k = 0; k <= K; k++)
			visited[k][0][0] = 1;
		while (!queue.isEmpty()) {
			Pos curPos = queue.poll();
			if (curPos.x == X - 1 && curPos.y == Y - 1) {
				if (minValue > curPos.depth) {
					minValue = curPos.depth;
				}
			}
			for (int d = 0; d < dDelta.length; d++) {
				int nx = curPos.x + dDelta[d][0];
				int ny = curPos.y + dDelta[d][1];

				if ((-1 < nx && nx < X) && (-1 < ny && ny < Y && board[nx][ny] == 0)) {
					if ((visited[curPos.count][nx][ny] == 0 || visited[curPos.count][nx][ny] > curPos.depth + 1)) {
						visited[curPos.count][nx][ny] = curPos.depth + 1;
						queue.add(new Pos(nx, ny, curPos.count, curPos.depth + 1));
					}
				}
			}

			if (curPos.count > 0) {
				for (int d = 0; d < hDelta.length; d++) {
					int nx = curPos.x + hDelta[d][0];
					int ny = curPos.y + hDelta[d][1];

					if ((-1 < nx && nx < X) && (-1 < ny && ny < Y && board[nx][ny] == 0)) {
						if (visited[curPos.count - 1][nx][ny] == 0
								|| visited[curPos.count - 1][nx][ny] > curPos.depth + 1) {
							visited[curPos.count - 1][nx][ny] = curPos.depth + 1;
							queue.add(new Pos(nx, ny, curPos.count - 1, curPos.depth + 1));
						}
					}
				}

			}
		}
	}
}
