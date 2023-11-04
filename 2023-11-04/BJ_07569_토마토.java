import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_07569_토마토 {
	static class Pos {
		int x,y,h;

		public Pos(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", h=" + h + "]";
		}
	}
	static int X, Y, H;
	static int[][][] board;
	static boolean[][][] visited;
	static int count = 0;
	static Queue<Pos> queue = new ArrayDeque<>();
	static int[][] delta = { {-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][X][Y];
		visited = new boolean[H][X][Y];
		count = H * X * Y;
		
		for(int h = 0; h < H; h++) {
			for(int x = 0; x < X; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y = 0; y < Y; y++) {
					board[h][x][y] = Integer.parseInt(st.nextToken());
					if(board[h][x][y] == 1) { // 익은토마토
						visited[h][x][y] = true;
						queue.add(new Pos(x, y, h));
						count --;
					}
					if(board[h][x][y] == -1) { // 없음
						visited[h][x][y] = true;
						count --;
					}
				}
			}
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		int depth = 0;
		
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Pos curPos = queue.poll();
				
				for(int d = 0; d < delta.length; d++) {
					int nx = curPos.x + delta[d][0];
					int ny = curPos.y + delta[d][1];
					int nh = curPos.h + delta[d][2];
					
					if((-1 < nh && nh < H) && (-1 < nx && nx < X) && (-1 < ny && ny < Y)) {
						if(visited[nh][nx][ny]) continue;
						
						board[nh][nx][ny] = 1;
						visited[nh][nx][ny] = true;
						count--;
						queue.add(new Pos(nx, ny, nh));
					}
				}
			}
			depth++;
		}
		
		return count == 0 ? (depth-1) : -1;
	}


}
