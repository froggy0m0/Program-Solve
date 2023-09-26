import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 신성현_BJ_2239_스도쿠 {
	static boolean[] checkXArr = new boolean[10];
	static boolean[] checkYArr = new boolean[10];
	static boolean[] check3by3Arr = new boolean[10];
	static int[][] board = new int[9][9];
	static boolean isFind = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int x = 0; x < 9; x++) board[x] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		
		fillBoard(0, 0);
	}
	private static void fillBoard(int x, int y) {
		if(isFind) return;
		
		if(x == 9 && y == 0) {
			for(int x1 = 0; x1 < 9; x1++) {
				for(int y2 = 0; y2 < 9; y2++) {
					System.out.print(board[x1][y2]);
				}
				System.out.println();
			}
			isFind = true;
			return;
		}
		
		if(x == 0) setCheckYArr(x);
		if(x % 3 == 0 && y % 3 == 0) setCheck3by3Arr(x,y);
		
		int nx = x;
		int ny = y+1;
		if(ny == 9) {
			nx += 1;
			ny = 0;
		}
		if(board[x][y] == 0) {
			for(int num = 1; num <= 9; num++) {
				if(isAvailable(x, y, num)) {
					board[x][y] = num;
					fillBoard(nx, ny);
					board[x][y] = 0;
				}
			}
		}else {
			fillBoard(nx, ny);
		}
	}
	
	private static boolean isAvailable(int X, int Y, int num) {
		//가로 체크
		boolean[] checkArr = new boolean[10];
		checkArr[num] = true;
		for(int y = 0; y < 9; y++) {
			if(board[X][y] == num) return false;
		}
		
		//세로 체크
		Arrays.fill(checkArr, false);
		checkArr[num] = true;
		for(int x = 0; x < 9; x++) {
			if(board[x][Y] == num) return false;
		}
		//3 by 3 체크
		Arrays.fill(checkArr, false);
		checkArr[num] = true;
		int baseX = (X/3) * 3;
		int baseY = (Y/3) * 3;
		for(int x = baseX; x < baseX + 3; x++) {
			for(int y = baseY; y < baseY + 3; y++) {
				if(board[x][y] == num) return false;
			}
		}
		return true;
	}
	private static void setCheckYArr(int X) {
		for(int y = 0; y < 9; y++) {
			checkYArr[board[X][y]] = true;
		}
		
	}
	
	private static void setCheck3by3Arr(int X, int Y) {
		for(int x = X; x < X+3; x++) {
			for(int y = Y; y < Y+3; y++) {
				checkYArr[board[X][y]] = true;
			}
		}
	}
}
