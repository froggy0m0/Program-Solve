import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Result {
	int val, count;

	public Result(int val, int count) {
		this.val = val;
		this.count = count;
	}

	@Override
	public String toString() {
		return val + " " + count;
	}

}

class Position {
	int x, y, count;

	public Position(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class SWEA_1861 {
	static int N;
	static int[][] board;
	static int[][] visited;
	static Result result ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][];
			for (int i = 0; i < N; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
						.toArray();
			}
			visited = new int[N][N];
			
			result = new Result(-1, -1);
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (visited[x][y] == 0) {
						find(new Position(x, y, 1));
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	private static void find(Position startPos) {
		if(visited[startPos.x][startPos.y] != 0) return;	//이미 방문한 곳은 방문한 필요가없음
		
		int[] dx = new int[] {-1,0,1,0};
		int[] dy = new int[] {0,1,0,-1};
		
		Queue<Position>queue = new ArrayDeque<>();
		queue.add(startPos);
		while(!queue.isEmpty()) {
			Position curPos = queue.poll();
			
			if(result.count <= curPos.count) {
				if(result.count == curPos.count) {
					result.val = Math.min(result.val, board[startPos.x][startPos.y]);
				}else {
					result.count = curPos.count;
					result.val = board[startPos.x][startPos.y];
				}
			}
			
			for(int d = 0; d < dx.length; d++) {
				int nx = curPos.x + dx[d];
				int ny = curPos.y + dy[d];
				
				if((-1 < nx && nx < N) && (-1 < ny && ny < N)) {
					if(board[curPos.x][curPos.y] == board[nx][ny] -1 && visited[nx][ny] < curPos.count+1) {
						queue.add(new Position(nx, ny, curPos.count+1));
						visited[nx][ny] = curPos.count+1;
					}
				}
				
			}
		}
	}

}
