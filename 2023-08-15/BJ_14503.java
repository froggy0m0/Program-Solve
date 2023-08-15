


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_14503 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inpTemp = br.readLine().split(" ");
		int N = Integer.parseInt(inpTemp[0]);
		int M = Integer.parseInt(inpTemp[0]);

		inpTemp = br.readLine().split(" ");
		int curX = Integer.parseInt(inpTemp[0]);
		int curY = Integer.parseInt(inpTemp[1]);
		int way = Integer.parseInt(inpTemp[2]);

		int[] dx = { -1, +0, +1, +0 };
		int[] dy = { +0, +1, +0, -1 };

		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int answer = 0;
		boolean check = false;
		while (true) {
			check = false;
			if (board[curX][curY] == 1)
				break; // 1은 벽
			if (board[curX][curY] == 0) { // 0은 청소가능함
				answer++;
				board[curX][curY] = 2; // 2는 청소했음
			}

			for (int i = 1; i < dx.length+1; i++) {
				int nx = curX + dx[(4+way - i) % 4];
				int ny = curY + dy[(4+way - i) % 4];
					if (board[nx][ny] == 0) {
						curX = nx;
						curY = ny;
						check = true;
					way = (4 + way - i) % 4;
					break;
					}
			}
			if(check == true) continue;
			
			int nx = curX + (-1 * dx[way]);
			int ny = curY + (-1 * dy[way]);
				if(board[nx][ny] != 1) {
					curX = nx;
					curY = ny;
					continue;
				}else if(board[nx][ny] == 1) {
					break;
				}
			
		}
		System.out.println(answer);
	}

}
