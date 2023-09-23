import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] board;
	static int N = 10;
	static int result = Integer.MAX_VALUE;
	static int[] paperCount = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[N][N];
		for (int x = 0; x < 10; x++) {
			board[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		func(0);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	private static void func(int count) {
		if(result <= count || isFinished(count)) return;

		int x = 0;
		int y = 0;
		boolean find = false;
		for(; x < N; x++) {
			for(; y < N; y++) {
				if(board[x][y] == 1) {
					find = true;
					break;
				}
			}
			if(find) break;
			y = 0;
		}
		
		for(int size = 1; size <= 5; size++) {
			if(paperCount[size] > 0 && isAvailable(x, y, size)) {
				setBoard(x, y, size, -1);
				func(count + 1);
				setBoard(x, y, size, +1);
			}
		}
	}

	private static void setBoard(int X, int Y, int size, int val) {
		paperCount[size] += val;
		for(int x = X; x < X + size; x++) {
			for(int y = Y; y < Y + size; y++) {
				board[x][y] += val; 
			}
		}
	}
	
	private static boolean isFinished(int count) {
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(board[x][y] == 1) return false;
			}
		}
		result = Integer.min(result, count);
		return true;
	}
	
	private static boolean isAvailable(int X, int Y, int size) {
		if((X + size > N) || (Y + size > N)) return false;
		
		for(int x = X; x < X+size; x++) {
			for(int y = Y; y < Y+size; y++) {
				if(board[x][y] == 0) return false;
			}
		}
		return true;
	}
}