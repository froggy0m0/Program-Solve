import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class bj_15683 {
	static class CCTV {
		int x,y;
		int type;
		public CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	static int N, M;
	static int minValue = 1 << 20;
	static int[][] board, copyBoard;
	static ArrayList<CCTV> cctvList = new ArrayList<>();
	static int[] cctvModeArr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] mode = {0, 4, 2, 4, 4, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for(int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < M; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
				if(board[x][y] != 0 && board[x][y] != 6) {
					cctvList.add(new CCTV(x, y, board[x][y]));
				}
			}
		}
		cctvModeArr = new int[cctvList.size()];
		perm(0);
		System.out.println(minValue);
	}
	private static void perm(int cnt) {
		if(cnt == cctvList.size()) {
			감시();
			return;
		}
		int size = mode[cctvList.get(cnt).type];
		for(int i = 0; i < size; i++) {
			cctvModeArr[cnt] = i;
			perm(cnt+1);
		}
		
	}
	private static void 감시() {
		copyBoard = new int[N][M];
		for(int x = 0; x < N; x++) copyBoard[x] = board[x].clone();
		
		for(int i = 0; i < cctvList.size(); i++) {
			CCTV cctv = cctvList.get(i);
			int mode = cctvModeArr[i];
			
			if(cctv.type == 1) {
				fillBoard(cctv.x, cctv.y, mode);
			} else if (cctv.type == 2) {
				fillBoard(cctv.x, cctv.y, (mode+1) % 4);
				fillBoard(cctv.x, cctv.y, (mode+3) % 4);
			} else if (cctv.type == 3) {
				fillBoard(cctv.x, cctv.y, (mode+0) % 4);
				fillBoard(cctv.x, cctv.y, (mode+1) % 4);
			} else if (cctv.type == 4) {
				fillBoard(cctv.x, cctv.y, (mode+0) % 4);
				fillBoard(cctv.x, cctv.y, (mode+1) % 4);
				fillBoard(cctv.x, cctv.y, (mode+3) % 4);
			} else if (cctv.type == 5) {
				fillBoard(cctv.x, cctv.y, (mode+0) % 4);
				fillBoard(cctv.x, cctv.y, (mode+1) % 4);
				fillBoard(cctv.x, cctv.y, (mode+2) % 4);
				fillBoard(cctv.x, cctv.y, (mode+3) % 4);
			}
			
		}
		
		//감시되는칸들은 9로체크, 9값 체크하기
		int count = 0;
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				if(copyBoard[x][y] == 0) count++;
			}
		}
		minValue = Math.min(minValue, count);
	}
	private static void fillBoard(int curX, int curY, int mode) {
		while(true) {
			curX += dx[mode];
			curY += dy[mode];
			if((-1 < curX && curX < N) && (-1 < curY && curY < M)) {
				if(copyBoard[curX][curY] == 6) break;
				if(copyBoard[curX][curY] == 0) copyBoard[curX][curY] = 9;
			}else {
				break;
			}
		}
	}
}
