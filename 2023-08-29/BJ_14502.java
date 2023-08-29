import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {
	static ArrayList<int[]> sPos = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] board;
	static int result;
	static int[][] wallPosArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
				if (board[x][y] == 2) {
					sPos.add(new int[] {x , y});
				}
			}
		}
		wallPosArr = new int[3][2];
		setWalls(0, 0);
		System.out.println(result);
	}

	private static void setWalls(int cnt, int start) {
		if (cnt == 3) {
			int count = bfs();
			result = Math.max(result, count);
			return;
		}
		
		for(int i = start; i < N*M; i++) {
			int x = i / M;
			int y = i % M;
			if(board[x][y] == 0) {
				wallPosArr[cnt] = new int[] {x, y};
				setWalls(cnt+1, i+1);
			}
		}
	}

	private static int bfs() {
		int[][] cBoard = new int[N][M];
		for(int x = 0; x < N; x++) cBoard[x] = board[x].clone();
		for (int[] wallPos : wallPosArr) {
			cBoard[wallPos[0]][wallPos[1]] = 1;
		}
		Queue<int[]> queue = new ArrayDeque<>();
		for(int[] pos : sPos) {
			queue.add(pos);
		}
		while(!queue.isEmpty()) {
			int[] posInfo = queue.poll();
			int curX = posInfo[0];
			int curY = posInfo[1];			
			for(int d = 0; d < dx.length; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if((-1 < nx && nx < N) && (-1 < ny && ny < M)) {
					if(cBoard[nx][ny] == 0) {
						queue.add(new int[] {nx, ny});
						cBoard[nx][ny] = 2;
					}
				}
			}
		}
		
		int count = 0; 
		for(int x = 0 ; x < N; x++) {
			for(int y = 0; y < M; y++) {
				if(cBoard[x][y] == 0) count++;
			}
		}
		return count;
	}
}
