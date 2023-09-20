import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_2112 {
	static int result;
	static int[][] board;
	static int[][] copyBoard;
	static int[] isSelect;
	static int D, W, K;	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[D][W];
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			isSelect = new int[D];
			copyBoard = new int[D][W];
			for(int d = 0; d < D; d++) copyBoard[d] = copy(d);
			dfs(0, 0);
			
			ans.append("#" + tc + " " + result + "\n");
		}
		System.out.println(ans.toString());
	}
	
	private static void dfs(int cnt, int injectionCount) {
		if(injectionCount >= result) return;
		if(check()) result = injectionCount;
		if(cnt == D) {
			return ;
		}
		
		dfs(cnt+1, injectionCount);
		
		copyBoard[cnt] = injection(cnt, 0);
		dfs(cnt+1, injectionCount+1);
		copyBoard[cnt] = copy(cnt);
		
		copyBoard[cnt] = injection(cnt, 1);
		dfs(cnt+1, injectionCount+1);
		copyBoard[cnt] = copy(cnt);
	}

	private static boolean check() {
		for(int w = 0; w < W; w++) {
			int count = 1;
			int val = copyBoard[0][w];
			for(int d = 1; d < D; d++) {
				if(val == copyBoard[d][w]) count++;
				else {
					val = copyBoard[d][w];
					count = 1;
				}
				
				if(count == K) break;
			}
			if(count < K) return false;
		}
		return true;
	}

	private static int[] copy(int d) {
		return board[d].clone();
	}
	
	private static int[] injection(int d, int status) {
		int[] arr = new int[W];
		Arrays.fill(arr, status);
		return arr;
	}
}
