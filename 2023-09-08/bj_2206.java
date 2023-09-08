package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class bj_2206 {
	static class Pos {
		int x, y, dis;
		int isBroken;
		
		public Pos(int x, int y, int dis, int isBroken) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.isBroken = isBroken;
		}
	}
	static int N, M;
	static int[][] board;
	static int MAX_VALUE = Integer.MAX_VALUE;
	static int[][][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for(int x = 0; x < N; x++) {
			int[] tempInp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for(int y = 0; y < M; y++) {
//				board[x][y] = Integer.parseInt(st.nextToken(""));
				board[x][y] = tempInp[y];
			}
		}
		visited = new int[N][M][2];
		MAX_VALUE = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Arrays.fill(visited[i][j], MAX_VALUE);
			}
		}
		bfs();
		int result = Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]);
		System.out.println(result == MAX_VALUE ? -1 : result);
	}
	private static void bfs() {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(0, 0, 1, 0));
		visited[0][0][0] = 1;
		visited[0][0][1] = 1;
		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();
			
			for(int d = 0; d < dx.length; d++) {
				int nx = curPos.x + dx[d];
				int ny = curPos.y + dy[d];
				if((-1 < nx && nx < N) && (-1 < ny && ny < M)) {
					if(board[nx][ny] == 0 && visited[nx][ny][curPos.isBroken] == MAX_VALUE) {
						queue.add(new Pos(nx, ny, curPos.dis+1, curPos.isBroken));
						visited[nx][ny][curPos.isBroken] = curPos.dis+1;
					}else if(board[nx][ny] == 1 && curPos.isBroken == 0 && visited[nx][ny][curPos.isBroken] == MAX_VALUE) {
						queue.add(new Pos(nx, ny, curPos.dis+1, 1));
						visited[nx][ny][1] = curPos.dis+1;
						
					}
				}
			}
		}
	}

}
