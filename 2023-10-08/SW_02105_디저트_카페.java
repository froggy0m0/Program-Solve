import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class SW_02105_디저트_카페 {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int maxValue;
	static int startX, startY;
	static HashSet<Integer> set = new HashSet<>();
	static int[][] delta = {{+1, -1}, {-1, -1}, {-1, +1}, {+1, +1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			maxValue = Integer.MIN_VALUE;
			visited = new boolean[N][N];
			board = new int[N][N];
			set.clear();
			for(int x = 0; x < N; x++) board[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					startX = x;
					startY = y;
					dfs(x, y, 0, 0);
//					int nx = x+delta[0][0];
//					int ny = y+delta[0][1];
//					if((-1 < nx && nx < N) && (-1 < ny && ny < N)){
//						dfs(x+delta[0][0], y+delta[0][1], 1, 0);
//					}
				}
			}
			
			System.out.println("#" + tc + " " + (maxValue == Integer.MIN_VALUE ? -1 : maxValue));
		}
	}
	private static void dfs(int curX, int curY, int count, int preDir) {
		if(count != 0 && preDir == 3 && curX == startX && curY == startY) {
			maxValue = Integer.max(maxValue, count);
			return;
		}
		
		for(int dir = preDir; dir < preDir+2; dir++) {
			if(dir == 4) continue;
			int nx = curX + delta[dir][0];
			int ny = curY + delta[dir][1];
			
			if((-1 < nx && nx < N) && (-1 < ny && ny < N) && visited[nx][ny] == false) {
				if(set.contains(board[nx][ny]) == false) {
					set.add(board[nx][ny]);
					visited[nx][ny] = true;
					dfs(nx, ny, count+1, dir);
					set.remove(board[nx][ny]);
					
					visited[nx][ny] = false;
				}
			}
		}
	}
}
