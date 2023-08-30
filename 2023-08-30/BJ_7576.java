import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static int count, non;
	static ArrayList<int[]> posList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < M; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
				if(board[x][y] == 1) posList.add(new int[] {x, y});
				if(board[x][y] == 0) count++;
				if(board[x][y] == -1) non++;
			}
		}
		if(posList.size()+non == N*M) {
			System.out.println(0);
			return;
		}	
		System.out.println(bfs());
	}
	private static int bfs() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0 , 1};
		Queue<int[]> queue = new ArrayDeque<>();
		for(int[] pos : posList) {
			queue.add(pos);
		}
		int t = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int[] posInfo = queue.poll();
				int curX = posInfo[0];
				int curY = posInfo[1];
				
				for(int d = 0; d < dx.length; d++) {
					int nx = curX + dx[d];
					int ny = curY + dy[d];
					if((-1 < nx && nx < N) && (-1 < ny && ny < M)) {
						if(board[nx][ny] == 0) {
							board[nx][ny] = 1;
							count--;
							if(count == 0) t--;
							queue.add(new int[] {nx, ny});
						}
					}
				}
			}
			t++;
		}
		
		return count == 0 ? t : -1;
	}
}
