import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SW_4615 {
	static int[][] board;
	static int N, M;
	static int bCount, wCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			initBoard();
			
			for(int i = 0; i < M; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				int color = sc.nextInt();

				board[x][y] = color;
				putBoard(x, y, color);
				turnStone(x,y);
			}
			bCount =0;
			wCount = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == 1) bCount++;
					if(board[i][j] == 2) wCount++;
				}
			}
			System.out.println("#"+tc + " " +bCount + " " + wCount);
		}
	}
	private static void putBoard(int x, int y, int color) {
		board[x][y] = color;
	}
	private static void turnStone(int x, int y) {
		List<int[]> list = new ArrayList<>(); // 뒤집을돌 저장할 리스트
		int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
		for(int d = 0; d < dx.length; d++) {
			int step = 0;
			list.clear();
			while(true) {
				step++;
				int nx = x + (step * dx[d]);
				int ny = y + (step * dy[d]);
				if((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
					if(board[nx][ny] == 0) break;
					if(board[nx][ny] == board[x][y]) {
						for (int[] info : list) {
							putBoard(info[0], info[1], board[x][y]);
						}
						break;
					}if(board[nx][ny] != board[x][y]) {
						list.add(new int[] {nx,ny});
					}
					
				}else {
					break;
				}
			}
		}
		
	}
	private static void initBoard() {
		board = new int[N][N];
		//1흑 2백
		board[N/2][N/2] = 2;
		board[(N/2)-1][(N/2)-1] = 2;
		board[(N/2)-1][N/2] = 1;
		board[N/2][(N/2)-1] = 1;
		bCount = 0; wCount=0;
	}

}
