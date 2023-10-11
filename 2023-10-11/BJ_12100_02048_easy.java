import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_12100_02048_easy {
		
	static int[] Select = new int[5]; //위 오 아 왼
	static int[][] board;
	static int N;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int x = 0; x < N; x++) {
			st= new StringTokenizer(br.readLine());
			for(int y = 0; y < N; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		중복순열(0);
		System.out.println(result);
	}
	private static void 중복순열(int cnt) {
		if(cnt == 5) {
			func();
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			Select[cnt] = i;
			중복순열(cnt+1);
		}
	}
	
	
	private static void func() {
		int copyBoard[][] = new int[N][N];
		for(int x = 0; x < N; x++) copyBoard[x] = board[x].clone();
		
		for(int dir : Select) {
			if(dir == 0) { //위
				
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				for(int y = 0; y < N; y++) {
					boolean check = false;
					
					for(int x = 0; x < N; x++) {
						if(copyBoard[x][y] == 0) continue; //빈칸이면 건너뛰기
						
						if((!queue.isEmpty()) && queue.peekLast() == copyBoard[x][y] && check == false) { //
							int mergeInfo = queue.pollLast();
							mergeInfo += copyBoard[x][y];
							queue.add(mergeInfo);
							check = true;  //합병했어
						}else {
							queue.add(copyBoard[x][y]);
							check = false; //합병안했어
						}
					}
					
					for(int x = 0; x < N; x++) {
						if(!queue.isEmpty()) {
							copyBoard[x][y] = queue.poll();
						}else {
							copyBoard[x][y] = 0;
						}
					}
				}
				
			}else if (dir == 1) { //오른쪽
				
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				for(int x = 0; x < N; x++) {
					boolean check = false;
					
					for(int y = N-1; y > -1; y--) {
						if(copyBoard[x][y] == 0) continue; //빈칸이면 건너뛰기
						
						if((!queue.isEmpty()) && queue.peekLast() == copyBoard[x][y] && check == false) { //
							int mergeInfo = queue.pollLast();
							mergeInfo += copyBoard[x][y];
							queue.add(mergeInfo);
							check = true;  //합병했어
						}else {
							queue.add(copyBoard[x][y]);
							check = false; //합병안했어
						}
					}
					
					for(int y = N-1; y > -1; y--) {
						if(!queue.isEmpty()) {
							copyBoard[x][y] = queue.poll();
						}else {
							copyBoard[x][y] = 0;
						}
					}
				}
				
			}else if (dir == 2) { // 아래
				
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				for(int y = 0; y < N; y++) {
					boolean check = false;
					
					for(int x = N-1; x > -1; x--) {
						if(copyBoard[x][y] == 0) continue; //빈칸이면 건너뛰기
						
						if((!queue.isEmpty()) && queue.peekLast() == copyBoard[x][y] && check == false) { //
							int mergeInfo = queue.pollLast();
							mergeInfo += copyBoard[x][y];
							queue.add(mergeInfo);
							check = true;  //합병했어
						}else {
							queue.add(copyBoard[x][y]);
							check = false; //합병안했어
						}
					}
					
					for(int x = N-1; x > -1; x--) {
						if(!queue.isEmpty()) {
							copyBoard[x][y] = queue.poll();
						}else {
							copyBoard[x][y] = 0;
						}
					}
				}
				
			}else if(dir == 3) { // 왼쪽
				
				ArrayDeque<Integer> queue = new ArrayDeque<>();
				for(int x = 0; x < N; x++) {
					boolean check = false;
					
					for(int y = 0; y < N; y++) {
						if(copyBoard[x][y] == 0) continue; //빈칸이면 건너뛰기
						
						if((!queue.isEmpty()) && queue.peekLast() == copyBoard[x][y] && check == false) { //
							int mergeInfo = queue.pollLast();
							mergeInfo += copyBoard[x][y];
							queue.add(mergeInfo);
							check = true;  //합병했어
						}else {
							queue.add(copyBoard[x][y]);
							check = false; //합병안했어
						}
					}
					
					for(int y = 0; y < N; y++) {
						if(!queue.isEmpty()) {
							copyBoard[x][y] = queue.poll();
						}else {
							copyBoard[x][y] = 0;
						}
					}
				}
		}
		
	}
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				if(copyBoard[x][y] == 0) continue;
				if(result < copyBoard[x][y]) result = copyBoard[x][y];
			}
		}
}

}
