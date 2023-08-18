import java.util.Scanner;

public class BJ_9663 {
	static int N;
	static int[] col;	//각 idx는 각행을 의미, 해당idx(행)에들어있는값은 열의 위치를 나타냄
	static int answer = 0;
	public static void main(String[] args) throws Exception {	
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1]; //0행은 쓰지않음
		setQueen(1);
		System.out.println(answer);
	}
	private static void setQueen(int row) {
		if(!isAvailable(row-1)) return;
		
		if(row == N+1) {
			answer++;
			return;
		}
		
		for(int c = 1; c <= N; c++) {
			col[row] = c;
			setQueen(row+1);
		}
	}
	private static boolean isAvailable(int row) {
		for(int i = 1; i < row; i++) {
			if(col[i] == col[row] || (Math.abs(i-row)) == (Math.abs(col[i] -col[row]))) {
				return false;
			}
		}
		return true;
	}

}