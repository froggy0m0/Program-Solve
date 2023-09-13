import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16236 {
	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos other) {
			if (this.x == other.x)
				return this.y - other.y;
			return this.x - other.x;
		}

		@Override
		public String toString() {
			return "(" +x + "," + y + ")";
		}
		

	}

	static class Shark {
		int x, y, level, feed;

		public Shark(int x, int y, int level, int feed) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.feed = feed;
		}

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N;
	static int[][] board;
	static int count;
	static Shark shark;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		int sx = 0;
		int sy = 0;
		count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0)
					continue;
				if (board[i][j] == 9) {
					shark = new Shark(i, j, 2, 2);
				} else {
					count++;
				}
			}
		}
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(shark.x, shark.y));
		ArrayList<Pos> feedPosList = new ArrayList<Pos>();
		boolean[][] visited = new boolean[N][N];
		visited[shark.x][shark.y] = true;
		int time = 0;
		boolean check = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pos curPos = queue.poll();
				for (int d = 0; d < dx.length; d++) {
					int nx = curPos.x + dx[d];
					int ny = curPos.y + dy[d];
					if ((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
						if (visited[nx][ny])
							continue;
						if (board[nx][ny] <= shark.level) {
							queue.add(new Pos(nx, ny));
							
							visited[nx][ny] = true;
							if (board[nx][ny] != 0 && board[nx][ny] < shark.level)
								feedPosList.add(new Pos(nx, ny));
						}
					}
				}
			}
			time++;
			if (!feedPosList.isEmpty()) {
				check = true;
				Collections.sort(feedPosList);
				Pos feedPos = feedPosList.get(0);
				board[shark.x][shark.y] = 0;
				board[feedPos.x][feedPos.y] = 9;
				shark.x = feedPos.x;
				shark.y = feedPos.y;
				if (shark.feed == 1) {
					shark.level += 1;
					shark.feed = shark.level;
				} else {
					shark.feed -= 1;
				}
				result += time;
				break;
			}
		}
		if (check == true)
			bfs();
	}
}
