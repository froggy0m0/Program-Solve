import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJ_4963 {
	static int[][] board;
	static int result;
	static int[] dx = {-1, 0, 1, 0, -1, -1, +1, +1};
	static int[] dy = {0, -1, 0, 1, -1, +1, -1, +1};
	static int h;
	static int w;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inpTemp = br.readLine();
		
		while(true) {
			int[] Temp = Arrays.stream(inpTemp.split(" ")).mapToInt(Integer::parseInt).toArray();
			result = 0;
			w = Temp[0];
			h = Temp[1];
			board = new int [h][w];
			
			for(int x = 0; x < h; x++) {
				board[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int x = 0; x < h; x ++) {
				for(int y = 0; y < w; y++) {
					if(board[x][y] == 1 || board[x][y] == 0) {
						if(board[x][y] == 1) result ++;
						bfs(x,y);
					}
				}
			}
			
			inpTemp = br.readLine();
			if(inpTemp == null) break;
			System.out.println(result);
		}
	}
	private static void bfs(int curX, int curY) {
		int maker = board[curX][curY];
		Queue<int[]> queue = new ArrayDeque<>();
		board[curX][curY] += 10; 
		queue.add(new int[] {curX, curY});
		while(!queue.isEmpty()) {
			int[] posInfo = queue.poll();
			curX = posInfo[0];
			curY = posInfo[1];
			
			for(int d = 0; d < dx.length; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if((-1 < nx && nx < h) && (-1 < ny && ny < w)) {
					if(board[nx][ny] == maker) {
						board[nx][ny] = maker+10;
						queue.add(new int[] {nx, ny});
					}
				}
			}
			
		}
	}

}