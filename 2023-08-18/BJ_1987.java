import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1987 {
	static int R, C;
	static char board[][];
	static int answer;
	static boolean[] isVisited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		R = temp[0];
		C = temp[1];
		
		board = new char[R][];
		isVisited = new boolean[26];
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1);
		System.out.println(answer);
	}
	private static void dfs(int x, int y, int dept) {
		answer = Math.max(answer, dept);
		isVisited[board[x][y] - 65] = true;
		
		for(int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if((-1 < nx && nx < R) && (-1 < ny && ny < C)) {
				if(isVisited[board[nx][ny] - 65]) continue;
				isVisited[board[nx][ny] - 65] = true;
				dfs(nx, ny, dept+1);
				isVisited[board[nx][ny] - 65] = false;
			}
		}
	}

}