import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJ_10026 {
	static int N;
	static char[][] board;
	static char[][] copyBoard;
	static boolean[][] isVisited;
	static int result1;
	static int result2;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		copyBoard = new char[N][N];
		isVisited = new boolean[N][N];
		for(int x = 0; x < N; x++) {
			board[x] = br.readLine().toCharArray();
		}
		
		for(int x = 0; x < N; x++) {
			copyBoard[x] = Arrays.copyOf(board[x], board[x].length);
		}
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(isVisited[x][y] == false) {
					bfs(x, y, 0);
				}
			}
		}
		
		for(int x = 0; x < N; x++) {
			copyBoard[x] = Arrays.copyOf(board[x], board[x].length);
			Arrays.fill(isVisited[x], false);
		}
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(isVisited[x][y] == false) {
					bfs(x, y, 1);
				}
			}
		}
		
		System.out.println(result1 + " " +result2);
	}
	private static void bfs(int curX, int curY, int check) {//0일반 | 1 색맹
		Queue<int[]> queue = new ArrayDeque<>();
		char[][][] flags = {{{'R'}, {'G'}, {'B'}}, {{'R', 'G'}, {'B'}}};
		
		int idx = -1;
		
		if(check == 0) {
			result1++;
			if(copyBoard[curX][curY] == 'R') idx = 0;
			else if(copyBoard[curX][curY] == 'G') idx = 1;
			else idx =2;
		}else {
			result2++;
			if(copyBoard[curX][curY] == 'B') idx = 1;
			else idx = 0;
		}
		
		queue.add(new int[] {curX, curY});
		while(!queue.isEmpty()) {
			int[] posInfo = queue.poll();
			curX = posInfo[0];
			curY = posInfo[1];
			
			for(int d = 0; d < dx.length; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
					for(char falg : flags[check][idx]) {
						if(copyBoard[nx][ny] == falg && isVisited[nx][ny] == false) {
							queue.add(new int[] {nx, ny});
							isVisited[nx][ny] = true;
						}
					}
				}
			}
		}
	}
}
