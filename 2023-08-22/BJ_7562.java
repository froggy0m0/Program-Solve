import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJ_7562 {
	static boolean[][] board;
	static int N;
	static int[] dx = {-1, -2, -2, -1, +1, +2, +2, +1};
	static int[] dy = {-2, -1, +1, +2, +2, +1, -1, -2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int result = 0;
			N = Integer.parseInt(br.readLine());
			board = new boolean[N][N];
			int[] curInfo= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] targetInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			result = bfs(curInfo[0], curInfo[1], targetInfo[0], targetInfo[1]);
			
			System.out.println(result);
		}
		
	}
	private static int bfs(int curX, int curY, int targetX, int targetY) {
		if(curX == targetX && curY == targetY) {
			return 0;
		}
		int depth = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {curX, curY, depth});
		board[curX][curY] = true;
		
		while(!queue.isEmpty()) {
			int[] posInfo = queue.poll();
			curX = posInfo[0];
			curY = posInfo[1];
			depth = posInfo[2];
			for(int d = 0; d < dx.length; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
					if(board[nx][ny] == false) {
						board[nx][ny] = true;
						if(nx == targetX && ny == targetY) {
							return depth+1;
						}
						queue.add(new int[] {nx, ny, depth+1});
					}
				}
			}
		}
		return -1;
	}

}