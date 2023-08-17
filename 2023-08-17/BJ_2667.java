import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2667 {
	static int N;
	static int[][] board;
	static PriorityQueue<Integer> resultQueue = new PriorityQueue<>();	//각단지의 집수저장
	static int dx[] = new int[] {-1, 0, +1, 0};
	static int dy[] = new int[] {0, +1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 1) {
					resultQueue.add(bfs(i,j));
				}
			}
		}
		System.out.println(resultQueue.size());
		while(!resultQueue.isEmpty()) {
			System.out.println(resultQueue.poll());
		}
	}
	private static int bfs(int curX, int curY) {
		int count = 1;
		int mark = 10 + resultQueue.size();			//2차원배열에 방문처리를하기위해  카운트한 단지수와 임의의 10값을더함
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {curX, curY});
		board[curX][curY] = mark;
		while(!queue.isEmpty()) {
			int[] temp  = queue.poll();
			curX = temp[0];
			curY = temp[1];
			
			for(int i = 0; i < dx.length; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
					if(board[nx][ny] == 1) {
						board[nx][ny] = mark;
						count++;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		return count;
	}
}