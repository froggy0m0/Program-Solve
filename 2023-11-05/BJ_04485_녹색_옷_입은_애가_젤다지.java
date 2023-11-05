import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_04485_녹색_옷_입은_애가_젤다지 {
	static class Info extends Pos implements Comparable<Info>{
		int w;

		public Info(int x, int y, int w) {
			super(x, y);
			this.w = w;
		}

		@Override
		public int compareTo(Info other) {
			return this.w - other.w;
		}
		
	}
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int N;
	static int[][] board;
	static int[][] delta = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int testCaseCount = 1;
		while(N != 0) {
			board = new int[N][N];
			for(int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y = 0; y < N; y++) {
					board[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem " + testCaseCount++ +": " + dijk() + "\n");
			
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sb.toString());
	}
	private static int dijk() {
		int[][] costArr = new int[N][N];
		int MAX_VALUE = 1<<30;
		for(int x = 0; x < N; x++) Arrays.fill(costArr[x], MAX_VALUE);
		costArr[0][0] = board[0][0];
		
		Queue<Info> queue = new ArrayDeque<>();
		queue.add(new Info(0, 0, board[0][0]));
		while(!queue.isEmpty()) {
			Info curInfo = queue.poll();
			
			if(curInfo.w > costArr[curInfo.x][curInfo.y]) continue;
			
			for(int d = 0; d < delta.length; d++) {
				int nx = curInfo.x + delta[d][0];
				int ny = curInfo.y + delta[d][1];
				
				if((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
					if(costArr[nx][ny] > curInfo.w + board[nx][ny]) {
						costArr[nx][ny] = curInfo.w + board[nx][ny];
						queue.add(new Info(nx, ny, costArr[nx][ny]));
					}
				}
			}
		}
		
		
		return costArr[N-1][N-1];
	}
}
