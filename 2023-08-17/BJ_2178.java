import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJ_2178 {
	static int N, M;
	static int[][] board;
	static int[][] distanceBoard;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = 0;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = inpTemp[0];
		M = inpTemp[1];
		board  = new int[N][M];
		distanceBoard = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(distanceBoard[i], 9999);
		}
		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		int curX = 0;
		int curY = 0;
		bfs(curX, curY, 1);
		System.out.println(distanceBoard[N-1][M-1]);
	}
	private static void bfs(int curX, int curY, int result) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {curX, curY, result});
		distanceBoard[curX][curY] = result;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			curX = info[0];
			curY = info[1];
			result = info[2];
			for(int i = 0; i < dx.length; i++) {
				int nx = curX+ dx[i];
				int ny = curY + dy[i];
				if((-1 < nx && nx < N) && (-1 < ny && ny < M)) {
					if(board[nx][ny] == 1 && distanceBoard[nx][ny] > result+1) {
						distanceBoard[nx][ny] = result+1;
						queue.add(new int[] {nx, ny, result+1});
					}
				}
			}
		}
		
	}

}