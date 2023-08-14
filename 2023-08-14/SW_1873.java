import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1873 {
	static String[][] board;
	static String[] movArr;
	static int tc;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			board = new String[H][W];

			int x = -1;
			int y = -1;
			for (int i = 0; i < board.length; i++) {
				String[] inp = br.readLine().split("");
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = inp[j];
					if (board[i][j].equals("<") || board[i][j].equals(">")
							|| board[i][j].equals("^") || board[i][j].equals("v")) {
						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());// movArr크기
			movArr = br.readLine().split("");
			func(x, y);
		}
	}

	private static void func(int x, int y) {
		for (String com : movArr) {
			if (com.equals("U")) {
				board[x][y] = "^";
				int nx = x + dx[0];
				int ny = y + dy[0];
				if (checkFlat(nx, ny)) {
					board[x][y] = ".";
					x = nx;
					y = ny;
					board[x][y] = "^";
					continue;
				}

			} else if (com.equals("D")) {
				board[x][y] = "v";
				int nx = x + dx[2];
				int ny = y + dy[2];
				if (checkFlat(nx, ny)) {
					board[x][y] = ".";
					x = nx;
					y = ny;
					board[x][y] = "v";
					continue;
				}

			} else if (com.equals("L")) {
				board[x][y] = "<";
				int nx = x + dx[3];
				int ny = y + dy[3];
				if (checkFlat(nx, ny)) {
					board[x][y] = ".";
					x = nx;
					y = ny;
					board[x][y] = "<";
					continue;
				}
			} else if (com.equals("R")) {
				board[x][y] = ">";
				int nx = x + dx[1];
				int ny = y + dy[1];
				if (checkFlat(nx, ny)) {
					board[x][y] = ".";
					x = nx;
					y = ny;
					board[x][y] = ">";
					continue;
				}
			} else if (com.equals("S")) {
				int way = -1;

				if (board[x][y].equals("^")) {
					way = 0;
				} else if (board[x][y].equals("v")) {
					way = 2;
				} else if (board[x][y].equals("<")) {
					way = 3;
				} else if (board[x][y].equals(">")) {
					way = 1;
				}

				int step = 1;
				int sx = x;
				int sy = y;
				while (true) {
					sx = x + (step *dx[way]);
					sy = y + (step * dy[way]);
					if ((-1 < sx && sx < board.length) && (-1 < sy && sy < board[0].length)) {
						if (board[sx][sy].equals("*")) {
							board[sx][sy] = ".";
							break;
						} else if (board[sx][sy].equals("#")) {// 강철
							break;
						}
					} else {// 맵밖으로
						break;
					}
					step++;
				}

			}
		}
		printBoard();
	}

	private static boolean checkFlat(int nx, int ny) {
		if ((-1 < nx && nx < board.length) && (-1 < ny && ny < board[0].length)
				&& (board[nx][ny].equals("."))) {
			return true;
		}
		return false;
	}

	private static void printBoard() {
		StringBuilder sb = new StringBuilder();
		sb.append("#" + tc + " ");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j]);
			}
			if(i != board.length-1) {sb.append("\n");}
		}
		System.out.println(sb.toString());
	}
}