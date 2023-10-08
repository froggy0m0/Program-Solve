import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int minValue = Integer.MAX_VALUE;
	static int totalCount;
	static int[] selectArr;
	static Queue<Pos> queue = new ArrayDeque<>();
	static ArrayList<Pos> virusPosList = new ArrayList<>();
	static int curTime;
	static boolean check = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selectArr = new int[M];
		totalCount = 0;
		int[][] board = new int[N][N];
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < N; y++) {
				int tempVal = Integer.parseInt(st.nextToken());
				if (tempVal == 0)
					totalCount++;
				else if (tempVal == 2)
					virusPosList.add(new Pos(x, y));

				board[x][y] = tempVal;
			}
		}
		combination(0, 0, board, totalCount);
		if(totalCount == 0) minValue = 0;
		System.out.println(minValue == Integer.MAX_VALUE ? -1 : minValue);
	}

	private static void combination(int cnt, int start, int[][] board, int totalCount) {
		if (cnt == M) {
			dfs(board, totalCount);
			queue.clear();
			if(check==true)minValue = Math.min(minValue, curTime);
			return;
		}

		for (int i = start; i < virusPosList.size(); i++) {
			selectArr[cnt] = i;
			combination(cnt + 1, i + 1, board, totalCount);
		}
	}

	private static void dfs(int[][] board, int totalCount) {
		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int count = 0;
		boolean[][] isVisited = new boolean[N][N];
		curTime = Integer.MAX_VALUE;
		check = false;
		for(int idx : selectArr) {
			Pos virusPos = virusPosList.get(idx);
			queue.add(virusPos);
			isVisited[virusPos.x][virusPos.y] = true;
		}
		int depth = 0 ;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Pos curPos = queue.poll();
				if(depth+1 >= minValue) return;
				for (int d = 0; d < delta.length; d++) {
					int nx = curPos.x + delta[d][0];
					int ny = curPos.y + delta[d][1];
						
					if ((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
						if (isVisited[nx][ny] == true || board[nx][ny] == 1) continue;
						
						if (board[nx][ny] == 0) {
							count++;
							curTime = depth + 1;
						}
	
						queue.add(new Pos(nx, ny));
						isVisited[nx][ny] = true;
						if (count == totalCount) {
							check = true;
							return;
						}
					}
				}
			}
			depth++;
		}
	}
}