import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11048 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/BJ_11048.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] board = new int[N][M];
		for(int x = 0; x < N; x++) {
			board[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int [][] D = new int[N][M];
		
		D[0][0] = board[0][0];
		int[] dx = {-1, 0, -1};
		int[] dy = {0, -1, -1};
		for(int x = 0; x  < N; x++) {
			for(int y = 0; y < M; y++) {
				int maxValue = 0;
				for(int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if((-1 < nx && nx <N) && (-1 < ny && ny < M)) {
						maxValue = Math.max(maxValue, D[nx][ny]);
					}
				}
				D[x][y] = Math.max(D[x][y], maxValue+board[x][y]);
			}
		}
		
		System.out.println(D[N-1][M-1]);
	}
}