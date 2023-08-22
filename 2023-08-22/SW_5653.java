import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SW_5653 {
	static class Cell implements Comparable<Cell> {
		int actTime;
		int v;
		int x;
		int y;

		public Cell(int actTime, int v, int x, int y) {
			this.actTime = actTime;
			this.v = v;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Cell other) {
			if (this.actTime == other.actTime)
				return other.v - this.v;
			return this.actTime - other.actTime;
		}

		@Override
		public String toString() {
			return "Cell [actTime=" + actTime + ", v=" + v + ", x=" + x + ", y=" + y + "]";
		}
	}

	static int[][] board;
	static int size, K;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[] actCell;
	static PriorityQueue<Cell> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int N = inpTemp[0];
			int M = inpTemp[1];
			K = inpTemp[2];
			size = N + (2 * K);
			board = new int[size][size];
			actCell = new int[K + 11];
			pq.clear();
			Arrays.fill(actCell, 0);
			for (int x = 0; x < N; x++) {
				inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for (int y = 0; y < M; y++) {
					board[x + K][y + K] = inpTemp[y];
					if (board[x + K][y + K] != 0) {
						pq.add(new Cell(board[x + K][y + K], board[x + K][y + K], x + K, y + K));
						actCell[board[x+K][y+K]]++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + bfs());
		}

	}

	private static int bfs() {		
		PriorityQueue<Cell> beforeAct = new PriorityQueue<>(); // 활성화이전 상태저장 -> 활성상태가되면 빼내서 bfs진행
		int curTime = 0;
		while (!pq.isEmpty()) {
			if (curTime == K)
				break;
			while (pq.peek().actTime == curTime) {
				Cell curCell = pq.poll();
				if(board[curCell.x][curCell.y] != 1)actCell[curCell.actTime + curCell.v-1]++;
				for (int d = 0; d < dx.length; d++) {
					int nx = curCell.x + dx[d];
					int ny = curCell.y + dy[d];
					if (board[nx][ny] == 0) {
						board[nx][ny] = curCell.v;
						pq.add(new Cell(curTime + curCell.v+1, curCell.v, nx, ny));
						
					}
				}
			}
			curTime++;
		}
		int count = 0;
		for (int i = curTime; i < actCell.length; i++) {
			count += actCell[i];
		}
		return pq.size() + count;
	}
}